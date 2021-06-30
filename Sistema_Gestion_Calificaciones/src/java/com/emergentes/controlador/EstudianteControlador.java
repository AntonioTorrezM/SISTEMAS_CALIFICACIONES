package com.emergentes.controlador;

import com.emergentes.dao.EstudiantesDAOimpl;
import com.emergentes.modelo.Estudiantes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.EstudiantesDAO;


@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class EstudianteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Estudiantes usu = new Estudiantes();
            int id;
            EstudiantesDAO dao = new EstudiantesDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch(action){
                case "add":
                    request.setAttribute("usuario", usu);
                    request.getRequestDispatcher("frmestudiantes.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    usu =  dao.getById(id);
                    request.setAttribute("usuario", usu);
                    request.getRequestDispatcher("frmestudiantes.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("UsuarioControlador");
                    break;
                case "view":
                    // Obtener la lista de registros
                    List<Estudiantes> lista = dao.getAll();
                    request.setAttribute("estudiantes",lista);
                    request.getRequestDispatcher("estudiantes.jsp").forward(request, response);
                    break;
            }
            
        }catch(Exception ex){
            System.out.println("Error " + ex.getMessage());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String usuario = request.getParameter("usuario");
        String correo =  request.getParameter("correo");
        String ci = request.getParameter("ci");
        
        Estudiantes usu = new Estudiantes();
        
        usu.setId(id);
        usu.setEstudiante(usuario);
        usu.setCorreo(correo);
        usu.setCi(ci);
        
        EstudiantesDAO dao = new EstudiantesDAOimpl();
        if (id == 0){
            try {
                // Nuevo registro
                dao.insert(usu);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ex.getMessage());
            }
        }
        else{
            try {
                // Edicion de registro
                dao.update(usu);
            } catch (Exception ex) {
                System.out.println("Error al editar "+ex.getMessage());
            }
        }
        response.sendRedirect("UsuarioControlador");
    }

}
