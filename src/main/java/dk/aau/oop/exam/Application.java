package dk.aau.oop.exam;

import java.util.Collection;
import java.util.List;

final class Application {
  public static void main(final String[] args) {
    // Library setup
    final Library library = new Library();

    final BookLocation bookLocationD1 = new BookLocation("D", 1);

    final LocationTracker locationTrackerD1 = new LocationTrackerListener(bookLocationD1);
    library.addListener(locationTrackerD1);

    final Textbook textbookOne =
        new Textbook("1", "First Book", "Someone", bookLocationD1, "Computer Science");
    final Textbook textbookTwo =
        new Textbook("2", "Second Book", "Someone", bookLocationD1, "Computer Science");
    final Textbook textbookThree =
        new Textbook("3", "Third Book", "Someone", bookLocationD1, "Computer Science");

    library.addBook(textbookOne);
    library.addBook(textbookTwo);
    library.addBook(textbookThree);

    // Print all books in the library at location D1
    System.out.println("All books at location D1:");
    final Collection<Book> locationTrackerD1Books = locationTrackerD1.getBooks();
    System.out.println(locationTrackerD1Books);

    System.out.println();

    // Check that exception is thrown on duplicates
    System.out.println("Exception is thrown on duplicates:");

    try {
      library.addBook(textbookOne);
    } catch (final DuplicateBookException duplicateBookException) {
      final String exceptionMessage = duplicateBookException.getMessage();

      System.out.println(exceptionMessage);
    }

    System.out.println();

    // Book removal works
    System.out.println("All books in library without book 2:");
    library.removeBook(textbookTwo);
    System.out.println(locationTrackerD1Books);

    System.out.println();

    // Novel BookLocation can be modified
    System.out.println("All books at location G2:");
    final Novel novel = new Novel("4", "Harry Potter", "Someone", bookLocationD1, "Fantasy");
    final BookLocation bookLocationG2 = new BookLocation("G", 2);
    novel.setBookLocation(bookLocationG2);
    final LocationTracker locationTrackerG2 = new LocationTrackerListener(bookLocationG2);
    library.addListener(locationTrackerG2);
    library.addBook(novel);
    final Collection<Book> locationTrackerG2Books = locationTrackerG2.getBooks();
    System.out.println(locationTrackerG2Books);

    System.out.println();

    // Print all books at a given book location
    System.out.println("All books at book location D1:");
    final List<Book> searchResult = library.findBooksAtLocation(bookLocationD1);
    System.out.println(searchResult);

    System.out.println();

    // Use SearchByAuthor strategy
    System.out.println("All books by author Miss Smith:");
    final Textbook textbookFour =
        new Textbook("5", "Some Book", "John Doe", bookLocationD1, "Philosophy");
    final Textbook textbookFive =
        new Textbook("6", "Not a Novel", "Miss Smith", bookLocationD1, "Cooking");
    library.addBook(textbookFour);
    library.addBook(textbookFive);

    final Collection<Book> booksByMissSmith = library.search(new SearchByAuthor(), "Miss Smith");
    System.out.println(booksByMissSmith);
  }
}
