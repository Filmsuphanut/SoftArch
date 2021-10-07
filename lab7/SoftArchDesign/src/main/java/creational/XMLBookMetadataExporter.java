package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.PrintStream;

public class XMLBookMetadataExporter extends BookMetadataExporter {

    private XMLBookMetadataFormatter xmlExport;

    public XMLBookMetadataExporter() {
        try {
            xmlExport = new XMLBookMetadataFormatter();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Book b) {
        super.add(b);
        xmlExport.append(b);
    }

    @Override
    public void export(PrintStream stream) {
        stream.print(xmlExport.getMetadataString());
    }

}
