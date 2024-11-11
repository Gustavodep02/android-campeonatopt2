package br.edu.fateczl.time.controller;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.time.model.Time;
import br.edu.fateczl.time.persistence.TimeDao;
/*
 *@author:<Gustavo de Paula>
 */
public class TimeController implements IController<Time>{

    private final TimeDao tDao;

    public TimeController(TimeDao tDao){
        this.tDao = tDao;
    }

    @Override
    public void inserir(Time t) throws SQLException {
        if(tDao.open()==null){
            tDao.open();
        }
        tDao.insert(t);
        tDao.close();
    }

    @Override
    public void modificar(Time t) throws SQLException{
        if(tDao.open()==null){
            tDao.open();
        }
        tDao.update(t);
        tDao.close();

    }

    @Override
    public void deletar(Time t) throws SQLException{
        if(tDao.open()==null){
            tDao.open();
        }
        tDao.delete(t);
        tDao.close();

    }

    @Override
    public Time buscar(Time t) throws SQLException {
        if (tDao.open() == null) {
            tDao.open();
        }
        return tDao.findOne(t);
    }
    @Override
    public List<Time> listar() throws SQLException{
        if(tDao.open() == null){
            tDao.open();
        }
        return tDao.findAll();
    }
}
