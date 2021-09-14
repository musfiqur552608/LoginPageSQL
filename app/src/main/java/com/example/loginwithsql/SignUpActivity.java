package com.example.loginwithsql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText name, email, username, pass;
    private Button reBtn;
    UserDetails userDetails;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.nameId);
        email = findViewById(R.id.emailId);
        username = findViewById(R.id.usernameId);
        pass = findViewById(R.id.passId);

        reBtn = findViewById(R.id.reBtn);
        userDetails = new UserDetails();
        databaseHelper = new DatabaseHelper(this);

        reBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname = name.getText().toString();
                String semail = email.getText().toString();
                String suname = username.getText().toString();
                String spass = pass.getText().toString();

                userDetails.setName(sname);
                userDetails.setEmail(semail);
                userDetails.setUsername(suname);
                userDetails.setPassword(spass);

                long rowId = databaseHelper.insertData(userDetails);

                if (rowId>0)
                {
                    Toast.makeText(getApplicationContext(), "Row "+rowId+" is inserted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Row "+rowId+" is insertion failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}