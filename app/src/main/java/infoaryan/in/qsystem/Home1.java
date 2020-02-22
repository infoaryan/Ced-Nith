package infoaryan.in.qsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home1 extends AppCompatActivity {
    Button rmr,q,gsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);

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
}
