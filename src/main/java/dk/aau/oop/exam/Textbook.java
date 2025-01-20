package dk.aau.oop.exam;

final class Textbook extends Book {
  private final String subject;
  private BookLocation bookLocation;

  /* default */ Textbook(
      final String isbn,
      final String title,
      final String author,
      final BookLocation bookLocation,
      final String subject) {
    super(isbn, title, author, bookLocation);

    this.subject = subject;
  }

  @Override
  public String toString() {
    return "Textbook{isbn="
        + getIsbn()
        + ", title="
        + getTitle()
        + ", author="
        + getAuthor()
        + ", bookLocation="
        + getBookLocation()
        + ", subject="
        + subject
        + '}';
  }
}
