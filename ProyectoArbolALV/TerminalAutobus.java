
public class TerminalAutobus
{
    private String clave;
    private String ciudad;
    private String nombre;
    private String tipo;

    public TerminalAutobus(String clave, String ciudad,String nombre, String tipo){
        this.clave = clave;
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.tipo = tipo;

    }

    @Override
    public String toString(){
        return String.format("\n|%-20s| %20s| %20s| %20s| \n",clave,ciudad,nombre,tipo);
    }
}
