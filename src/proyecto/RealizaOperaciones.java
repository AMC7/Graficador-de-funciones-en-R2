package proyecto;
public class RealizaOperaciones {
     
	int j=0;
	Simbolos[] sim;
	ArbolBinarioDeSimbolos arbol ;
	Lista<Simbolos> lista=new Lista<Simbolos>();
	Pila<Double>pila =new Pila<Double>();
	Punto[]punto;

	public Lista<Punto> listaDePuntos;
	
	public RealizaOperaciones(ArbolBinarioDeSimbolos arbolDeSimbolos,Punto punto, double separacion) {
	    int posicionEnElArreglo=0; 
		arbol=arbolDeSimbolos;
		sim=new Simbolos[arbol.elementos];
		if(punto.ya!=null){
		this.punto=new Punto[(int) ((punto.ya-punto.xa)*(1/separacion))];
		System.out.println("");
	   
		double i=punto.xa;
		
		while(i<punto.ya-separacion){
			
				recorreArbol(arbol.raiz,i);
				Double y =pila.saca();
				  if(!y.isInfinite()&&!y.isNaN()){
					  this.punto[posicionEnElArreglo++]=new Punto((double)i,y); 
				
				  }
				  i=i+separacion;
			
		}
		
		}else{
			try{
			this.punto=new Punto[(int) ((punto.y-punto.x)*(1/separacion))];
			}catch(Exception e){
				throw new SintaxisException("Rango no valido");
			}
		   
			double i=punto.x;
			
			while(i<punto.y-separacion){
				
					recorreArbol(arbol.raiz,i);
					Double y =pila.saca();
					  if(!y.isInfinite()&&!y.isNaN()){
						  this.punto[posicionEnElArreglo++]=new Punto((double)i,y); 
					
					  }
					  i=i+separacion;
				
			}
			
			
			
		}
		
		
	    
	    
	   }
	
	
	



	public void recorreArbol(ArbolBinarioDeSimbolos.Vertice a,double variable) {
		if(a==null){
			return;
		}
		
		if(a.hayDerecho()){
			recorreArbol(a.derecho,variable);	
		}

		if(a.hayIzquierdo()){
			recorreArbol(a.izquierdo,variable);
		}
	
		realizaOperacion(a,variable);
	
 	 }
	



	 public void realizaOperacion(ArbolBinarioDeSimbolos.Vertice a,Double variable){
		 if(a.get().valor==0){
			 if(a.get().s.equalsIgnoreCase("x")){
				 pila.mete(variable); 
			 }else{
			 pila.mete(Double.parseDouble(a.get().s));
			 }
		 }else{
		 if(a.hayIzquierdo()){
			 if(a.get().s.equalsIgnoreCase("+")){
			      pila.mete(pila.saca()+pila.saca());
			 }if(a.get().s.equalsIgnoreCase("-")){
				  pila.mete(pila.saca()-pila.saca());
			 }if(a.get().s.equalsIgnoreCase("*")){
				 pila.mete(pila.saca()*pila.saca());
			 }if(a.get().s.equalsIgnoreCase("/")){
				 Double numerador=pila.saca();
				 Double denominador=pila.saca();
				 
				 pila.mete(numerador/denominador);
			 }if(a.get().s.equalsIgnoreCase("^")){
				pila.mete(Math.pow(pila.saca(),pila.saca()));
			 }
			 
		 }else{
			 if(a.get().s.equalsIgnoreCase("sin")){
				 pila.mete(Math.sin(pila.saca()));
			 }
			if(a.get().s.equalsIgnoreCase("sqr")){

				pila.mete(Math.sqrt(pila.saca()));
			 }
			 if(a.get().s.equalsIgnoreCase("cos")){
				 pila.mete(Math.cos(pila.saca()));
			 }
			 if(a.get().s.equalsIgnoreCase("tan")){
				 pila.mete(Math.tan(pila.saca()));
			 }
			 if(a.get().s.equalsIgnoreCase("csc")){
				 pila.mete(1/Math.sin(pila.saca()));
			 }
			 if(a.get().s.equalsIgnoreCase("sec")){
				 pila.mete(1/Math.cos(pila.saca()));
			 }
			 if(a.get().s.equalsIgnoreCase("cot")){
				 pila.mete(1/Math.tan(pila.saca()));
			 } if(a.get().s.equalsIgnoreCase("-")){
				pila.mete(-pila.saca());
			 }
			
			 
		 }
		 }
		
		
	 }
		public void imprimeContenedorDeSimbolos(){
			for(int i =0;i<punto.length;i++){	
			System.out.print("["+punto[i]+"]");
			}
			System.out.println();
		}

	 
    

		

}


