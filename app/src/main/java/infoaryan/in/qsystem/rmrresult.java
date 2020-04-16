package infoaryan.in.qsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class rmrresult extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7;
    Button back;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rmrresult);

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);
        sp = getSharedPreferences("rmr",MODE_PRIVATE);

        t1.setText("RMR = "+sp.getString("rmr",""));
        t2.setText("CLASS : "+sp.getString("class",""));
        t3.setText("STAND TIME : "+sp.getString("stand",""));
        t4.setText("COHESIVE : "+sp.getString("cohesion",""));
        t5.setText("FRICTION ANGLE : "+sp.getString("angle",""));
        t6.setText("ALLOWED PRESSURE : "+sp.getString("pressure",""));
        t7.setText("SUPPORTS :  "+sp.getString("support",""));

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rmrresult.this,rmrhome.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
