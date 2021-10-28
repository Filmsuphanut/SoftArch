import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StringPublisher publisher = new StringPublisher();
        AlphabetSubscriber Al_subscriber = new AlphabetSubscriber();
        NumberSubscriber Nu_subscriber = new NumberSubscriber();
        SymbolSubscriber Sym_subscriber = new SymbolSubscriber();

        publisher.subscribe(Al_subscriber);
        publisher.subscribe(Nu_subscriber);
        publisher.subscribe(Sym_subscriber);

        //while (true){
            Scanner inp = new Scanner(System.in);
            System.out.println("Enter Text");

            String Data = inp.nextLine();
            System.out.println("Your text : " + Data);

            publisher.submitData(Data);
        //}

    }
}
