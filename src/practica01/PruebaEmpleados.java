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
public class PruebaEmpleados {
	
	public static void main(String[] args) {
		
		boolean[] prestaciones = {true, true, false, false, true, false, true, false};
		Directivo iron = new Directivo("Tony", "Stark", 5, prestaciones, 12500.0, 5000.0, "Director general Stark Inc");
	
		boolean[] prestaciones2 = {false, true, true, false, true, true, false, false};
		Secretaria roz = new Secretaria("Roz", "Ronney", 10, prestaciones2, 6200.0, "Secretaria ejecutiva");
	
		System.out.println(iron.toString());
		System.out.println(roz.toString());
		
		System.out.println("\n\n** POLIMORFISMO CON PLANTA **");
		System.out.println("\n" + iron.getNombre() + " " + iron.getApellido() + " " + PruebaEmpleados.actividadParticular(iron));
		System.out.println("\n" +roz.getNombre() + " " + roz.getApellido() + " " + PruebaEmpleados.actividadParticular(roz));
		
		
		System.out.println("\n\n** POLIMORFISMO CON ADMINISTRATIVO **");
		System.out.println("\n" + iron.getNombre() + " " + iron.getApellido() + " " + PruebaEmpleados.queHace(iron));
		
		System.out.println("\n\n");
	}
	
	
	public static String actividadParticular(Planta a){	
		/*
		 * TODO:
		 * Regresa una cadena con las actividades particulares del objeto de Planta que se recibe de par·metro
		 */
            
		if(a instanceof Directivo){
                    Directivo b = (Directivo)a;
                    return b.administrar() + b.reportarLogros() + b.definirAumentos();
                }
                
                if(a instanceof Secretaria){
                    Secretaria b =(Secretaria)a;
                    return b.llenaRegistros();  
                }
                else
                    return null;
	}
	
	
	
	public static String queHace(Administrativo d){
		/*
		 * TODO:
		 * Regresa una cadena con las actividades que realiza el objeto con un rol de Administrativo que se recibe de par·metro
		 */
		
	if(d instanceof Directivo){
                    Directivo b = (Directivo)d;
                    return b.administrar() +"\n"+ b.reportarLogros() +"\n" + b.definirAumentos();
                }
        else
            return "No administrador";
        }
}