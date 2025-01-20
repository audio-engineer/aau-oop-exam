package dk.aau.oop.exam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class Library {
  private final Map<String, Book> books;
  private final List<LocationTracker> listeners;

  /* default */ Library() {
    books = new HashMap<>(50);
    listeners = new ArrayList<>(50);
  }

  /* default */ void addBook(final Book book) {
    final String isbn = book.getIsbn();

    if (books.containsKey(isbn)) {
      throw new DuplicateBookException("A book with the same ISBN is already in the library.");
    }

    books.put(isbn, book);

    for (final LocationTracker locationTracker : listeners) {
      locationTracker.update(book, true);
    }
  }

  /* default */ void removeBook(final Book book) {
    final String isbn = book.getIsbn();

    books.remove(isbn);

    for (final LocationTracker locationTracker : listeners) {
      locationTracker.update(book, false);
    }
  }

  /* default */ List<Book> findBooksAtLocation(final BookLocation bookLocation) {
    return books.values().stream()
        .filter(book -> book.getBookLocation().equals(bookLocation))
        .toList();
  }

  /* default */ void addListener(final LocationTracker locationTracker) {
    listeners.add(locationTracker);
  }

  /* default */ Collection<Book> search(final SearchStrategy searchStrategy, final String query) {
    final Collection<Book> queryableBooks = books.values();

    return searchStrategy.search(query, queryableBooks);
  }
}
