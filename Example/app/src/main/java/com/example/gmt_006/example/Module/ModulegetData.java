package com.example.gmt_006.example.Module;

import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gmt_006.example.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ModulegetData {
    public static void getData(TextView username, TextView password, ImageView images, ArrayList<User> manguser){
        Log.d("User:",manguser.get(0).getTaikhoan());
        Log.d("Password",manguser.get(0).getMatkhau());
        Log.d("Hinh:",manguser.get(0).getHinh());



        username.setText(manguser.get(0).getTaikhoan());
        password.setText(manguser.get(0).getMatkhau());
        Picasso.get().load(manguser.get(0).getHinh()).into(images);


    }
}
