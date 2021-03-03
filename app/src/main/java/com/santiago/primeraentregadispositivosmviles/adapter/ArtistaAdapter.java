package com.santiago.primeraentregadispositivosmviles.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.santiago.primeraentregadispositivosmviles.PlayList;
import com.santiago.primeraentregadispositivosmviles.R;
import com.santiago.primeraentregadispositivosmviles.model.Artista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtistaAdapter extends BaseAdapter implements Filterable {

    private final LayoutInflater inflater;
    private List<Artista> artistasIn;
    private List<Artista> artistasOut;
    private Context contexto;

    public ArtistaAdapter(Context contexto, List<Artista> artistaList) {
        this.contexto=contexto;
        artistasIn = artistaList;
        artistasOut = artistaList;
        inflater = LayoutInflater.from(contexto);
    }

    @Override
    public int getCount() {
        return artistasOut.size();
    }

    @Override
    public Object getItem(int position) {
        return artistasOut.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Artista item=(Artista) getItem(position);
        ViewHolder viewHolder;
        if(convertView != null){
            viewHolder = (ViewHolder) convertView.getTag();
        }else {
            convertView = inflater.inflate(R.layout.artista_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
            viewHolder.imagen.setImageResource(artistasOut.get(position).getRecurso());
            viewHolder.nombre.setText(artistasOut.get(position).getNombre());
            viewHolder.genero.setText(artistasOut.get(position).getGenero());
        }
        viewHolder.imagen.setImageResource(artistasOut.get(position).getRecurso());
        viewHolder.nombre.setText(artistasOut.get(position).getNombre());
        viewHolder.genero.setText(artistasOut.get(position).getGenero());


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(contexto,PlayList.class);
                intent.putExtra("objetoData",item);
                contexto.startActivity(intent); }
        });

        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                List<Artista> filteredArrList = new ArrayList<>();
                if(artistasIn == null){
                    artistasIn = new ArrayList<>(artistasOut);
                }
                if (constraint == null){
                    results.count = artistasIn.size();
                    results.values = artistasIn;
                }
                else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i=0; i<artistasIn.size(); i++){
                        String data = artistasIn.get(i).getNombre();
                        if(data.toLowerCase().contains(constraint.toString())){
                            filteredArrList.add(artistasIn.get(i));
                        }
                    }
                    results.count = filteredArrList.size();
                    results.values = filteredArrList;
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                artistasOut = (List<Artista>) results.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }

    //biding de los elementos graficos del layout artista_item
    class ViewHolder{

        @BindView(R.id.img_artistas)
        ImageView imagen;

        @BindView(R.id.lb_nombre_artistas_item)
        TextView nombre;

        @BindView(R.id.lb_genero_artistas)
        TextView genero;

        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
}
