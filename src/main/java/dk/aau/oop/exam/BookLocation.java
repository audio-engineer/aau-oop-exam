package dk.aau.oop.exam;

final class BookLocation {
  private final String section;
  private final int shelf;

  /* default */ BookLocation(final String section, final int shelf) {
    this.section = section;
    this.shelf = shelf;
  }

  @Override
  public String toString() {
    return "BookLocation{section=" + section + ", shelf=" + shelf + '}';
  }
}
