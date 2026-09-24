public class Valores implements Comparable<Valores>  {

    private String nombre;
    private int memoria;

    public Valores() {
    }

    public Valores(int memoria, String nombre) {
        this.memoria = memoria;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Valores [nombre=" + nombre + ", memoria=" + memoria + "]";
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    @Override
    public int compareTo(Valores o) {

        //si devuelve 0 es igual
        //<0 negativo
        //>0 positivo

        if(this.memoria ==o.memoria){

            return 0;
        }else if (this.memoria> o.memoria){
                return 1;
            
        }else{ return -1;}
    }



    
}
