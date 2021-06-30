package com.emergentes.dao;

import com.emergentes.modelo.Notas;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NotasDAOimpl extends ConexionBD implements NotasDAO{

    @Override
    public void insert(Notas permiso) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO notas (id_estudiante, id_materia, nota) values (?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, permiso.getId_estudiante());
            ps.setInt(2, permiso.getId_materia());
            ps.setInt(2, permiso.getNota());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Notas permiso) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE notas SET id_estudiante = ?, id_materia = ? , nota = ? WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, permiso.getId_estudiante());
            ps.setInt(2, permiso.getId_materia());
            ps.setInt(3, permiso.getNota());
            ps.setInt(4, permiso.getId());
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
            String sql = "DELETE FROM notas WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Notas getById(int id) throws Exception {
        Notas p = new Notas();
        try {
            this.conectar();
            String sql = "SELECT * FROM notas WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setId_estudiante(rs.getInt("id_estudiante"));
                p.setId_materia(rs.getInt("id_materia"));
                p.setNota(rs.getInt("nota"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return p;
    }

    @Override
    public List<Notas> getAll() throws Exception {
        List<Notas> lista = null;
        try {
            this.conectar();
            String sql = "SELECT v.*,p.estudiante as estudiantes, c.materia as materias FROM notas v ";
            sql += "LEFT JOIN estudiantes p ON v.id_estudiante = p.id ";
            sql += "LEFT JOIN materias c ON v.id_materia = c.id";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Notas>();
            while (rs.next()) {
                Notas v = new Notas();
                v.setId(rs.getInt("id"));
                v.setId_estudiante(rs.getInt("id_estudiante"));
                v.setId_materia(rs.getInt("id_materia"));
                v.setEstudiante(rs.getString("estudiantes"));
                v.setMateria(rs.getString("materias"));
                lista.add(v);
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
