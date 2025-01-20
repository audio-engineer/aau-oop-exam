package dk.aau.oop.exam;

class Book {
  private final String isbn;
  private final String title;
  private final String author;
  // I don't like this solution at all, but I guess this is what you want.
  /* default */ BookLocation bookLocation;

  /* default */ Book(
      final String isbn, final String title, final String author, final BookLocation bookLocation) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.bookLocation = bookLocation;
  }

  /* default */ final String getIsbn() {
    return isbn;
  }

  /* default */ final String getTitle() {
    return title;
  }

  /* default */ final String getAuthor() {
    return author;
  }

  /* default */ final BookLocation getBookLocation() {
    return bookLocation;
  }

  @Override
  public String toString() {
    return "Book{isbn="
        + isbn
        + ", title="
        + title
        + ", author="
        + author
        + ", bookLocation="
        + bookLocation
        + '}';
  }
}
