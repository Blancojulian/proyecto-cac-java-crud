package ar.com.codoacodo.dao;

import java.util.List;

public interface IDAO<T extends Object> {

	// select * from departamentos where id = id;
			public T getById(Long id) throws Exception; // devuelve de un id todos los campos 
			
			// cambiamos el array por una lista de java 
			// select * from departamentos;
			public List<T> findAll() throws Exception;	// devuelve todos los registros de la tabla departamentos
			
			
			// delete from departamentos where id = id;
			public void delete(Long id) throws Exception;// esto borra un registro por el id del departamento
			
			
			//update departamentos set nombre = nombre, presupuesto = presupuesto where id = depto.id;
			public void update(T datos) throws Exception; // se le pasa un objeto 
			
			// insert to departamentos (campo 1..campo2..campo3) values(newDepto.campo1....newDepto.campoN)
			public void create(T newDatos) throws Exception;
			
			//select * from departamentos where titulo like '%clave%' 
		    public List<T> search(String clave) throws Exception;
}
