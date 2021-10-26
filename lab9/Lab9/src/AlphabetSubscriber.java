import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AlphabetSubscriber extends StringSubscriber{

    @Override
    public void onNext(String item) {
        try {
            super.Create(item,"AlphabetSubscriber.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onComplete() {
        System.out.println("AlphabetSubscriber Write Data Complete");
    }




}
