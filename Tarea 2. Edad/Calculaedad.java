
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Calculaedad {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        Scanner teclado = new Scanner(System.in);
        int dia = 0;
        int mes = 0;
        int anho = 0;
        String fechaNacimiento = "";

        //Pedimos la fecha de nacimiento por consola
        System.out.println("**** CALCULA TU EDAD ******");
        System.out.println("Introduce tu fecha de nacimiento:");
        System.out.println("Día: ");
        dia = teclado.nextInt();
        System.out.println("Mes: ");
        mes = teclado.nextInt();
        System.out.println("Año: ");
        anho = teclado.nextInt();

		//Lo pasamos a int para pasarlo por el comando
        String [] lineaComandos = {"java", "Edad", String.valueOf(dia),String.valueOf(mes),

    String.valueOf(anho)};

        //Crea e inicia un proceso que estará formado de argumentos
        //El proceso se inicia fuera del try-with-resources
        Process proceso = new ProcessBuilder(lineaComandos).start();
        	//cañería
        try (InputStream is = proceso.getInputStream(); 
			//char
            InputStreamReader isr = new InputStreamReader(is); 
			//líneas
            BufferedReader br = new BufferedReader(isr); 
	){
              
    //Lee lo que escribe el hijo. El sout de Edad
    String line ="";
	while((line = br.readLine()) != null){
		System.out.println(line);
	}
	
		//Primero se ponen las excepciones específicas
        } catch (ArrayIndexOutOfBoundsException e) {

        } catch (IOException e1) {
            System.out.println(e1.getLocalizedMessage());

            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();		
        }

    }
}
