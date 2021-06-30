package com.emergentes.controlador;

import com.emergentes.dao.NotasDAOimpl;
import com.emergentes.dao.MateriasDAOimpl;
import com.emergentes.dao.EstudiantesDAOimpl;
import com.emergentes.modelo.Notas;
import com.emergentes.modelo.Materias;
import com.emergentes.modelo.Estudiantes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.NotasDAO;
import com.emergentes.dao.MateriasDAO;
import com.emergentes.dao.EstudiantesDAO;

@WebServlet(name = "PermisoControlador", urlPatterns = {"/PermisoControlador"})
public class NotaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            NotasDAO dao = new NotasDAOimpl();
            EstudiantesDAO daoUsuario = new EstudiantesDAOimpl();
            MateriasDAO daoRol = new MateriasDAOimpl();
            int id;
            int notas = 0;
            
            List<Estudiantes> lista_estudiantes = null;
            List<Materias> lista_materias = null;
            
            Notas per = new Notas();
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            System.out.println("Opcion = "+ action);
            switch(action){
                case "add":
                    lista_estudiantes = daoUsuario.getAll();
                    lista_materias = daoRol.getAll();
                    request.setAttribute("lista_estudiantes", lista_estudiantes);
                    request.setAttribute("lista_materias", lista_materias);
                    request.setAttribute("lista_notas", notas);
                    request.setAttribute("nota",per);
                    request.getRequestDispatcher("frmnotas.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    per = dao.getById(id);
                    lista_estudiantes = daoUsuario.getAll();
                    lista_materias = daoRol.getAll();
                    request.setAttribute("lista_estudiantes", lista_estudiantes);
                    request.setAttribute("lista_materias", lista_materias);
                    request.setAttribute("lista_notas", notas);
                    request.setAttribute("nota",per);
                    request.getRequestDispatcher("frmnotas.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("PermisoControlador");
                    break;
                case "view":
                    List<Notas> lista = dao.getAll();
                    request.setAttribute("notas", lista);
                    request.getRequestDispatcher("notas.jsp").forward(request, response);
                    break;
            }
        }catch(Exception ex){
            System.out.println("Error fatal " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        int id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
        int id_materia = Integer.parseInt(request.getParameter("id_materia"));
        int nota = Integer.parseInt(request.getParameter("nota"));
        
        Notas per = new Notas();
        
        per.setId(id);
        per.setId_estudiante(id_estudiante);
        per.setId_materia(id_materia);
        per.setNota(nota);
        
        if(id == 0){
            // Nuevo
            NotasDAO dao = new NotasDAOimpl();
            try {
                dao.insert(per);
                response.sendRedirect("PermisoControlador");
            } catch (Exception ex) {
                Logger.getLogger(NotaControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            //Editar
            NotasDAO dao = new NotasDAOimpl();
            try {
                dao.update(per);
                response.sendRedirect("PermisoControlador");
            } catch (Exception ex) {
                Logger.getLogger(NotaControlador.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }
    }
}
    
