package proyecto;

@SuppressWarnings("serial")
public class SintaxisException extends RuntimeException  {
	
	public SintaxisException(){
		super();
	}
	
	public SintaxisException(String f){
		super(f);
	}

}
