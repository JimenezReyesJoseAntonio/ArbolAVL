

public class Viaje
{
  private String codigo;
  private int Num_autobus;
  private int Num_terminalSalida;
  private int Num_terminalDestino;
  private String fecha;
  private String hora;
  
  public Viaje(String codigo, int Num_autobus, int Num_terminalSalida, int Num_terminalDestino,
  String fecha, String hora){
    this.codigo = codigo;
    this.Num_autobus = Num_autobus;
    this.Num_terminalSalida = Num_terminalSalida;
    this.Num_terminalDestino = Num_terminalDestino;
    this.fecha =fecha;
    this.hora =hora;
    
    
  
  }
  
      @Override
    public String toString(){
        return String.format("\n|%-20s| %20s| %20s| 20%s| 20%s| %20s |  \n",codigo,Num_autobus,Num_terminalSalida,Num_terminalDestino,fecha,hora);
    }
    
    public String getCodigo(){
     return codigo;
    }
}
