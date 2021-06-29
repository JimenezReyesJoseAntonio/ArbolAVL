public class AVLNode 
{
  public String dato;        // el dato del nodo
  public AVLNode izquierdo;      // hijo izquierdo
  public AVLNode derecho;        // hijo derecho
  public int height;             // altura
  //public String key;
  private Boleto boleto;
  public Comparable key;
  
  /**Constructor recibe un objeto de la clase Comparable y un objeto del tipo boleto*/
  public AVLNode(Comparable key,Boleto boleto){
    this.key = key;
    this.boleto = boleto;
  }
  
  public Boleto getBoleto(){
   return this.boleto;  
  }
}


