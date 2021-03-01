package com.santiago.primeraentregadispositivosmviles.ui.artista;

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
import com.santiago.primeraentregadispositivosmviles.adapter.ArtistaAdapter;
import com.santiago.primeraentregadispositivosmviles.model.Artista;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtistaFragment extends Fragment {
    
    @BindView(R.id.list_view_artistas)
    ListView listViewArtistas;
    
    @BindView(R.id.et_buscar_artista)
    EditText editTextArtistas;

    ArtistaAdapter artistaAdapter;

    private List<Artista> artistas;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //forma minima para trabajar con un fragment
        View root = inflater.inflate(R.layout.fragment_artista, container, false);
        ButterKnife.bind(this, root);
        loadInformation();
        artistaAdapter = new ArtistaAdapter(getContext(), artistas);
        listViewArtistas.setAdapter(artistaAdapter);
        return root;
    }

    private void editTextWatcher(){
        editTextArtistas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                artistaAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void loadInformation() {
        artistas = new ArrayList<>();
        artistas.add(new Artista(R.drawable.ic_adele,"Adele","Pop"));
        artistas.add(new Artista(R.drawable.ic_bob_marley, "Bob Marley","Reguee"));
        artistas.add(new Artista(R.drawable.ic_maicol, "Michael Jackson","Pop"));
        artistas.add(new Artista(R.drawable.ic_shakira, "Shakira","Pop"));
        artistas.add(new Artista(R.drawable.ic_drake, "Drake","Rap"));
    }
}