/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica01;

/**
 *
 * @author Neil
 */
public abstract class Empleado {

	protected String nombre;
	protected String apellido;
	protected int antiguedad;

	public Empleado( String nombre, String apellido, int antiguedad ) {
		this.nombre = new String ( nombre );
		this.apellido = new String( apellido );
		
		if (antiguedad > 0)
			this.antiguedad = antiguedad;
	}	
   
	public String getNombre() { 
		return nombre; 
	}

	public String getApellido() { 
		return apellido; 
	}
	
	public void setAntiguedad(int antiguedad) {
		if (antiguedad > this.antiguedad)
			this.antiguedad = antiguedad;
	}

	abstract double sueldo(); 
	
	public String toString() {
		return "\nNombre: " + this.nombre + "\nApellido: " + this.apellido + "\nAntiguedad: " + this.antiguedad;
	}
}