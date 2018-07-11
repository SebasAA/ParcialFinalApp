package com.example.pdmsebasa.parcial3.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pdmsebasa.parcial3.R;
import com.example.pdmsebasa.parcial3.database.entities.Material;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MaterialAdapter extends RecyclerView.Adapter<MaterialAdapter.ViewHolder> {

    private List<Material> list = new ArrayList<>();

    public MaterialAdapter(List<Material> list) {
        this.list = list;
    }

    //TODO: AUN NO EXISTE EL LAYOUT PARA ESTE ITEM DE MATERIAL
    /**
     * @param list Lista a mostrar en {@link RecyclerView}
     */
    public void setList(List<Material> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.generic_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Material MaterialItem = list.get(position);
        String price_and_gain;
        price_and_gain = "$" + MaterialItem.getCosto();
        holder.name.setText(MaterialItem.getName());
        holder.price.setText(price_and_gain);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public String truncFloat(Float number) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(number);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, price;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.generic_cardview_textView);
            price = itemView.findViewById(R.id.generic_cardview_textView);//change id later


        }
    }
}
