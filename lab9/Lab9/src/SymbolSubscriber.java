import java.io.IOException;

public class SymbolSubscriber extends StringSubscriber{


    @Override
    public void onComplete() {
        String Data = super.Data;
        super.Data = "";

            try {
                Create(Data+"\n", "SymbolSubscriber.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}
