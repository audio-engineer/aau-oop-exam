package dk.aau.oop.exam;

import java.util.Collection;

@FunctionalInterface
interface SearchStrategy {
  Collection<Book> search(String query, Collection<Book> books);
}
