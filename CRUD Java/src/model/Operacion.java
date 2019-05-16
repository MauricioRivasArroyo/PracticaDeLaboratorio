package model;

public class Operacion {
	private int id;	
	private String operacion;
	private float primero;
	private float segundo;
	private float resultado;

	
	public Operacion() {
	}
	
	public Operacion(int id,String operacion, float primero, float segundo,float resultado) {
		this.id = id;
		this.operacion = operacion;
		this.primero = primero;
		this.segundo = segundo;
		this.resultado = resultado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public float getPrimero() {
		return primero;
	}

	public void setPrimero(float primero) {
		this.primero = primero;
	}

	public float getSegundo() {
		return segundo;
	}

	public void setSegundo(float segundo) {
		this.segundo = segundo;
	}

	public float getResultado() {
		return resultado;
	}

	public void setResultado(float resultado) {
		this.resultado = resultado;
	}	
	
}