package ar.com.codoacodo.dao.implement;

import ar.com.codoacodo.dao.IDAO;
import ar.com.codoacodo.domain.Empleado;
import ar.com.codoacodo.db.AdministradorDeConexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class EmpleadoDAOMysqlImpl implements IDAO<Empleado> {


	@Override
	public Empleado getById(Long dni)  throws Exception{
		//-1 necesito la conection a la base
		Connection connection = AdministradorDeConexiones.getConnection();
		//2 - arma el statement
		String sql = "select * from empleados where dni = " + dni;
	    
		Statement statement  = connection.createStatement();
		
		//3 - obtengo el resulSet
		ResultSet resultSet = statement.executeQuery(sql);
		// El resultset devuelve un registro de una tabla 
		
	     // primero verifico si hay datos 
		
		if (resultSet.next()){
			
			return this.crearEmpleado(resultSet);
			
		}
		cerrar(connection);
		return null; // si no hay resultset entonces no devuelve nada
	}

	@Override
	public List<Empleado> findAll() throws Exception {
		//-1 necesito la conection a la base
		Connection connection = AdministradorDeConexiones.getConnection();
		//2 - arma el statement
	    String sql = "select * from empleados";
			   
		Statement statement  = connection.createStatement();
				
		//3 - obtengo el resulSet
		ResultSet resultSet = statement.executeQuery(sql);
		// El resultset devuelve un registro de una tabla 
				
	     // primero verifico si hay datos 
		    // creo una lista de departamentos
			List<Empleado> empleados = new ArrayList<Empleado>();	
			
			// mientras encontremos resultados de la base 
			while (resultSet.next()){
				// creamos un empleado y lo agregamos a la lista
				empleados.add(this.crearEmpleado(resultSet));
					
			}
			cerrar(connection);
		   // devolvemos departamentos		
		   return empleados;
	}

	@Override
	public void delete(Long dni) throws Exception {
	   //-1 necesito la conection a la base
		Connection connection = AdministradorDeConexiones.getConnection();
		//2 - arma el statement
	     String sql = "DELETE FROM empleados WHERE DNI=" + dni;
	 	 Statement statement  = connection.createStatement();
	 	//3 -devuelve un entero devuelve 1 o 0, pero no hace falta confirmar para este caso 
	 	 statement.executeUpdate(sql);
	 	 cerrar(connection);
		 
	}

	@Override
	public void update(Empleado empleado) throws Exception {
		// creo un Departamento con los datos modificados del departemento 
		  
		//-1 necesito la conection a la base
		Connection connection = AdministradorDeConexiones.getConnection();
		//2 - arma el statement
		 String sql = "update empleados set nombre = ?, apellido = ?, dpto_id = ? where dni= ?";
		 PreparedStatement statement  = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		 statement.setString(1, empleado.getNombre());
	     statement.setString(2, empleado.getApellido());
		 statement.setLong(3, empleado.getDptoId());
		 statement.setLong(4, empleado.getDni());
		 
		//3 -devuelve un entero devuelve 1 o 0, pero no hace falta confirmar para este caso 
		 statement.execute();
		
		 cerrar(connection);
	}

	@Override
	public void create(Empleado newEmpleado) throws Exception {
		
        
		//-1 necesito la conection a la base
		Connection connection = AdministradorDeConexiones.getConnection();
		//2 - arma el statement
		 String sql = "insert into empleados (dni, nombre, apellido, dpto_id) values (?,?,?,?)";
		 PreparedStatement statement  = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		 statement.setLong(1, newEmpleado.getDni());
		 statement.setString(2, newEmpleado.getNombre());
		 statement.setString(3, newEmpleado.getApellido());
		 statement.setLong(4, newEmpleado.getDptoId());
		//3 -devuelve un entero devuelve 1 o 0, pero no hace falta confirmar para este caso 
		 statement.execute();
		 
		 ResultSet res = statement.getGeneratedKeys(); // RETORNA LA KEY QUE SE GENERO
		 if (res.next()) {
			 System.out.println("Se creo el empleado correctamente");
		 }
		 cerrar(connection);
	}
	@Override
	public List<Empleado> search(String clave) throws Exception {
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		//ver que no tire error si el dni es int en la tabla
		String sql = "SELECT * FROM empleados WHERE NOMBRE LIKE ? OR APELLIDO LIKE ? OR DNI LIKE ? OR DPTO_ID LIKE ?";
		PreparedStatement statement = connection.prepareStatement(sql);

		//setear el valor que va en remplazo del ?
		statement.setString(1, "%" + clave + "%");
		statement.setString(2, "%" + clave + "%");
		statement.setString(3, "%" + clave + "%");
		statement.setString(4, "%" + clave + "%");
		
		// 3 - resultset
		ResultSet resultSet = statement.executeQuery();

		// Interface i = new ClaseQueImplementaLaInterface();
		List<Empleado> empleados = new ArrayList<Empleado>();

		// verifico si hay datos
		while (resultSet.next()) {
			empleados.add(this.crearEmpleado(resultSet));
		}
		
		cerrar(connection);
		
		return empleados;
	}
	
	private void cerrar(Connection con) throws Exception{
		con.close();
	}
	
	private Empleado crearEmpleado(ResultSet resultSet) throws Exception {
		// obtengo el dato del campo dni
		Long dniBd = resultSet.getLong("dni");
		String nombreBd = resultSet.getString("nombre");
		String apellidoBd = resultSet.getString("apellido");
		Long dptoIdBd = resultSet.getLong("dpto_id");
		
		return new Empleado(dniBd, nombreBd, apellidoBd, dptoIdBd);
	}
}
