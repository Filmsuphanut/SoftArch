import java.io.IOException;

public class NumberSubscriber extends StringSubscriber {

    @Override
    public void onComplete() {
        String Data = super.Data;
        super.Data = "";

            try {
                Create(Data+"\n", "NumberSubscriber.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

}
