package com.example.diego.logindiegohuanaco.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.diego.logindiegohuanaco.models.Empleados;
import com.example.diego.logindiegohuanaco.R;
import com.example.diego.logindiegohuanaco.models.Empleados;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<Empleados> list;
    private int layout;
    private Context context;

    public MyAdapter(List<Empleados> list, int layout, Context context) {
        this.list = list;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Empleados getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new ViewHolder();
            vh.rut = (TextView) convertView.findViewById(R.id.textViewRut);
            vh.nombre = (TextView) convertView.findViewById(R.id.textViewNombre);
            vh.edad = (TextView) convertView.findViewById(R.id.textViewEdad);
            vh.direccion = (TextView) convertView.findViewById(R.id.textViewDireccion);
            vh.sueldo = (TextView) convertView.findViewById(R.id.textViewSueldo);
            vh.cargo = (TextView) convertView.findViewById(R.id.textViewCargo);
            vh.id = (TextView) convertView.findViewById(R.id.textViewId);

            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Empleados p = list.get(position);
        //vh.id.setText(p.getId() + "");
        //vh.empleado.setText(p.getRut() + "\n" + p.getNombre()  + "\n" + p.getEdad() + "\n"  );

        return convertView;
    }
    public class ViewHolder {
        TextView id;
        TextView rut;
        TextView nombre;
        TextView edad;
        TextView direccion;
       TextView sueldo;
        TextView cargo;


    }
}