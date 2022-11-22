/**
  * Archivo: Arco.java
  * Descripcion: Implementacion de un arco de un grafo mediante una clase.
  */

public class Arco extends Lado
{
    private Vertice extremoInicial;
    private Vertice extremoFinal;
  
    /* 
     * Descripcion:    Constructor de la clase Arco.
     * Pre condicion:  id == String && peso == double &&
     *                 extremoInicial == Vertice && extremoFinal == Vertice
     * Parametros:     id: identificador del vertice.
     *                 peso: peso del vertice.
     *                 extremoInicial: vertice del cual sale el arco.
     *                 extremoFinal: vertice al cual llega el arco.
     * Post condicion: super(id, peso) && this.extremoInicial = extremoInicial &&
     *                 this.extremoFinal = extremoFinal
     */
  
    public Arco(String id, double peso, Vertice extremoInicial, Vertice extremoFinal) 
    {
    	super( id, peso );
        this.extremoInicial = extremoInicial;
        this.extremoFinal = extremoFinal;
    }

    /* 
     * Descripcion:    Retorna el vertice del cual sale el arco.
     * Pre condicion:  True
     * Parametros:
     * Post condicion: return extremoInicial
     */
  
    public Vertice getExtremoInicial() 
    {
        return extremoInicial;
    }

    /* 
     * Descripcion:    Retorna el vertice al cual llega el arco.
     * Pre condicion:  True
     * Parametros:
     * Post condicion: return extremoFinal
     */
  
    public Vertice getExtremoFinal() 
    {
        return extremoFinal;
    }

    /* 
     * Descripcion:    Retorna los vertices pertenecientes al arco como una
     *                 cadena de caracteres.
     * Pre condicion:  True
     * Parametros:
     * Post condicion: return( "( " + extremoInicial + ", " + extremoFinal + " )" )
     */
  
    public String toString() 
    {
        return( "[" + extremoInicial.getId() + "," + extremoFinal.getId() + "]" ); 
    }

} // Fin de la clase Arco