
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programa implements Comparable<Valores> {


    public static void main(String[] args) {

        String[] lineaComando = { "tasklist" };

        try (
                Process proceso = new ProcessBuilder(lineaComando).start();) {
            InputStream is = proceso.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String linea = "";

            System.out.println(Arrays.toString(lineaComando));

            linea = br.readLine();
            linea = br.readLine();
            linea = br.readLine();

            String[] cachos = linea.split(" ");

            int primero = cachos[0].length();
            int segundo = cachos[1].length();
            int tercero = cachos[2].length();
            int cuarto = cachos[3].length();
            int quinto = cachos[4].length();

                    
            
List<Valores> lista = new ArrayList<>();
 
                    
            while ((linea = br.readLine()) != null) {
                /*
                 * System.out.println("Nombre de imagen: "+linea.substring(0,
                 * cachos[0].length()));
                 * //la segunda cadena empieza en la última posición de 0 +1
                 * System.out.print("PID: "+linea.substring(((cachos [0].length())
                 * -1),((cachos[0].length()+1)+(cachos[1].length()-1))));
                 * 
                 * System.out.print("Nombre de sesión: "+linea.substring(((cachos[0].length())+(
                 * cachos[1].length())+1)
                 * , ((cachos[0].length())+(cachos[1].length())+ (cachos[2].length()))));
                 */

                String nombre = linea.substring(primero, primero + segundo);

                String memoriaString = linea.substring((primero+segundo+tercero+cuarto+4),
            primero+segundo+tercero+cuarto+quinto).trim();

            int memoria = Integer.parseInt(memoriaString);

                System.out.println("Nombre " + (primero) );
                System.out.println("Servicios "+ linea.substring((primero), 
                (primero + segundo + tercero +cuarto+ 3)));

                Valores valor = new Valores();
                valor.setNombre(nombre);
                valor.setMemoria(memoria);
                
    
                lista.add(valor);

            }
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());

        }

        /*
         * El proceso ppal llama al tasklist
         * llama al segundo proceso que lo devuelva ordenado
         */

    }

    @Override
    public int compareTo(Valores o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
