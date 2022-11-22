/**
  * Archivo: Arista.java
  * Descripcion: Implementacion de una arista de un grafo mediante una clase.
  */

public class Arista extends Lado
{
    private Vertice u;
    private Vertice v;
  
    /* 
     * Descripcion:    Constructor de la clase Arista.
     * Pre condicion:  id == Stirng && peso == double &&
     *                 u == Vertice && v == Vertice
     * Parametros:     id: identificador del vertice.
     *                 peso: peso del vertice.
     *                 u: vertice perteneciente a la arista.
     *                 v: vertice perteneciente a la arista.
     * Post condicion: super(id, peso) && this.u = u && this.v = v
     */
  
    public Arista(String id, double peso, Vertice u, Vertice v) 
    {
        super( id, peso );
        this.u = u;
        this.v = v;
    }

    /* 
     * Descripcion:    Retorna un vertice extremo del lado.
     * Pre condicion:  True
     * Parametros:
     * Post condicion: return u
     */
  
    public Vertice getExtremo1() 
    {
        return u;
    }

    /* 
     * Descripcion:    Retorna un vertice extremo del lado.
     * Pre condicion:  True
     * Parametros:
     * Post condicion: return v
     */
  
    public Vertice getExtremo2() 
    {
        return v;
    }

    /* 
     * Descripcion:    Retorna los vertices extremos del lado como una cadena
     *                 de caracteres.
     * Pre condicion:  True
     * Parametros:
     * Post condicion: return( "( " + u + ", " + v + " )" )
     */
  
    public String toString() 
    {
        return( "["+u.getId() + "," + v.getId()+"]" ); 
    }

} // Fin de la clase Arista