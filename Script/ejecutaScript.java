import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ejecutaScript {

    final static String[] PROCESO = {"listado.bat"};

    public static void main(String[] args) {

        try {

            String recibido = "";
            // Preparo el proceso hijo
            ProcessBuilder pb = new ProcessBuilder(PROCESO);
            // Lanzo el proceso hijo
            Process process = pb.start();
            InputStream is = process.getInputStream();
            // Miro lo que me manda
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            recibido = br.readLine();
            // Miro el retorno de la ejecución
            int retorno = process.waitFor();

            System.out.println("Texto recibido: " + recibido);
            System.out.println("Salida del proceso: " + retorno);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
