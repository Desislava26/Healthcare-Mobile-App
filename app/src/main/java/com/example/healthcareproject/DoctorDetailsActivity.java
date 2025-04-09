package com.example.healthcareproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1={
            {"Doctor Name: Desislava Papalakova", "Hospital Adress: bul. Ruski 13", "Exp: 2yrs", "Phone Number: 0899638527", "40"},
            {"Doctor Name: Ivan Ivanov", "Hospital Adress: bul. 6ti Septemvri 18", "Exp: 5yrs", "Phone Number: 0899638529", "50"},
            {"Doctor Name: Vasil Yordanov", "Hospital Adress: bul. Vasil Aprilov 35", "Exp: 10yrs", "Phone Number: 0899638520", "60"},
            {"Doctor Name: Petar Petrov", "Hospital Adress: bul. Vasil Aprilov 38", "Exp: 8yrs", "Phone Number: 0899638521", "70"},
            {"Doctor Name: Nina Petrova", "Hospital Adress: ul. Petar Stoev 11", "Exp: 20yrs", "Phone Number: 0899638523", "70"}

    };

    private String[][] doctor_details2={
            {"Doctor Name: Desislava Papalakova", "Hospital Adress: bul. Ruski 13", "Exp: 2yrs", "Phone Number: 0899638527", "40"},
            {"Doctor Name: Ivan Ivanov", "Hospital Adress: bul. 6ti Septemvri 18", "Exp: 5yrs", "Phone Number: 0899638529", "50"},
            {"Doctor Name: Vasil Yordanov", "Hospital Adress: bul. Vasil Aprilov 35", "Exp: 10yrs", "Phone Number: 0899638520", "60"},
            {"Doctor Name: Petar Petrov", "Hospital Adress: bul. Vasil Aprilov 38", "Exp: 8yrs", "Phone Number: 0899638521", "70"},
            {"Doctor Name: Nina Petrova", "Hospital Adress: ul. Petar Stoev 11", "Exp: 20yrs", "Phone Number: 0899638523", "70"}

    };

    private String[][] doctor_details3={
            {"Doctor Name: Desislava Papalakova", "Hospital Adress: bul. Ruski 13", "Exp: 2yrs", "Phone Number: 0899638527", "40"},
            {"Doctor Name: Ivan Ivanov", "Hospital Adress: bul. 6ti Septemvri 18", "Exp: 5yrs", "Phone Number: 0899638529", "50"},
            {"Doctor Name: Vasil Yordanov", "Hospital Adress: bul. Vasil Aprilov 35", "Exp: 10yrs", "Phone Number: 0899638520", "60"},
            {"Doctor Name: Petar Petrov", "Hospital Adress: bul. Vasil Aprilov 38", "Exp: 8yrs", "Phone Number: 0899638521", "60"},
            {"Doctor Name: Nina Petrova", "Hospital Adress: ul. Petar Stoev 11", "Exp: 20yrs", "Phone Number: 0899638523", "70"}

    };

    private String[][] doctor_details4={
            {"Doctor Name: Desislava Papalakova", "Hospital Adress: bul. Ruski 13", "Exp: 2yrs", "Phone Number: 0899638527", "40"},
            {"Doctor Name: Ivan Ivanov", "Hospital Adress: bul. 6ti Septemvri 18", "Exp: 5yrs", "Phone Number: 0899638529", "50"},
            {"Doctor Name: Vasil Yordanov", "Hospital Adress: bul. Vasil Aprilov 35", "Exp: 10yrs", "Phone Number: 0899638520", "60"},
            {"Doctor Name: Petar Petrov", "Hospital Adress: bul. Vasil Aprilov 38", "Exp: 8yrs", "Phone Number: 0899638521", "60"},
            {"Doctor Name: Nina Petrova", "Hospital Adress: ul. Petar Stoev 11", "Exp: 20yrs", "Phone Number: 0899638523", "70"}

    };

    private String[][] doctor_details5={
            {"Doctor Name: Desislava Papalakova", "Hospital Adress: bul. Ruski 13", "Exp: 2yrs", "Phone Number: 0899638527", "40"},
            {"Doctor Name: Ivan Ivanov", "Hospital Adress: bul. 6ti Septemvri 18", "Exp: 5yrs", "Phone Number: 0899638529", "50"},
            {"Doctor Name: Vasil Yordanov", "Hospital Adress: bul. Vasil Aprilov 35", "Exp: 10yrs", "Phone Number: 0899638520", "60"},
            {"Doctor Name: Petar Petrov", "Hospital Adress: bul. Vasil Aprilov 38", "Exp: 8yrs", "Phone Number: 0899638521", "60"},
            {"Doctor Name: Nina Petrova", "Hospital Adress: ul. Petar Stoev 11", "Exp: 20yrs", "Phone Number: 0899638523", "70"}

    };

    TextView tv;
    Button btn;
    String[][] doctor_details={};
    ArrayList list;

    HashMap<String, String> item;
    SimpleAdapter sa;
    Button mapBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonDDback);
        mapBtn=findViewById(R.id.buttonDDLocation);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians") ==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician") ==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist") ==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon") ==0)
            doctor_details = doctor_details4;
        else
        //if(title.compareTo("Cardiologists") ==0)
            doctor_details = doctor_details5;
        //else


        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        mapBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(DoctorDetailsActivity.this,MapsActivity.class));
            }
        });

        list=new ArrayList<>();
        for(int i=0; i<doctor_details.length;i++){
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            //item.put("line5", doctor_details[i][4]);
            item.put("line5", "Cons Fees: "+doctor_details[i][4]+" Leva");
            list.add(item);

        }
        sa=new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent (DoctorDetailsActivity.this, BookAppointmentActivity.class);
                    it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][2]);
                it.putExtra("text5", doctor_details[i][3]);
                startActivity(it);
            }
        });
    }
}