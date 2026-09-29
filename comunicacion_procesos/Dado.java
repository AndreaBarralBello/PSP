public class Dado {
    
    public static void main(String[] args){
        // Compruebo el número de dados
        if(args.length==0){
            // No se ha indicado el número de dados
            System.out.println("No has indicado el número de dados");
            System.exit(-1);
        }else if(compruebaArgumentos(args)){
            // No se ha indicado el número de dados
            System.out.println("Debes indicar los dados con números");
            System.exit(-2);
        }else{
            System.out.println(sumaDados(args));
            System.exit(0);
        }
    }
    
    private static boolean compruebaArgumentos(String[] dados){
        boolean devolver=false;
        for(String dado: dados){
            try{
                Integer.valueOf(dado);
            }catch(NumberFormatException e){
                devolver=true;
            }
        }
        return devolver;
    }

    private static int sumaDados(String[] dados){
        int sumaDados=0;
        for(String dado: dados){
            //coge al azar, y los suma
            sumaDados+=(int) (Math.random()*Double.parseDouble(dado)+1);
        }
        return sumaDados;
    }
}