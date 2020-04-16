package infoaryan.in.qsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Home extends AppCompatActivity {
    Spinner rqdspinner, jnspinner, jrspinner, jaspinner, jwspinner, srfspinner, esrspinner, bspinner, typespinner;
    Button calc;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        setAdaps();
        Toast.makeText(getApplicationContext(),"Press Button below to calculate !",Toast.LENGTH_SHORT).show();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double Q, rqd, jr, jn, ja, jw, ed, b, srf, de, qc, pv, esr, ph, qw, fa,bl;
                rqd = Double.parseDouble(rqdspinner.getSelectedItem().toString());
                sharedPreferences = getSharedPreferences("imp", MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                DecimalFormat decimalFormat = new DecimalFormat("0.000");
                // getting of the parameters form the spinners
                jr = seljr();
                jn = seljn();
                esr = selesr();
                ja = selja();
                jw = seljw();
                srf = selsrf();

                Q = (rqd * jr * jw) / (jn * ja * srf);//to show


                String clas;
                {

                if (Q > 0.001 && Q <= 0.01) {
                    clas = "Exceptionally poor";
                } else if (rqd > 0.01 && rqd <= 0.1) {
                    clas = "Extremely poor";
                } else if (rqd > 0.1 && rqd <= 1) {
                    clas = "very poor";
                } else if (rqd > 1 && rqd <= 4) {
                    clas = "poor";
                } else if (rqd > 4 && rqd <= 10) {
                    clas = "fair";
                } else if (rqd > 10 && rqd <= 40) {
                    clas = "good";
                } else if (rqd > 40 && rqd <= 100) {
                    clas = "very good";
                } else if (rqd > 100 && rqd <= 400) {
                    clas = "Extremely good";
                } else {
                    clas = "Exceptionally good";
                }

            }// determination of the class

                b = Double.parseDouble(bspinner.getSelectedItem().toString());
                if (Q > 10) {
                    qw = 5 * Q;
                } else if (Q > 0.1 && Q <= 10) {
                    qw = 2.5 * Q;
                } else {
                    qw = Q;
                }

                if (Q < 4) {//
                    pv = 40 * b / (Math.pow(Q, (1 / 3.0))*jr);//kpa
                    edit.putString("pv",""+decimalFormat.format(pv)+"KPa");
                    if (jn < 3) {
                        ph = (0.2 * Math.pow(jn, 0.5) * Math.pow(qw, -0.33)) / (3 * jr);
                    } else {
                        ph = (0.2 * Math.pow(qw, -0.33)) / jr;
                    }
                    edit.putString("ph",""+decimalFormat.format(ph)+"Mpa");
                } else {//mpa
                    if (jn < 3) {
                        pv = (0.2 * Math.pow(jn, 0.5)) / (3 * jr * Math.pow(Q,1/3.0));
                        ph = (0.2 * Math.pow(jn, 0.5)) / (3 * jr * Math.pow(qw, 0.33));
                    } else {
                        pv = 0.2 / (jr * Math.pow(Q, 0.33));
                        ph = 0.2 / (jr * Math.pow(qw, 0.33));
                    }

                    edit.putString("pv",""+decimalFormat.format(pv)+"MPa");
                    edit.putString("ph",""+decimalFormat.format(ph)+"Mpa");
                }


                qc = selqc();
                fa = Math.atan(jr / ja);
                fa=(fa*180)/3.14;
                de = b / esr;
                bl = 2.0 + (0.15*b/esr);
                ed = 10 * (Math.pow((Q * qc / 100), 0.33));


                edit.putString("q",""+decimalFormat.format(Q));
                edit.putString("class",clas);

                edit.putString("fa",""+decimalFormat.format(fa));

                edit.putString("de",""+decimalFormat.format(de));
                edit.putString("ed",""+decimalFormat.format(ed));
                edit.putString("bl",""+decimalFormat.format(bl));
                edit.commit();
                Intent intent = new Intent(Home.this,Show.class);
                startActivity(intent);
            }
        });


    }

    private void init() {
        rqdspinner = findViewById(R.id.rqdspinner);
        jnspinner = findViewById(R.id.jnspinner);
        jrspinner = findViewById(R.id.jrspinner);
        jaspinner = findViewById(R.id.jaspinner);
        jwspinner = findViewById(R.id.jwspinner);
        srfspinner = findViewById(R.id.srfspinner);
        esrspinner = findViewById(R.id.esrspinner);
        bspinner = findViewById(R.id.roofspanspinner);
        typespinner = findViewById(R.id.rocktypespinner);


        calc = findViewById(R.id.calcuate);

    }

    private void setAdaps() {
        ArrayAdapter<CharSequence> jnadap = ArrayAdapter.createFromResource(this, R.array.jn, android.R.layout.simple_spinner_item);
        jnadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jnspinner.setAdapter(jnadap);

        ArrayAdapter<CharSequence> jradap = ArrayAdapter.createFromResource(this, R.array.jr, android.R.layout.simple_spinner_item);
        jradap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jrspinner.setAdapter(jradap);
        ArrayAdapter<CharSequence> jaadap = ArrayAdapter.createFromResource(this, R.array.ja, android.R.layout.simple_spinner_item);
        jaadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jaspinner.setAdapter(jaadap);
        ArrayAdapter<CharSequence> jwadap = ArrayAdapter.createFromResource(this, R.array.jw, android.R.layout.simple_spinner_item);
        jwadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jwspinner.setAdapter(jwadap);
        ArrayAdapter<CharSequence> srfadap = ArrayAdapter.createFromResource(this, R.array.srf, android.R.layout.simple_spinner_item);
        srfadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        srfspinner.setAdapter(srfadap);
        ArrayAdapter<CharSequence> esradap = ArrayAdapter.createFromResource(this, R.array.esr, android.R.layout.simple_spinner_item);
        esradap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        esrspinner.setAdapter(esradap);
        ArrayAdapter<CharSequence> typeadap = ArrayAdapter.createFromResource(this, R.array.type, android.R.layout.simple_spinner_item);
        typeadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typespinner.setAdapter(typeadap);

        ArrayList<String> rqdl = new ArrayList<>();
        rqdl.add("1");
        for (int i = 2; i < 100; ++i) {
            rqdl.add("" + i);
        }
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, rqdl);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, rqdl);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rqdspinner.setAdapter(adapter);
        bspinner.setAdapter(stringArrayAdapter);

    }

    public Double seljr() {
        Double re;

        int i = jrspinner.getSelectedItemPosition();
        switch (i) {
            case 0:
                re = 4.0;
                break;
            case 1:
                re = 3.0;
                break;
            case 2:
                re = 2.0;
                break;
            case 3:
                re = 1.50;
                break;
            case 4:
                re = 1.5;
                break;
            case 5:
                re = 1.0;
                break;
            default:
                re = 0.5;
        }
        return re;

    }

    public Double selja() {
        Double re;

        int i = jaspinner.getSelectedItemPosition();
        switch (i) {
            case 0:
                re = 0.75;
                break;
            case 1:
                re = 1.0;
                break;
            case 2:
                re = 2.0;
                break;
            case 3:
                re = 3.0;
                break;
            case 4:
                re = 4.0;
                break;
            case 5:
                re = 4.0;
                break;
            case 6:
                re = 8.0;
                break;
            case 7:
                re = 6.0;
                break;
            case 8:
                re = 7.5;
                break;
            case 9:
                re = 8.0;
                break;
            case 10:
                re=12.0;
                break;
            case 11: re=10.0;
            break;
            default:re=16.75;


        }
        return re;

    }

    public Double seljn() {
        Double re;

        int i = jnspinner.getSelectedItemPosition();
        switch (i) {
            case 0:
                re = 0.5;
                break;
            case 1:
                re = 1.0;
                break;
            case 2:
                re = 2.0;
                break;
            case 3:
                re = 3.0;
                break;
            case 4:
                re = 4.0;
                break;
            case 5:
                re = 6.0;
                break;
            case 6:
                re = 9.0;
                break;
            case 7:
                re = 12.0;
                break;
            case 8:
                re=15.0;
                break;
            default:
                re = 20.0;


        }
        return re;


    }

    public Double seljw() {
        Double re;

        int i = jwspinner.getSelectedItemPosition();
        switch (i) {
            case 0:
                re = 1.0;
                break;
            case 1:
                re = 0.66;
                break;
            case 2:
                re = 0.5;
                break;
            case 3:
                re = 0.3;
                break;
            case 4:
                re = 0.25;
                break;


            default:
                re = 0.1;


        }
        return re;


    }

    public Double selsrf() {
        Double re;

        int i = srfspinner.getSelectedItemPosition();
        switch (i) {
            case 0:
                re = 10.0;
                break;
            case 1:
                re = 5.0;
                break;
            case 2:
                re = 2.5;
                break;
            case 3:
                re = 7.5;
                break;
            case 4:
                re = 5.0;
                break;
            case 5:
                re = 2.5;
                break;
            case 6:
                re = 5.0;
                break;
            case 7:
                re = 2.5;
                break;
            case 8:
                re = 1.0;
                break;
            case 9:
                re = 1.25;
                break;
            case 10:
                re = 22.5;
                break;
            case 11:
                re = 125.0;
                break;
            case 12:
                re = 300.0;
                break;
            case 13:
                re = 7.5;
                break;
            case 14:
                re = 15.0;

                break;
            case 15:
                re = 7.5;
                break;
            default:
                re = 12.5;


        }
        return re;


    }

    public Double selesr() {
        Double re;

        int i = srfspinner.getSelectedItemPosition();
        switch (i) {
            case 0:
                re = 4.0;
                break;
            case 1:
                re = 2.25;
                break;
            case 2:
                re = 1.6;
                break;
            case 3:
                re = 1.3;
                break;
            case 4:
                re = 1.0;
                break;


            default:
                re = 0.8;


        }
        return re;

    }

    public Double selqc() {
        Double re;

        int i = srfspinner.getSelectedItemPosition();
        switch (i) {
            case 0:
                re = 150.0;
                break;
            case 1:
                re = 160.0;
                break;
            case 2:
                re = 160.5;
                break;
            case 3:
                re = 160.5;
                break;
            case 4:
                re = 55.0;
                break;
            case 5:
                re = 140.0;
                break;
            case 6:
                re = 200.0;
                break;
            case 7:
                re = 100.0;
                break;
            case 8:
                re = 240.0;
                break;
            case 9:
                re = 160.0;
                break;
            case 10:
                re = 100.0;
                break;
            case 11:
                re = 160.0;
                break;
            case 12:
                re = 90.0;
                break;
            case 13:
                re = 130.0;
                break;
            case 14:
                re = 75.0;

                break;
            case 15:
                re = 130.0;
                break;
            case 16:
                re = 80.0;
                break;
            case 17:
                re = 90.0;
                break;
            case 18:
                re = 100.0;
                break;
            case 19:
                re = 90.0;
                break;
            case 20:
                re = 85.0;
                break;
            case 21:
                re = 80.0;
                break;
            case 22:
                re = 50.0;
                break;
            case 23:
                re = 190.0;
                break;
            case 24:
                re = 100.0;
                break;
            case 25:
                re = 85.0;
                break;
            case 26:
                re = 100.0;

                break;
            case 27:
                re = 135.0;
                break;
            case 28:
                re = 95.0;
                break;
            case 29:
                re = 80.0;
                break;
            case 30:
                re = 190.0;
                break;
            case 31:
                re = 150.0;
                break;
            case 32:
                re = 25.0;
                break;
            case 33:
                re = 160.0;
                break;
            case 34:
                re = 0.7;

                break;
            case 35:
                re = 0.2;
                break;
            case 36:
                re = 0.03;
                break;
            default:
                re = 0.0005;


        }
        return re;

    }
}