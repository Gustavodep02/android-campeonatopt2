package br.edu.fateczl.time.persistence;

import java.sql.SQLException;
/*
 *@author:<Gustavo de Paula>
 */
public interface IJogadorDao {
    public JogadorDao open() throws SQLException;

    public void close();
}