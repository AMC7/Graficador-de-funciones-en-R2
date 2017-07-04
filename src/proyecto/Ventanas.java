package proyecto;
import java.io.File;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Ventanas extends Application {
	
	private Group root;

	Lista<Formula> listaDeFormulas=new Lista<Formula>();
	SVG svg=new SVG();
	int color;
	Punto dominio=new Punto(-10.0,10.0);
	Punto rango=new Punto(-4.0,4.0);
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Graficador");
	    primaryStage.show();
	    Group root =new Group();
	    Scene scene = new Scene(root, 750,800);
	    
	    primaryStage.setScene(scene);
	    BorderPane border = new BorderPane();
	    HBox hbox = agregaTitulo();
	    border.setTop(hbox);
	    border.setCenter(dibujaEjes(new Punto(primaryStage.getWidth()/2,primaryStage.getHeight()/3)));
	    border.setBottom(entradaDeUsuario(border,primaryStage));
	    root.getChildren().add(border);
	    

	       scene.widthProperty().addListener(new ChangeListener<Number>() {
	    	    

				@Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
					 
					  Group root=new Group();
					  svg.svg="";
					  root=dibujaEjes(new Punto(primaryStage.getWidth()/2,primaryStage.getHeight()/3));
					  for(Formula formula :listaDeFormulas){
	    		      DibujaGrafica(new Punto(primaryStage.getWidth()/2,primaryStage.getHeight()/3), formula.formula, root,formula.dominio, formula.rango, formula.color);
	    		    }
	    		  
	    			border.setCenter(root);
	    			
	    	    }

				
	    	});
	    	scene.heightProperty().addListener(new ChangeListener<Number>() {
	    	    @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
	    	    	  Group root=new Group();
					  svg.svg="";
					  root=dibujaEjes(new Punto(primaryStage.getWidth()/2,primaryStage.getHeight()/3));
					  for(Formula formula :listaDeFormulas){
	    		      DibujaGrafica(new Punto(primaryStage.getWidth()/2,primaryStage.getHeight()/3), formula.formula, root,formula.dominio, formula.rango, formula.color);
	    		    }
	    		  
	    			border.setCenter(root);
	    		 
	    	    }
	    	});
	  }
	
	
	public HBox agregaTitulo() {
		
	    HBox hbox = new HBox();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    
	    String family = "Helvetica";
	    double size = 20;

	    TextFlow textFlow = new TextFlow();
	   
	    Text text1 = new Text("Tonio");
	    text1.setFont(Font.font(family, FontWeight.BOLD,size));
	    text1.setFill(Color.RED);
	    Text text2 = new Text("Gebra");
	    text2.setFill(Color.ORANGE);
	    text2.setFont(Font.font(family, FontWeight.BOLD, size));
	
	    textFlow.getChildren().addAll(text1, text2);
	     
	  
	    text2.setFont(Font.font(family, FontWeight.BOLD, size));
	    hbox.getChildren().addAll(textFlow);

	    return hbox;
	
}
public Node DibujaGrafica(Punto centro, String s,Group root,Punto dominio, Punto r, int numero ) {
		
		double zoom=70;
		
		Proyecto1 proyecto=new Proyecto1();
        proyecto.procesaPalabras(s, new Punto (dominio.x,dominio.y),0.1);
      	Punto[] punto=proyecto.arregloDePuntos;
       if(numero==-1){
        numero =creaNumeroAleatorio();
       }
      	Paint color=getColor(numero);
      	String color2=getColorSVG(numero);
      	this.color=numero;
    	Punto rango =new Punto(centro.y+(r.x*zoom),centro.y+(r.y*zoom));
    	
      	for(int i=0;i<punto.length-2;i++){
        	if(punto[i]!=null&&punto[i+1]!=null){
        	
        	Punto punto1=new Punto(centro.x+(punto[i].x*zoom),centro.y+(punto[i].y*zoom*-1));
        	Punto punto2=new Punto(centro.x+(punto[i+1].x*zoom),centro.y+(punto[i+1].y*zoom*-1));
         	
        	if(estaEnRango(punto1,punto2,centro,rango)){
        	 Line linea=new Line(punto1.x,punto1.y,punto2.x,punto2.y);
        	 linea.setStroke(color);
         	 root.getChildren().add(linea);
         	 this.svg.svg+=this.svg.dibujaLinea(punto1,punto2,color2);
         	}
        	}
        	
        }
		return root;
	    
	    
	}
	
	
	
	

	public Node entradaDeUsuario(BorderPane border,Stage primaryStage) {
		   GridPane grid = new GridPane();
		   grid.setAlignment(Pos.BOTTOM_LEFT);
		   grid.setHgap(10);
		   grid.setVgap(10);
		   @SuppressWarnings("unused")
		Scene scene = new Scene(grid, 300, 275);
		 
		 
		    Label funcion = new Label("                          f(x)=");
		    grid.add(funcion, 0, 0);
		    TextField insertaFuncion = new TextField();
		    grid.add(insertaFuncion , 1, 0);
		    
		    final Text actiontarget = new Text();
	        grid.add(actiontarget, 3, 0);
	        
	        Label idominio = new Label("Intervalo de Dominio: ");
		    grid.add(idominio, 4, 0);

		    TextField insertaDominio = new TextField();
		    grid.add(insertaDominio, 5, 0);
		    
		    Label irango= new Label("Intervalo de Rango: ");
		    grid.add(irango, 4, 1);

		    TextField insertaRango = new TextField();
		    grid.add(insertaRango, 5, 1);
		    
		    Label dimensiones= new Label("Dimensiones de Ventana: ");
		    grid.add(dimensiones, 0, 1);

		    TextField insertaDimensiones = new TextField();
		    grid.add(insertaDimensiones, 1, 1);
		    
		    
		    Button boton = new Button("Guardar");
		    HBox hbBtn = new HBox(10);
		    hbBtn.getChildren().add(boton);
		    grid.add(hbBtn,1,2);
		    
		    Button btn2 = new Button("Limpia");
		    HBox hbBtn2 = new HBox(10);
		    hbBtn2.setAlignment(Pos.BOTTOM_LEFT);
		    hbBtn2.getChildren().add(btn2);
		    grid.add(hbBtn2, 4, 2);
		    
		    
		    insertaDimensiones .setOnKeyPressed(new EventHandler<KeyEvent>() {

				@Override
				public void handle(final KeyEvent keyEvent) {
                    if (keyEvent.getCode() == KeyCode.ENTER) {
                  	 try{
                    Punto dimensiones =creaPunto(insertaDimensiones.getText());
                    primaryStage.setWidth(dimensiones.x);
                    primaryStage.setHeight(dimensiones.y);
                    Group root=new Group();
					svg.svg="";
					 actiontarget.setText("");
					root=dibujaEjes(new Punto(primaryStage.getWidth()/2,primaryStage.getHeight()/3));
					for(Formula formula :listaDeFormulas){
						DibujaGrafica(new Punto(primaryStage.getWidth()/2,primaryStage.getHeight()/3), formula.formula, root,formula.dominio, formula.rango, formula.color);
	    		    }
	    		  
	    			border.setCenter(root);
                  	 }catch(Exception e){
                  		actiontarget.setFill(Color.FIREBRICK);
      	            	actiontarget.setText(e.getMessage());
                  	 }
                  
                    }
                }
		    });
		    
		 
		  
		    
	        insertaFuncion .setOnKeyPressed(new EventHandler<KeyEvent>() {

				@Override
				public void handle(final KeyEvent keyEvent) {
                    if (keyEvent.getCode() == KeyCode.ENTER) {
                    	 String funcion=insertaFuncion.getText();
                    	 Punto centro=new Punto(primaryStage.getWidth()/2,primaryStage.getHeight()/3);
                    	try{
          	            	border.setCenter(DibujaGrafica(centro,funcion,root,dominio,rango,-1));
                    	    listaDeFormulas.agrega(new Formula(funcion,color,dominio,rango));
                    	    actiontarget.setText("");
          	            }catch(Exception e){
          	            	actiontarget.setFill(Color.FIREBRICK);
          	            	actiontarget.setText(e.getMessage());
      	            	} 
                    }
                }
		    });
		    
		  
		    
		    insertaDominio.setOnKeyPressed(new EventHandler<KeyEvent>() {

		    	@Override
				public void handle(final KeyEvent keyEvent) {
                    if (keyEvent.getCode() == KeyCode.ENTER) {
                    	  try{
                    	   String funcion=insertaFuncion.getText();
                    	   Punto centro=new Punto(primaryStage.getWidth()/2,primaryStage.getHeight()/3);
                    	   Punto dominio= creaPunto(insertaDominio.getText());
          	            	border.setCenter(DibujaGrafica(centro,funcion,root,dominio,rango,-1));
                    	    listaDeFormulas.agrega(new Formula(funcion,color,dominio,rango));
                    	    actiontarget.setText("");
          	            }catch(Exception e){
          	            	actiontarget.setFill(Color.FIREBRICK);
          	            	actiontarget.setText(e.getMessage());
      	            	} 
           	       }
                }
		    });
		    
		   
		    
		    insertaRango.setOnKeyPressed(new EventHandler<KeyEvent>() {

		    	@Override
				public void handle(final KeyEvent keyEvent) {
                    if (keyEvent.getCode() == KeyCode.ENTER) {
                    	
                   	
                   try{
                	 String funcion=insertaFuncion.getText();
                  	 Punto centro=new Punto(primaryStage.getWidth()/2,primaryStage.getHeight()/3);
                  	 	if(!insertaDominio.getText().equals("")){
                  	 		dominio=creaPunto(insertaDominio.getText());
                  	 	}
                  	 Punto rango=creaPunto(insertaRango.getText());
      	             border.setCenter(DibujaGrafica(centro,funcion,root,dominio,rango,-1));
                	 listaDeFormulas.agrega(new Formula(funcion,color,dominio,rango));
                	  actiontarget.setText("");
      	            }catch(Exception e){
      	            	actiontarget.setFill(Color.FIREBRICK);
      	            	actiontarget.setText(e.getMessage());
  	            	} 
      	            	 
                    }
                }
		    });
		    
		    boton.setOnAction(new EventHandler<ActionEvent>() {
		    	 
	            @Override
	            public void handle(ActionEvent e) {
	            	String aux=svg.creaEntrada(100000, 100000)+svg.svg+svg.creaSalida();
	            	FileChooser fileChooser = new FileChooser();
	            	fileChooser.setInitialFileName("NuevaGrafica.svg");
	            	
	                fileChooser.getExtensionFilters().addAll(	    
	                        	new FileChooser.ExtensionFilter("SVG", "*.svg"),
	                        	new FileChooser.ExtensionFilter("HTML", "*.html")
	                    );
	                
			            fileChooser.setTitle("Save Image");
			  
			            File file = fileChooser.showSaveDialog(primaryStage);
			         
			            if (file != null) {
			            	 svg.generaArchivo(file.toString(), aux);
			            }
	            }
	        });
		    
		  
	        
	        btn2.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent e) {
	              root=new Group();
	              svg.svg="";
	               dibujaEjes(new Punto(primaryStage.getWidth()/2,primaryStage.getHeight()/3));
	            	border.setCenter(root);
	            	listaDeFormulas.limpia();
	            }
	        });
	        return grid;
	}

	private Paint getColor(int i) {
	
	switch(i){
		
		case 0:
			return Color.RED;
		case 1:
			return Color.BROWN;
		case 2:
			return Color.GREEN;
		case 3:
			return Color.ORANGE;
		case 4:
			return Color.PURPLE;
		case 5:
			return Color.BLUE;
		}
		return Color.VIOLET;
	}
	
	private String getColorSVG(int numero) {

		switch(numero){
	    
		case 0:
			return "red";
		case 1:
			return  "brown";
		case 2:
			return "green";
		case 3:
			return "orange";
		case 4:
			return "purple";
		case 5:
			return "blue";
		}
		return "violet";
		
	}

	private Punto creaPunto(String s) {
		
		char[] a= s.toCharArray();
		Punto punto=new Punto();
		String numero="";
		for(int i=0 ;i<a.length;i++){
			if(esNumero(a[i]))
			numero+=a[i];
			if(!esNumero(a[i])||i==a.length-1){
				if(numero!=null){
					if(!numero.equals("")){
						if(punto.x==null){
							punto.x=Double.parseDouble(numero);
							numero="";
						}else{
							punto.y=Double.parseDouble(numero);
						}
					}
				}
			}
			
		}
		if(punto.x==null||punto.y==null){
			throw new SintaxisException("Inserta punto de la forma (1,2)");
		}
		return punto;
	}
	

	private boolean esNumero(char a){
		return a=='0'||a=='1'||a=='2'||a=='3'||a=='4'||a=='5'
			 ||a=='6'||a=='7'||a=='8'||a=='9'||a=='.'||a=='+'||a=='-';
	}
	
	private int creaNumeroAleatorio(){
		return (int)(Math.random()*6);
	}
	
	private Group dibujaEjes(Punto centro) {
		Group root= new Group();
		 
	    Line Ejey =new Line(centro.x,0,centro.x,2*centro.y);
	    Line Ejex =new Line(0,centro.y,centro.x*2,centro.y);
	    root.getChildren().add(Ejey);
	    root.getChildren().add(Ejex);
	    this.root=root;
	    this.svg.svg+=this.svg.dibujaLinea(new Punto(centro.x,0),new Punto(centro.x,2*centro.y),"black");
	    this.svg.svg+=this.svg.dibujaLinea(new Punto(0,centro.y),new Punto(centro.x*2,centro.y),"black");
	    
		return root;
		}

	private boolean estaEnRango(Punto punto1, Punto punto2, Punto centro, Punto rango) {
		
		if((punto1.x>0&&punto1.x<centro.x*2)&&(punto2.x>0&&punto2.x<centro.x*2)
				&&(punto1.y>0&&punto1.y<centro.y*2)&&(punto2.y>0&&punto2.y<centro.y*2)
				&&(punto1.y>rango.x&&punto1.y<rango.y)&&(punto2.y>rango.x&&punto2.y<rango.y)){
			return true;
		}
		return false;
	}

	
	



	
	

	public static void main(String[]args){
		launch();
	}
	 
}
	
	


