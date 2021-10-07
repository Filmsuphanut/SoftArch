package creational;

public interface BookMetadataFormatter {
    static void append() {
    }

    BookMetadataFormatter reset();
    BookMetadataFormatter append(Book b);
    String getMetadataString();
}
