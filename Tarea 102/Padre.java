import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Padre {
    public static void main(String[] args) {
        try {
            // Lanzo el proceso hijo
            ProcessBuilder processBuilderHijo = new ProcessBuilder("java", "Hijo");
            
            // Inicio el proceso hijo
            Process procesoHijo = processBuilderHijo.start();

            
            // Flujo para ENVIAR datos al stdin del hijo
            BufferedWriter escritorHijo = new BufferedWriter(
                new OutputStreamWriter(procesoHijo.getOutputStream())
            );
            
            // Flujo para LEER datos del stdout del hijo
            BufferedReader lectorHijo = new BufferedReader(
                new InputStreamReader(procesoHijo.getInputStream())
            );

            
            Scanner scannerUsuario = new Scanner(System.in);
            
            System.out.println("Escribe cualquier texto para pedir un número aleatorio.");
            System.out.println("Escribe 'fin' para terminar.");
            System.out.println("-------------------------------------------");

            while (scannerUsuario.hasNextLine()) {
                String lineaUsuario = scannerUsuario.nextLine();

                // Enviar la línea al stdin del hijo
                escritorHijo.write(lineaUsuario);
                escritorHijo.newLine();
                escritorHijo.flush(); // CRÍTICO: forzar el envío

                // Se escribe fin
                if (lineaUsuario.equals("fin")) {
                    break;
                }

                // Ver respuesta
                String respuestaHijo = lectorHijo.readLine();
                

                System.out.println("Número aleatorio recibido: " + respuestaHijo);
            }

            // Cerrar flujos
            escritorHijo.close();
            scannerUsuario.close();
            
            // Esperar a que el proceso hijo finalice
            int codigoSalida = procesoHijo.waitFor();
            
            System.out.println("Hasta la vista");
            System.out.println("(El proceso hijo terminó con código: " + codigoSalida + ")");

        } catch (Exception e) {
            System.err.println("Error en la comunicación entre procesos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}