import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription {

    private StringSubscriber my_subscriber;
    private Object class_type;
    private boolean check_request = false;
    private String Data = "";

    public void get_Subscriber(StringSubscriber my_subscriber){
        this.my_subscriber = my_subscriber;
    }

    @Override
    public void request(long n) {

        if(!this.check_request){
            this.check_request = true;
        }
            if (this.Data == "") {
                this.my_subscriber.onComplete();
                this.check_request = true;
            } else {
                String Buffer = this.Data.substring(0,this.Data.length() < (int)n? this.Data.length():(int)n);
                //System.out.println(Buffer);
                this.Data = this.Data.substring(this.Data.length() < (int)n? this.Data.length():(int)n, this.Data.length());
                this.my_subscriber.onNext(Buffer);
        }

    }

    @Override
    public void cancel() {

    }

    public void set_type(Object type){
        this.class_type = type;
    }

    public Object get_type(){
        return this.class_type;
    }

    public void set_Data(String Data){
        this.Data = Data;

        if(this.check_request){
            this.my_subscriber.onNext("");
        }

    }
}