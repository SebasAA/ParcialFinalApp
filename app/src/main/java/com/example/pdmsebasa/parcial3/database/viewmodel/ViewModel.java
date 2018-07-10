package com.example.pdmsebasa.parcial3.database.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.example.pdmsebasa.parcial3.database.repositories.ListaMaterialesRepo;
import com.example.pdmsebasa.parcial3.database.repositories.MaterialRepo;
import com.example.pdmsebasa.parcial3.database.repositories.ProductoRepo;

public class ViewModel extends AndroidViewModel {
    private MaterialRepo materialRepo;
    private ProductoRepo productoRepo;
    private ListaMaterialesRepo listaMaterialesRepo;

    public ViewModel(Application application) {
        super(application);
    }
}
