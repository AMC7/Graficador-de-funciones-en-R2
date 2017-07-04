package proyecto;

public class SeparadorDeSimbolos {
	
	public char[] f;
	public Pila<Parentesis> pila =new Pila<Parentesis>();
	public Lista<Parentesis> listaDeParentesis =new Lista<Parentesis>();
	public int longitud=0,k=0;
	public Simbolos[] contenedorDeSimbolos;
	public Parentesis[] arregloDeParentesis;
	
	public SeparadorDeSimbolos(String a){
		a=a.replaceAll(" ","");
		a="("+a+")"; 
		f=a.toCharArray();
		longitud=f.length;
		contenedorDeSimbolos= new Simbolos[longitud*2];	
		arregloDeParentesis= new Parentesis[contenedorDeSimbolos.length] ;
	}
	
	public void separaSimbolos(){
		 
		 if(f.length==0){
			 throw new SintaxisException("No Escribiste nada");
			}
	
		 String numero="",operacion="";
		
		 for (int i=0;i<longitud;i++){
			 if(esNumero(f[i])){ 
				    numero=meteNumero(i, numero);
			  }else if(esVariable(f[i])){
			    	meteVariable(i,numero);
			  }else if(esOperador(f[i])){
				 	meteOperador(i, numero);
			  }else if(esLetraValida(f[i])){
				  	operacion=meteLetraValida(i,operacion);
			  }else if(f[i]=='('){
				  meteParentesis(1,i);
			  }else if(f[i]==')'){
				  meteParentesis(2,i);
			  }else{
				  throw new SintaxisException("\""+f[i]+"\"" +" no es un caracter no es valido");
			  }
		  }
	}
	public void imprimeContenedorDeSimbolos(){
		for(int i =0;i<contenedorDeSimbolos.length;i++){	
		System.out.print("["+contenedorDeSimbolos[i]+"]");
		}
		System.out.println();
	}



	private void meteParentesis(int b,int y) {
		switch(b){
		case 1:
			 pila.mete( new Parentesis(k));
		        k++;
		       
		        break;
		case 2:	
		      Parentesis a =pila.saca();
			  a.segundoParentesis=k++;
			   if(a.segundoParentesis-1==a.primerParentesis){
					throw new SintaxisException("No Escribiste nada");
				}if(y+1<f.length){
					if(f[++y]=='('){
						contenedorDeSimbolos[k++]=new Simbolos("*",2);
					}
				} 
			   
			listaDeParentesis.agregaInicio(a);
			arregloDeParentesis[a.primerParentesis]=a;
			 
		}
		
	}

	


		
	
private String meteLetraValida(int i,String operacion) {
	operacion+=String.valueOf(f[i]);
	if(operacion.length()>3){
		throw new SemanticaException(operacion + " no es una operacion valida");
	}else if(operacion.length()==3){
		if(operacion.equalsIgnoreCase("sin")||
				operacion.equalsIgnoreCase("cos")||
				operacion.equalsIgnoreCase("tan")||
				operacion.equalsIgnoreCase("csc")||
				operacion.equalsIgnoreCase("sec")||
				operacion.equalsIgnoreCase("cot")){
			contenedorDeSimbolos[k++]=new Simbolos(operacion,4);
			return "";
		}if(operacion.equalsIgnoreCase("sqr")){
			contenedorDeSimbolos[k++]=new Simbolos(operacion,4);
			return "";
		}else{
			throw new SemanticaException(operacion+" no es una operacion valida");
		}
		
		
		
	}else{
		if(esLetraValida(f[i+1])){
			return operacion;
		}else{
			throw new SemanticaException((operacion+" no es una operacion valida"));
		}
	}
}
		
	

private void meteOperador(int i, String numero) {
	
	  if(f[i]=='+'){
		  contenedorDeSimbolos[k++]=new Simbolos(String.valueOf(f[i]),1);	  
	  }
	  else if(f[i]=='-'){
		  
		  	if(k-1>=0){
				  if(contenedorDeSimbolos[k-1]!=null){
				       if(contenedorDeSimbolos[k-1].valor==0){
				    	   contenedorDeSimbolos[k++]=new Simbolos(String.valueOf(f[i]),1);
				       	}else{contenedorDeSimbolos[k++]=new Simbolos(String.valueOf(f[i]),4);}
				  }else{contenedorDeSimbolos[k++]=new Simbolos(String.valueOf(f[i]),4);}
		  	}else{contenedorDeSimbolos[k++]=new Simbolos(String.valueOf(f[i]),4);}
		  	
		  
		  
		 
		  
	  }else if(f[i]=='*'||f[i]=='/'){
		  contenedorDeSimbolos[k++]=new Simbolos(String.valueOf(f[i]),2);
	  }else{
		  contenedorDeSimbolos[k++]=new Simbolos(String.valueOf(f[i]),3);
	  }
	  
	  
		
	}

private void meteVariable(int i, String numero) {

	  if(i>0){
			if(esNumero(f[i-1])){
				contenedorDeSimbolos[k++]=new Simbolos(String.valueOf('*'),2);
				contenedorDeSimbolos[k++]=new Simbolos(String.valueOf(f[i]),0);
				  lanzaExcepcion(f,i);
				
			}else{
				contenedorDeSimbolos[k++]=new Simbolos(String.valueOf(f[i]),0);
			}
		  }else{
			  lanzaExcepcion(f,i);
			  contenedorDeSimbolos[k++]=new Simbolos(String.valueOf(f[i]),0);
		  }

	  
		
	}

	
	
	private String meteNumero(int i, String numero) {		
		if(f[i]=='.'&&numero.contains(".")){
			throw new SintaxisException(numero + ". contiene más de un punto");
		} 
		
		numero+=String.valueOf(f[i]); 
		 
		 if(i+1<f.length){
			 if(!esNumero(f[i+1])){
				contenedorDeSimbolos[k++]=new Simbolos(numero,0);
				
				numero="";
			 }
			 
		 }
		return numero;
		
		
	}
	
	



	
	private static boolean esNumero(char c) {
		if(c=='0'||c=='1'||c=='2'||c=='3'|| c=='4'
			||c=='5'||c=='6'||c=='7'||c=='8'||c=='9'||c=='.'
			){
			return true;
		}
		return false;
	}
	
	private static boolean esVariable(char c) {
		if(c=='x'||c=='X'){
			return true;
		}
		return false;
	}

	private static boolean esOperador(char c) {
		if(c=='+'||c=='*'||c=='/'||c=='='||c=='-'|| c=='^'){
			return true;
		}
		return false;
	}
	
	private static boolean esLetraValida(char c) {
		if(c=='c'||c=='s'||c=='t'||c=='o'||c=='i'|| c=='e'||
				c=='q'||c=='a'||c=='n'||c=='r'||
				c=='C'||c=='S'||c=='T'||c=='O'||c=='I'|| c=='E'||
				c=='Q'||c=='A'||c=='N'||c=='R'){
			return true;
		}
		return false;
	}
	private void lanzaExcepcion(char[] f, int i) {
		  if(i+1<f.length){
				 if(esNumero(f[i+1])){
					 throw new SintaxisException("\""+f[i+1]+"\"" +" no esta en una posicion valida"); 
				 }
			 }
		
	}




}
