package dk.aau.oop.exam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class LocationTrackerListener implements LocationTracker {
  private final BookLocation bookLocation;
  private final List<Book> books;

  /* default */ LocationTrackerListener(final BookLocation bookLocation) {
    this.bookLocation = bookLocation;
    books = new ArrayList<>(50);
  }

  @Override
  public void update(final Book book, final boolean isAdded) {
    final BookLocation bookUpdatedAtLocation = book.getBookLocation();

    if (!bookLocation.equals(bookUpdatedAtLocation)) {
      return;
    }

    if (!isAdded) {
      books.remove(book);

      return;
    }

    books.add(book);
  }

  @Override
  public Collection<Book> getBooks() {
    return Collections.unmodifiableList(books);
  }
}
