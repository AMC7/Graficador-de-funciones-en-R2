package proyecto;
public class Punto {
	
Double x;
Double y ;

Integer xa;
Integer ya;



public Punto(Double x){
	this.x=x;
}
public Punto(int i, int j) {
	this.xa=i;
	this.ya=j;
}

public Punto(double i, double saca) {
	x=i;
	y=saca;
}

public Punto() {
}
public String toString(){
	if(x!=null){
	return "("+x+","+y+")";
	}
	return "("+xa+","+ya+")";
} 

public void setY(Double y){
	this.y=y;
}
}
