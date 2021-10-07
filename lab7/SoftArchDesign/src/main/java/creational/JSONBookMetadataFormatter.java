package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JSONObject bookObject;
    private JSONObject bookDetails;
    private JSONArray bookList;

    public JSONBookMetadataFormatter(){
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        bookObject = new JSONObject();
        bookList = new JSONArray();
        bookObject.put("Books",bookList);

        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        List<String> authors = new ArrayList<String>(Arrays.asList(b.getAuthors()));
        bookDetails = new JSONObject();
        bookDetails.put("ISBN", b.getISBN());
        bookDetails.put("Authors",authors );
        bookDetails.put("Title", b.getTitle());
        bookDetails.put("Publisher", b.getPublisher());
        bookList.add(bookDetails);

        return this;
    }

    @Override
    public String getMetadataString() {
        return bookObject.toString();
    }
}
