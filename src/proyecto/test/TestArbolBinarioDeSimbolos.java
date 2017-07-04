package proyecto.test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import proyecto.Lista;
import proyecto.IteradorLista;
import proyecto.SeparadorDeSimbolos;
import proyecto.Parentesis;
import proyecto.Simbolos;
import proyecto.ArbolBinarioDeSimbolos;
import proyecto.Proyecto1;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

/*Clase que testea las Operaciones de Arbol Binario*/

public class TestArbolBinarioDeSimbolos{
	
	  ArbolBinarioDeSimbolos arbol= new ArbolBinarioDeSimbolos();
	  
        public static void imprime(Simbolos[]a){
        	int i=0;
        	     	for(Simbolos z:a){
        	     		System.out.println(z+" "+(i++));
        	     	}
        }
	
	    
	   
        /*Prueba que la suma se realice correctamente*/
        
	    @Test public void TestSuma() {
	    	ArbolBinarioDeSimbolos arbol= new ArbolBinarioDeSimbolos();
	    	arbol.agrega(new Simbolos("1",0));
	    	arbol.agrega(new Simbolos("+",1));
	    	arbol.agrega(new Simbolos("3",0));
	    	
	    	Lista<Simbolos>a =new Lista<Simbolos>();
	    	a.agrega(new Simbolos("+",1));
	    	a.agrega(new Simbolos("1",0));
	    	a.agrega(new Simbolos("3",0));
	    
	    	Assert.assertTrue(a.equals(arbol.recorreArbol()));
	    
	   
	    }
	    
	    /*Prueba que la resta se realice correctamente*/
	   
	    @Test public void TestResta(){
	    	ArbolBinarioDeSimbolos arbol= new ArbolBinarioDeSimbolos();
	    	arbol.agrega(new Simbolos("1",0));
	    	arbol.agrega(new Simbolos("-",1));
	    	arbol.agrega(new Simbolos("3",0));
	    	
	    	Lista<Simbolos>a =new Lista<Simbolos>();
	    	a.agrega(new Simbolos("-",1));
	    	a.agrega(new Simbolos("1",0));
	    	a.agrega(new Simbolos("3",0));
	    
	    	Assert.assertTrue(a.equals(arbol.recorreArbol()));
	    
	   
	   }
	    /*Prueba que la multiplicacion se realice correctamente*/
	    
	    @Test public void TestMultiplicacion() {
	    	ArbolBinarioDeSimbolos arbol= new ArbolBinarioDeSimbolos();
	    	arbol.agrega(new Simbolos("1",0));
	    	arbol.agrega(new Simbolos("*",2));
	    	arbol.agrega(new Simbolos("3",0));
	    	
	    	Lista<Simbolos>a =new Lista<Simbolos>();
	    	a.agrega(new Simbolos("*",2));
	    	a.agrega(new Simbolos("1",0));
	    	a.agrega(new Simbolos("3",0));
	    
	    	Assert.assertTrue(a.equals(arbol.recorreArbol()));
	    
	   
	    }
	    /*Prueba que la division se realice correctamente*/
	   
	    @Test public void TestDivision(){
	    	ArbolBinarioDeSimbolos arbol= new ArbolBinarioDeSimbolos();
	    	arbol.agrega(new Simbolos("1",0));
	    	arbol.agrega(new Simbolos("/",2));
	    	arbol.agrega(new Simbolos("3",0));
	    	
	    	Lista<Simbolos>a =new Lista<Simbolos>();
	    	a.agrega(new Simbolos("/",2));
	    	a.agrega(new Simbolos("1",0));
	    	a.agrega(new Simbolos("3",0));
	    
	    	Assert.assertTrue(a.equals(arbol.recorreArbol()));
	    
	   
	   }
	    /*Prueba que la potencia se realice correctamente*/
	    
	    @Test public void TestPotencia(){
	    	ArbolBinarioDeSimbolos arbol= new ArbolBinarioDeSimbolos();
	    	arbol.agrega(new Simbolos("1",0));
	    	arbol.agrega(new Simbolos("^",3));
	    	arbol.agrega(new Simbolos("3",0));
	    	
	    	Lista<Simbolos>a =new Lista<Simbolos>();
	    	a.agrega(new Simbolos("^",3));
	    	a.agrega(new Simbolos("1",0));
	    	a.agrega(new Simbolos("3",0));
	    
	    	Assert.assertTrue(a.equals(arbol.recorreArbol()));
	    
	   
	   }
	    /*Prueba que la Raiz se realice correctamente*/
	    
	    @Test public void TestRaiz(){
	    	ArbolBinarioDeSimbolos arbol= new ArbolBinarioDeSimbolos();
	    	arbol.agrega(new Simbolos("sqr",4));
	    	arbol.agrega(new Simbolos("3",0));
	    	
	    	Lista<Simbolos>a =new Lista<Simbolos>();
	    	a.agrega(new Simbolos("sqr",4));
	    	a.agrega(new Simbolos("3",0));
	    
	    
	    	Assert.assertTrue(a.equals(arbol.recorreArbol()));
	    
	   
	   }
	    /*Prueba que los operaciones unarias se realicen correctamente*/
	    @Test public void TestUnario(){
	    	ArbolBinarioDeSimbolos arbol= new ArbolBinarioDeSimbolos();
	
	    	arbol.agrega(new Simbolos("sin",4));
	    	arbol.agrega(new Simbolos("3",0));
	    	
	   Lista<Simbolos> a =new Lista<Simbolos>();
	    	a.agrega(new Simbolos("sin",4));
	    	a.agrega(new Simbolos("3",0));
	    
	    	Assert.assertTrue(a.equals(arbol.recorreArbol()));
	    	arbol= new ArbolBinarioDeSimbolos();
	    	
	    	arbol.agrega(new Simbolos("cos",4));
	    	arbol.agrega(new Simbolos("3",0));
	    	
	    	a =new Lista<Simbolos>();
	    	a.agrega(new Simbolos("cos",4));
	    	a.agrega(new Simbolos("3",0));
	    
	    	Assert.assertTrue(a.equals(arbol.recorreArbol()));
	    	
	    	arbol= new ArbolBinarioDeSimbolos();
	    	arbol.agrega(new Simbolos("tan",4));
	    	arbol.agrega(new Simbolos("3",0));
	    	
	    	a =new Lista<Simbolos>();
	    	a.agrega(new Simbolos("tan",4));
	    	a.agrega(new Simbolos("3",0));
	    
	    	Assert.assertTrue(a.equals(arbol.recorreArbol()));
	    
	   
	   }
	    /*Prueba que la jerarquia funcione*/
	    @Test public void TestJerarquia(){
	    	ArbolBinarioDeSimbolos arbol= new ArbolBinarioDeSimbolos();
	    	arbol.agrega(new Simbolos("tan",4));
	    	arbol.agrega(new Simbolos("1",0));
	    	arbol.agrega(new Simbolos("/",2));
	    	arbol.agrega(new Simbolos("3",0));
	    	arbol.agrega(new Simbolos("+",1));
	    	arbol.agrega(new Simbolos("3",0));
	    	
	    	
	    	Lista<Simbolos>a =new Lista<Simbolos>();
	    	a.agrega(new Simbolos("+",1));
	    	a.agrega(new Simbolos("/",2));
	    	a.agrega(new Simbolos("3",0));
	    	a.agrega(new Simbolos("tan",4));
	    	a.agrega(new Simbolos("3",0));
	    	a.agrega(new Simbolos("1",0));
	    
	    	Assert.assertTrue(a.equals(arbol.recorreArbol()));
	    
	   
	   }
	    
	    
	    	
	    	
	    	
	    	
	    

	
	
	
}