package proyecto;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * <p>
 * Clase para SVG.
 * </p>
 *
 * <p>
 * Un SVG es una clase que Genera SVG , con 3 operaciones Básicas
 * crea Entrada , crea Salida y DibujaLinea
 * </p>
 */
public class SVG {
	
	String svg="";/*String que contiene la info del SVG*/
	private String salto="\n"; /*Salto de Linea*/
	
	/** Genera un archivo con la informacion en el texto en la
	 *  direccion
	 *  @param String direccion:Direccion en la que se guardara en el 
	 * 		  archivo
	 * 		  String texto: Texto a Guardar en Direccion*/
	
	 public void generaArchivo(String direccion,String texto){
	 	   try {
	        	File archivo = new File(direccion);
	            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
	            bw.write(texto);
	            bw.close();
	            
	           
	            
	        } catch(IOException e) {
	            System.err.println("No se ha podido crear el archivo " +e);
	        }
	 	   
	    }
	 
	     /** Genera la entrada del SVG , dado un tamaño 
		 * @param  int ancho : Ancho del SVG
		 * 		   int largo : Largo del SVG	
		 * */
		
	 public String creaEntrada(int ancho,int largo){
		 return "<?x"+"ml version='1.0' encoding='UTF-8' ?>"+salto+
				 "<svg width='"+ancho+"' height='"+largo+"'>"+salto+"<g>";
		}
	 
	  /** Genera la Salida del SVG , dado un tamaño */
	 public String creaSalida(){
		 return   salto+" </g>"+salto+ " </svg>"+salto;
		}
	 
	 /** Genera una linea del punto1 al punto 2 de 
	  *  color s 
		 * @param  Punto punto1 : Punto1 de la Linea
		 * 		   Punto punto2 : Punto2 de la Linea	
		 * 					  s : Color	
		 * */
	
	 public String dibujaLinea(Punto punto1, Punto punto2,String s){
		return "<line x1='"+String.valueOf(punto1.x)+"'"
				  + " y1='"+String.valueOf(punto1.y)+"'"
				  + " x2='"+String.valueOf(punto2.x)+"'"
				  + " y2='"+String.valueOf(punto2.y)+"' "
				  + "stroke='"+s+"' stroke-width='1' />";
		
		
	}

}
