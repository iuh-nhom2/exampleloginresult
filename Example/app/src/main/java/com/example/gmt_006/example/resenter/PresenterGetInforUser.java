package com.example.gmt_006.example.resenter;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.gmt_006.example.Module.InterfaceCreateAccount;
import com.example.gmt_006.example.Module.ModulegetData;
import com.example.gmt_006.example.User;
import com.example.gmt_006.example.ViewProFile;
import com.example.gmt_006.example.ViewRigiter;

import java.util.ArrayList;

public class PresenterGetInforUser {
    private ModulegetData modulegetData;
    private ViewRigiter viewRigiter;

    public void GetInforUserRequest(TextView user, TextView pass, ImageView img, ArrayList<User> mang){

        modulegetData.getData(user,pass,img,mang);

    }


}
