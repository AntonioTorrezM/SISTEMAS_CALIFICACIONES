package com.emergentes.dao;

import com.emergentes.modelo.Notas;
import java.util.List;

public interface NotasDAO {
    
    public void insert(Notas permiso) throws Exception;
    public void update(Notas permiso) throws Exception;
    public void delete(int id) throws Exception;
    public Notas getById(int id) throws Exception;
    public List<Notas> getAll() throws Exception;
    
}
