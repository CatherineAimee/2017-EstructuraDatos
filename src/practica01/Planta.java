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
public abstract class Planta extends Empleado {

	protected double pagoSemanal;
	protected boolean[] prestaciones;
	protected double diaVacaciones;
	protected String nombrePuesto;
      
	
	private static final String [] PRESTACIONES = {"Vales despensa", "Afore", "Infonavit", "Vacaciones Semana Santa", 
				"Vacaciones Verano", "Descuento proveedores afiliados", "Seguro de auto", "Seguro de vida"}; 
	private static final double [] PAGO_PRESTACIONES = {1000, 0.2, 0.1, 7, 2, 0.25, 5000, 25000}; 				 
	private static final double PORCENTAJE_PLANTA = 0.1;			
	private static final int MAXIMO_SUELDO = 25000;
	
	

	public Planta( String nombre, String apellido, int antiguedad, double pagoSemanal, boolean[] prestaciones) {
		super(nombre, apellido, antiguedad);
                
                this.prestaciones = prestaciones;
                
                if(pagoSemanal > 0 && pagoSemanal<=MAXIMO_SUELDO)
                    this.pagoSemanal = pagoSemanal;
                else
                    this.pagoSemanal = 0;
                
                this.diaVacaciones = this.pagoSemanal*this.antiguedad*PORCENTAJE_PLANTA;
		/*
		 * TODO: 
		 * Constructor de la clase Planta.
		 * 1. Inicializa el atributo  de instancia del arreglo de prestaciones con los valores
		 *    del arreglo de prestaciones que recibe de par·metro.
		 * 2. Valida que el atributo de instancia, pagoSemanal, se inicialice con un valor entre 0 y MAXIMO_SUELDO.
		 *    En caso contrario, se asigna 0.
		 * 3. El atributo de instancia, diaVacaciones, se inicializa con el pagoSemanal * antiguedad * PORCENTAJE_PLANTA. 
		 */
	}
   
   
    private String regresaPrestaciones() {
    	/*
    	 * TODO: 
    	 * MÈtodo privado que recorre el arreglo de instancia de prestaciones y si tiene un valor de true en la posiciÛn i,
    	 * entonces crea una cadena con el nombre de la prestaciÛn correspondiente. Los nombres de las prestaciones est·n en
    	 * el arreglo est·tico PRESTACIONES, en la misma posiciÛn i. AsÌ, si prestaciones[0] = true, entonces la prestaciÛn
    	 * correspondiente es PRESTACIONES[0] (que es ìVales despensaî).
    	 */
        String prestacion = "";
        for(int i=1; i<this.prestaciones.length;i++){
            if(prestaciones[i] == true){
                prestacion = PRESTACIONES[i];
            }
            return prestacion;
        }
    	return "";
	}
          
        @Override
    public double sueldo() { 
        double sueldo = this.pagoSemanal;
            for(int i=0; i< prestaciones.length; i++) {
                if(prestaciones[i] == true) {
                    switch (i) {
                        case 0:        
                        case 6:
                        case 7:
                            sueldo += PAGO_PRESTACIONES[i];
                            break;
                        case 1:
                        case 2:
                        case 5:
                            sueldo += PAGO_PRESTACIONES[i] * pagoSemanal;
                            break;
                        case 3:
                        case 4:
                            sueldo += PAGO_PRESTACIONES[i] * diaVacaciones;
                            break;
                        default:
                            break;
                    }
                }
            }
            return sueldo;
    }

	
    public void setPagoSemanal( double pagoSemanal ) { 
		if (pagoSemanal > 0 && pagoSemanal <= MAXIMO_SUELDO)
			this.pagoSemanal = pagoSemanal;
	}
   
    public String toString() {
		return "\n***  Empleado de Planta  ***\n" + super.toString() + "\nCon puesto: " + this.getNombrePuesto() +
				"\nPago semanal: " + this.pagoSemanal + "\nSueldo integrado: " + this.sueldo() + "\nPrestaciones: " + this.regresaPrestaciones();
	}
	
    public String getNombrePuesto() {
		return this.nombrePuesto;
	}
	
    public abstract void setNombrePuesto (String nombrePuesto);
	/*
	 * TODO:
	 * Crear mÈtodo p˙blico abstracto de nombre setNombrePuesto.
	 * El mÈtodo no regresa nada.
	 * El mÈtodo recibe una cadena de caracteres con el nombre del puesto (nombrePuesto).
	 */
    
}