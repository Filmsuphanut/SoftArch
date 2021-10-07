package creational;

import java.io.PrintStream;

public class JSONBookMetadataExporter extends BookMetadataExporter{

    private JSONBookMetadataFormatter jsonExporter;

    public JSONBookMetadataExporter() {
        jsonExporter = new JSONBookMetadataFormatter();
    }

    @Override
    public void add(Book b) {
        super.add(b);
        jsonExporter.append(b);
    }

    @Override
    public void export(PrintStream stream) {
        stream.print(jsonExporter.getMetadataString());
    }
}
