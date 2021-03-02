package com.santiago.primeraentregadispositivosmviles.ui.hojaDeVida;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.santiago.primeraentregadispositivosmviles.R;
import com.santiago.primeraentregadispositivosmviles.adapter.HojaDeVidaAdapter;
import com.santiago.primeraentregadispositivosmviles.model.HojaDeVida;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HojaDeVidaFragment extends Fragment {

    @BindView(R.id.lv_hoja_de_vida)
    ListView listViewHojaDeVida;

    @BindView(R.id.edit_text_hoja_de_vida)
    EditText editTextHojaVida;

    HojaDeVidaAdapter hojaDeVidaAdapter;

    private List<HojaDeVida> hojasDeVida;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hoja_vida, container, false);
        ButterKnife.bind(this,root);
        loadInformation();
        hojaDeVidaAdapter = new HojaDeVidaAdapter(getContext(), hojasDeVida);
        listViewHojaDeVida.setAdapter(hojaDeVidaAdapter);
        editTextWatcher();
        return root;
    }

    private void editTextWatcher(){
        editTextHojaVida.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    hojaDeVidaAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void loadInformation() {
        hojasDeVida = new ArrayList<>();
        hojasDeVida.add(new HojaDeVida(R.drawable.santiago, "Santiago Ocampo Jimenez","una persona positiva, le gusta hacer ejercício, la programación y uno de sus principales hobbits son las motos."));
        hojasDeVida.add(new HojaDeVida(R.drawable.camilo, "Camilo Ramirez Montoya","una persona creativa, apasionada y dispuesta a asumir retos que me ayuden a crecer continuamente tanto en el ámbito personal como en el técnico.."));
    }
}