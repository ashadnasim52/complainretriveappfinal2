package com.cit.complainretrive;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,adapterofitem.Onitemclicklistner {


    adapterofitem adapterofitemyo;
    ArrayList<String> extraarray;
    ArrayList<String> titlearray;
    ArrayList<String> complainarray;
    ArrayList<String> namearray;
    ArrayList<String> emailarray;
    RecyclerView recyclerView;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    DatabaseReference user=myRef.child("Users");





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        extraarray = new ArrayList<>();
        complainarray=new ArrayList<>();
        emailarray=new ArrayList<>();
        namearray=new ArrayList<>();
        titlearray=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapterofitemyo=new adapterofitem(titlearray,getApplicationContext());
        adapterofitemyo.setonitemclicklistner(this);

        recyclerView.setAdapter(adapterofitemyo);
        ChildEventListener childEventListener=new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

//                animalNames.add(dataSnapshot.toString());
                Log.i("datasnapshot","is"+dataSnapshot);

                Log.i("datasnapshotatonepsio","is "+dataSnapshot);



                Itemclass itemclass=dataSnapshot.getValue(Itemclass.class);
                String extra=itemclass.getextra();
                String name=itemclass.getName();
                String complaian=itemclass.getcomplain();
                String title=itemclass.getTitle();
                String email=itemclass.getEmail();


                extraarray.add(extra);
                complainarray.add(complaian);
                emailarray.add(email);
                namearray.add(name);
                titlearray.add(title);
                Log.i("gantaitemsttles"," Are title "+titlearray);
                Log.i("gantaitemsttles"," Are extra"+extraarray);
                Log.i("gantaitemsttles"," Are complan "+complainarray);
                Log.i("gantaitemsttles"," Are emal"+emailarray);
                Log.i("gantaitemsttles"," Are name"+namearray);



//                    arraylistofitem.add(itemclass);


//                    String altro = ds.child("Name").getValue(String.class);
//                    String asd=ds.getChildren().toString();
//
//                    Log.i("childrenis","is"+asd);
//                    String as= ds.getKey();
//                    Log.i("dsskeyis","is"+as);
//                    Boolean a=ds.hasChild("LIBg7gn1S0126t1ONnJ");
//                    Log.i("haikinahi"," is" +a);
//
//                    HashMap<String ,String > uid= new HashMap<>();
//                    uid.put("Uid",altro);
//                    Log.i("dataofuid","is of"+uid);
//                    String cognome = ds.child("value").getValue(String.class);
//                    String informazioni = ds.child("Informazioni").getValue(String.class);
//                    String nome = ds.child("Nome").getValue(String.class);
//                    animalNames.add(altro);
//                    animalNames.add(cognome);
//                    animalNames.add(informazioni);
//                    Log.d("TAG", altro + " / " + cognome + " / " + informazioni + " / " + nome);

                //

                adapterofitemyo.notifyDataSetChanged();


            }


            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        user.addChildEventListener(childEventListener);


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
        getMenuInflater().inflate(R.menu.main, menu);
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

    @Override
    public void onitemclick(int position) {
        Toast.makeText(getApplicationContext(),"bro goodjob"+position+"\n"+titlearray.get(position)+"\n"+complainarray.get(position)+extraarray.get(position),Toast.LENGTH_SHORT).show();

        Intent i=new Intent(getApplicationContext(),compalindetails.class);
        //  itemcalss clickeditem=itemcalsses.get(position);
        //        i.putExtra(extra_url,clickeditem.getUrltocontent());
        //startActivity(i);
        Bundle bundle=new Bundle();

        i.putExtra("complainarray",complainarray.get(position));
        i.putExtra("titlearray",titlearray.get(position));
        i.putExtra("emailarray",emailarray.get(position));
        i.putExtra("extraarray",extraarray.get(position));
        i.putExtra("namearray",namearray.get(position));

        startActivity(i);
    }
}
