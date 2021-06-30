<%
    String opcion =  request.getParameter("opcion");
%>
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("usuarios") ?  "active" : "") %>" href="UsuarioControlador">ESTUDIANTES</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("roles") ?  "active" : "") %>" href="RolControlador">MATERIAS</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("permisos") ?  "active" : "") %>" href="PermisoControlador">CALIFICACIONES</a>
                </li>
            </ul>
