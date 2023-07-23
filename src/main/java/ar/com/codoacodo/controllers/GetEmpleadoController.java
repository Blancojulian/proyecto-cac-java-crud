package ar.com.codoacodo.controllers;

import ar.com.codoacodo.dao.IDAO;
import ar.com.codoacodo.dao.implement.EmpleadoDAOMysqlImpl;
import ar.com.codoacodo.domain.Empleado;

public class GetEmpleadoController {

	public static void main(String[] args) {
		//interface = new class que implementa la interface
		IDAO<Empleado> dao = new EmpleadoDAOMysqlImpl();
		
		// como llego a la base de datos si quiero pedir datos de un departamento?
		Long dni = 11l;
		Empleado d;
		// si no usamos try catch podemos arriba poner throws Exception
		try {
		d = dao.getById(dni);
		}
		catch(Exception e) {
			//e.printStackTrace();
			d= null;
		}
		if (d != null) {
			System.out.println(d);
		}else {
			System.err.println("No existe el dni:"+ dni);
		}
		
	}
}
