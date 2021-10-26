import java.util.ArrayList;
import java.util.concurrent.Flow;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPublisher implements Flow.Publisher<String>{

    ArrayList<Flow.Subscriber> Subscriber_List = new ArrayList<>();

    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        this.Subscriber_List.add(subscriber);
        System.out.println(subscriber.getClass() + " Subscribe Complete");
    }

    public void submitData(String Data){

        for (Flow.Subscriber Subs: Subscriber_List) {

            if(Data.matches(".*[a-zA-Z]+.*") && Subs.getClass() == AlphabetSubscriber.class){
                //System.out.println("Alphabet");
                Subs.onNext(Data);
                Subs.onComplete();

            }

            if (Data.matches(".*[0-9]+.*") && Subs.getClass() == NumberSubscriber.class) {
                //System.out.println("Number");
                Subs.onNext(Data);
                Subs.onComplete();
            }

            if ( check_Spacial(Data)  && Subs.getClass() == SymbolSubscriber.class){
                //System.out.println("Symbol");
                Subs.onNext(Data);
                Subs.onComplete();
            }

        }
    }

    private boolean check_Spacial(String str){
        String specialChars = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
        boolean check = false;
        for (int i = 0; i < str.length(); i++) {
            String strChar = Character.toString(str.charAt(i));
            if (specialChars.contains(strChar)) {
                check = true;
                break;
            }
        }
        if (check) {
            return true;
        }else {
            return false;
        }
    }

}
