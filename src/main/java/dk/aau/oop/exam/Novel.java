package dk.aau.oop.exam;

final class Novel extends Book {
  private final String genre;

  /* default */ Novel(
      final String isbn,
      final String title,
      final String author,
      final BookLocation bookLocation,
      final String genre) {
    super(isbn, title, author, bookLocation);

    this.genre = genre;
  }

  /// @param bookLocation The location of the book.
  /// @see Book#bookLocation
  /* default */ void setBookLocation(final BookLocation bookLocation) {
    this.bookLocation = bookLocation;
  }

  @Override
  public String toString() {
    return "Novel{isbn="
        + getIsbn()
        + ", title="
        + getTitle()
        + ", author="
        + getAuthor()
        + ", bookLocation="
        + getBookLocation()
        + ", genre="
        + genre
        + '}';
  }
}
