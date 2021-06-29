
/**
 * Write a description of class Autobus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Autobus
{
    private int numero;
    private String clase;
    private int capacidad;
    
    public Autobus(int numero, String clase, int capacidad){
     this.numero = numero;
     this.clase = clase;
     this.capacidad = capacidad;
    
    }
    
        @Override
    public String toString(){
        return String.format("\n|%-20s| %20s| %20s| \n",numero,clase,capacidad);
    }
    
    public String getClase(){
    
     return clase;
    }
    
}
