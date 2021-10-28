import java.util.ArrayList;
import java.util.concurrent.Flow;

public class StringPublisher implements Flow.Publisher<String>{

    ArrayList<StringSubscriber> Subscriber_List = new ArrayList<>();
    ArrayList<StringSubscription> Subscription_List = new ArrayList<>();


    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        StringSubscription my_subscription = new StringSubscription();


        this.Subscription_List.add(my_subscription);
        my_subscription.get_Subscriber((StringSubscriber) subscriber);

        this.Subscriber_List.add((StringSubscriber) subscriber);
        subscriber.onSubscribe(my_subscription);
        my_subscription.set_type(subscriber.getClass());


        System.out.println(subscriber.getClass() + " Subscribe Complete");
    }

    public void submitData(String Data) {


        for (StringSubscription Subs : Subscription_List) {


            if(Data.matches(".*[a-zA-Z]+.*") && Subs.get_type() == AlphabetSubscriber.class){
                //System.out.println("Alphabet");
                Subs.set_Data(Data);

            }

            if (Data.matches(".*[0-9]+.*") && Subs.get_type() == NumberSubscriber.class) {
                //System.out.println("Number");
                Subs.set_Data(Data);
            }

            if ( check_Spacial(Data)  && Subs.get_type() == SymbolSubscriber.class){
                //System.out.println("Symbol");
                Subs.set_Data(Data);
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
