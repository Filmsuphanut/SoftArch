import java.io.IOException;

public class NumberSubscriber extends StringSubscriber {

    @Override
    public void onNext(String item) {
        try {
            super.Create(item,"NumberSubscriber.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onComplete() {
        System.out.println("NumberSubscriber Write Data Complete");
    }

}
