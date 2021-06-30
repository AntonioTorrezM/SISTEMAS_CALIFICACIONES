package com.emergentes.controlador;

import com.emergentes.dao.MateriasDAOimpl;
import com.emergentes.modelo.Materias;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.MateriasDAO;

@WebServlet(name = "RolControlador", urlPatterns = {"/RolControlador"})
public class MateriaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Materias ro = new Materias();
            int id;
            MateriasDAO dao = new MateriasDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch(action){
                case "add":
                    request.setAttribute("rol", ro);
                    request.getRequestDispatcher("frmmaterias.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    ro =  dao.getById(id);
                    request.setAttribute("rol", ro);
                    request.getRequestDispatcher("frmmaterias.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("RolControlador");
                    break;
                case "view":
                    // Obtener la lista de registros
                    List<Materias> lista = dao.getAll();
                    request.setAttribute("materias",lista);
                    request.getRequestDispatcher("materias.jsp").forward(request, response);
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
        String materia = request.getParameter("materia");
        
        Materias ro = new Materias();
        ro.setId(id);
        ro.setMateria(materia);
        
        MateriasDAO dao = new MateriasDAOimpl();
        if (id == 0){
            try {
                // Nuevo registro
                dao.insert(ro);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ex.getMessage());
            }
        }
        else{
            try {
                // Edicion de registro
                dao.update(ro);
            } catch (Exception ex) {
                System.out.println("Error al editar "+ex.getMessage());
            }
        }
        response.sendRedirect("RolControlador");
    }
}
