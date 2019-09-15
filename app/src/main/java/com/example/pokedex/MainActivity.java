package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private static FragmentManager fragmentManager;
    homefragment Home_Fragment;



import android.os.Bundle;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    Button birds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        birds=findViewById(R.id.button1);


        Home_Fragment = new homefragment();

        fragmentManager = getSupportFragmentManager();

        if(findViewById(R.id.fragment_container)!=null)
        {
            if(savedInstanceState!=null)
                return;
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(R.id.fragment_container,new homefragment(),null).commit();
        }

        drawer = (DrawerLayout)findViewById(R.id.drawerLayout);
        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }
    

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){

            case R.id.registerspecies:
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));



        }
        return false;


    }
}
