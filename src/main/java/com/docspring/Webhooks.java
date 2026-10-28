package com.docspring;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Checks webhook requests' X-DocSpring-Signature header
 * (https://docspring.com/docs/webhooks/verifying-signatures/).
 */
public final class Webhooks {
  /** The number of seconds a webhook request's signature stays valid (verifyWebhookSignature) */
  public static final long DEFAULT_TOLERANCE_SECONDS = 300;

  private Webhooks() {}

  /**
   * Checks a webhook request's X-DocSpring-Signature header, with a 5-minute tolerance. Returns true when one of its v1
   * signatures is the HMAC-SHA256 of "{t}.{payload}" with the webhook's secret, and its timestamp t is at most 5
   * minutes from now. Returns false for anything else, including a missing or malformed header.
   *
   * @param payload The request body exactly as it was received, not parsed JSON
   * @param signatureHeader The X-DocSpring-Signature header
   * @param secret The webhook's signing secret
   * @return True if the request came from DocSpring
   */
  public static boolean verifyWebhookSignature(String payload, String signatureHeader, String secret) {
    return verifyWebhookSignature(payload, signatureHeader, secret, DEFAULT_TOLERANCE_SECONDS);
  }

  /**
   * Checks a webhook request's X-DocSpring-Signature header, with another tolerance.
   *
   * @param payload The request body exactly as it was received, not parsed JSON
   * @param signatureHeader The X-DocSpring-Signature header
   * @param secret The webhook's signing secret
   * @param toleranceSeconds How many seconds old (or early) the timestamp can be
   * @return True if the request came from DocSpring
   */
  public static boolean verifyWebhookSignature(
      String payload, String signatureHeader, String secret, long toleranceSeconds) {
    return verifyWebhookSignature(
        payload, signatureHeader, secret, toleranceSeconds, System.currentTimeMillis() / 1000);
  }

  /**
   * Checks a webhook request's X-DocSpring-Signature header at a given time, for tests.
   *
   * @param payload The request body exactly as it was received, not parsed JSON
   * @param signatureHeader The X-DocSpring-Signature header
   * @param secret The webhook's signing secret
   * @param toleranceSeconds How many seconds old (or early) the timestamp can be
   * @param nowSeconds The current Unix time in seconds
   * @return True if the request came from DocSpring
   */
  public static boolean verifyWebhookSignature(
      String payload, String signatureHeader, String secret, long toleranceSeconds, long nowSeconds) {
    if (payload == null || signatureHeader == null || secret == null || secret.isEmpty()) return false;

    String timestamp = null;
    List<String> signatures = new ArrayList<>();
    for (String part : signatureHeader.split(",", -1)) {
      String[] pair = part.trim().split("=", 2);
      String value = pair.length == 2 ? pair[1] : "";
      if (pair[0].equals("t") && timestamp == null) {
        timestamp = value;
      } else if (pair[0].equals("v1") && !value.isEmpty()) {
        signatures.add(value);
      }
    }
    if (timestamp == null || !timestamp.matches("[0-9]+") || signatures.isEmpty()) return false;

    long seconds;
    try {
      seconds = Long.parseLong(timestamp);
    } catch (NumberFormatException e) {
      // Too many digits for a long
      return false;
    }
    long age = nowSeconds > seconds ? nowSeconds - seconds : seconds - nowSeconds;
    if (age > toleranceSeconds) return false;

    byte[] expected;
    try {
      Mac mac = Mac.getInstance("HmacSHA256");
      mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
      expected = hex(mac.doFinal((timestamp + "." + payload).getBytes(StandardCharsets.UTF_8)))
          .getBytes(StandardCharsets.US_ASCII);
    } catch (GeneralSecurityException e) {
      // Every Java platform has HmacSHA256
      return false;
    }
    boolean valid = false;
    for (String signature : signatures) {
      // Constant time, so a timing attack can't find a valid signature byte by byte
      if (MessageDigest.isEqual(signature.getBytes(StandardCharsets.UTF_8), expected)) valid = true;
    }
    return valid;
  }

  private static String hex(byte[] bytes) {
    StringBuilder hex = new StringBuilder(bytes.length * 2);
    for (byte b : bytes) hex.append(String.format("%02x", b));
    return hex.toString();
  }
}
