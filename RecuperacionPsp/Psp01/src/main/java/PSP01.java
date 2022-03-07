
import java.io.IOException;
import java.util.Scanner;


public class PSP01 {
    public static void main(String[] args) {

        //pb es el proceso padre
        ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c","type","recetas.txt");

        //con este metodo indicamos al proceso hijo que utilice la salida y la entrada del padre

        try {
            //dir es el proceso hijo
            Process dir = pb.start();

            dir.getOutputStream();

            Scanner sc = new Scanner(dir.getInputStream());
//            String linea = sc.nextLine();

            while (sc.hasNextLine()){

                System.out.println(sc.nextLine());
            }

            try {

                while (sc.hasNextLine()){

                    System.out.println(sc.nextLine());
                }
                
                System.out.println("El resultado del hijo es "+dir.waitFor());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
