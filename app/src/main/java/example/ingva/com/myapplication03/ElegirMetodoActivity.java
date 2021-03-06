package example.ingva.com.myapplication03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

public class ElegirMetodoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    ImageButton imageIMC, imageComplexion;
    Button btn_imc1, btn_complex1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_metodo);
      //  setContentView(R.layout.content_elegir_metodo);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageIMC = (ImageButton) findViewById(R.id.imageIMC);
        imageIMC.setOnClickListener((View.OnClickListener) this);

        btn_imc1 = (Button) findViewById(R.id.btn_imc1);
        btn_imc1.setOnClickListener((View.OnClickListener) this);

        imageComplexion = (ImageButton) findViewById(R.id.imageComplexion);
        imageComplexion.setOnClickListener((View.OnClickListener) this);

        btn_complex1 = (Button) findViewById(R.id.btn_complex1);
        btn_complex1.setOnClickListener((View.OnClickListener) this);

     /*     FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    public boolean onNavigationItemSelected (MenuItem item){
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Intent main = new Intent(getApplicationContext(),MainActivity.class);

        if (id == R.id.nav_donation) {
            FragmentsIds.setId("nav_donation");

        } else if (id == R.id.nav_help) {
            FragmentsIds.setId("nav_help");

        } else if (id == R.id.nav_share) {
            FragmentsIds.setId("nav_share");

        } else if (id == R.id.nav_about_us) {
            FragmentsIds.setId("nav_about_us");

        } else if (id == R.id.nav_comment) {
            FragmentsIds.setId("nav_comment");

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


        startActivity(main);

        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.imageIMC:
            case R.id.btn_imc1:
                Intent intent_imageIMC = new Intent(ElegirMetodoActivity.this, ImcActivity.class);
                startActivity(intent_imageIMC);
                break;

            case R.id.imageComplexion:
            case R.id.btn_complex1:
                Intent intent_imageComplex = new Intent(ElegirMetodoActivity.this, ComplexionActivity.class);
                startActivity(intent_imageComplex);
                break;

        }
    }
}
