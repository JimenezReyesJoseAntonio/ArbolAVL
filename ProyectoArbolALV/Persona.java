
/**
 * Write a description of class Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Persona
{
    private String id;
    private String nombre;
    private String sexo;
    private String nacionalidad;
    private int edad;
    
    public Persona(String id, String nombre, String sexo, String nacionalidad, int edad){
      this.id = id;
      this.nombre = nombre;
      this.sexo = sexo;
      this.nacionalidad = nacionalidad;
      this.edad = edad;
    
    }
    
    @Override
    public String toString(){
        return String.format("\n|%-20s| %20s| %20s| %20s| %20s | \n",id,nombre,sexo,nacionalidad,edad);
    }
    
    public String getId(){
     return id;
    }
    
    public String getName(){
     return nombre;
    }
}
