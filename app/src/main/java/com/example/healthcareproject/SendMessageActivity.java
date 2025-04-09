package com.example.healthcareproject;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.Manifest;
import android.widget.Toast;

public class SendMessageActivity extends AppCompatActivity {

    EditText edTextPhone, edTextMessage;
            Button btnSend, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_send_message);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edTextPhone = findViewById(R.id.editTextSMSPhone);
        edTextPhone = findViewById(R.id.editTextSMSMessage);
        btnSend = findViewById(R.id.buttonSMSSend);
        btnBack = findViewById(R.id.buttonSMSback);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(ContextCompat.checkSelfPermission(SendMessageActivity.this, Manifest.permission.SEND_SMS)
                        == PackageManager.PERMISSION_GRANTED){
                        sendSMS();
                    }else{
                        ActivityCompat.requestPermissions(SendMessageActivity.this,new String[]{Manifest.permission.SEND_SMS},100);
                    }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SendMessageActivity.this, HomeActivity.class));
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults, int deviceId) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults, deviceId);

        if(requestCode==100 && grantResults.length >0&& grantResults[0] == PackageManager.PERMISSION_GRANTED){
            sendSMS();
        }else{
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendSMS(){
        String phone = edTextPhone.getText().toString();
        String message = edTextMessage.getText().toString();

        if(!phone.isEmpty() && !message.isEmpty()){
            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage(phone,null,message, null, null);
            Toast.makeText(this, "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Please, enter Phone and Message", Toast.LENGTH_SHORT).show();
        }
    }


}