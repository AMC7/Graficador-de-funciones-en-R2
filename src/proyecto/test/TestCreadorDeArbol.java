package proyecto.test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import proyecto.Lista;
import proyecto.IteradorLista;
import proyecto.SeparadorDeSimbolos;
import proyecto.Parentesis;
import proyecto.Simbolos;
import proyecto.Proyecto1;
import proyecto.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class TestCreadorDeArbol{    
	   
	    
	    @Test public void TestCreaArbolconSumasyRestas() {
	    	Proyecto1 a= new Proyecto1();
	    	a.procesaPalabras("1+2+3-4",new Punto(-1.0,1.0),0.1);
	    	
	    	Lista<Simbolos> lista = new Lista<Simbolos>();
	    	
	    	lista.agrega(new Simbolos("-",1));
	    	lista.agrega(new Simbolos("+",1));
	    	lista.agrega(new Simbolos("4",0));
	    	lista.agrega(new Simbolos("+",1));
	    	lista.agrega(new Simbolos("3",0));
	    	lista.agrega(new Simbolos("1",0));
	    	lista.agrega(new Simbolos("2",0));
	    
	    	Assert.assertTrue(lista.equals(a.arbolDeSimbolos.recorreArbol()));
	    }
	    
	    @Test public void TestCreaArbolConSimbolosVariados() {
	    	Proyecto1 a= new Proyecto1();
	    	a.procesaPalabras("-sin(1+2*3^4)",new Punto(-1.0,1.0),0.1);
	    
	    	Lista<Simbolos> lista = new Lista<Simbolos>();
	    	
	    	lista.agrega(new Simbolos("-",4));
	    	lista.agrega(new Simbolos("sin",4));
	       	lista.agrega(new Simbolos("+",1));
	    	lista.agrega(new Simbolos("1",0));
	    	lista.agrega(new Simbolos("*",2));
	    	lista.agrega(new Simbolos("2",0));
	    	lista.agrega(new Simbolos("^",3));
	    	lista.agrega(new Simbolos("3",0));
	    	lista.agrega(new Simbolos("4",0));
	 
	    	 Assert.assertTrue(lista.equals(a.arbolDeSimbolos.recorreArbol()));
	    }
	    
	    
	    @Test public void TestCreaArbolConMultiplicacionesYDivisiones() {
	    	Proyecto1 a= new Proyecto1();
	    	a.procesaPalabras("1*2/3*7",new Punto(-1.0,1.0),0.1);
	    	
	    
	    	Lista<Simbolos> lista = new Lista<Simbolos>();
	    	
	   
	    	lista.agrega(new Simbolos("*",2));
	       	lista.agrega(new Simbolos("/",2));
	    	lista.agrega(new Simbolos("7",0));
	    	lista.agrega(new Simbolos("*",2));
	    	lista.agrega(new Simbolos("3",0));
	    	lista.agrega(new Simbolos("1",0));
	     	lista.agrega(new Simbolos("2",0));
	    	
	 
	    	 Assert.assertTrue(lista.equals(a.arbolDeSimbolos.recorreArbol()));
	    }
	    
	    @Test public void TestCreaArbolConOperadoresUnarios() {
	    	Proyecto1 a= new Proyecto1();
	    	a.procesaPalabras("tan(sin(-x))",new Punto(-1.0,1.0),0.1);
	    	
	    	
	    	Lista<Simbolos> lista = new Lista<Simbolos>();
	    	
	   
	    	lista.agrega(new Simbolos("tan",4));
	       	lista.agrega(new Simbolos("sin",4));
	    	lista.agrega(new Simbolos("-",4));
	    	lista.agrega(new Simbolos("x",0));
	    
	    	
	 
	    	 Assert.assertTrue(lista.equals(a.arbolDeSimbolos.recorreArbol()));
	    }
	    
	    @Test public void TestCreaLosParentesisBien() {
	    	Proyecto1 a= new Proyecto1();
	    	a.procesaPalabras("(12+32)*48",new Punto(-1.0,1.0),0.1);
	    	
	    	Lista<Simbolos> lista = new Lista<Simbolos>();
	    	lista.agrega(new Simbolos("*",2));
	     	lista.agrega(new Simbolos("+",1));
	    	lista.agrega(new Simbolos("48",0));
	    	lista.agrega(new Simbolos("12",0));
	      
	    	lista.agrega(new Simbolos("32",0));
	    	
	    
	    
	    	
	 
	    	 Assert.assertTrue(lista.equals(a.arbolDeSimbolos.recorreArbol()));
	    }
	    
	    
	 
	    	
	    

	
	
	
}