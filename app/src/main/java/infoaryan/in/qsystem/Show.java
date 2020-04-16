package infoaryan.in.qsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Show extends AppCompatActivity {
TextView q,clas,pv,ph,fa,de,ed,bl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        q=findViewById(R.id.rmq);
        clas=findViewById(R.id.clas);
        pv=findViewById(R.id.pv);
        ph=findViewById(R.id.Ph);
        fa=findViewById(R.id.fa);
        de=findViewById(R.id.de);
        ed=findViewById(R.id.ed);
        bl = findViewById(R.id.bl);

        SharedPreferences sharedPreferences=getSharedPreferences("imp",MODE_PRIVATE);
        q.setText("Q = "+sharedPreferences.getString("q","1.0"));
        clas.setText("CLASS = "+sharedPreferences.getString("class","1.0"));
        pv.setText("Roof Support pressure(Pv) = "+sharedPreferences.getString("pv","1.0"));
        ph.setText("Wall Support pressure (Ph)= "+sharedPreferences.getString("ph","1.0"));
        fa.setText("Friction angle = "+sharedPreferences.getString("fa","1.0"));
        de.setText("De= "+sharedPreferences.getString("de","1.0"));
        ed.setText("Elastic Modulus(Ed) = "+sharedPreferences.getString("ed","1.0"));
        bl.setText("Bolt length(l) = "+sharedPreferences.getString("bl","")+" m");
        Button hhh;
        hhh=findViewById(R.id.hhh);
        hhh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Show.this,Home.class);
                startActivity(intent);
                finish();

            }
        });

    }

}
