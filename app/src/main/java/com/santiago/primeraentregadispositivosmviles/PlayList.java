package com.santiago.primeraentregadispositivosmviles;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.santiago.primeraentregadispositivosmviles.model.Artista;

public class PlayList extends AppCompatActivity {

    private Artista item;
    private TextView lb_nombre_artistas_item;
    private TextView lb_genero_artistas;
    private ImageView img_artistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artista_item);

        item= (Artista) getIntent().getSerializableExtra("objetoData");

        lb_nombre_artistas_item=(TextView) findViewById(R.id.lb_nombre_artistas_item);
        lb_genero_artistas=(TextView) findViewById(R.id.lb_genero_artistas);
        img_artistas=(ImageView) findViewById(R.id.img_artistas);

        lb_nombre_artistas_item.setText(item.getNombre());
        lb_genero_artistas.setText(item.getNombre());
        img_artistas.setImageResource(item.getRecurso());


    }
}
