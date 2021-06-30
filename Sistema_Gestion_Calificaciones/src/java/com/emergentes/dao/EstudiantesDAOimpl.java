package com.emergentes.dao;

import com.emergentes.modelo.Estudiantes;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudiantesDAOimpl extends ConexionBD implements EstudiantesDAO {

    @Override
    public void insert(Estudiantes usuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO estudiantes (estudiante,correo,ci) values (?,?,?)");
            ps.setString(1, usuario.getEstudiante());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getCi());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Estudiantes usuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE estudiantes SET estudiante = ?, correo = ?, ci = ? where id = ?");
            ps.setString(1, usuario.getEstudiante());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getCi());
            ps.setInt(4, usuario.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM estudiantes WHERE id = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Estudiantes getById(int id) throws Exception {
        Estudiantes usu = new Estudiantes();
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM estudiantes WHERE id = ?");
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                usu.setId(rs.getInt("id"));
                usu.setEstudiante(rs.getString("estudiante"));
                usu.setCorreo(rs.getString("correo"));
                usu.setCi(rs.getString("ci"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return usu;
    }

    @Override
    public List<Estudiantes> getAll() throws Exception {
        List<Estudiantes> lista = null;
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM estudiantes");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Estudiantes>();
            while (rs.next()){
                Estudiantes usu =  new Estudiantes();
                
                usu.setId(rs.getInt("id"));
                usu.setEstudiante(rs.getString("estudiante"));
                usu.setCorreo(rs.getString("correo"));
                usu.setCi(rs.getString("ci"));
                
                lista.add(usu);
            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}
