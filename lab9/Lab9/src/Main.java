import java.util.Scanner;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;

public class Main {

    public static void main(String[] args) {

        StringPublisher publisher = new StringPublisher();
        StringSubscriber Al_subscriber = new AlphabetSubscriber();
        StringSubscriber Nu_subscriber = new NumberSubscriber();
        StringSubscriber Sym_subscriber = new SymbolSubscriber();

        publisher.subscribe(Al_subscriber);
        publisher.subscribe(Nu_subscriber);
        publisher.subscribe(Sym_subscriber);

        Scanner inp = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Text");

        String Data = inp.nextLine();  // Read user input
        System.out.println("Your text : " + Data);  // Output user input

        publisher.submitData(Data);

    }
}
