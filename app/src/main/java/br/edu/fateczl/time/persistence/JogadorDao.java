package br.edu.fateczl.time.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.time.model.Jogador;
import br.edu.fateczl.time.model.Time;

/*
 *@author:<Gustavo de Paula>
 */
public class JogadorDao implements IJogadorDao, ICRUDDao<Jogador>{

    private final Context context;

    private GenericDao gDao;

    private SQLiteDatabase database;


    public JogadorDao(Context context) {
        this.context = context;
    }

    @Override
    public JogadorDao open() throws SQLException {
        gDao = new GenericDao(context);
        database = gDao.getWritableDatabase();
        return this;
    }

    @Override
    public void close() {
        gDao.close();
    }

    @Override
    public void insert(Jogador jogador) throws SQLException {
        ContentValues contentValues = getContentValues(jogador);
        database.insert("jogador",null,contentValues);
    }

    @Override
    public int update(Jogador jogador) throws SQLException {
        ContentValues contentValues = getContentValues(jogador);
        int ret = database.update("jogador",contentValues,"id = "+jogador.getId(),null);
        return ret;
    }

    @Override
    public void delete(Jogador jogador) throws SQLException {
        database.delete("jogador","id = "+jogador.getId(),null);
    }

    @Override
    public Jogador findOne(Jogador jogador) throws SQLException {
        String sql = "Select t.codigo AS TimeCodigo, t.nome AS nome_time, t.cidade AS cid_time, j.id, j.nome, j.data_nasc, j.altura, j.peso FROM time t, jogador j WHERE t.codigo = j.TimeCodigo AND j.id = " + jogador.getId();        Cursor cursor = database.rawQuery(sql,null);

        if(cursor !=null){
            cursor.moveToFirst();
        }
        if(!cursor.isAfterLast()){
            Time time = new Time();
            time.setCodigo(cursor.getInt(cursor.getColumnIndex("TimeCodigo")));
            time.setNome(cursor.getString(cursor.getColumnIndex("nome_time")));
            time.setCidade(cursor.getString(cursor.getColumnIndex("cid_time")));

            jogador.setId(cursor.getInt(cursor.getColumnIndex("id")));
            jogador.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            jogador.setDataNasc(LocalDate.parse(cursor.getString(cursor.getColumnIndex("data_nasc"))));
            jogador.setAltura(cursor.getFloat(cursor.getColumnIndex("altura")));
            jogador.setPeso(cursor.getFloat(cursor.getColumnIndex("peso")));
            jogador.setTime(time);

        }
        cursor.close();
        return jogador;
    }

    @Override
    public List<Jogador> findAll() throws SQLException {
        List<Jogador> jogadores = new ArrayList<>();
        String sql = "Select t.codigo AS TimeCodigo, t.nome AS nome_time, t.cidade AS cid_time, j.id, j.nome, j.data_nasc, j.altura, j.peso FROM time t, jogador j WHERE t.codigo = j.TimeCodigo";        Cursor cursor = database.rawQuery(sql,null);
        if(cursor !=null){
            cursor.moveToFirst();
        }
        while(!cursor.isAfterLast()){
            Jogador jogador = new Jogador();
            Time time = new Time();
            time.setCodigo(cursor.getInt(cursor.getColumnIndex("TimeCodigo")));
            time.setNome(cursor.getString(cursor.getColumnIndex("nome_time")));
            time.setCidade(cursor.getString(cursor.getColumnIndex("cid_time")));

            jogador.setId(cursor.getInt(cursor.getColumnIndex("id")));
            jogador.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            jogador.setDataNasc(LocalDate.parse(cursor.getString(cursor.getColumnIndex("data_nasc"))));
            jogador.setAltura(cursor.getFloat(cursor.getColumnIndex("altura")));
            jogador.setPeso(cursor.getFloat(cursor.getColumnIndex("peso")));
            jogador.setTime(time);

            jogadores.add(jogador);
            cursor.moveToNext();

        }
        cursor.close();
        return jogadores;
    }

    private static ContentValues getContentValues(Jogador jogador){
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", jogador.getId());
        contentValues.put("nome", jogador.getNome());
        contentValues.put("data_nasc", jogador.getDataNasc().toString());
        contentValues.put("altura", jogador.getAltura());
        contentValues.put("peso", jogador.getPeso());
        contentValues.put("TimeCodigo", jogador.getTime().getCodigo());

        return contentValues;
    }
}
