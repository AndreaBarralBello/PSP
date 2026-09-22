
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Programa {

    public static void main(String[] args) {

        String [] lineaComando = {"java", "ClaseTasklist", "tasklist" };

        try(
        Process proceso = new ProcessBuilder(lineaComando).start();
        ){
        InputStream is = proceso.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String linea = "";

        System.out.println(Arrays.toString(lineaComando));

        while ((linea = br.readLine()) != null){
            System.out.println(linea);
        }
        } catch (IOException ex){
            System.out.println(ex.getLocalizedMessage());

        }
        


        /*
        El proceso ppal llama al tasklist
        llama al segundo proceso que lo devuelva ordenado
         */

    }
    
}
