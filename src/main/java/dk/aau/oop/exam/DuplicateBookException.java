package dk.aau.oop.exam;

import java.io.Serial;

class DuplicateBookException extends RuntimeException {
  @Serial private static final long serialVersionUID = -6775120263457912314L;

  /* default */ DuplicateBookException(final String message) {
    super(message);
  }
}
