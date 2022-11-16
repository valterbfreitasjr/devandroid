package com.empresalogistica.jogoprapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastrarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastrarFragment extends Fragment {

    Button mBotaoJogar;
    Button mBotaoCadastrar;
    EditText mEditTextPerg;
    EditText mEditTextResp;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CadastrarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadastrarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastrarFragment newInstance(String param1, String param2) {
        CadastrarFragment fragment = new CadastrarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastrar, container, false);
    }


    //A aplicação irá chamar o método sempre que o fragmento for inserido na tela e inicializado.
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Por estarmos em um fragmento, passaremos primeiro pelo 'getActivity' para então o findView...
        mBotaoJogar = getActivity().findViewById(R.id.botaoJogar);
        mBotaoCadastrar = getActivity().findViewById(R.id.botaoCadastrar);
        mEditTextPerg = getActivity().findViewById(R.id.editPergunta);
        mEditTextResp = getActivity().findViewById(R.id.editResposta);

        mBotaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, new JogarFragment()).commit();
            }
        });

        mBotaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pergunta = mEditTextPerg.getText().toString();
                String resposta = mEditTextResp.getText().toString();

                if(!pergunta.isEmpty() && !resposta.isEmpty()){

                    Questoes questoes = new Questoes(pergunta, resposta);

                    BancoDeDados.getBancoDeDados(getActivity()).meuDAO().inserirQuestoes(questoes);

                    mEditTextPerg.setText("");
                    mEditTextResp.setText("");

                    Toast.makeText(getActivity(), "Inserido com sucesso!", Toast.LENGTH_SHORT);
                }
            }
        });
    }
}