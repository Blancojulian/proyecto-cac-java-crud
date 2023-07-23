<%@page import="ar.com.codoacodo.domain.Empleado"%>
<%
	Empleado d = (Empleado)request.getAttribute("empleado"); // levanto el empleado que viene del controller
%>

<!Doctype html>
<html>
		<head>
		 <!-- Required meta tags -->
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Editar Empleado</title>
		 <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">  
	</head>
	<body>
	   <div class="container bg-light">
	   		<jsp:include page="navbarEmpleado.jsp"/>
	   </div>
		
		
		<main class="container mt-5">
			<h1>Editar Empleado</h1>
			
			<div class="row mt-5">
				<div class="col-12">
					<form class="row g-3 needs-validation" 
						action="<%=request.getContextPath()%>/UpdateEmpleadoController"
						method="POST">
					  <div class="col-md-8">
					  	<label for="validationCustom01" class="form-label">DNI</label>
					    <input type="text" 
					    name="dni"
					    class="form-control" 
					    id="validationCustom01" 
					    value="<%=d.getDni()%>"
					    required>					    
					  </div>
					  
					  <div class="col-md-8">
					    <label for="validationCustom02" class="form-label">NOMBRE</label>
					    <input type="text"
					    	name="nombre" 
					    	class="form-control" 
					    	id="validationCustom02"
					    	value="<%=d.getNombre()%>" 
					    	required>
					    <div class="valid-feedback">
					      Looks good!
					    </div>
					  </div>
					  
					  <div class="col-md-8">
					    <label for="validationCustom03" class="form-label">APELLIDO</label>
					    <input type="text"
					    	name="apellido" 
					    	class="form-control" 
					    	id="validationCustom03"
					    	value="<%=d.getApellido()%>" 
					    	required>
					    <div class="valid-feedback">
					      Looks good!
					    </div>
					  </div>
					  
					  <div class="col-md-8">
					    <label for="validationCustom04" class="form-label">DEPARTAMENTO</label>
					    <input type="text"
					    	name="dpto_id" 
					    	class="form-control" 
					    	id="validationCustom04"
					    	value="<%=d.getDptoId()%>" 
					    	required>
					    <div class="valid-feedback">
					      Looks good!
					    </div>
					  </div>
					 
					  <div class="col-12">
					    <button class="btn btn-primary" type="submit">Editar</button>
					    <a href="<%=request.getContextPath()%>/FindAllEmpleadoController" class="btn btn-secondary">Cancelar</a>
					  </div>
					</form>
				</div>
			</div>
		</main>
	</body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</html>