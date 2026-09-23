
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Programa {

    public static void main(String[] args) {

        String [] lineaComando = {"tasklist"};

        try(
        Process proceso = new ProcessBuilder(lineaComando).start();
        ){
        InputStream is = proceso.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String linea = "";

        System.out.println(Arrays.toString(lineaComando));

        linea = br.readLine();
        linea = br.readLine();
        linea = br.readLine();

        String [] cachos = linea.split(" ");

        int primero = cachos [0].length();
        int segundo = cachos [1].length();
        int tercero = cachos [2].length();
        int cuarto = cachos [3].length();



        while ((linea = br.readLine()) != null){
            System.out.println("Nombre de imagen: "+linea.substring(0, cachos[0].length()));
            //la segunda cadena empieza en la última posición de 0 +1
            System.out.println("PID: "+linea.substring(((cachos [0].length()) -1),((cachos[0].length()+1)+(cachos[1].length()-1))));

            System.out.println("Nombre de sesión: "+linea.substring(((cachos[0].length())+(cachos[1].length())+1)
            , ((cachos[0].length())+(cachos[1].length())+ (cachos[2].length()))));

            System.out.println("Nombre "+ (primero) + "Servicios" +linea.substring((primero), (primero+segundo+tercero+3)));
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
