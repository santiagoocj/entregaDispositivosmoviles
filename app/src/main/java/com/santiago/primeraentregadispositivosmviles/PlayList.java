package com.santiago.primeraentregadispositivosmviles;

import android.content.ClipData;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.santiago.primeraentregadispositivosmviles.model.Artista;

public class PlayList extends AppCompatActivity {

    private Artista item;
    private TextView nombreArt;
    private TextView generoArt;
    private ImageView imagenArt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artista_music);

        item = (Artista) getIntent().getSerializableExtra("objetoData");

        nombreArt = (TextView) findViewById(R.id.nombre_art);
        generoArt = (TextView) findViewById(R.id.genero_art);
        imagenArt = (ImageView) findViewById(R.id.imagen_art);

        nombreArt.setText(item.getNombre());
        generoArt.setText(item.getGenero());
        imagenArt.setImageResource(item.getRecurso());

        /*public void playCerdo(View view) {
            playSound(R.raw.cerdo);
        }

        public void playGato(View view) {
            playSound( R.raw.gato);
        }

        private void playSound(int resource){
            MediaPlayer mediaPlayer = MediaPlayer.create(this,resource);
            mediaPlayer.start();
        }*/

    }
}
