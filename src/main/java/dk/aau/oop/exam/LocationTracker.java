package dk.aau.oop.exam;

import java.util.Collection;

interface LocationTracker {
  void update(Book book, boolean isAdded);

  Collection<Book> getBooks();
}
