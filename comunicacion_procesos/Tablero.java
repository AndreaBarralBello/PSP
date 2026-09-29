import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class Tablero{
    
    final static String[] LANZAR={"java","Dado","6","6"};

	public static void main(String[] args){
		/*
         * Resto del código
         */
        System.out.println(lanzaDado());
	}

    private static int lanzaDado(){
        try{
            String recibido;
            // Preparo el proceso hijo
            ProcessBuilder pb = new ProcessBuilder(LANZAR);
            // Lanzo el proceso hijo
            Process process = pb.start();
            // Miro lo que me manda
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            recibido= br.readLine();
            // Miro el retorno de la ejecución
            int retorno = process.waitFor();
            if(retorno < 0){
                System.out.println(recibido);
                return retorno;
            }else{
                return Integer.parseInt(recibido);
            }
        }catch(IOException | InterruptedException e){
            return -1;
        }
    }
}