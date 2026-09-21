import java.io.IOException;

public class Calculaedad {
    public static void main(String[] args) throws IOException{

		Process process = null;

	try {
		
        //Crea e inicia un proceso que estará formado de argumentos
		process = new ProcessBuilder(args).start();
		//Primero se ponen las excepciones específicas
	} catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("Tienes que llamar al proceso dado pq no has pasado argumentos");

		System.exit(0);//cierra el hilo ppal y cierra el programa
	//Luego las excepciones genéricas pq sino Excepcion captura todo y 
	//no lo diferencia

	//Se pueden llamar e pq son ámbitos diferentes
	} catch (IOException e1){
		System.out.println(e1.getLocalizedMessage());

		System.exit(0);
	}catch (Exception e){
	e.printStackTrace();
	}
			
    
}
}
