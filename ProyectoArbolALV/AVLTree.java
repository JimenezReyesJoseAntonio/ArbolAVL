/**
 * Arbol AVL: es un arbol binario balanceado, ordenado y no
 * acepta nodos duplicados
 */

public class AVLTree {
    private AVLNode root;

    public void insert( String key, Boleto boleto)
    {
        root = insert( key, root,boleto );
    }

    /** x es una instancia de una clase que implementa Comparable */
    @SuppressWarnings("unchecked")
    private AVLNode insert( Comparable key, AVLNode t,Boleto boleto )
    {
        if ( t == null )
            t = new AVLNode( key,boleto);
        else if( key.compareTo( t.key ) < 0 )
        {
            t.izquierdo = insert( key, t.izquierdo,boleto );
            if ( height( t.izquierdo ) - height( t.derecho ) == 2 )
                if ( key.compareTo( t.izquierdo.dato ) < 0 )
                    t = rotateWithLeftChild( t );             /** Caso 1 */
                else
                    t = doubleWithLeftChild( t );               /** Caso 2 */
        }
        else if( key.compareTo( t.key ) > 0 )
        {
            t.derecho = insert( key, t.derecho,boleto );
            if ( height( t.derecho ) - height( t.izquierdo ) == 2 )
                if ( key.compareTo( t.derecho.key ) > 0 )
                    t = rotateWithRightChild( t );        /** Caso 4 */
                else
                    t = doubleWithRightChild( t );          /** Caso 3 */
        }
        else
            ; /** Duplicado; no hago nada */
        t.height = max( height( t.izquierdo ), height( t.derecho ) ) + 1;
        return t;
    }

    private static int max( int lhs, int rhs ) {
        return lhs > rhs ? lhs : rhs;
    }

    private static AVLNode rotateWithLeftChild( AVLNode k2 )
    {
        AVLNode k1 = k2.izquierdo;
        k2.izquierdo = k1.derecho;
        k1.derecho = k2;
        k2.height = max( height(k2.izquierdo), height(k2.derecho)) + 1;
        k1.height = max( height( k1.izquierdo ), k2.height ) + 1;
        return k1;
    }

    private static AVLNode rotateWithRightChild( AVLNode k1 )
    {
        AVLNode k2 = k1.derecho;
        k1.derecho = k2.izquierdo;
        k2.izquierdo = k1;
        k1.height = max( height(k1.izquierdo), height(k1.derecho) ) + 1;
        k2.height = max( height( k2.derecho ), k1.height ) + 1;
        return k2;
    }

    private static AVLNode doubleWithLeftChild( AVLNode k3 )
    {
        k3.izquierdo = rotateWithRightChild( k3.izquierdo );
        return rotateWithLeftChild( k3 );
    }

    private static AVLNode doubleWithRightChild( AVLNode k1 )
    {
        k1.derecho = rotateWithLeftChild( k1.derecho );
        return rotateWithRightChild( k1 );
    }

    private static int height( AVLNode t )
    {
        return t == null ? -1 : t.height;
    }

    /** Imprime el arbol con el recorrido InOrden */
    public void imprimir(Persona [] n)
    {
        imprimir(root,n);
    }

    /** Imprime el arbol con el reccorido PreOder*/
    public void imprimirPre(Persona [] n){
        imprimirPre(root,n); 
    }

    /** Imprime el arbol con el reccorido PostOder*/
    public void imprimirPost(Persona [] n){
        imprimirPost(root,n);
    }

    private void imprimir(AVLNode nodo,Persona [] personas)
    {
        String name = "nada";

        if ( nodo != null )
        {

            imprimir(nodo.derecho,personas);
            // recorremos un arreglo que contiene objetos Persona y los comparamos para encontrar el nombre por medio del id_persona
            for(int i = 0; i < personas.length;i++){
                if(personas[i].getId().equals(nodo.getBoleto().getIdPersona())){
                    name = personas[i].getName();
                }
            }
            System.out.println("["+ nodo.key + "]"+ "----> "+ name);

            imprimir(nodo.izquierdo,personas);
        }
    }

    private void imprimirPre(AVLNode nodo,Persona [] personas){
        String name = "nada";

        if ( nodo != null )
        {    
            // recorremos un arreglo que contiene objetos Persona y los comparamos para encontrar el nombre por medio del id_persona
            for(int i = 0; i < personas.length;i++){
                if(personas[i].getId().equals(nodo.getBoleto().getIdPersona())){
                    name = personas[i].getName();
                }
            }
            System.out.println("["+ nodo.key + "]"+ "----> "+ name);

            imprimir(nodo.derecho,personas);
            imprimir(nodo.izquierdo,personas);
        }
    }

    private void imprimirPost(AVLNode nodo,Persona [] personas){
        String name = "nada";

        if ( nodo != null )
        {
            imprimir(nodo.derecho,personas);
            imprimir(nodo.izquierdo,personas);
            // recorremos un arreglo que contiene objetos Persona y los comparamos para encontrar el nombre por medio del id_persona
            for(int i = 0; i < personas.length;i++){
                if(personas[i].getId().equals(nodo.getBoleto().getIdPersona())){
                    name = personas[i].getName();
                }
            }
            System.out.println("["+ nodo.key + "]"+ "----> "+ name);

        }
    }

    public void imprimirXaltura()
    {
        imprimirXaltura ( root );
    }

    /**
     * Imprime cada nodo linea por linea. Recorriendo el arbol desde
     * el Nodo mas a la derecha hasta el nodo mas a la izquierda,
     * y dejando una identacion de varios espacios en blanco segun su
     * altura en el arbol
     */
    private void imprimirXaltura(AVLNode nodo)
    {
        if ( nodo != null )
        {
            imprimirXaltura(nodo.derecho);
            System.out.println( replicate(" ",height(root) - height(nodo)) +"["+ nodo.dato + "]");
            imprimirXaltura(nodo.izquierdo);
        }
    }

    /**
     * Metodo estatico auxiliar que dada una cadena a y un enterto cnt
     * replica o concatena esa cadena a, cnt veces
     */
    private static String replicate (String a, int cnt)
    {
        String x = new String("");

        for ( int i = 0; i < cnt; i++ )
            x = x + a;
        return x;
    }

    /** Obtiene la altura del arbol AVL */
    public int calcularAltura()
    {
        return calcularAltura(root);
    }

    private int calcularAltura(AVLNode actual )
    {
        if (actual == null)
            return -1;
        else
            return 1 + Math.max(calcularAltura(actual.izquierdo), calcularAltura(actual.derecho));
    }

    /** Imprime el arbol por niveles. Comienza por la raiz. */
    public void imprimirPorNiveles(Persona [] n){
        imprimirPorNiveles(root,n);
    }

    /** Imprime el arbol por niveles. */
    /** Imprime el arbol por niveles con una descripcion. */

    private void imprimirPorNiveles(AVLNode nodo,Persona [] personas)
    {
        /** Mediante la altura calcula el total de nodos posibles del árbol
         * y crea el array cola con ese tamaño */
        int max = 0;
        int nivel = calcularAltura();
        String name = "";
        for ( ; nivel >= 0; nivel--)
            max += Math.pow(2, nivel);
        max++;      /** Suma 1 para no utilizar la posicion 0 del array */

        AVLNode cola[] = new AVLNode[ max ];

        /** Carga en la pos 1 el nodo raiz */
        cola[1] = nodo;
        int x = 1;

        /** Carga los demas elementos del arbol,
         * Carga null en izq y der si el nodo es null
         * i aumenta de a 2 por q carga en izq y der los hijos
         * x aumenta 1, que son los nodos raiz - padre */
        for (int i = 2; i < max; i += 2, x++)
        {
            if (cola[x] == null)
            {
                cola[i] = null;
                cola[i + 1] = null;
            }
            else
            {
                cola[i]   = cola[x].izquierdo;
                cola[i + 1] = cola[x].derecho;
            }
        }
        nivel = 0;
        int cont = 0;                 /** contador para cada nivel */
        int cantidad = 1;             /** cantidad de nodos por nivel */
        int ultimaPosicion = 1;       /** ultima Posicion del nodo en la cola de cada nivel */

        /** Cuando i es = a 2^nivel hay cambio de nivel
         * 2 ^ 0 = 1 que es el nodo raiz */
        for (int i = 1; i < max; i++)
        {
            if (i == Math.pow(2, nivel))
            {
                /** Nodo raiz tiene nivel 1, por eso (nivel + 1) */
                System.out.print("\n Nivel " + (nivel) + ": ");
                nivel++;
            }
            if ( cola[i] != null )
            {
                for(int k = 0; k < personas.length;k++){
                    if(personas[k].getId().equals(cola[i].getBoleto().getIdPersona())){
                        name = personas[k].getName();
                    }
                }
                //System.out.print("[" + cola[i].key + "]" + "----> "+ cola[i].getBoleto().getIdPersona());
                System.out.print(" ["+ cola[i].key + "]"+ " ----> "+ name);

                cont++;
            }
            if (ultimaPosicion == i  && cantidad == Math.pow(2, --nivel)) {
                if (cantidad == 1)
                    System.out.print(" Cantidad de nodos: " + cont + " (raiz)");
                else
                    System.out.print(" Cantidad de nodos: " +  cont);
                cont = 0;
                cantidad *= 2;
                ultimaPosicion += (int)Math.pow(2, ++nivel);
            }
        }
    }

    public Boleto buscarBoleto(AVLNode aux, Comparable key){
        while(aux!=null){
            int cmp = key.compareTo(aux.key);
            if (cmp < 0) {
                aux = aux.izquierdo;

            } else if (cmp > 0) {
                aux = aux.derecho;
            } else {
                return aux.getBoleto();
            }

        }
        return null;
    }

    public Boleto buscar(String key){
        if(key==null){

            return null;

        }

        Boleto encontrado = buscarBoleto(root,key);
        return encontrado;
    }
}
