/**
  * Archivo: Lado.java
  * Descripcion: Implementacion del lado de un grafo mediante una clase.
  */

public abstract class Lado
{
  private String id;
  private double peso;

  /* 
   * Descripcion:    Constructor de la clase Lado.
   * Pre condicion:  id == String && peso == double
   * Parametros:     id: identificador del vertice.
   *                 peso: peso del vertice
   * Post condicion: this.id = id && this.peso = peso
   */
  
  public Lado(String id, double peso) 
  {
    this.id = id;
    this.peso = peso;
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
   * Descripcion:    Retorna los atributos id y peso en una cadena
   *                 de caracteres.
   * Pre condicion:  True
   * Parametros:
   * Post condicion: return( "( " + id + ", " + peso + " )" );
   */
  
  public abstract String toString();

} // Fin de la clase Lado