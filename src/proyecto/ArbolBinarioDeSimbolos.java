package proyecto;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * <p>
 * Clase para arboles binarios completos.
 * </p>
 *
 * <p>
 * Un arbol binario completo agrega y elimina elementos de tal forma que el
 * arbol siempre es lo mas cercano posible a estar lleno.
 * </p>
 */
public class ArbolBinarioDeSimbolos extends ArbolBinario<Simbolos> {
	
	ArbolBinario<Simbolos>.Vertice ultimoSimboloAgregado;
	public boolean tieneVariables=false;

	/* Clase privada para iteradores de arboles binarios completos. */
	@SuppressWarnings("rawtypes")
	private class Iterador implements Iterator {

		private Cola<ArbolBinario<Simbolos>.Vertice> cola;

		/* Constructor que recibe la raiz del arbol. */
		@SuppressWarnings("unused")
		public void p(String f){
			System.out.println(f);
		}
		
		public Iterador(ArbolBinario<Simbolos>.Vertice raiz) {
			cola = new Cola<ArbolBinario<Simbolos>.Vertice>();
			
			if (raiz != null) {
				cola.mete(raiz);
			}
		}

		/* Nos dice si hay un elemento siguiente. */
		@Override
		public boolean hasNext() {
		return !cola.esVacia();
        }

		/* Regresa el elemento siguiente. */
		@Override
		public Simbolos next() {
			
			if (cola.esVacia()) {
			throw new NoSuchElementException();
			}else{
				ArbolBinario<Simbolos>.Vertice vertice=cola.saca();
				if(vertice.hayIzquierdo()){
					cola.mete(vertice.izquierdo);
				}if(vertice.hayDerecho()){
					cola.mete(vertice.derecho);
				}
				
				return vertice.elemento;
			}
			
		}

		/* No lo implementamos: siempre lanza una excepcion. */
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Agrega un elemento al �rbol binario completo. El nuevo elemento se
	 * coloca a la derecha del ultimo nivel, o a la izquierda de un nuevo nivel.
	 * 
	 * @param elemento
	 *            el elemento a agregar al �rbol.
	 * @throws Exception 
	 */
	

	
	public void agrega(ArbolBinarioDeSimbolos arbol,int i) {
		 
		if(arbol.raiz!=null){
		Vertice nuevo=arbol.raiz;
			if(this.raiz!=null){
				ultimoAgregado.derecho=nuevo;
				nuevo.padre=ultimoAgregado;
				elementos+=i;
				}else{
				verificaCambioDeRaiz(nuevo);
				ultimoAgregado=nuevo;
				elementos+=i;
				}
			}
	}
		
	@Override
	public void agrega(Simbolos elemento) {
		
		
		Vertice nuevo= nuevoVertice(elemento);
		int i =getCaso(elemento.valor);
		
	   switch(i){
			case 0: //Caso de los Numeros
				ultimoAgregado.derecho=nuevo;
				nuevo.padre=ultimoAgregado;
				break;
		
			case 1://Caso en que Se Agrega signo + o signo -
				nuevo.izquierdo=raiz;
				raiz.padre=nuevo;
				break;
			case 2://Caso De la multiplicacion y división
				nuevo.izquierdo=ultimoSimboloAgregado;
				if(ultimoSimboloAgregado!=null){
				asignaElpadreDe(ultimoSimboloAgregado,nuevo);
				ultimoSimboloAgregado.padre=nuevo;
				}
				break;
					
			case 3:
				
				nuevo.izquierdo=ultimoAgregado;
				if(ultimoAgregado!=null){
				asignaElpadreDe(ultimoAgregado,nuevo);
				ultimoAgregado.padre=nuevo;
				break;
				}
				
			case 4:
				nuevo.derecho=raiz;
				raiz.padre=nuevo;
				break;
				
			case 5:
				ultimoSimboloAgregado.derecho=nuevo;
				nuevo.padre=ultimoAgregado;
			
				
				break;
				}
		 
			if(elemento.valor>0){
				ultimoSimboloAgregado=nuevo;}
				if(ultimoSimboloAgregado!=null){
					if(ultimoSimboloAgregado.get().valor==4&&ultimoSimboloAgregado.padre!=null){
					ultimoSimboloAgregado=ultimoSimboloAgregado.padre;
					}
				}verificaCambioDeRaiz(nuevo);
			    
				
		        ultimoAgregado=nuevo;
		        elementos++;
		    	
		 
		   
		    }		
	
	
	
	
			
			
			
		 
	    
     
	
	/**
	 * Nos dice si un elemento esta en el �rbol binario completo.
	 * 
	 * @param elemento
	 *            el elemento que queremos comprobar si esta en el arbol.
	 * @return <code>true</code> si el elemento esta en el arbol;
	 *         <code>false</code> en otro caso.
	 */
	public boolean contiene(Simbolos elemento) {
		if(this.raiz==null){
			return false;
		}
		else if(this.busca(elemento)==null){
			return false;
		}else{
			return true;
		}
		
	}
	

	
	

	/**
	 * Regresa un iterador para iterar el �rbol. El �rbol se itera en orden
	 * BFS.
	 * 
	 * @return un iterador para iterar el �rbol.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Iterator<Simbolos> iterator() {
		return new Iterador(raiz);
	}
	
 
  /**
	 * Elimina un elemento del �rbol. El elemento a eliminar cambia lugares con
	 * el �ltimo elemento del �rbol al recorrerlo por BFS, y entonces es
	 * eliminado.
	 * 
	 * @param element el elemento a eliminar.
	 */
	@Override
	public void elimina(Simbolos elemento) {
	
		}	
	
	

		
	

	
		


	private int getCaso(int valor) {
		if(raiz==null){
			  return -1;
		   }
			if(elementos==1&&valor!=4&&valor!=0){
				return 1;
			}
			
			
			if(ultimoSimboloAgregado!=null){
				
				if(valor==4){
					   if(ultimoSimboloAgregado.elemento.getValor()<=4){
						   return 0;
					   }	
					
					}
				
				if(valor==3){
				   if(ultimoSimboloAgregado.elemento.getValor()==4){
					   return 2;
				   }	
				
				}
				
				if(valor==2&&ultimoSimboloAgregado.elemento.getValor()==1){
					return 3;
				}
				if(valor==2&&ultimoSimboloAgregado.elemento.getValor()==4){
					
					//System.out.println("El error stá en el cuatro");
					return 1;
				}
				
				if(valor==4&&ultimoSimboloAgregado.elemento.getValor()==2){
					return 5;
				}
				if(valor==4&&ultimoSimboloAgregado.elemento.getValor()==1){
					return 5;
				}
			}else{
				if(valor==2){
					
					return 1;
				}
				
			}
			
			
			return valor;
	}





	private void asignaElpadreDe(Vertice ultimoAgregado,Vertice nuevo) {
		if(ultimoAgregado.hayPadre()){
			
			if(esIzquierdo(ultimoAgregado)){
				ultimoAgregado.padre.izquierdo=nuevo;
			}else{
				ultimoAgregado.padre.derecho=nuevo;
			}
			
			nuevo.padre=ultimoAgregado.padre;
		}
		
	}
	
	public Lista<Simbolos> recorreArbol() {
		if(this.raiz==null){
			return null;
		}
		Cola<Vertice> cola= new Cola<Vertice>();
		cola.mete(raiz);
		Lista<Simbolos>lista= new Lista<Simbolos>();
		while(!cola.esVacia()){
			Vertice e =cola.saca();
			lista.agregaFinal(e.elemento);
			if(e.hayIzquierdo()){
				cola.mete(e.izquierdo);
			}
			if(e.hayDerecho()){
				cola.mete(e.derecho);
				
			}
			
		}
		return lista;
		
	}




	private void verificaCambioDeRaiz(ArbolBinario<Simbolos>.Vertice nuevo) {
	
		if(nuevo.padre==null){
			raiz=nuevo;
			}
		
	}

	private boolean esIzquierdo(Vertice vertice){
	
		 if(vertice.padre.izquierdo!=null){
			if(vertice.padre.izquierdo==vertice){
				return true;
			}
			}
		return false;
		  }
	


	public static void main(String[]args){
		ArbolBinarioDeSimbolos a = new ArbolBinarioDeSimbolos();
		a.agrega(new Simbolos("1",0));
		a.agrega(new Simbolos("+",1));
		a.agrega(new Simbolos("1",0));
		a.agrega(new Simbolos("*",2));
		a.agrega(new Simbolos("3",0));
		System.out.println(a);
		System.out.println(a.recorreArbol());
		
	}

	

	


	
	

}
