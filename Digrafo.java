/**
  * Archivo: Dirigido.java
  * Descripcion: Implementacion de un grafo dirigido mediante una clase.
  * @author Albert Diaz 11-10278
  * @author Nathalia Silvera 12-10921
  * @since *19/10/2017*
  */

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Clase Digrafo

public class Digrafo implements Grafo
{

    // Atributos de la clase
    private int nVertices;
    private int nLados;
    private int n;
    private int l;
    private ArrayList<ArrayList<Vertice>> listaDeListas = new ArrayList<ArrayList<Vertice>>();
    private ArrayList<Arco> listaDeArcos = new ArrayList<Arco>();

    /**
     * Descripcion:    Constructor de la clase Digrafo.
     * Orden: O(2)
     */
  
    public void Digrafo() {

        n = 0;
        l = 0;
    }

    /**
     * Descripcion:    Carga la informacion almacenada en el archivo.
     * Pre condicion:  driArchivo == String 
     * @param dirArchivo: archivo que almacena la informacion.
     *                 del grafo.
     * @return cargoArchivo
     * Exception e
     * Exception e2
     * Orden: O(cubica)
     */

    public boolean cargarGrafo( String dirArchivo ) {

        boolean cargoArchivo;
        int nLados = 0;
        BufferedReader in = null;
        String s;
        int contador = 0;
        String[] tok;
        //int nVertice = 0;

        try
        {
            in = new BufferedReader(new FileReader(dirArchivo));

            while((s=in.readLine())!= null)
            {
                tok = s.split(" ");

                if( tok.length == 4 && ( contador >= ( nVertices+2 ) ) )
                {
                    agregarArco(tok[0], Double.parseDouble(tok[3]),
                                tok[1], tok[2] );
                }

                else if( tok.length == 2 && contador > 1 && 
                         contador <= ( nVertices+2 ) )
                {
                    agregarVertice(tok[0], Double.parseDouble(tok[1]));
                }

                else if( tok.length == 1 && contador == 0 )
                {
                    nVertices = Integer.parseInt( tok[0] );
                    setNumeroVertice( nVertices );
                }

                else if(tok.length == 1 && contador == 1)
                {
                    nLados = Integer.parseInt( tok[0] );
                    setNumeroLados( nLados );
                }

                else
                {

                    cargoArchivo = false;
                    return cargoArchivo;
                }

                contador = contador + 1;
            }
        }
        catch (Exception e){
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
     * Descripcion:    Retorna el numero de vertices del grafo.
     * Pre condicion:  True
     * @return int nVertice.
     * Orden: O(1)
     */

    public int numeroDeVertices() {
        return nVertices;
    }

    /**
     * Descripcion:    Retorna el numero de lados del grafo.
     * Pre condicion:  True
     * @return int nLados.
     * Orden: O(1)
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
     * Descripcion:    Establece el numero de lados del grafo.
     * Pre condicion:  lados == int
     * @param     lados: numero de lados del grafo dirigido.
     * Post condicion: nLados = lados
     * Orden: O(constante)
     */

    public void setNumeroLados( int lados ) {
        nLados = lados;
    }

    /** 
     * Descripcion:    Establece el numero de vertices del grafo.
     * Pre condicion:  vertices == int
     * @param  vertices: numero de vertices del grafo dirigido.
     * Post condicion nVertice = vertices.
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
     * Pre condicion:  v == Vertice
     * @param  v: objeto de la clase Vertice
     * @return true en caso de agregar el vertice y 
     *                 false en caso contrario.
     * Orden: O(cuadratico)
     */ 

    public boolean agregarVertice( Vertice v ) {

        ArrayList<Vertice> listaDeVertices = new ArrayList<Vertice>();
        if( !( estaVertice( v.getId() ) ) )
        {
            if( listaDeVertices.add( v ) && listaDeListas.add( listaDeVertices ) )
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
     * Descripcion:   Agregar el vertice v al grafo g creado.
     * Pre condicion: id == String and peso == double REVIIIISARRRRR
     * @param  id: identificador del vertice.
     * @param  peso: peso del vertice con identificador id.
     * @return return true en caso de no existir un vertice con el 
     *         mismo id y lo agrega, retorna false, en caso contrario.
     * Orden: O(cuadratico)
     */
    public boolean agregarVertice(String id, double peso) 
    {

        Vertice v = new Vertice( id, peso );
        if( !( estaVertice( v.getId() ) ) )
        {
            if( agregarVertice( v ) )
            {
                return true;
            }
        }
            return false;
    }
    
    /** 
     * Descripcion:    Retorna el vertice contenido en el atributo id.
     * Pre condicion:  id == String
     * @param  id: identificador del vertice.
     * @return retorna el vertice si se encuentra en la lista de listas.
     * @exception NoSuchElementException
     *            ("El vertice buscado no existe en el grafo.")
     * Orden: O(cuadratico)
     */
    
    public Vertice obtenerVertice(String id) {

        if( estaVertice( id ))
        {
            for( ArrayList<Vertice> lista: listaDeListas )
            {
                for( Vertice v: lista )
                {
                    if( v.getId().equals(id) )
                    {
                        return v;
                    }
                }
            }
        }
        throw new NoSuchElementException("El vertice buscado no existe en el grafo.");
    }

    /** 
     * Descripcion:    Indica si el vertice con atributo id esta en el grafo.
     * Pre condicion:  id == String
     * @param  id: identificador del vertice.
     * @return return true en caso de estar y false en caso contrario.
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
     * Descripcion:    Determina si el lado pertenece al grafo.
     * Pre condicion:  u == String and v == String
     * @param u extremo inicial.
     * @param v extremo final.
     * @return return True si los vertices cuyos id's son u y v estan
     *                 en el grafo, y False en caso contrario.
     * Orden: O(cuadratico)
     */
    
    public boolean estaLado(String u, String v){

        Vertice v1;
        Vertice v2;

        for ( Arco arco: listaDeArcos )
        {
            v1 = arco.getExtremoInicial();
            v2 = arco.getExtremoFinal();

            if( (v1.getId().equals(u)) && (v2.getId().equals(v)) )
            {
                return true;
            }
            else if (v2.getId().equals(u) && v1.getId().equals(v))
            {
                return true;
            }
        }
        //throw new NoSuchElementException("No existe lado entre u y v "); 
        return false;

    }

    /** 
     * Descripcion:    Elimine el vertice del grafo.
     * Pre condicion:  id == String
     * @param  id: identificador del vertice.
     * @return return true si el vertice esta y lo elimina 
     *         y false en caso contrario.
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
            for( i = 0; i < listaDeListas.size()-1; i++ )
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

            for( i = listaDeArcos.size() - 1; i > 0; i-- )
            {
                if( listaDeArcos.get(i).getExtremoInicial().getId().equals(id) ||
                    listaDeArcos.get(i).getExtremoFinal().getId().equals(id) )
                {
                    listaDeArcos.remove( listaDeArcos.get(i) );
                    n = numeroDeLados();
                    setNumeroLados( n - 1 );
                }
            }
        }

        return false;
    }

    /** 
     * Descripcion:    Retorna una lista con los vertices del grafo.
     * Pre condicion:  True
     * @return lista, la lista con los vertices del grafo.
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
     * @return return listaLados,  la lista de los lados del grafo.
     * Orden: O(lineal)
     */
    
    public ArrayList<Lado> lados() {

        ArrayList<Lado> listaLados = new  ArrayList<Lado>();
        Lado l;

        for( Arco arco: listaDeArcos )
        {
            l = arco;
            listaLados.add( l );
        }

        return listaLados;
    }

    /** 
     * Descripcion:    Calcula el grado del grafo.
     * Pre condicion:  id == String
     * @param id: identificador del vertice. 
     * @return g or throws.
     * @exception NoSuchElementException
     * "El grafo no contiene ningun vertice con ese identificador"
     * Orden: O(lineal)
     */
    
    public int grado(String id) {

        int g = 0;
        if(id != " "){
            g = gradoInterior( id ) + gradoExterior( id );
            return g;
        }
        throw new NoSuchElementException("El grafo no contiene " +
                            "ningun vertice con ese identificador");
    }

    /**
     * Descripcion:    Obtiene los vertices adyacentes al vertice 
     *                 identidicado id.
     * Pre condicion:  id == String
     * @param id: identificador del vertice.
     * @return return listaAdyancentes.
     * @exception NoSuchElementException
     * "El grafo no contiene un vertice con ese id"
     * Orden: O(cuadratico)
     */
    
    public ArrayList<Vertice> adyacentes(String id) {

        int i = 0;
        int j = 0;
        ArrayList<Vertice> listaAdyacentes = new ArrayList<Vertice>();
        ArrayList<Vertice> listaVertices = vertices();
        ArrayList<Vertice> listaAux = new ArrayList<Vertice>();

        if( estaVertice(id) )
        {

            for( i = 0; i < listaDeArcos.size(); i++ )
            {
                if( listaDeArcos.get(i).getExtremoInicial().getId().equals(id) )
                {
                    listaAux.add( listaDeArcos.get(i).getExtremoFinal() );
                }
                else if( listaDeArcos.get(i).getExtremoFinal().getId().equals(id) )
                {
                    listaAux.add( listaDeArcos.get(i).getExtremoInicial() );
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
        throw new NoSuchElementException("El grafo no contiene " +
                       "un vertice con ese id");
        
    }
    
    /** 
     * Descripcion:    Obtiene los lados incidentes al vertice id.
     * Pre condicion: id == String
     * @param id: identificador del vertice.
     * @return listaIncidencias.
     * @exception NoSuchElementException
     * "El grafo no contiene un vertice con ese id"
     * Orden: O(cuadratico)
     */
    
    public ArrayList<Lado> incidentes(String id) {

        int i = 0;
        int j = 0;
        ArrayList<Lado> listaIncidencias = new ArrayList<Lado>();
        ArrayList<Lado> listaAux = new ArrayList<Lado>();
        
        if( estaVertice(id) )
        {
            for( i = 0; i < listaDeArcos.size(); i++ )
            {
                if( listaDeArcos.get(i).getExtremoInicial().getId().equals(id) || 
                    listaDeArcos.get(i).getExtremoFinal().getId().equals(id) )
                {
                    listaAux.add( listaDeArcos.get(i) );
                }
            }

            for( i = 0; i < listaDeArcos.size(); i++ )
            {
                for( j = 0; j < listaAux.size(); j++ )
                {
                    if(listaDeArcos.get(i).getId().equals( listaAux.get(j).getId() ))
                    {
                        listaIncidencias.add( listaDeArcos.get(i) );
                        break;
                    }

                }
            }

            return listaIncidencias;
        }
        throw new NoSuchElementException("El grafo no contiene " +
                        "un vertice con ese id");
        
    }

    /** 
     * Descripcion:    Retorna un nuevo grafo con la misma composicion del 
     *                 grafo de entrada.
     * Pre condicion: true
     * @return grafo
     * Orden O(constante)
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
     * Pre condicion:  true
     * @return grafo.
     * Orden: O(cuadratico)
     */
    
    public String toString() {

        String grafo = "";
        Vertice v1;
        Vertice v2;
        double n = 0;
        double m = 0;

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

        for( Arco arco: listaDeArcos )
        {
            v1 = arco.getExtremoInicial();
            v2 = arco.getExtremoFinal();
            m = /*(int)*/ arco.getPeso();
            grafo += arco.getId() + " " + v1.getId() + " " + v2.getId() + 
                     " " + m + "\n";

        }

        return grafo;
    }

    /** 
     * Descripcion:    Agrega un nuevo arco al grafo.
     * Pre condicion:  a == Arco.
     * @param          a: arco a insertar.
     * @return         true si la insercion se lleva a cabo,
     *                 false en caso contrario.
     * Orden: O(lineal)
     */
    
    public boolean agregarArco(Arco a) {

        if( !( estaArco( a.getId() ) ) )
        {
            if( listaDeArcos.add( a ) )
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
     * Descripcion:   Agrega un nuevo arco al grafo.
     * Pre condicion: id == String and peso == double and
     *                extremoInicial == String and 
     *                extremoFinal == String
     * @param id: identificador del arco.
     * @param peso: peso del arco.
     * @param extremoInicial: extremo inicial del arco.
     * @param extremoFinal: extremo final del arco.
     * @return true or false.
     * Orden: O(cubico)
     */
    
    public boolean agregarArco(String id, double peso, 
                               String extremoInicial,
                               String extremoFinal ) {

        Vertice v1;
        Vertice v2;

        if( !( estaArco(id) ) )
        {
            if(!estaArco(extremoInicial))
            {

                agregarVertice(extremoInicial, 1.0);
            }
            if(!estaArco(extremoFinal))
            {
                agregarVertice(extremoFinal, 1.0);
            }
            if( estaVertice( extremoInicial ) && estaVertice( extremoFinal ) )
            {
                v1 = obtenerVertice( extremoInicial );
                v2 = obtenerVertice( extremoFinal );
                Arco arc = new Arco( id, peso, v1, v2 );

                if( agregarArco( arc ) )
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
     * Pre condicion: a == Arco
     * @param a: objeto tipo Arco.
     * Orden: O(cuadratico)
     */

    public void agregarIncidencia( Arco a )
    {
        int i = 0;
        for( i = 0; i < listaDeListas.size(); i++ )
        {
            if( listaDeListas.get(i).get(0).getId().equals( a.getExtremoInicial().getId() ) )
            {
                listaDeListas.get(i).add( a.getExtremoFinal() );
            }
        }
    }

    /** 
     * Descripcion:    Calcula el grado interior del vertice id.
     * Pre condicion:  id == String.
     * @param id: identificador del vertice.
     * @return gradoIn
     * @exception NoSuchElementException
     * "No existe ningun vertice con ese id"
     * Orden: O(cuadratico)
     */
    
    public int gradoInterior(String id) {

        int gradoIn = 0;
        Vertice v1;
        if( estaVertice(id) ){

            for( Arco arco: listaDeArcos )
            {
                v1 = arco.getExtremoFinal();
                if( v1.getId().equals(id) )
                {
                    gradoIn = gradoIn + 1;
                }
            }
            return gradoIn;
        }
        throw new NoSuchElementException("No existe ningun" + 
                          " vertice con ese id");        
    }

    /** 
     * Descripcion:    Calcula el grado exterior del vertice id.
     * Pre condicion:
     * @param  id: identificador del vertice.
     * @return gradoEx
     * @exception NoSuchElementException
     * "No existe ningun vertice con ese id"
     * Orden: O(cuadratico)
     */
    
    public int gradoExterior(String id) {

        int gradoEx = 0;
        Vertice v1;

        if( estaVertice(id) )
        {

            for( Arco arco: listaDeArcos )
            {
                v1 = arco.getExtremoInicial();
                if( v1.getId() == id )
                {
                    gradoEx = gradoEx + 1;
                }
            }
            return gradoEx;
        }
        throw new NoSuchElementException("No existe ningun" + 
                          " vertice con ese id");        
    }

    /** 
     * Descripcion:  Retorna una lista de vertices sucesores al vertice id.
     * Pre condicion:id == String
     * @param        id: identificador del vertice.
     * @return       listaSucesores
     * @exception NoSuchElementException
     * "No existe vertice en el grafo con ese id"
     * Orden: O(cubico)
     */
    
    public ArrayList<Vertice> sucesores(String id) {

        int i = 0;
        int j = 0;
        Vertice v;
        Vertice v1;
        Vertice v2;
        ArrayList<Vertice> listaSucesores = new ArrayList<Vertice>();
        ArrayList<Vertice> listaAux = new ArrayList<Vertice>();
        ArrayList<Vertice> listaVertices = vertices();

        if( estaVertice( id ) )
        {
            v = obtenerVertice( id );
            for( Arco arco: listaDeArcos )
            {
                v1 = arco.getExtremoInicial();
                v2 = arco.getExtremoFinal();
                if( v1.getId().equals(id) )
                {
                    listaAux.add( v2 );
                }
            }

            for( i = 0; i < listaVertices.size(); i++ )
            {
                for( j = 0; j < listaAux.size(); j++ )
                {
                    if(listaVertices.get(i).getId().equals( listaAux.get(j).getId() ))
                    {
                        listaSucesores.add( listaVertices.get(i) );
                        break;
                    }

                }
            }
            return listaSucesores;
        }
        throw new NoSuchElementException("No existe vertice " + 
                                     "en el grafo con ese id");        
    }

    /** 
     * Descripcion:    Retorna una lista de vertices precedesores al vertice id.
     * Pre condicion:  id == String
     * @param     id: identificador del vertice.
     * @return listaPredecesores
     * @exception NoSuchElementException
     * "No existe vertice en el grafo con ese id"
     * Orden: O(cuadratico)
     */
    
    public ArrayList<Vertice> predecesores(String id) {

        int i = 0;
        int j = 0;
        Vertice v;
        Vertice v1;
        Vertice v2;
        ArrayList<Vertice> listaPredecesores = new ArrayList<Vertice>();
        ArrayList<Vertice> listaAux = new ArrayList<Vertice>();
        ArrayList<Vertice> listaVertices = vertices();

        if( estaVertice( id ) )
        {
            for( Arco arco: listaDeArcos )
            {
                v1 = arco.getExtremoInicial();
                v2 = arco.getExtremoFinal();

                if( v2.getId().equals(id) )
                {
                    listaAux.add( v1 );
                }
            }

            for( i = 0; i < listaVertices.size(); i++ )
            {
                for( j = 0; j < listaAux.size(); j++ )
                {
                    if(listaVertices.get(i).getId().equals( listaAux.get(j).getId() ))
                    {
                        listaPredecesores.add( listaVertices.get(i) );
                        break;
                    }

                }
            }
            return listaPredecesores;
        }
        throw new NoSuchElementException("No existe vertice " + 
                                     "en el grafo con ese id");        
    }

    /**
     * Descripcion:  Elimina el Arco identificado con id.
     * Pre condicion:id == String.
     * @param        id: identificador.
     * @return       true or false
     * Orden: O(cuadratico)
     */
    
    public boolean eliminarArco(String id) {

        int i = 0;
        int j = 0;
        int n = 0;
        String s1 = "";
        String s2 = "";
        Vertice v1;
        Vertice v2;

        if( estaArco(id) )
        {
            for( i = 0; i < listaDeArcos.size(); i++ )
            {
                if( listaDeArcos.get(i).getId().equals(id) )
                {
                    s1 = listaDeArcos.get(i).getExtremoInicial().getId();
                    s2 = listaDeArcos.get(i).getExtremoFinal().getId();
                    listaDeArcos.remove( listaDeArcos.get(i) );
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
     * Descripcion:   Obtiene el Arco identificado con id.
     * Pre condicion: id == String
     * @param     id: identificador.
     * @return        arco
     * @exception NoSuchElementException 
     * "El arco buscada no existe en el grafo"
     * Orden: O(lineal)
     */
    
    public Arco obtenerArco( String id ) {

        for( Arco arco: listaDeArcos )
        {
            if( arco.getId().equals(id) )
                return arco;
        }
        throw new NoSuchElementException("El arco buscada " + 
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

    public boolean estaArco( String id )
    {
        for( Arco arco: listaDeArcos )
        {
            if( arco.getId().equals(id) )
            {
                return true;
            }
        }
        return false;
    }

    public void mostrarGrafo() {

        for( ArrayList<Vertice> lista: listaDeListas )
        {
            System.out.println(lista);
        }
    }

} // Fin de la clase Digrafo
