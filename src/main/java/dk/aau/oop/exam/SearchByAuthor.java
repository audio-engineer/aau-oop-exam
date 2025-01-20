package dk.aau.oop.exam;

import java.util.Collection;

final class SearchByAuthor implements SearchStrategy {
  @Override
  public Collection<Book> search(final String query, final Collection<Book> books) {
    return books.stream().filter(book -> book.getAuthor().equals(query)).toList();
  }
}
