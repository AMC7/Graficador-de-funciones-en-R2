package proyecto.test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import proyecto.Lista;
import proyecto.IteradorLista;
import proyecto.SeparadorDeSimbolos;
import proyecto.Parentesis;
import proyecto.Simbolos;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class TestSeparadorDeSimbolos{
	
	  
	    private SeparadorDeSimbolos separadorDeSimbolos;
        public static void imprime(Simbolos[]a){
        	int i=0;
        	     	for(Simbolos z:a){
        	     		System.out.println(z+" "+(i++));
        	     	}
        }
	
	    
	   
	    
	    @Test public void TestQuitaEspacios() {
	    	SeparadorDeSimbolos separador=new SeparadorDeSimbolos("s i  n(1 + 2)");
	    	separador.separaSimbolos();
	    	  /*Checa si quito los espacios*/
	     	Assert.assertTrue(String.valueOf(separador.f).equals("(sin(1+2))"));
	    }
	    
	    @Test public void TestCreaListaDeParentesis() {
	    	SeparadorDeSimbolos separador=new SeparadorDeSimbolos("sin(1 + 2)");
	    	separador.separaSimbolos();
	    	  /*Checa si hizo la lista de parentesis bien*/
	    	Lista<Parentesis> listaAuxiliarDeParentesis=new Lista<Parentesis>();
	    	listaAuxiliarDeParentesis.agrega(new Parentesis(0,7));
	    	listaAuxiliarDeParentesis.agrega(new Parentesis(2,6));
	    	
	    	Assert.assertTrue(listaAuxiliarDeParentesis.equals(separador.listaDeParentesis));
	    }
	     	
	    @Test public void TestCreaArregloDeSimbolos() {
	    	
	    	SeparadorDeSimbolos separador=new SeparadorDeSimbolos("sin(1 + 2)");
	    	separador.separaSimbolos();
	    	
	    	Simbolos[] a= new Simbolos[20];
	    	a[1]=new Simbolos("sin",4);
	    	a[3]=new Simbolos("1",0);
	     	a[4]=new Simbolos("+",1);
	     	a[5]=new Simbolos("2",0);
	     	
	     	Assert.assertTrue(Arrays.equals(a,separador.contenedorDeSimbolos));
	    }
	    
	    @Test public void TestCreaArregloDeSimbolosCorrectamente() {
	    	
	    	SeparadorDeSimbolos separador=new SeparadorDeSimbolos("sin(1 + 2)");
	    	separador.separaSimbolos();
	    	
	    	Simbolos[] a= new Simbolos[20];
	    	a[1]=new Simbolos("sin",4);
	    	a[3]=new Simbolos("1",0);
	     	a[4]=new Simbolos("+",1);
	     	a[5]=new Simbolos("2",0);
	     	
	     	Assert.assertTrue(Arrays.equals(a,separador.contenedorDeSimbolos));
	    }
	    
	    @Test public void TestMeteDecimalesCorrectamente() {
	    	
	    	SeparadorDeSimbolos separador=new SeparadorDeSimbolos("2443.34 + 545454.3");
	    	separador.separaSimbolos();
	    	
	    	Simbolos[] a= new Simbolos[36];
	    	a[1]=new Simbolos("2443.34",0);
	    	a[2]=new Simbolos("+",1);
	     	a[3]=new Simbolos("545454.3",0);
	     	
	     	
	     	Assert.assertTrue(Arrays.equals(a,separador.contenedorDeSimbolos));
	    }
	    
	    @Test public void TestMeteVariablesCorrectamente() {
	    	
	    	SeparadorDeSimbolos separador=new SeparadorDeSimbolos("2x");
	    	separador.separaSimbolos();
	    
	    	
	    	Simbolos[] a= new Simbolos[8];
	    	a[1]=new Simbolos("2",0);
	    	a[2]=new Simbolos("*",2);
	     	a[3]=new Simbolos("x",0);
	     	Assert.assertTrue(Arrays.equals(a,separador.contenedorDeSimbolos));
	    }
	    
	    
 @Test public void TestChecaExcepciones() {
	    	
	    	SeparadorDeSimbolos separador=new SeparadorDeSimbolos("");
	    	
	    	 try {
	    		 separador.separaSimbolos();
	             Assert.fail();
	         } catch (Exception nsee) {}
	    	 
	    	separador=new SeparadorDeSimbolos("a");
	    	
	    	try {
	    		 separador.separaSimbolos();
	             Assert.fail();
	         } catch (Exception nsee) {}
	     	
	     	
	    }
 
 
 
 @Test public void TestChecaQueAgregueSignoPor() {
 	
    SeparadorDeSimbolos separador=new SeparadorDeSimbolos("(2)(4)");
	separador.separaSimbolos();
	
	
	Simbolos[] a= new Simbolos[16];
	a[2]=new Simbolos("2",0);
	a[4]=new Simbolos("*",2);
 	a[6]=new Simbolos("4",0);
 	Assert.assertTrue(Arrays.equals(a,separador.contenedorDeSimbolos));
  	
 }
	    	
	    	
	    	  
	    	
	    	
	    	
	    	
	    

	
	
	
}