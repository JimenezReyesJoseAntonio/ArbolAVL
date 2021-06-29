
/**En esta clase se encuentran los metodos para guardar los objetos que creamos con los txt
 * y los metodos que utilizaremos para la clase cliente.
 * Esta clase cuenta con un metodo main con el cual podemos ver las formas de impresion del arbol 
 * la impresion por InOrder,PosOrder,PreOrder.
 *
 */
public class Paseo
{
    static In in;
    //Los objetos creados de los txt se guardan en colas
    private static Queue <Persona> personas;
    private static Queue <Autobus> autobuses;
    private static Queue <Viaje> viajes;
    private static Queue <TerminalAutobus> terminales;
    private static Queue <Boleto> boletos;
    private static Queue <Persona> personaAux;
    private static AVLTree arbol;
    private static Persona per[];
    public Paseo(){
        personas  = new Queue <Persona>();
        autobuses = new Queue <Autobus>();
        viajes    = new Queue <Viaje>();
        terminales= new Queue <TerminalAutobus>();
        personaAux = new Queue <Persona>();
        arbol = new AVLTree();
    }

    public void agregarPersonas(){
        try {
            in = new In("personas.txt");
            String cadena;
            while (!in.isEmpty()){
                cadena = in.readLine();
                String [] persona = cadena.split("%");
                Persona person = new Persona(persona[0],persona[1],persona[2],persona[3],Integer.parseInt(persona[4]));
                String str = "";

                personas.enqueue(person);
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public void agregarAutobuses(){
        try {
            in = new In("autobus.txt");
            String cadena;
            while (!in.isEmpty()) {
                cadena = in.readLine();
                String [] autobus = cadena.split("%");
                Autobus auto= new Autobus(Integer.parseInt(autobus[0]),autobus[1],Integer.parseInt(autobus[2]));
                String str = "";

                autobuses.enqueue(auto);
            }
        }
        catch (IllegalArgumentException e) {
            System.err.print(e);
        }
    }

    public void agregarViajes(){
        try {
            in = new In("viaje.txt");
            String cadena;
            int i =0;
            while (!in.isEmpty()) {
                cadena = in.readLine();

                String [] viaje = cadena.split("%");
                Viaje via = new Viaje(viaje[0],Integer.parseInt(viaje[1]),Integer.parseInt(viaje[2]),
                        Integer.parseInt(viaje[2]),viaje[4],viaje[5]);
                String str = "";

                viajes.enqueue(via);

            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public void agregarTerminales(){
        try {
            in = new In("terminal.txt");
            String cadena;
            while (!in.isEmpty()) {
                cadena = in.readLine();
                String [] terminal = cadena.split("%");
                TerminalAutobus ter= new TerminalAutobus(terminal[0],terminal[1],terminal[2],terminal[3]);
                String str = "";

                terminales.enqueue(ter);
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public void agregarBoletos(){
        Viaje v;
        Viaje via[] = new Viaje[viajes.size()];
        per = new Persona[personas.size()];
        Autobus bus[] = new Autobus[autobuses.size()];
        int i = 0;
        int aux = 0;
        // guardamos los objetos de la cola en los arreglos para utilizar los atributos que se necesitan para crear el boleto
        while(!viajes.isEmpty()){
            via[i] = viajes.dequeue();

            i++;
        }
        i = 0;
        while(!personas.isEmpty()){
            per[i] = personas.dequeue();
            personaAux.enqueue(per[i]);
            i++;
        }
        i = 0;
        while(!autobuses.isEmpty()){
            bus[i] = autobuses.dequeue();
            i++;
        }
        try {
            in = new In("boletos.txt");
            String cadena;
            Boleto ticket;
            while (!in.isEmpty()){
                cadena = in.readLine();
                String [] boleto = cadena.split("%");
                String key = boleto[0];
                //utilizamos los atributos de los objetos autobus y viaje para crear los boletos 
                if (aux < 16){
                    ticket= new Boleto(boleto[0],via[0].getCodigo(),boleto[2],Integer.parseInt(boleto[3]),Integer.parseInt(boleto[4]),
                        bus[0].getClase());
                    arbol.insert(key,ticket);

                }
                if(aux > 15){

                    ticket= new Boleto(boleto[0],via[1].getCodigo(),boleto[2],Integer.parseInt(boleto[3]),Integer.parseInt(boleto[4]),
                        bus[1].getClase());
                    arbol.insert(key,ticket);
                }
                aux++;
            }
        }
        catch (IllegalArgumentException e) {
            System.err.println(e);
        }
    }
    //busqueda de un boleto por su llave
    public void buscarBoleto(String key){
        Boleto b;
        if(arbol.buscar(key) != null){
            b = arbol.buscar(key);
            System.out.println(b.toString());
        }
        else  System.out.println("\nEl boleto no existe");
    }

    public static Persona [] arregloPer(){
        Persona ps [] = per;

        return ps;
    }

    public AVLTree getArbol(){
        return arbol;
    }

    public static void imprimir(){
        Persona [] personas = arregloPer();
        arbol.imprimir(personas);
    }

    public static void imprimirPre(){
        Persona [] personas = arregloPer();
        arbol.imprimirPre(personas);

    }

    public static void imprimirPost(){
        Persona [] personas = arregloPer();
        arbol.imprimirPost(personas);

    }

    public static void imprimirPorNivel(){
        Persona [] personas = arregloPer();
        arbol.imprimirPorNiveles(personas);

    }
    // genera un arreglo con 10 numeros random que no se repiten y sin ordenar
    public int [] arregloRandom(){
        int n = 10;

        int array[] = new int[n];
        for(int i = 0; i <array.length; i++){
            array[i] = (int)(Math.random()*42)+13;
            for(int j = 0; j < i; j++){
                if(array[i]==array[j]){
                    i--;
                }
            }
        }
        return array;

    }

    public static void main(String args[]){
        Paseo pas = new Paseo();
        pas.agregarPersonas();
        pas.agregarAutobuses();
        pas.agregarViajes();
        pas.agregarTerminales();

        System.out.println("Se comienzan a agregar los boletos al arbol\n");
        pas.agregarBoletos();

        System.out.println("Impresion por nivel"); 
        imprimirPorNivel();

        System.out.println("\nImpresion por InOrder\n"); 
        imprimir();

        System.out.println("\nImpresion por PreOrder\n"); 
        imprimirPre();

        System.out.println("\nImpresion por PostOrder\n"); 
        imprimirPost();

    }

}
