package proyecto;
/**
 * Clase de Parentesis , un parentesis está conformado 
 * por dos enteros
 */

public class Parentesis {
	
	int primerParentesis=0;/*Primer entero,representa la pocision en que se encuentra el 
	 						caracter "("*/
	int segundoParentesis=0;/*Segundo entero,representa la pocision en que se encuentra el 
							caracter ")"*/
	
	
	
	/**Construye un parentesis con elemento "(" en i .
     * @param int i :e Primer elemento del paréntesis
     */
	public Parentesis(int i){
		primerParentesis=i;
	}
	
	/**Construye un parentesis con elemento "(" en i 
	 * y el elemento ")" en la posicion y
     * 
     * @param int i:El primer elemento del paréntesis
     *        int y:El segundo elemento del paréntesis
     */
	public Parentesis(int i,int y){
		
		primerParentesis=i;
		segundoParentesis=y;
		
	}
	
	/**Regresa un String que representa el parentesis
     * 
     * @return String que representa un parentesis 
     */
	@Override
	public String toString(){
		return   "("+String.valueOf(primerParentesis)+","+String.valueOf(segundoParentesis)+")";
	}
	
	/**Compara un elemento con this
     * @param Object u: El objeto a comparar 
     * @return <tt>true</tt> si el está Objeto es igual a this,
     *         <tt>false</tt> en otro caso.
     */       
     
	@Override
	public boolean equals(Object u){
		if(u==null)
			return false;
		if(u.getClass()!=this.getClass())
			return false;
					Parentesis a= (Parentesis)u;
		return  a.primerParentesis==primerParentesis&&a.segundoParentesis==segundoParentesis ;
	}
	
}
