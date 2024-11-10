package br.edu.fateczl.time;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/*
 *@author:<Gustavo de Paula>
 */
public class JogadorFragment extends Fragment {

    private View view;

    private EditText etNomeJogador, etDataNascJogador, etAlturaJogador, etPesoJogador;

    private Spinner spTimeJogador;

    private Button btnBuscarJogador, btnInserirJogador, btnModificarJogador, btnExcluirJogador, btnListarJogador;

    private TextView tvSaidaJogador;

    public JogadorFragment() {
        super();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_jogador, container, false);
        etNomeJogador = view.findViewById(R.id.etNomeJogador);
        etDataNascJogador = view.findViewById(R.id.etDataNascJogador);
        etAlturaJogador = view.findViewById(R.id.etAlturaJogador);
        etPesoJogador = view.findViewById(R.id.etPesoJogador);
        spTimeJogador = view.findViewById(R.id.spTimeJogador);
        btnBuscarJogador = view.findViewById(R.id.btnBuscarJogador);
        btnInserirJogador = view.findViewById(R.id.btnInserirJogador);
        btnModificarJogador = view.findViewById(R.id.btnModificarJogador);
        btnExcluirJogador = view.findViewById(R.id.btnExcluirJogador);
        btnListarJogador = view.findViewById(R.id.btnListarJogador);
        tvSaidaJogador = view.findViewById(R.id.tvSaidaJogador);
        tvSaidaJogador.setMovementMethod(new ScrollingMovementMethod());
        return view;
    }
}