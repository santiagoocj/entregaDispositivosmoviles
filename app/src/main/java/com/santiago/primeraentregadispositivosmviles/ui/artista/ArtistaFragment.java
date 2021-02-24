package com.santiago.primeraentregadispositivosmviles.ui.artista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.santiago.primeraentregadispositivosmviles.R;

public class ArtistaFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //forma minima para trabajar con un fragment
        View root = inflater.inflate(R.layout.fragment_artista, container, false);
        return root;
    }
}