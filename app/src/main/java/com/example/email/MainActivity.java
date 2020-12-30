package com.example.email;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.fragment.app.FragmentManager;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public DrawerLayout drawer;
    //private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tool); //using toolbar as the action bar
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.draw_lay);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace With Your Own Action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                    new Inbox_f()).commit();
            navigationView.setCheckedItem(R.id.nav_msg);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        switch (item.getItemId()) {
            case R.id.nav_msg:
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                        new Inbox_f()).commit(); //fragment calling
                break;

            case R.id.nav_chat:
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                        new chat_f()).addToBackStack("inbox").add(new Inbox_f(),"inbox").commit();
                break;

            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                        new profile_f()).addToBackStack("inbox").add(new Inbox_f(),"inbox").commit();
                break;

            case R.id.nav_set:
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                        new setting_f()).addToBackStack("inbox").add(new Inbox_f(),"inbox").commit();
                break;

            case R.id.nav_feed:
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                        new hf_f()).addToBackStack("inbox").add(new Inbox_f(),"inbox").commit();
                break;

            case R.id.nav_share:
                Toast.makeText(this, "Sharing...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_send:
                Toast.makeText(this, "Sending...", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else

            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item1:
                Toast.makeText(this, "Bluetooth", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item6:
                Toast.makeText(this, "Copy", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Group", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sitem1:
                Toast.makeText(this, "Adding", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sitem2:
                Toast.makeText(this, "Deleting", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                Toast.makeText(this, "Report", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}

//ic_chat,profile,send,share