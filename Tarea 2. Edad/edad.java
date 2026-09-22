import java.time.LocalDate;
import java.time.Period;

public class Edad {

public static void main(String[] args) {

    //Como nos llega por un array de Strings, descomponemos ese array para 
    //calcular el día, mes y anho
    try{

    int dia = Integer.parseInt(args[0]);
    int mes = Integer.parseInt(args[1]);
    int anho = Integer.parseInt(args[2]);

    //Lo pasamos a LocalDate
    LocalDate fechaNacimiento = LocalDate.of(anho, mes, dia);

    //Fecha actual
    LocalDate ahora = LocalDate.now();

    //Calculamos la diferencia entre las dos fechas
    Period edad = fechaNacimiento.until(ahora);

    //probamos si funciona
    System.out.println(edad.getYears());

    
}catch(ArrayIndexOutOfBoundsException e){
    System.out.println("Faltan argumentos");
}catch (NumberFormatException e){
    System.out.println("Los argumentos deben ser números enteros");
}catch (Exception ex){
    System.out.println("Error "+ex.getLocalizedMessage());
}  

}

}