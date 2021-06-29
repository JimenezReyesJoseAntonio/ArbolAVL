
/**
 * Write a description of class Boleto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boleto
{
    private String numero;
    private String codigo_viaje;
    private String id_persona;
    private int Num_asiento;
    private int precio;
    private String clase;
    
    public Boleto(String numero, String codigo_viaje, String id_persona, int Num_asiento,
    int precio, String clase){
      this.numero = numero;
      this.codigo_viaje = codigo_viaje;
      this.id_persona = id_persona;
      this.Num_asiento = Num_asiento;
      this.precio = precio;
      this.clase = clase;
    
    }
    @Override
    public String toString(){
        return String.format("\n|%-20s| %-20s| %-20s| %-20s| %-20s | %-20s \n",numero,codigo_viaje,id_persona,Num_asiento,precio,clase);
        
    }
    
    public String getIdPersona(){
     return id_persona;
    }
    
    public String getClase(){
      return clase;
    }
}
