/*** <p>
 * Clase para Formulas
 * </p>
 *
 * <p>
 * Una formula contiene un entero que representa el color que le 
 * corresponda a una linea , y la formula es la que que dibujara
 * </p>
 */
package proyecto;
public class Formula {
	
	String formula;/*Formula a dibujar*/
	int color;/*Representa el color de linea*/
	Punto dominio;
	Punto rango;
	/**
     * Constructor unico que recibe un String y un 
     * entero.
     * @param String y el entero de la formula
     */
	public Formula(String s ,int i,Punto dominio,Punto rango){
		this.formula=s;
		this.color=i;
		this.dominio=dominio;
		this.rango=rango;
	}

}
