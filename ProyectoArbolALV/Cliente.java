
public class Cliente
{
    public static void main(String args[]){
        Paseo client = new Paseo();

        AVLTree arbol = client.getArbol();
        /**Agregamos a las personas con la informacion del txt */
        client.agregarPersonas();
        /**Agregamos a los autobuses con la informacion del txt */
        client.agregarAutobuses();
        /**Agregamos a los viajes con la informacion del txt */
        client.agregarViajes();
        /**Agregamos las terminales con la informacion del txt */
        client.agregarTerminales();
        //creamos los boletos con la informacion del txt boletos y los txt donde sacamos informacion que requerian 
        System.out.printf("%45s","Los boletos se comienzan a agregar al arbol\n" );
        client.agregarBoletos();
        System.out.printf("\n %45s","Se muestra el numero de boleto y quien lo compro\n");
        client.imprimir();
               
        
        System.out.printf("%65s","Busqueda de boletos\n");
        int [] array = client.arregloRandom();
        for(int i = 0; i < array.length;i++){
            String buscado = String.valueOf(array[i]);
            System.out.println("\nBoleto a buscar: " + buscado);
            System.out.printf("\n|%-20s| %-20s| %-20s| %-20s| %-20s | %-20s \n","Numero","Codigo","ID persona","Numero asiento","Precio","Clase");
            client.buscarBoleto(buscado);

        }

    }
}
