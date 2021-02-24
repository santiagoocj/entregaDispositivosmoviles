package com.santiago.primeraentregadispositivosmviles.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.santiago.primeraentregadispositivosmviles.R;
import com.santiago.primeraentregadispositivosmviles.model.HojaDeVida;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HojaDeVidaAdapter extends BaseAdapter implements Filterable {

    private final LayoutInflater inflater;
    private List<HojaDeVida> hojasDeVidaIn;
    private List<HojaDeVida> hojasDeVidaOut;

    public HojaDeVidaAdapter(Context context, List<HojaDeVida> hojasDeVida){
        hojasDeVidaIn = hojasDeVida;
        hojasDeVidaOut = hojasDeVida;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return hojasDeVidaOut.size();
    }

    @Override
    public HojaDeVida getItem(int position) {
        return hojasDeVidaOut.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        //patron singleton
        if(convertView != null){
            viewHolder = (ViewHolder) convertView.getTag();
        }else{
            convertView = inflater.inflate(R.layout.hoja_vida_item, parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder.recurso.setImageResource(hojasDeVidaOut.get(position).getRecurso());
        viewHolder.nombre.setText(hojasDeVidaOut.get(position).getNombre());
        viewHolder.descripcion.setText(hojasDeVidaOut.get(position).getDescripcion());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                List<HojaDeVida> filteredArrList = new ArrayList<>();
                if(hojasDeVidaIn == null){
                    hojasDeVidaIn = new ArrayList<>(hojasDeVidaOut);
                }
                if(constraint == null){
                    results.count = hojasDeVidaIn.size();
                    results.values = hojasDeVidaIn;
                }else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i=0; i<hojasDeVidaIn.size(); i++){
                        String data = hojasDeVidaIn.get(i).getNombre();
                        if(data.toLowerCase().contains(constraint.toString())){
                            filteredArrList.add(hojasDeVidaIn.get(i));
                        }
                    }
                    results.count = filteredArrList.size();
                    results.values = filteredArrList;
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                hojasDeVidaOut = (List<HojaDeVida>) results.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }

    class ViewHolder{

        @BindView(R.id.img_hoja_vida)
        ImageView recurso;

        @BindView(R.id.lb_nombre)
        TextView nombre;

        @BindView(R.id.lb_descripcion)
        TextView descripcion;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
