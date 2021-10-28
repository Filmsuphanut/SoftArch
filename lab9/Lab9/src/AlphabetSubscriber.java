import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AlphabetSubscriber extends StringSubscriber{

    @Override
    public void onComplete() {
        String Data = super.Data;
        super.Data = "";

            try {
                Create(Data+"\n", "AlphabetSubscriber.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
