import java.util.Random;
import java.util.Scanner;

public class Hijo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.flush();

        // Bucle infinito esperando peticiones del padre
        while (scanner.hasNextLine()) {
            String mensaje = scanner.nextLine().trim();


            if (mensaje.isEmpty()) {
                System.out.println("No has escrito nada");
                continue;
            }

            
            if (mensaje.equals("fin")) {
                System.out.println("Adios");
                System.out.flush();
                break;
            }else {
                // Cualquier otro texto: generar número aleatorio entre 0 y 10
                int numero = random.nextInt(11);
                System.out.println(numero);
                System.out.flush();
            }
        }

        scanner.close();
    }
}