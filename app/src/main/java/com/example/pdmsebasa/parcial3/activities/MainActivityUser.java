package com.example.pdmsebasa.parcial3.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pdmsebasa.parcial3.R;
import com.example.pdmsebasa.parcial3.fragments.HomeFragment;
import com.example.pdmsebasa.parcial3.fragments.ProductListFragment;
import com.example.pdmsebasa.parcial3.fragments.ProductListUserFragment;

public class MainActivityUser extends AppCompatActivity{

    private DrawerLayout drawerLayout;
    private Boolean isFirstEntry = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState != null){
            if (savedInstanceState.containsKey("FIRST")){
                isFirstEntry = savedInstanceState.getBoolean("FIRST");
            }
        }

        setupToolbar();
        setupDrawer();
    }

    private void setupToolbar(){
        Toolbar toolbar = findViewById(R.id.appsbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
    }

    private void setupDrawer(){
        drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.drawer_menu_user);

        if (isFirstEntry) {
            navigationView.setCheckedItem(R.id.drawer_home_item);
            navigationView.getMenu().performIdentifierAction(R.id.drawer_home_item, 0);
            setProductFragment();
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                switch (item.getItemId()){
                    case R.id.drawer_products_item:
                        setProductFragment();
                        break;
                    case R.id.drawer_about_us_item:
                        openAboutUsActivity();
                        break;
                    case R.id.drawer_logout_item:
                        logout();
                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void setProductFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, new ProductListUserFragment());
        fragmentTransaction.commit();
    }

    private void openAboutUsActivity(){
        Intent intent = new Intent(this, AboutUsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("FIRST", false);
    }

    private void logout(){
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(getString(R.string.key_token));
        editor.apply();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
