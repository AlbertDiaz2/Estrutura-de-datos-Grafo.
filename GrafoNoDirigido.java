/**
  * Archivo: GrafoNoDirigido.java
  * Descripcion: Implementacion de un grafo no dirigido mediante una clase.
  * Autores: Albert Diaz 11-10278
  *          Nathalia Silvera 12-10921
  * Ultima modificacion: *El dia de la entrega*
  */

import java.util.*;
import java.io. BufferedReader;
import java.io.FileReader;
import java.io.StringReader;

public class GrafoNoDirigido implements Grafo
{

    // atributos de la clase GrafoNoDrigido.
    private int nVertices; // numero de vertices del grafo.
    private int nLados;     // numero de lados del grafo.
    private int n;
    private int l;
    private ArrayList<ArrayList<Vertice>> listaDeListas = new ArrayList<ArrayList<Vertice>>();
    private ArrayList<Vertice> listaVertices = new ArrayList<Vertice>();
    private ArrayList<Arista> listaDeAristas = new ArrayList<Arista>();

    /* 
     * Descripcion:    Constructor de la clase GrafoNoDirigido.
     * Orden: O(constante)
     */
    
    public void GrafoNoDirigido() 
    {
        n = 0;
        l = 0;
    }

    /** 
     * Descripcion:    Carga la informacion almacenada en el archivo.
     * Pre condicion:  dirArchivo == String.
     * @param dirArchivo: nombre del archivo.
     * Post condicion: lectura satisfactoria o una excepcion.
     * Orden: O(cubica)
     */
    
    public boolean cargarGrafo(String dirArchivo) 
    {

        boolean cargoArchivo;
        String s;
        int contador = 0;
        String[] tok;
        BufferedReader in = null;

        try {

            in = new BufferedReader(new FileReader(dirArchivo));

            while( ( s = in.readLine() ) != null )
            {

                tok = s.split(" ");

                if( tok.length == 4  && ( contador >= ( nVertices + 2 ) ) )
                {
                    agregarArista(tok[0], Double.parseDouble(tok[3]), 
                              tok[1], tok[2]);
                }

                else if( tok.length == 2 && ( contador >= 2 && contador < (nVertices + 2) ) )
                {

                    agregarVertice(tok[0], Double.parseDouble(tok[1]));
                }

                else if( tok.length == 1 && contador == 0 )
                {
                    setNumeroVertice( Integer.parseInt( tok[0] ) );
                }

                else if(tok.length == 1 && contador == 1 )
                {
                    setNumeroLados( Integer.parseInt( tok[0] ) );
                }

                else
                {
                    cargoArchivo = false;
                    return cargoArchivo;
                }
                contador = contador + 1;  
            }
        }

        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }

        finally 
        {

            try 
            { 
                if (in != null) 
                {
                    in.close(); 
                }
            }
            catch (Exception e2) 
            {
                e2.printStackTrace();
            }
        }

        cargoArchivo = true;
        return cargoArchivo;
    }
    
    /** 
     * Descripcion:    Metodo getter. 
     *                 Retorna el numero total de vertices del grafo dirigido.
     * Pre condicion:  True
     * Post condicion: return nVertices
     * @return nVertices
     * Orden: O(constante)
     */
    
    public int numeroDeVertices() {
        return nVertices;
    }

    /** 
     * Descripcion:    Metodo getter.
     *                 Retorna el numero total de lados del grafo 
     *                 no dirigido.
     * Pre condicion:  True
     * Post condicion: return nLados
     * @return nLados
     * Orden: O(constante)
     */
    
    public int numeroDeLados() {
        return nLados;
    }

    /**
     * Descripcion:    Retorna n, variable para controlar el numero de 
     *                 vertices.
     * Pre condicion:  True
     * @return int n.
     * Orden: O(constante)
     */

    public int numeroDeControlVertices() {
        return n;
    }

    /**
     * Descripcion:    Retorna l, variable para controlar el numero de 
     *                 vlados.
     * Pre condicion:  True
     * @return int l.
     * Orden: O(constante)
     */

    public int numeroDeControlLados() {
        return l;
    }

    /** 
     * Descripcion:    Establece el numero de lados del grafo no dirigido.
     * Pre condicion:  lados == int
     * @param lados: numero de lados del grafo no dirigido.
     * Post condicion: lados = nLados.
     * Orden: O(constante)
     */

    public void setNumeroLados( int lados ) {
        nLados = lados;
    }

    /** 
     * Descripcion:    Establece el numero de vertices del grafo no dirigido.
     * Pre condicion:  vertices == int
     * @param vertices: numero de vertices del grafo no dirigido.
     * Post condicion: vertices = nVertice.
     * Orden: O(constante)
     */

    public void setNumeroVertice( int vertices ) {
        nVertices = vertices;
    }

    /** 
     * Descripcion:    Establece el numero de vertices en la
     *                 variable control.
     * Pre condicion:  lados == int
     * @param     vertices: numero de vertices del grafo.
     * Post condicion: n = vertices
     * Orden: O(constante)
     */

    public void setNumeroControlVertice( int vertices ) {
        n = vertices;
    }

    /** 
     * Descripcion:    Establece el numero de lados en la
     *                 variable control.
     * Pre condicion:  lados == int
     * @param     lado: numero de lados del grafo.
     * Post condicion: l = lado
     * Orden: O(constante)
     */

    public void setNumeroControlLado( int lado ) {
        l = lado;
    }

    /** 
     * Descripcion:    Agrega los vertices v al grafo g.
     * Pre condicion:  v == Vertice.
     * @param v: vertice a agregar.
     * Post condicion: Return true en caso de no existir un vertice con el 
     *                 mismo id y lo agrega, retorna false, en caso contrar
     * @return true or false.
     * Orden: O(cuadratico)
     */
    
    public boolean agregarVertice(Vertice v) 
    {
        ArrayList<Vertice> vertices = new ArrayList<Vertice>();
        if( !( estaVertice( v.getId() ) ) )
        {
            if( vertices.add( v ) && listaDeListas.add( vertices ) )
            {
                if( n < nVertices )
                {
                    n = n + 1;
                    return true;
                }
                else
                {
                    n = n + 1;
                    setNumeroVertice( n );
                    return true;
                }
            }
        }
        return false;

    }

    /** 
     * Descripcion:    Agrega el vertice con su id y peso. 
     * Pre condicion:  id == String and peso == double.
     * @param id: identificador del vertice.
     *                 peso: peso del vertice.
     * Post condicion: return true en caso de agregar el vertice 
     *                 y false en caso contra
     * @return true or false
     * Orden: O(cuadratico)
     */
    
    public boolean agregarVertice(String id, double peso) {

        Vertice v = new Vertice( id, peso );
        if( agregarVertice( v ) )
        {
            return false;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Descripcion:    Retorna el vertice contenido en el atributo id.
     * Pre condicion:  id == String.
     * @param id: identificador del vertice.
     * Post condicion: return v, o una excepcion.
     * @return v
     * @exception NoSuchElementException
     * "El vertice buscado no existe en el grafo"
     * Orden: O(lineal)
     */
    
    public Vertice obtenerVertice(String id) {

        int i = 0;

        for( i = 0; i < listaDeListas.size(); i++ )
        {
            if( listaDeListas.get(i).get(0).getId().equals(id) )
            {
                Vertice v = listaDeListas.get(i).get(0);
                return v;
            } 
        }
        throw new NoSuchElementException("El vertice buscado" +
                "no existe en el grafo");
    }

    /**
     * Descripcion:    Indica si el vertice con atributo id esta en el grafo.
     * Pre condicion:  id == String.
     * @param id: identificador del vertice.
     * Post condicion: return true o false y una excepcion.
     * @return true or false
     * Orden: O(cuadratico)
     */
    
    public boolean estaVertice(String id) {

        int i = 0;
        for( i = 0; i < listaDeListas.size(); i++ )
        {
            if( listaDeListas.get(i).get(0).getId().equals(id) )
            {
                return true;
            } 
        }
        return false;

    }

    /** 
     * Descripcion:    Indica si el lado pertenece grafo.
     * Pre condicion:  u == String and v == String.
     * @param u: identificador del lado.
     * @param v: identificador del lado.
     * Post condicion:retorna True si los vertices cuyos id's son u y v estan
     *                 en el grafo, y False en caso contrario.
     * @return true or false
     * Orden: O(cuadratico)
     */
    
    public boolean estaLado(String u, String v){

        for ( int i = 0; i < listaDeAristas.size(); i++ )
        {
            if( listaDeAristas.get(i).getExtremo1().getId().equals(u) &&
                listaDeAristas.get(i).getExtremo2().getId().equals(v) )
            {
                return true;
            }
            else if ( listaDeAristas.get(i).getExtremo1().getId().equals(v) &&
                      listaDeAristas.get(i).getExtremo2().getId().equals(u) )
            {
                return true;
            }
        }
        return false;

    }

    /** 
     * Descripcion:   Elimina el vertice id del grafo.
     * Pre condicion: id == String.
     * @param id: identificador del lado.
     * Post condicion:retorna True si los vertices cuyos id's son eliminados,
     *                y False en caso contrario.
     * @return true or false
     * Orden: O(cubico)
     */
    
    public boolean eliminarVertice(String id) {

        int i = 0;
        int j = 0;
        int n = 0;
        int v = 0;
        String s1;
        String s2;
        Vertice v1;
        Vertice v2;

        if( estaVertice(id) )
        {
            for( i = 0; i < listaDeListas.size(); i++ )
            {
                if( listaDeListas.get(i).get(0).getId().equals( id ) )
                {
                    listaDeListas.remove( listaDeListas.get(i) );
                    v = numeroDeVertices();
                    setNumeroVertice( v - 1 );
                }

                for( j = listaDeListas.get(i).size() - 1 ; j > 0 ; j-- )
                {
                    if( listaDeListas.get(i).get(j).getId().equals( id ) )
                    {   
                        listaDeListas.get(i).remove( listaDeListas.get(i).get(j) );
                    }
                }
            }

            for( i = listaDeAristas.size() - 1; i >= 0; i-- )
            {
                if( listaDeAristas.get(i).getExtremo1().getId().equals(id) ||
                    listaDeAristas.get(i).getExtremo2().getId().equals(id) )
                {
                    listaDeAristas.remove( listaDeAristas.get(i) );
                    n = numeroDeLados();
                    setNumeroLados( n - 1 );
                }
            }
        }

        return false;
    }

    /** 
     * Descripcion:    Retorna una lista de vertices del grafo.
     * Pre condicion:  True
     * Post condicion: return lista
     * @return lista
     * Orden: O(cuadratico)
     */
    
    public ArrayList<Vertice> vertices() {

        ArrayList<Vertice> lista = new ArrayList<Vertice>();

        for( ArrayList<Vertice> list: listaDeListas )
        {
            for( Vertice ver: list )
            {
                    lista.add( ver );
                    break;
            }
        }
        return lista;
    }

    /** 
     * Descripcion:    Retorna una lista de los lados del grafo.
     * Pre condicion:  True
     * Post condicion: return listaDeAristas.
     * @return listaLados
     * Orden: O(lineal)
     */
    
    public ArrayList<Lado> lados() {

        ArrayList<Lado> listaLados = new  ArrayList<Lado>();
        Lado l;

        for( Arista arista: listaDeAristas )
        {
            l = arista;
            listaLados.add( l );
        }

        return listaLados;
    }

    /** 
     * Descripcion:    Calcula el grado del grafo.
     * Pre condicion:  id == String.
     * @param id: identificador del vertice.
     * Post condicion: return grado.
     * @return grado
     * @exception NoSuchElementException
     * "No existe ningun vertice con ese id"
     * Orden: O(lineal)
     */
    
    public int grado(String id) {

        int grado = 0;
        Vertice v1;
        Vertice v2;
        if(estaVertice(id))
        {

            for( Arista arista: listaDeAristas )
            {
                v1 = arista.getExtremo1();
                v2 = arista.getExtremo2();
                if( v1.getId().equals(id) && v2.getId().equals(id) )
                {
                    grado = grado + 2;
                }
                else if( v1.getId().equals(id) || v2.getId().equals(id) )
                {
                    grado = grado + 1;
                }
            }
            return grado;
        }
        throw new NoSuchElementException("No existe ningun" + 
                          " vertice con ese id");
    }

    /** 
     * Descripcion:    Obtiene los vertices adyacentes al vertice id.
     * Pre condicion:  id == String.
     * @param  id: identificador del vertice.
     * Post condicion: return listaAdyacentes.
     * @return listaAdyacentes
     * @exception NoSuchElementException
     * "No existe el vertice con ese id en el grafo."
     * Orden: O(cuadratico)
     */
    
    public ArrayList<Vertice> adyacentes(String id) {

        int i = 0;
        int j = 0;
        ArrayList<Vertice> listaAdyacentes = new ArrayList<Vertice>();
        ArrayList<Vertice> listaVertices = vertices();
        ArrayList<Vertice> listaAux = new ArrayList<Vertice>();

        for( i = 0; i < listaDeAristas.size(); i++ )
        {
            if( listaDeAristas.get(i).getExtremo1().getId().equals(id) )
            {
                listaAux.add( listaDeAristas.get(i).getExtremo2() );
            }
            else if( listaDeAristas.get(i).getExtremo2().getId().equals(id) )
            {
                listaAux.add( listaDeAristas.get(i).getExtremo1() );
            }
        }

        for( i = 0; i < listaVertices.size(); i++ )
        {
            for( j = 0; j < listaAux.size(); j++ )
            {
                if(listaVertices.get(i).getId().equals( listaAux.get(j).getId() ))
                {
                    listaAdyacentes.add( listaVertices.get(i) );
                    break;
                }

            }
        }

        return listaAdyacentes;      
    }
    
    /** 
     * Descripcion:    Obtiene los vertices incidentes al vertice id.
     * Pre condicion:  id == String
     * @param id: identificador del vertice.
     * Post condicion: return listaIncidencias.
     * @return listaIncidencias
     * @exception NoSuchElementException
     * "No existe el vertice con ese id en el grafo.
     * Orden: O(cuadratico)
     */
    
    public ArrayList<Lado> incidentes(String id) {

        int i = 0;
        int j = 0;
        ArrayList<Lado> listaIncidencias = new ArrayList<Lado>();
        ArrayList<Lado> listaAux = new ArrayList<Lado>();

        for( i = 0; i < listaDeAristas.size(); i++ )
        {
            if( listaDeAristas.get(i).getExtremo1().getId().equals(id) || 
                listaDeAristas.get(i).getExtremo2().getId().equals(id) )
            {
                listaAux.add( listaDeAristas.get(i) );
            }
        }

        for( i = 0; i < listaDeAristas.size(); i++ )
        {
            for( j = 0; j < listaAux.size(); j++ )
            {
                if(listaDeAristas.get(i).getId().equals( listaAux.get(j).getId() ))
                {
                    listaIncidencias.add( listaDeAristas.get(i) );
                    break;
                }

            }
        }

        return listaIncidencias;
        
    }

    /* 
     * Descripcion:    Clona el grafo de entrada.
     * Pre condicion:  True
     * Post condicion: return Object.
     * Orden: O(consstante)
     */
    
    public Object clone() {
        Object grafo = null;

        try
        {
            grafo = super.clone();
        }
        catch( CloneNotSupportedException e )
        {
            System.out.println("ERROR");
        }
        return grafo;
    }

    /** 
     * Descripcion:    Devuelve el contenido del grafo como una cadena de 
     *                 caracteres.
     * Pre condicion:  True    
     * Post condicion: return grafo.
     * @return grafo
     * Orden O(cuadratico)
     */
    
    public String toString() {

        String grafo = "";
        Vertice v1;
        Vertice v2;
        double n;
        double m;

        grafo += Integer.toString( numeroDeVertices() ) + "\n";
        grafo += Integer.toString( numeroDeLados() ) + "\n";

        for( ArrayList<Vertice> lista: listaDeListas )
        {
            for( Vertice v: lista )
            {
                n = /*(int)*/ v.getPeso();
                grafo += v.getId() + " " + n + "\n";
                break;
            }
        }

        for( Arista arista: listaDeAristas )
        {
            v1 = arista.getExtremo1();
            v2 = arista.getExtremo2();
            m = /*(int)*/ arista.getPeso();
            grafo += arista.getId() + " " + v1.getId() + " " + v2.getId() + 
                     " " + m + "\n";

        }

        return grafo;
    }

    /** 
     * Descripcion:    Agrega una nueva arista al grafo, en caso de no tener.
     * Pre condicion:  a == Arista
     * @param     a: Arco a insentar.
     * Post condicion: return true 
     * @return true or false
     * Orden O(cuadratico)
     */
    
    public boolean agregarArista(Arista a) {

        if( !( estaArista( a.getId() ) ) )
        {
            if( listaDeAristas.add( a ) )
            {
                if( l <= nVertices )
                {
                    l = l + 1;
                    return true;
                }
                else
                {
                    l = l + 1;
                    setNumeroVertice( l );
                    return true;
                }
            }
        }
        return false;
    } 

    /** 
     * Descripcion:    Agrega una nueva arista al grafo.
     * Pre condicion:  id == String and peso == double and u == String and
     *                 v == String.
     * @param  id: identificador de la arista.
     * @param  peso: peso de la arista.
     * @param  u: extremo inicial de la arista.
     * @param  v: extremo final del arista.
     * Post condicion: return tru si la arista es agregada y
     *               false en caso contrario.
     * @return true or false
     * Orden: O(cubico)
     */
    
    public boolean agregarArista(String id, double peso, String u,
                                 String v ) {

        Vertice v1;
        Vertice v2;
        boolean a, b;

        if( !( estaArista( id ) ) )
        {
            if( estaVertice( u ) && estaVertice( v ) )
            {
                v1 = obtenerVertice( u );
                v2 = obtenerVertice( v );
                Arista arc = new Arista( id, peso, v1, v2 );

                if( agregarArista( arc ) )
                {
                    agregarIncidencia( arc );
                    return true;
                }
            }

        }
        return false;
    }

    /** 
     * Descripcion:   Agrega la arista en el grafo.
     * Pre condicion: a == Arista
     * @param a: objeto tipo Arista.
     * Orden: O(cuadratico)
     */

    public void agregarIncidencia( Arista a )
    {
        int i = 0;
        for( i = 0; i < listaDeListas.size(); i++ )
        {
            if( listaDeListas.get(i).get(0).getId().equals( a.getExtremo1().getId() ) )
            {
                listaDeListas.get(i).add( a.getExtremo2() );
            }
            else if( listaDeListas.get(i).get(0).getId().equals( a.getExtremo2().getId() ) )
            {
                listaDeListas.get(i).add( a.getExtremo1() );
            }
        }
    }

    /** 
     * Descripcion:    Elimina la arista con identificador id.
     * Pre condicion:  id == String
     * @param id: identificador.
     * Post condicion: return true si es eliminado y false en caso contrario.
     * @return true or false
     * Orden: O(cubico)
     */
    
    public boolean eliminarArista(String id) {

        int i = 0;
        int j = 0;
        int n = 0;
        String s1 = "";
        String s2 = "";
        Vertice v1;
        Vertice v2;

        if( estaArista(id) )
        {
            for( i = 0; i < listaDeAristas.size(); i++ )
            {
                if( listaDeAristas.get(i).getId().equals(id) )
                {
                    s1 = listaDeAristas.get(i).getExtremo1().getId();
                    s2 = listaDeAristas.get(i).getExtremo2().getId();
                    listaDeAristas.remove( listaDeAristas.get(i) );
                    n = numeroDeLados();
                    setNumeroLados( n - 1 );
                    break;
                }
            }

            v1 = obtenerVertice( s1 );
            v2 = obtenerVertice( s2 );
            for( i = 0; i < listaDeListas.size(); i++ )
            {
                if(listaDeListas.get(i).get(0).getId().equals(v1.getId()))
                {
                    for (j=1;j<listaDeListas.get(i).size() ;j++ ) 
                    {
                        if (listaDeListas.get(i).get(j).getId().equals(v2.getId())) 
                        {
                            listaDeListas.get(i).remove(j);
                            j--;
                            break;
                        }
                    }
                }else if(listaDeListas.get(i).get(0).getId().equals(v2.getId()))
                {
                    for (j=1;j<listaDeListas.get(i).size() ;j++ ) 
                    {
                        if (listaDeListas.get(i).get(j).getId().equals(v1.getId())) 
                        {
                            listaDeListas.get(i).remove(j); 
                            j--;
                            break;  
                        }
                    }
                }

            }
            return true;
        }

        return false;

    }

    /**
     * Descripcion:    Obtiene la arista con identificador id.
     * Pre condicion:  id == String
     * @param  id: identificador de la arista.
     * @return arista; y  una excepcion en caso de no existir.
     * Orden: O(lineal)
     */
    
    public Arista obtenerArista(String id) {

        for( Arista arista: listaDeAristas )
        {
            if( arista.getId().equals(id) )
                return arista;
        }
        throw new NoSuchElementException("La Arista buscada " + 
                                       "no existe en el grafo.");
    }

    /** 
     * Descripcion:   Obtiene el Arco identificado con id.
     * Pre condicion: id == String
     * @param     id: identificador.
     * @return    true si el arco esta en  el grafo.
     *            false si el arco no esta en el grafo.
     * Orden: O(lineal)
     */

    public boolean estaArista( String id )
    {
        for( Arista arista: listaDeAristas )
        {
            if( arista.getId().equals(id) )
            {
                return true;
            }
        }
        return false;
    }

} // Fin de la clase GrafoNoDirigido