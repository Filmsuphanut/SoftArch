package creational;

import java.io.IOException;
import java.io.PrintStream;

public class CSVBookMetadataExporter extends BookMetadataExporter{

    private CSVBookMetadataFormatter csvExpoter;

    public CSVBookMetadataExporter(){
        try {
            csvExpoter = new CSVBookMetadataFormatter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Book b) {
        super.add(b);
        csvExpoter.append(b);
    }

    @Override
    public void export(PrintStream stream) {
        stream.print(csvExpoter.getMetadataString());
    }
}
