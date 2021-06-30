package com.emergentes.dao;

import com.emergentes.modelo.Materias;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MateriasDAOimpl extends ConexionBD implements MateriasDAO{

    @Override
    public void insert(Materias rol) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO materias (materia) values (?)");
            ps.setString(1, rol.getMateria());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Materias rol) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE materias SET materia = ? where id = ?");
            ps.setString(1, rol.getMateria());
            ps.setInt(2, rol.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM materias WHERE id = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Materias getById(int id) throws Exception {
               Materias ro = new Materias();
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM materias WHERE id = ?");
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                ro.setId(rs.getInt("id"));
                ro.setMateria(rs.getString("materia"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return ro;
    }

    @Override
    public List<Materias> getAll() throws Exception {
        List<Materias> lista = null;
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM materias");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Materias>();
            while (rs.next()){
                Materias ro =  new Materias();
                
                ro.setId(rs.getInt("id"));
                ro.setMateria(rs.getString("materia"));
                
                lista.add(ro);
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
