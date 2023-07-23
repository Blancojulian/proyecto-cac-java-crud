<%@page import="ar.com.codoacodo.domain.Empleado"%>
<%@page import="java.util.List"%>
<!doctype html>
<html lang="es">
 <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--animated-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    <!--logos-->
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <title>Empleados</title>
  </head>
	
	<body>
		<!-- ACA VA EL NAVBAR  include file="navbar.jsp" %> -->
		<div class="container bg-light">
		 <!-- aca va el navbar.jsp -->
		 <jsp:include page="navbarEmpleado.jsp"/>
		</div>
		
		<main>			
			<div class="container bg-light mt-5">
				<section>
					<h1>Listado de empleados</h1>
					<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">DNI</th>
					      <th scope="col">NOMBRE</th>
					      <th scope="col">APELLIDO</th>
					      <th scope="col">DPTO_ID</th>					      
					      <th scope="col">ACCIONES</th>
					   
					    </tr>
					  </thead>
					  <% 
					  	//codigo java
					  	//obtener el listado desde el request
					  	//se guardo bajo el nombre de "empleado"
					  	List<Empleado> listado = (List<Empleado>)request.getAttribute("listado");
					  %>
					  <tbody>
					   <!-- ESTO SE REPITE TANTA CANDTIDAD DE VECES COMO ARTICULOS TENGA -->
					   <%
					   	for( Empleado  unDni : listado) {
					   %>
					    <tr>
						      <th scope="row"> <%=unDni.getDni()%> </th>
						      <td><%=unDni.getNombre() %></td>
						      <td><%=unDni.getApellido() %></td>
						      <td><%=unDni.getDptoId() %></td>
						   
						      <td>
						      	
							      	<a class="btn btn-secondary" 
							      	   role="button" 
							      	   href="<%=request.getContextPath()%>/UpdateEmpleadoController?dni=<%=unDni.getDni()%>">
							      	   Editar
							      	</a> | 
						      		<!-- Button trigger modal -->
									<button type="button" class="btn btn-danger" 
										data-bs-toggle="modal" 
										data-bs-target="#exampleModal" 
										onclick="setEmpleadoDni(<%=unDni.getDni()%>)">
									  Eliminar
									</button>
							  </td>
					    
					    </tr>
					   <%
					   	}
					   %>
					  </tbody>
					</table>
				</section>
			</div>
		</main>
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		    	<form action="<%=request.getContextPath()%>/DeleteEmpleadoController">
		    	  <input type="hidden" name="dni" id="dni">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Eliminar Empleado</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        ¿Confirma que desea eliminar? 
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
			        <button type="submit" class="btn btn-danger">Eliminar</button>
			      </div>
		    	</form>
		    </div>
		  </div>
		</div>
	</body>	
	  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

	  <script>
			function setEmpleadoDni(dni) {
				document.getElementById('dni').value=dni;
			}
			
	  </script>
</html>