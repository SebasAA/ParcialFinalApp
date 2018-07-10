package com.example.pdmsebasa.parcial3.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pdmsebasa.parcial3.R;
import com.example.pdmsebasa.parcial3.adapters.Adapter;
import com.example.pdmsebasa.parcial3.adapters.ProductoAdapter;
import com.example.pdmsebasa.parcial3.database.entities.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductListFragment extends Fragment{

    private List<Producto> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.generic_list_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.generic_list_fragment_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ProductoAdapter adapter = new ProductoAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        return view;
    }
}
