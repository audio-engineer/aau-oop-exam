package dk.aau.oop.exam;

import java.util.Collection;

final class SearchByTitle implements SearchStrategy {
  @Override
  public Collection<Book> search(final String query, final Collection<Book> books) {
    return books.stream().filter(book -> book.getTitle().equals(query)).toList();
  }
}
