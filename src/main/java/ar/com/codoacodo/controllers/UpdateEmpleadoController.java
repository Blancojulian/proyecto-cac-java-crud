package ar.com.codoacodo.controllers;

import ar.com.codoacodo.dao.IDAO;
import ar.com.codoacodo.dao.implement.EmpleadoDAOMysqlImpl;
import ar.com.codoacodo.domain.Empleado;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateEmpleadoController")
public class UpdateEmpleadoController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//capturo los parametros que viene en el request enviado por el form
		String nombre= req.getParameter("nombre");//name de input
		String dni = req.getParameter("dni");//name de input
		String apellido = req.getParameter("apellido");//name de input
		String dpto_id = req.getParameter("dpto_id");//name de input
		
		//interface = new class que implementa la interface
		IDAO<Empleado> dao = new EmpleadoDAOMysqlImpl();
		
		
		
		Empleado e = new Empleado(Long.parseLong(dni),nombre,apellido,Long.parseLong(dpto_id));
		// si no usamos try catch podemos arriba poner throws Exception
		try { 
			dao.update(e);
			//aca mensaje de exito, PERO COMO UNA LISTA
			req.setAttribute("success", List.of("Empleado dni:" + e.getDni() + " actualizado correctamente"));
		} catch (Exception ex) {
			ex.printStackTrace();
			req.setAttribute("errors", List.of("Error actualizando Empleado<" + ex.getMessage()));
		}
		
		
		//ahora redirect!!!!
	     getServletContext().getRequestDispatcher("/FindAllEmpleadoController").forward(req, resp);
		
		
	}
	
	//cargar el empleado y enviarlo a la jsp que va a editar los datos
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String dni = req.getParameter("dni");
		
		// realizar validaciones, para los datos que vienen!!!
		
		//interface = new class que implementa la interface
		IDAO<Empleado> dao = new EmpleadoDAOMysqlImpl();
		
		Empleado e = null;
		//cargo los datos 
		try {
			e = dao.getById(Long.parseLong(dni));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		//guardar el producto en request y pasar dicho producto a la jsp
		req.setAttribute("empleado", e);
		
		//redirect
		//ahora redirect!!!!
		getServletContext().getRequestDispatcher("/editarEmpleado.jsp").forward(req, resp);
	}

}
