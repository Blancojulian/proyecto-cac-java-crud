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

@WebServlet("/DeleteEmpleadoController")
public class DeleteEmpleadoController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long dni = Long.parseLong(req.getParameter("dni"));//viene como String -> Long.parseLong()

		//interface = new class que implementa la interface
		IDAO<Empleado> dao = new EmpleadoDAOMysqlImpl();
			
		//eliminar
		try {
			dao.delete(dni);
			//mensaje de exito
			req.setAttribute("success", List.of("Se ha eliminado el empleado con dni:" + dni));
		} catch (Exception e) {
			e.printStackTrace();
			//mensaje de error
			req.setAttribute("erorrs", List.of("NO se ha eliminado el empleado :" + e.getMessage()));
		}//ctrl+t
			
		//ahora redirect!!!!
		getServletContext().getRequestDispatcher("/FindAllEmpleadoController").forward(req, resp);
			
			
	}
}
