package br.edu.fateczl.time.controller;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.time.model.Jogador;
import br.edu.fateczl.time.persistence.JogadorDao;
/*
 *@author:<Gustavo de Paula>
 */
public class JogadorController implements IController<Jogador>{
    private final JogadorDao jDao;

    public JogadorController(JogadorDao jDao){
        this.jDao = jDao;
    }

    @Override
    public void inserir(Jogador t) throws SQLException {
        if(jDao.open()==null){
            jDao.open();
        }
        jDao.insert(t);
        jDao.close();
    }

    @Override
    public void modificar(Jogador t) throws SQLException{
        if(jDao.open()==null){
            jDao.open();
        }
        jDao.update(t);
        jDao.close();
    }

    @Override
    public void deletar(Jogador t) throws SQLException{
        if(jDao.open()==null){
            jDao.open();
        }
        jDao.delete(t);
        jDao.close();
    }

    @Override
    public Jogador buscar(Jogador t) throws SQLException{
        if (jDao.open() == null) {
            jDao.open();
        }
        return jDao.findOne(t);
    }

    @Override
    public List<Jogador> listar() throws SQLException{
        if(jDao.open() == null){
            jDao.open();
        }
        return jDao.findAll();
    }
}
