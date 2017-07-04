package proyecto;
import java.awt.Font;

/**Clase que recibe una cadena de texto , y la convierte en una lista de puntos
 * que la clase ventana puede convetir en la grafica*/

public class Proyecto1 {
	 
	public Punto rango=new Punto(0,0);//Rango en que se hara la grafica 
	public String ecuacion;//La ecuacion recibida
	
	public ArbolBinarioDeSimbolos arbolDeSimbolos;//Arbol que ordena los simbolos por su jerarquia
	
	public SeparadorDeSimbolos separador;//Convierte una cadena de caracteres en  en 
	                              //un arreglo de Simbolos , lista de parentesis y 
								 //un arreglo de parentesis
	
	public CreadorDeArbol creador;   //Crea un arbol ordenado jerarjicamente
	public RealizaOperaciones operador;//Valua la funcion
	
	
	
	public Punto[] arregloDePuntos;
	
	
	public void procesaPalabras(String s,Punto punto, double separacion){
		ecuacion=s;
		rango=punto;

	    separador= new SeparadorDeSimbolos(s);
	    separador.separaSimbolos();
	   
	    
	    creador = new CreadorDeArbol(separador.contenedorDeSimbolos,separador.listaDeParentesis,separador.arregloDeParentesis);
		arbolDeSimbolos = creador.arbol;
		
		operador = new RealizaOperaciones(arbolDeSimbolos,rango,separacion);
	
		arregloDePuntos=operador.punto;
	
		
	}
	

	
	
	

	
	
}
