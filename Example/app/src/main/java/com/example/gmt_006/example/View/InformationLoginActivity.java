package com.example.gmt_006.example.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gmt_006.example.R;
import com.example.gmt_006.example.Presenter.PresenterGetInforUser;

public class InformationLoginActivity extends AppCompatActivity  {
    ImageView imguserlogin;
    TextView username,password;
    Button logout,xemapi;
    PresenterGetInforUser presenterGetInforUser;
  // public static ArrayList<User> userloginArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_login);

        AnhXa();
        presenterGetInforUser = new PresenterGetInforUser();
//        ReadData();
//        ModulegetData.getData(username,password,imguserlogin,MainActivity.manguerlogin);
            presenterGetInforUser.GetInforUserRequest(username,password,imguserlogin,MainActivity.manguerlogin);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.manguerlogin.clear();
//                userloginArrayList.clear();
                Intent intentlogout = new Intent(InformationLoginActivity.this,MainActivity.class);
                startActivity(intentlogout);

            }
        });
        xemapi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(InformationLoginActivity.this,ApiActivity.class);
                startActivity(intent);
            }
        });

    }

//    private void ReadData() {
//        Intent intent = getIntent();
//         userloginArrayList = intent.getParcelableArrayListExtra("manguser");
//        Log.d("Loguser", userloginArrayList.get(0).getTaikhoan());
//        username.setText(userloginArrayList.get(0).getTaikhoan());
//        password.setText(userloginArrayList.get(0).getMatkhau());
//        Picasso.get().load(userloginArrayList.get(0).getHinh()).into(imguserlogin);
//    }

    private void AnhXa() {
        imguserlogin = findViewById(R.id.imguser);
        username = findViewById(R.id.txtuserid);
        password = findViewById(R.id.txtpassword);
        logout = findViewById(R.id.btnlogout);
        xemapi = findViewById(R.id.btnXemAPI);
    }


}
