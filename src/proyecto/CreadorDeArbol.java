package proyecto;
public class CreadorDeArbol {
	
	

	Simbolos[] contenedorDeSimbolos;
	ArbolBinarioDeSimbolos arbol =new ArbolBinarioDeSimbolos();
	Lista<Parentesis> listaDeParentesis;
	Parentesis[] arregloDeParentesis;
	Cola<Parentesis> cola = new Cola<Parentesis>();
	Parentesis actual;
	
	public CreadorDeArbol(Simbolos[] contenedorDeSimbolos, Lista<Parentesis> listaDeParentesis, Parentesis[] arregloDeParentesis2) {
	   this.contenedorDeSimbolos=contenedorDeSimbolos;
	   arregloDeParentesis= arregloDeParentesis2;
	   this.listaDeParentesis=listaDeParentesis;
		
		ArbolBinarioDeSimbolos auxiliar=new ArbolBinarioDeSimbolos();
		arbol=creaArbol(arregloDeParentesis[0],auxiliar);
	
	}
	
	public ArbolBinarioDeSimbolos creaArbol(Parentesis parentesis,ArbolBinarioDeSimbolos auxiliar){
		int b=parentesis.segundoParentesis-1;
		int a=parentesis.primerParentesis+1;
	  
		while(a<=b){
	
	 if(contenedorDeSimbolos[a]!=null){
		 
			auxiliar.agrega(contenedorDeSimbolos[a]);
			contenedorDeSimbolos[a]=null;
	 
	 }else if(arregloDeParentesis[a]!=null){
		    
		 	ArbolBinarioDeSimbolos c=new ArbolBinarioDeSimbolos();
		    c=creaArbol(arregloDeParentesis[a],c);
			auxiliar.agrega(c,c.elementos);
			a+=c.elementos+1;
	  }else{
			a++;
	  }
	 
	}
		
	return auxiliar;

	}
	

	public void imprimeContenedorDeSimbolos(){
		for(int i =0;i<contenedorDeSimbolos.length;i++){	
		System.out.print("["+contenedorDeSimbolos[i]+"]");
		}
		System.out.println();
	}
   }
