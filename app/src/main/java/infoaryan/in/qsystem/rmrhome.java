package infoaryan.in.qsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;

public class rmrhome extends AppCompatActivity {

    Spinner r1,r2,r3,r4,r5,r6;
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8;
    int R1,R2,R3,R4,R5,R6,rmr;
    Button calc;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rmrhome);

        init();
        Toast.makeText(this, "Click below to Calculate!", Toast.LENGTH_SHORT).show();

        //The setters for the checkbox to be selected and list changes
        {
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked){
                   c2.setChecked(false);
                   c3.setChecked(false);
                   firstList();

               }

            }
        });
        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    c1.setChecked(false);
                    c3.setChecked(false);
                    firstList();
                }

            }
        });
        c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    c2.setChecked(false);
                    c1.setChecked(false);
                    firstList();
                }

            }
        });
        c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    c5.setChecked(false);
                    c6.setChecked(false);
                    secondList();
                }
            }
        });
        c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    c4.setChecked(false);
                    c6.setChecked(false);
                    secondList();
                }
            }
        });
        c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    c5.setChecked(false);
                    c4.setChecked(false);
                    secondList();
                }
            }
        });
        c7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    c8.setChecked(false);
                    thirdList();
                }
            }
        });
        c8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    c7.setChecked(false);
                    thirdList();
                }
            }
        });
    }

        c2.setChecked(true);
        c5.setChecked(true);
        c7.setChecked(true);

        //The Onclick methods for the Button.
        calc = findViewById(R.id.calcuate);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                R1 = getR1();
                R2 = getR2();
                R3 = getR3();
                R4 = getR4();
                R5 = getR5();
                R6 = getR6();
                rmr = R1+R2+R3+R4+R5+R6;
                showresults(rmr);
            }
        });

        sp = getSharedPreferences("rmr",MODE_PRIVATE);
        editor = sp.edit();


    }
    public void init(){
        r1 =findViewById(R.id.r1spinner);
        r2 = findViewById(R.id.r2spinner);
        r3 =findViewById(R.id.r3spinner);
        r4 = findViewById(R.id.r4spinner);
        r5 = findViewById(R.id.r5spinner);
        r6 = findViewById(R.id.r6spinner);

        c1 = findViewById(R.id.ucscheckbox);
        c2 = findViewById(R.id.plsicheckbox);
        c3 = findViewById(R.id.typecheckbox);
        c4 =findViewById(R.id.inflowcheckbox);
        c5 = findViewById(R.id.psratiocheckbox);
        c6 = findViewById(R.id.generalcheckbox);
        c7 = findViewById(R.id.tunnelcheckbox);
        c8 = findViewById(R.id.Damcheckbox);

        ArrayAdapter<CharSequence> typeadap = ArrayAdapter.createFromResource(this, R.array.r2, android.R.layout.simple_spinner_item);
        typeadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        r2.setAdapter(typeadap);
        ArrayAdapter<CharSequence> typeadape = ArrayAdapter.createFromResource(this, R.array.r3, android.R.layout.simple_spinner_item);
        typeadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        r3.setAdapter(typeadape);
        ArrayAdapter<CharSequence> typeadapee = ArrayAdapter.createFromResource(this, R.array.r4, android.R.layout.simple_spinner_item);
        typeadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        r4.setAdapter(typeadapee);



    }

    //The methods for setting the list to the assigned spinners

    public void firstList(){
        if(c1.isChecked()){


            ArrayAdapter<CharSequence> typeadap = ArrayAdapter.createFromResource(this, R.array.r11, android.R.layout.simple_spinner_item);
            typeadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            r1.setAdapter(typeadap);

        }
       else if(c2.isChecked()){

            ArrayAdapter<CharSequence> typeadap = ArrayAdapter.createFromResource(this, R.array.r12, android.R.layout.simple_spinner_item);
            typeadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            r1.setAdapter(typeadap);
        }
        else if(c3.isChecked()){

            ArrayAdapter<CharSequence> typeadap = ArrayAdapter.createFromResource(this, R.array.r13, android.R.layout.simple_spinner_item);
            typeadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            r1.setAdapter(typeadap);
        }
    }
    public void secondList(){
        if(c4.isChecked()){


            ArrayAdapter<CharSequence> typeadap = ArrayAdapter.createFromResource(this, R.array.r51, android.R.layout.simple_spinner_item);
            typeadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            r5.setAdapter(typeadap);

        }
        else if(c5.isChecked()){

            ArrayAdapter<CharSequence> typeadap = ArrayAdapter.createFromResource(this, R.array.r52, android.R.layout.simple_spinner_item);
            typeadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            r5.setAdapter(typeadap);
        }
        else if(c6.isChecked()){

            ArrayAdapter<CharSequence> typeadap = ArrayAdapter.createFromResource(this, R.array.r53, android.R.layout.simple_spinner_item);
            typeadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            r5.setAdapter(typeadap);
        }

    }
    public void thirdList(){
        if(c7.isChecked()){


            ArrayAdapter<CharSequence> typeadap = ArrayAdapter.createFromResource(this, R.array.tunnel, android.R.layout.simple_spinner_item);
            typeadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            r6.setAdapter(typeadap);

        }
        else if(c8.isChecked()){

            ArrayAdapter<CharSequence> typeadap = ArrayAdapter.createFromResource(this, R.array.dam, android.R.layout.simple_spinner_item);
            typeadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            r6.setAdapter(typeadap);
        }

    }

    //The methods for picking the value from the spinners
    private int getR1(){
        int temp = r1.getSelectedItemPosition();
        switch(temp){
            case 0: R1 =15;
            break;
            case 1: R1 =12;
                break;
            case 2: R1 =7;
                break;
            case 3: R1 =4;
                break;
            case 4: R1 =3;
                break;
            case 5: R1 =1;
                break;
            case 6: R1 =0;
                break;
        }
        return R1;
    }
    private int getR2(){
        int temp = r2.getSelectedItemPosition();
        switch(temp){
            case 0: R2 =20;
                break;
            case 1: R2 =17;
                break;
            case 2: R2 =13;
                break;
            case 3: R2 =8;
                break;
            case 4: R2 =3;
                break;
        }
        return R2;
    }
    private int getR3(){
        int temp = r3.getSelectedItemPosition();
        switch(temp){
            case 0: R3 =20;
                break;
            case 1: R3 =15;
                break;
            case 2: R3 =10;
                break;
            case 3: R3 =8;
                break;
            case 4: R3 =5;

        }
        return R3;
    }
    private int getR4(){
        int temp = r4.getSelectedItemPosition();
        switch(temp){
            case 0: R4 =30;
                break;
            case 1: R4 =25;
                break;
            case 2: R4 =20;
                break;
            case 3: R4 =10;
                break;
            case 4: R4 =0;
        }
        return R4;
    }
    private int getR5(){
        int temp = r5.getSelectedItemPosition();
        switch(temp){
            case 0: R5 =15;
                break;
            case 1: R5 =10;
                break;
            case 2: R5 =7;
                break;
            case 3: R5 =4;
                break;
            case 4: R5 =0;

        }
        return R5;
    }
    private int getR6(){
        int temp = r6.getSelectedItemPosition();
        if(c7.isChecked()){
            switch(temp){
                case 0: R6 =0;
                    break;
                case 1: R6 =-2;
                    break;
                case 2: R6 =-5;
                    break;
                case 3: R6 =-10;
                    break;
                case 4: R6 =-5;
                    break;
                case 5: R6 = -12;
                break;
                case 6: R5 =-5;

            }
        }
        else{

        }
        return R6;
    }
    public void showresults(int rmr){
        String classi="",standup="",cohesion="",angle="",pressure="",support="";
        if(rmr<=20){
            classi ="Very poor";
            standup = "30 Min for 1m span";
            cohesion = "less than 0.1 MPa";
            angle = "less than 15 deg";
            pressure = "45-30 T/m2";
            support = "Systematic bolts 5-6m Long, spaced 1-1.5m crown, 150-200mm in crown 150mm in sides and 50mm on face. Medium to heavy rigs spaced 0.75m.";
        }
       else if(rmr>20 && rmr<=40){
            classi ="poor";
            standup = "10 Hrs for 2.5m span";
            cohesion = "0.1-0.2 MPa";
            angle = "15-25 deg";
            pressure = "135-45 T/m2";
            support = "Systematic bolts 4-5m Long, spaced 1-1.5m crown, 100-150mm in crown 100mm in sides. Light to Medium ribs spaced 1.5m.";
        }
        else if(rmr>40 && rmr<=60){
            classi ="Fair";
            standup = "1 Week for 5m span";
            cohesion = "0.2-0.3  MPa";
            angle = "25-35 deg";
            pressure = "280-135 T/m2";
            support = "Systematic bolts 4m Long, spaced 1.5-2m crown and walls with wire mesh, 50-100mm in crown 30mm in sides.";
        }
        else if(rmr>60 && rmr<=80){
            classi ="Good";
            standup = "6 Months for 8m span";
            cohesion = "0.3-0.4  MPa";
            angle = "35-45 deg";
            pressure = "440-280 T/m2";
            support = "Locally, bolts in crown 3m,long spaced 2.5m with occasional wire mesh, 50mm in crown, where required";

        }
        else if(rmr>80){
            classi ="very Good";
            standup = "10 Years for 15m span";
            cohesion = "greater than 0.4 MPa";
            angle = "greater than 45 deg";
            pressure = "600-440 T/m2";
            support = "Generally no support required !";
        }
        editor.putString("rmr",rmr+"");
        editor.putString("class",classi);
        editor.putString("stand",standup);
        editor.putString("cohesion",cohesion);
        editor.putString("angle",angle);
        editor.putString("pressure",pressure);
        editor.putString("support",support);
        editor.commit();
        Intent intent = new Intent(this,rmrresult.class);
        startActivity(intent);
        finish();

    }
}
