import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ejecuta {


   public static void main(String[] args) throws InterruptedException{


    int retorno = lanzarProceso(args);


    System.out.println("*** SALIDA STDEER ***");
    if (retorno == 0){
    System.out.println("Retorno "+retorno);
        System.out.println("\n Proceso ejecutado correctamente");

   }else  {
    System.out.println("Proceso fallido");
   }
   }
   public static int lanzarProceso(String[] args) throws InterruptedException{
    int devolver = -1;

        try{
       
            // Preparo el proceso hijo
            ProcessBuilder pb = new ProcessBuilder(args);

            //Se crea el proceso hijo
            Process process = pb.start();

            //Se obtiene el stdout del hijo. Lo escribe mientras trabaja
            InputStream is = process.getInputStream();

            //Conveirte UTF-8 en String de Java
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            System.out.println("Salida del proceso hijo "+Arrays.toString(args));

            //Lo leemos
            String linea = br.readLine();

            System.out.println("*** SALIDA STDOUT ***");
            while((linea = br.readLine() )!= null){
                System.out.println(linea);

            }


            //Guarda retorno cuando termina el proceso
            devolver = process.waitFor();

            //el proceso devuelve un entero al finalizar, por eso cuando finalice
            //guarda esa variable y es lo que devuelve este método
         
        }catch(IOException e){
            e.getLocalizedMessage();
        }

        return devolver;
    }
}
