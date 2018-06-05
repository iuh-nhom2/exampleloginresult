package com.example.gmt_006.example.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gmt_006.example.R;
import com.example.gmt_006.example.User;
import com.example.gmt_006.example.ViewLogin;
import com.example.gmt_006.example.resenter.PresenterLogin;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewLogin {

    EditText edtuser,edtpass;
    Button btnlogin;
    TextView txtRefister;
    String username="";
    String password="";
    public static ArrayList<User> manguerlogin;
    PresenterLogin presenterLogin;
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
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = edtuser.getText().toString();
                password = edtpass.getText().toString();
//                if(username.length() >0 && password.length()>0){
//                    GuiYeuCauServer dataclient = APIUtil.getData();
//                    retrofit2.Call<List<User>> callbackdatalogin = dataclient.getUserloginData(username,password);
//                    callbackdatalogin.enqueue(new Callback<List<User>>() {
//                        @Override
//                        public void onResponse(retrofit2.Call<List<User>> call, Response<List<User>> response) {
//                            manguerlogin = (ArrayList<User>) response.body();
//                            if(manguerlogin.size()>0){
//                                Log.d("LogUser",manguerlogin.get(0).getTaikhoan());
//                                Log.d("LogPassword",manguerlogin.get(0).getMatkhau());
//                                Log.d("LogHinhanh", manguerlogin.get(0).getHinh());
//                                Intent intent =  new Intent(MainActivity.this,InformationLoginActivity.class);
//                                intent.putExtra("manguser",manguerlogin);
//                                startActivity(intent);
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(retrofit2.Call<List<User>> call, Throwable t) {
//                            Toast.makeText(MainActivity.this,"the account not realy in the database ",Toast.LENGTH_LONG).show();
//                        }
//                    });
//                }
                presenterLogin.RequestLogin(username,password);
            }
        });

    }

    private void Anhxa() {
        edtuser = findViewById(R.id.edtUsername);
        edtpass = findViewById(R.id.edtPassword);
        txtRefister = findViewById(R.id.txtRegister);
        btnlogin = findViewById(R.id.btnLogin);
        presenterLogin = new PresenterLogin(this);

    }


    @Override
    public void LoginSuccess() {
        Intent inten = new Intent(MainActivity.this,InformationLoginActivity.class);
        inten.putExtra("manguser",manguerlogin);
        startActivity(inten);
    }

    @Override
    public void LoginFailed() {
        Toast.makeText(MainActivity.this,"Login Failed", Toast.LENGTH_LONG).show();

    }
}
