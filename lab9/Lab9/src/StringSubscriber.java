import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow;

public abstract class StringSubscriber implements Flow.Subscriber<String> {

    private StringSubscription my_subscription;
    public String Data = "";

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.my_subscription = (StringSubscription) subscription;
        this.my_subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        this.Data += item;
        //if(this.Data == ""){
        this.my_subscription.request(1);
        //}

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
            }else{
                WriteFile(item,file);
            }

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
            if(file != ""){
                System.out.println(file + " Write Data Complete");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
