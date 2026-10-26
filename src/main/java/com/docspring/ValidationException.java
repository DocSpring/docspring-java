package com.docspring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Thrown before a request is sent when the API would reject it with a 422. getDetails() returns the API's error
 * details: each has a code, a message and a pointer into the body (or a parameter for a query parameter).
 */
public class ValidationException extends IllegalArgumentException {
  private static final long serialVersionUID = 1L;

  private final List<ErrorDetail> details;

  public ValidationException(List<ErrorDetail> details) {
    super(describe(details));
    this.details = Collections.unmodifiableList(new ArrayList<>(details));
  }

  public List<ErrorDetail> getDetails() {
    return details;
  }

  private static String describe(List<ErrorDetail> details) {
    List<String> shown = new ArrayList<>();
    for (ErrorDetail detail : details.subList(0, Math.min(3, details.size()))) {
      String subject = detail.getPointer() != null ? detail.getPointer() : detail.getParameter();
      if ("".equals(subject)) subject = "the request body";
      shown.add(subject + " " + detail.getMessage());
    }
    String message = "Invalid request: " + String.join("; ", shown);
    if (details.size() > 3) message += " (and " + (details.size() - 3) + " more)";
    return message;
  }
}
