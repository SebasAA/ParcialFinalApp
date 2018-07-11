package com.example.pdmsebasa.parcial3.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pdmsebasa.parcial3.R;
import com.example.pdmsebasa.parcial3.database.entities.Producto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {

    private List<Producto> list = new ArrayList<>();

    public ProductoAdapter(List<Producto> list){
        this.list = list;
    }

    /**
     * @param list Lista a mostrar en {@link RecyclerView}
     */
    public void setList(List<Producto> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.producto_item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Producto ProductoItem = list.get(position);
        String price_and_gain;
        Float gain = ProductoItem.getPrice()- ProductoItem.getCosto();
        price_and_gain = "$"+ ProductoItem.getPrice() + " - " + truncFloat(gain);
        holder.name.setText(ProductoItem.getName());
        holder.price.setText(price_and_gain);
        holder.quantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityOnClick(list.get(position));
            }
        });
        holder.less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lessOnClick(list.get(position));
            }
        });

        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moreOnClick(list.get(position));
            }
        });
    }

    protected abstract void moreOnClick(Producto producto);

    protected abstract void lessOnClick(Producto producto);

    public abstract void quantityOnClick(Producto producto);

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView less, more;
        private TextView name, price, quantity;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.venta_precio);
            price = itemView.findViewById(R.id.venta_nombre_cliente2);//change id later
            quantity = itemView.findViewById(R.id.textView2);
            less = itemView.findViewById(R.id.imageView2);
            more = itemView.findViewById(R.id.imageView3);

        }
    }

    public String truncFloat(Float number){
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(number);
    }
}
