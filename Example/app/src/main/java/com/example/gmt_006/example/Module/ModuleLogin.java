package com.example.gmt_006.example.Module;

import android.util.Log;

import com.example.gmt_006.example.User;
import com.example.gmt_006.example.View.MainActivity;
import com.example.gmt_006.example.ServerUtil.APIUtil;
import com.example.gmt_006.example.ServerUtil.GuiYeuCauServer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class ModuleLogin {
    InterfaceLoginRequest interfaceLoginRequest;

    public  ModuleLogin(InterfaceLoginRequest interfaceLoginRequest){
            this.interfaceLoginRequest = interfaceLoginRequest;
    }
    public  void login(String user, String password){
        if(user.length()>0 && password.length()>0){
            GuiYeuCauServer dataClient = APIUtil.getData();
            retrofit2.Call<List<User>> callbacklogin = dataClient.getUserloginData(user,password);
            callbacklogin.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(retrofit2.Call<List<User>> call, Response<List<User>> response) {
                    MainActivity.manguerlogin = (ArrayList<User>) response.body();
                    if(MainActivity.manguerlogin.size()>0){
                        Log.d("LogUser: ",MainActivity.manguerlogin.get(0).getTaikhoan());
                        Log.d("LogPassword",MainActivity.manguerlogin.get(0).getMatkhau());
                        Log.d("LogImage:", MainActivity.manguerlogin.get(0).getHinh());
                        interfaceLoginRequest.LoginSuccess();
                    }
                }

                @Override
                public void onFailure(retrofit2.Call<List<User>> call, Throwable t) {
                    interfaceLoginRequest.LoginFailded();
                }
            });
        }else {

            interfaceLoginRequest.LoginFailded();
        }

    }
}
