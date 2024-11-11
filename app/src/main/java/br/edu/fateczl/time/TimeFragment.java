package br.edu.fateczl.time;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.time.controller.TimeController;
import br.edu.fateczl.time.model.Time;
import br.edu.fateczl.time.persistence.TimeDao;

/*
 *@author:<Gustavo de Paula>
 */
public class TimeFragment extends Fragment {

    private View view;

    private EditText etNomeTime, etCidadeTime, etCodigoTime;

    private Button btnBuscarTime, btnInserirTime, btnModificarTime, btnExcluirTime, btnListarTime;

    private TextView tvSaidaTime;

    private TimeController tCont;

    public TimeFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_time, container, false);

        etNomeTime = view.findViewById(R.id.etNomeTime);
        etCidadeTime = view.findViewById(R.id.etCidadeTime);
        etCodigoTime = view.findViewById(R.id.etCodigoTime);
        btnBuscarTime = view.findViewById(R.id.btnBuscarTime);
        btnInserirTime = view.findViewById(R.id.btnInserirTime);
        btnModificarTime = view.findViewById(R.id.btnModificarTime);
        btnExcluirTime = view.findViewById(R.id.btnExcluirTime);
        btnListarTime = view.findViewById(R.id.btnListarTime);
        tvSaidaTime = view.findViewById(R.id.tvSaidaTime);
        tvSaidaTime.setMovementMethod(new ScrollingMovementMethod());

        tCont = new TimeController(new TimeDao(view.getContext()));

        btnInserirTime.setOnClickListener(op -> acaoInserir());
        btnModificarTime.setOnClickListener(op -> acaoModificar());
        btnExcluirTime.setOnClickListener(op -> acaoExcluir());
        btnBuscarTime.setOnClickListener(op -> acaoBuscar());
        btnListarTime.setOnClickListener(op -> acaoListar());

        return view;
    }

    private void acaoInserir() {
        Time t = montaTime();
        try {
            tCont.inserir(t);
            Toast.makeText(view.getContext(), "Time inserido com sucesso", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        limpaCampos();
    }

    private void acaoModificar() {
        Time t = montaTime();
        try {
            tCont.modificar(t);
            Toast.makeText(view.getContext(), "Time atualizado com sucesso", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        limpaCampos();
    }

    private void acaoExcluir() {
        Time t = montaTime();
        try {
            tCont.deletar(t);
            Toast.makeText(view.getContext(), "Time excluido com sucesso", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        limpaCampos();
    }

    private void acaoBuscar() {
        Time t = montaTime();
        try {
            t = tCont.buscar(t);
            if(t.getNome()!= null){
                preencheCampos(t);
            }else{
                Toast.makeText(view.getContext(), "Time não encontrado", Toast.LENGTH_LONG).show();
                limpaCampos();
            }
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void acaoListar() {
        try{
            List<Time> times = tCont.listar();
            StringBuffer buffer = new StringBuffer();
            for(Time t:times){
                buffer.append(t.toString()+"\n");
            }
            tvSaidaTime.setText(buffer.toString());
            }catch(SQLException e){
                Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
    }

    private Time montaTime(){
        Time t = new Time();
        t.setCodigo(Integer.parseInt(etCodigoTime.getText().toString()));
        t.setNome(etNomeTime.getText().toString());
        t.setCidade(etCidadeTime.getText().toString());

        return t;
    }

    private void preencheCampos(Time t){
        etCodigoTime.setText(String.valueOf(t.getCodigo()));
        etNomeTime.setText(t.getNome());
        etCidadeTime.setText(t.getCidade());
    }

    private void limpaCampos(){
        etCodigoTime.setText("");
        etNomeTime.setText("");
        etCidadeTime.setText("");
    }

}