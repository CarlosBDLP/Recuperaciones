import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String frase;

        while (!(frase = sc.nextLine())
                .equalsIgnoreCase("stop")){

            System.out.println(frase);
        }
    }
}
