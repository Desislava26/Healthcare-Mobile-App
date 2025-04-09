package com.example.healthcareproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class RegisterActivity extends AppCompatActivity {

    EditText edUsername, edEmail, edPassword, edConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
           // Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            //return insets;

        edUsername = findViewById(R.id.editTextRegUsername);
        edPassword = findViewById(R.id.editTextRegPassword);
        edEmail = findViewById(R.id.editTextRegEmail);
        edConfirm = findViewById(R.id.editTextRegConfirmPassword);
        btn = findViewById(R.id.buttonRegister);
        tv = findViewById(R.id.textViewExistingUser); //за съществуващ потребител

       // }
       // );

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                String email = edEmail.getText().toString();
                String confirm = edConfirm.getText().toString();
                Database db = new Database(getApplicationContext(), "healthcare", null, 1);

                if(username.length()==0 || password.length()==0){ // този вариант или мога да използвам .IsEmpty()
                    Toast.makeText(getApplicationContext(), "Please, fill all empty details", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.compareTo(confirm)==0){
                        if(isValid(password)){
                                db.register(username,email,password);
                                Toast.makeText(getApplicationContext(), "Successful registration! Record inserted", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }else {
                            Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters, having digit, letter and special symbol", Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    public static Boolean isValid(String passwordhere){
        int f1=0, f2=0, f3=0;
        if(passwordhere.length()<8){
            return false;

        }else {
            for (int p=0; p<passwordhere.length(); p++){
                if(Character.isLetter(passwordhere.charAt(p))){
                    f1=1;
                }
            }
            for (int r=0; r<passwordhere.length(); r++){
                if(Character.isDigit(passwordhere.charAt(r))){
                    f2=1;
                }
            }
            for (int s=0; s<passwordhere.length(); s++){
                char c = passwordhere.charAt(s);
                if(c>=33&&c<=46||c==64){
                    f3=1;
                }
            }
            if(f1==1&&f2==1&&f3==1){
                return true;
            }
           // return false;
        }


        return false;
    }

}