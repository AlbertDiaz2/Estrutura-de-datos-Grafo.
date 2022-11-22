/*
 * Archivo: Vertice.java
 * Descripcion: Implementacion del vertice de un grafo mediante una clase.
 */

// Clase Vertice
public class Vertice
{

    // Atributos de la clase.
    private String id;
    private double peso;
  
    /* 
     * Descripcion:    Constructor de la clase Vertice.
     * Pre condicion:  id == String && peso == double
     * Parametros:     id: identificador del vertice.
     *                 peso: peso del vertice.
     * Post condicion: this.id = id && this.peso = peso;
     */

    public Vertice(String id, double peso) 
    {
        this.id = id;
        this.peso = peso;
    }

    /* 
     * Descripcion:    Retorna el atributo peso de la clase.
     * Pre condicion:  True
     * Parametros:     
     * Post condicion: return peso
     */

    public double getPeso() 
    {
        return peso;
    }

    /* 
     * Descripcion:    Retorna el atributo id de la clase.
     * Pre condicion:  True
     * Parametros:
     * Post condicion: return id
     */

    public String getId() 
    {
        return id;
    }

    /* 
     * Descripcion:    Retorna los atributos id y peso como una cadena 
     *                 de caracteres.
     * Pre condicion:  True
     * Parametros:
     * Post condicion: return( "( " + id + ", " + peso + " )" )
     */

    public String toString() 
    {
        return( id + "," + peso ); 
    }

} // Fin de la clase Vertice