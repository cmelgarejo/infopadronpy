package com.infopadronpy.activities;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.infopadronpy.R;
import com.infopadronpy.entities.Afiliation;

import java.util.List;

/**
 * Created by Gabriel on 24/07/2015.
 */
public class ListAdapter  extends BaseAdapter {
    private Context _context;
    private List<Afiliation> _listData; // header titles

    ViewHolder holder = null;
    Afiliation data= new Afiliation();

    public ListAdapter(Context context, List<Afiliation> listData ) {
        this._context = context;
        this._listData=listData;
    }



    public int getCount() {
        return _listData.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        data= _listData.get(position);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();
            holder.txtpartido = (TextView) convertView.findViewById(R.id.txt_partido);
            holder.txtci=(TextView) convertView.findViewById(R.id.txt_ci);
            holder.txtlugar = (TextView) convertView.findViewById(R.id.txt_lugar);
            holder.txtmesa = (TextView) convertView.findViewById(R.id.txt_mesa);
            holder.txtorden = (TextView) convertView.findViewById(R.id.txt_orden);
            holder.txtnombre = (TextView) convertView.findViewById(R.id.txt_nombre);
            holder.thumbnail = (LinearLayout) convertView.findViewById(R.id.thumbnail);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtpartido.setText("Partido: "+data.getPartido());
        holder.txtnombre.setText("Nombre: "+data.getNombre_completo());
        holder.txtci.setText("Cedula: "+data.getCi());
        holder.txtlugar.setText("Lugar de Votación: "+data.getLugar_votacion());
        holder.txtmesa.setText("Mesa: "+data.getMesa());
        holder.txtorden.setText("Orden: "+data.getOrden());
        switch (data.getPartido()) {
            case "ANR":
                holder.thumbnail.setBackgroundColor(Color.RED);
            break;
            case "PLRA":
                holder.thumbnail.setBackgroundColor(Color.BLUE);
                break;
            default:
                holder.thumbnail.setBackgroundColor(Color.GRAY);
                break;
        }
        return convertView;
    }

    static class ViewHolder {
        TextView  txtpartido;
        TextView txtci;
        TextView txtlugar;
         TextView txtmesa;
        TextView txtorden;
        TextView txtnombre;
        LinearLayout thumbnail;
    }
}