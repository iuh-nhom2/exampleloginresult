package com.example.gmt_006.example.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gmt_006.example.R;

public class MainActivity extends AppCompatActivity {

    EditText edtuser,edtpass;
    Button btnlogin;
    TextView txtRefister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        txtRefister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RigisterActivity.class);
                startActivity(intent);

            }
        });

    }

    private void Anhxa() {
        edtuser = findViewById(R.id.edtUsername);
        edtpass = findViewById(R.id.edtPassword);
        txtRefister = findViewById(R.id.txtRegister);
        btnlogin = findViewById(R.id.btnLogin);

    }

}
