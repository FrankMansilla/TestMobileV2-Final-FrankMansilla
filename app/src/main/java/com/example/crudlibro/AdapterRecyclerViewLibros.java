package com.example.crudlibro;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudlibro.controladores.SelectListener;
import com.example.crudlibro.modelos.Libro;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterRecyclerViewLibros extends RecyclerView.Adapter<AdapterRecyclerViewLibros.ViewHoderDatos> {

    List<Libro> listDatos;
    private SelectListener selectListener;
    private Context context;

    public AdapterRecyclerViewLibros(Context context, List<Libro> listDatos, SelectListener selectListener) {
        this.context = context;
        this.listDatos = listDatos;
        this.selectListener = selectListener;
    }

    @NotNull
    @Override
    public ViewHoderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,null,false);
        return new ViewHoderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoderDatos holder, int position) {
        holder.asignarDatos(listDatos.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    Libro l = listDatos.get(adapterPosition);
                    selectListener.onItemClick(String.valueOf(l.getId()));
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHoderDatos extends RecyclerView.ViewHolder {

        TextView datoTitulo, datoSubtitulo;

        public ViewHoderDatos(@NonNull View itemView) {
            super(itemView);
            datoTitulo = (TextView) itemView.findViewById(R.id.item_list_titulo);
            datoSubtitulo = (TextView) itemView.findViewById(R.id.item_list_subtitulo);
        }

        public void asignarDatos(Libro libro){
            this.datoTitulo.setText(libro.getTitulo());
            this.datoSubtitulo.setText(libro.getSubtitlo());
        }

    }
}
