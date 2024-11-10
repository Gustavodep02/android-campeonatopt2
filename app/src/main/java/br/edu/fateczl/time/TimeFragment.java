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

/*
 *@author:<Gustavo de Paula>
 */
public class TimeFragment extends Fragment {

    private View view;

    private EditText etNomeTime, etCidadeTime, etCodigoTime;

    private Button btnBuscarTime, btnInserirTime, btnModificarTime, btnExcluirTime, btnListarTime;

    private TextView tvSaidaTime;

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
        return view;
    }
}