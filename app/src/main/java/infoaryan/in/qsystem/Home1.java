package infoaryan.in.qsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Home1 extends AppCompatActivity {
    Button rmr,q,gsi;
    DrawerLayout dl;
    ActionBarDrawerToggle t;
    NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);

        //The presets for the working of the navigation view
        {


            dl = findViewById(R.id.maindrawer);
            t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

            dl.addDrawerListener(t);
            t.syncState();

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            nv = findViewById(R.id.nv);
            nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();
                    switch(id)
                    {
                        case R.id.one:
                            Toast.makeText(Home1.this, "Home",Toast.LENGTH_SHORT).show();break;
                        case R.id.two:
                            Toast.makeText(Home1.this, "RMR",Toast.LENGTH_SHORT).show();break;
                        case R.id.three:
                            Toast.makeText(Home1.this, "Q-system",Toast.LENGTH_SHORT).show();break;
                        case R.id.four:
                            Toast.makeText(Home1.this, "GSI",Toast.LENGTH_SHORT).show();break;
                        case R.id.five:
                            Toast.makeText(Home1.this, "About the App",Toast.LENGTH_SHORT).show();break;
                        default:
                            return true;
                    }


                    return true;
                }
            });

        }

        rmr = findViewById(R.id.rmr);
        q = findViewById(R.id.q);
        gsi = findViewById(R.id.gsi);

        rmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home1.this,rmrhome.class);
                startActivity(intent);
            }
        });

        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home1.this,Home.class);
                startActivity(intent);
            }
        });

        gsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home1.this,gsihome.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(t.onOptionsItemSelected(item)){
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }
}
