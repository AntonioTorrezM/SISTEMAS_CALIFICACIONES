<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" >
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

        <title>Permiso</title>
    </head>
    <body>
        <div class="container">
            <h1>Registro de Notas</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="permisos" />
            </jsp:include>
            <br>
            <form action="PermisoControlador" method="post" >
                <input type="hidden" name="id" value="${permiso.id}">
                <div class="form-group">
                    <label for="" class="form-label">Estudiante</label>
                    <select name="id_estudiante" class="form-control">
                        <option value="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_estudiantes}">
                            <option value="${item.id}" 
                                    <c:if test="${permiso.id_estudiante == item.id}">
                                        selected
                                    </c:if>
                                        >${item.estudiante}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Materia</label>
                    <select name="id_materia" class="form-control">
                        <option value="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_materias}">
                            <option value="${item.id}" <c:if test="${permiso.id_materia == item.id}">
                                        selected
                                    </c:if>>${item.materia}</option>
                        </c:forEach>
                    </select>
                </div>  
                <div class="form-group">
                    <label for="" class="form-label">Calificacion</label>
                    <input type="number" class="form-control" name="ci" value="${permiso.nota}" placeholder="Calificacion" min="1" max="100">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>

    </body>
</html>