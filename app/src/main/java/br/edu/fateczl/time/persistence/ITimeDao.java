package br.edu.fateczl.time.persistence;

import java.sql.SQLException;
/*
 *@author:<Gustavo de Paula>
 */
public interface ITimeDao {
    public TimeDao open() throws SQLException;
    public void close();
}
