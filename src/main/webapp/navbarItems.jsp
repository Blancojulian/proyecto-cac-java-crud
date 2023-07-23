<ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/index.jsp">Inicio</a>
        </li>
        
        <li class="nav-item dropdown">
		  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Listado</a>
		  <ul class="dropdown-menu">
		    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/FindAllDepartamentoController">Departamentos</a></li>
		    <li><hr class="dropdown-divider"></li>
		    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/FindAllEmpleadoController">Empleados</a></li>
		  </ul>
		</li>
		
		<li class="nav-item dropdown">
		  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Nuevo</a>
		  <ul class="dropdown-menu">
		    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/nuevoDepartamento.jsp">Nuevo Departamento</a></li>
		    <li><hr class="dropdown-divider"></li>		    
		    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/nuevoEmpleado.jsp">Nuevo Empleado</a></li>
		  </ul>
		</li>
       
</ul>