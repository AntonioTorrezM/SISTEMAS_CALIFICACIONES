package com.emergentes.dao;

import com.emergentes.modelo.Materias;
import java.util.List;

public interface MateriasDAO {
    
    public void insert(Materias rol) throws Exception;
    public void update(Materias rol) throws Exception;
    public void delete(int id) throws Exception;
    public Materias getById(int id) throws Exception;
    public List<Materias> getAll() throws Exception;
    
}
