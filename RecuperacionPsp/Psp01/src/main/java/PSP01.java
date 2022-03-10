
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class PSP01 {
    public static void main(String[] args) {

        //pb es el proceso padre
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "Hijo1.jar");


        //con este metodo indicamos al proceso hijo que utilice la salida y la entrada del padre
         //pb.inheritIO();

        try {
            //hijo1 es el proceso hijo
            Process hijo1 = pb.start();

            Scanner scHijo = new Scanner(hijo1.getInputStream());
          //  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(hijo1.getOutputStream()));
            PrintWriter pw = new PrintWriter(hijo1.getOutputStream(),
                    true);

            Scanner sc = new Scanner(System.in);

            //Empezamos el ritual

            String  lineaUsuario = sc.nextLine();
            pw.println(lineaUsuario);
            String lineaProceso = scHijo.nextLine();

//            bw.write(lineaUsuario);
//            bw.newLine();
//            bw.flush();
//

            boolean salida_ok = hijo1.waitFor() == 0;

            hijo1.getOutputStream();

            //salida del hijo
            Scanner salidaHijo ;

            // esta es una de las formas para redirigir la salida de errores
            if (salida_ok){
                salidaHijo  = new Scanner(hijo1.getInputStream());
            }else {
                salidaHijo = new Scanner(hijo1.getInputStream());
            }

            while (salidaHijo.hasNextLine()) {

                System.out.println(salidaHijo.nextLine());
            }

            try {

                while (salidaHijo.hasNextLine()) {

                    System.out.println(salidaHijo.nextLine());
                }

                System.out.println("El resultado del hijo es " + hijo1.waitFor());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
