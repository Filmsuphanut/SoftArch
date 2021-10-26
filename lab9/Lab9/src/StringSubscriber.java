import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.Flow;

public abstract class StringSubscriber implements Flow.Subscriber<String> {

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
    }

    @Override
    public void onNext(String item) {
    }

    @Override
    public void onError(Throwable throwable) {
    }

    @Override
    public void onComplete() {
    }

    public void Create(String item,String file) throws IOException {
        try {
            File myObj = new File(file);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
            WriteFile(item+"\n",file);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void WriteFile(String item,String file){
        try {
            FileWriter Writer = new FileWriter(file,true);
            Writer.write(item);
            Writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
