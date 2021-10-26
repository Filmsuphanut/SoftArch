import java.io.IOException;

public class SymbolSubscriber extends StringSubscriber{
    @Override
    public void onNext(String item) {
        try {
            super.Create(item,"SymbolSubscriber.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onComplete() {
        System.out.println("SymbolSubscriber Write Data Complete");
    }
}
