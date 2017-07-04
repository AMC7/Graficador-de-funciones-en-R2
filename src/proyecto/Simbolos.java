package proyecto;

public class Simbolos{
	  int valor=0 ;
	  String s="";
	  
	  public Simbolos(String h , int r){
		  this.valor=r;
		  this.s=h;
	}
	  
	  public String toString(){
		return s +"("+valor+")";
		  
	  }
	  public int getValor(){
		  return this.valor;
	  }
	  public String getString(){
		  return this.s;
	  }
	  
	  public boolean equals(Object o){
		  if (o == null){
        	 
            return false;
        }
        if (getClass() != o.getClass()){
        	
            return false;
        }
        
        Simbolos a = (Simbolos)o;
        
        if(a.s.equals(this.s)&&a.valor==this.valor){
        	return true ;
        }
        return false;
		  
	  }
	  
		
	  public boolean esOperador() {
	     if(this.s.length()==1){
	    	 char c=s.charAt(0);
		  if(c=='+'||c=='*'||c=='='||c=='-'|| c=='^'){
	  		return true;
	     	}
	     }
	  	return false;
	  }
	
	 public boolean esNumero() {
	     return !this.esOperador()&&!esOperador();
	  }
	  
}