package com.cit.complainretrive;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class compalindetails extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView complain,complaintitle,complainextra,complainname,complainemail,complaindate,authid,idofcompaliner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compalindetails);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




//            TextView complain,complaintitle,complainextra,
// complainname,complainemail,complaindate;
        complain=findViewById(R.id.compalintxt);
        idofcompaliner=findViewById(R.id.idofcompaliner);
        authid=findViewById(R.id.authid);
        complaintitle=findViewById(R.id.compalintitletxt);
        complaindate=findViewById(R.id.datetxt);
        complainextra=findViewById(R.id.compalinextratxt);
        complainemail=findViewById(R.id.emailtxt);
        complainname=findViewById(R.id.compalinidnametxt);

        // Intent i = getIntent();
        //String webadress = i.getStringExtra(extra_url);
        Intent intent=getIntent();
        complainname.setText(intent.getStringExtra("namearray"));
        complain.setText(intent.getStringExtra("complainarray"));
        complaintitle.setText(intent.getStringExtra("titlearray"));
//        complaindate.setText(intent.getStringExtra());
        complaindate.setText(intent.getStringExtra("dateandtime"));
        authid.setText(intent.getStringExtra("authidofc"));
        idofcompaliner.setText(intent.getStringExtra("idid"));
        complainemail.setText(intent.getStringExtra("emailarray"));
        complainextra.setText(intent.getStringExtra("extraarray"));

        //i.putExtra(extracomplain,complainarray.get(position));
        //        i.putExtra(extratitle,titlearray.get(position));
        //        i.putExtra(extraemail,emailarray.get(position));
        //        i.putExtra(extraextyra,extraarray.get(position));
        //        i.putExtra(extraname,namearray.get(position));











    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.compalindetails, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
