package br.edu.fateczl.time.persistence;

import java.sql.SQLException;
import java.util.List;
/*
 *@author:<Gustavo de Paula>
 */
public interface ICRUDDao <T>{
    public void insert(T t) throws SQLException;

    public int update(T t) throws SQLException;

    public void delete(T t) throws SQLException;

    public T findOne(T t) throws SQLException;

    public List<T> findAll() throws SQLException;
}
