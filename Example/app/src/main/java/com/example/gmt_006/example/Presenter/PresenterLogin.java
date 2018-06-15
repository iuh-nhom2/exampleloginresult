package com.example.gmt_006.example.Presenter;

import com.example.gmt_006.example.Module.InterfaceLoginRequest;
import com.example.gmt_006.example.Module.ModuleLogin;
import com.example.gmt_006.example.ViewLogin;

public class PresenterLogin implements InterfaceLoginRequest {

    private  ModuleLogin moduleLogin;
    private ViewLogin viewLogin;
    public  PresenterLogin(ViewLogin viewLogin){
        this.viewLogin =viewLogin;
    }
    public  void RequestLogin(String user, String password){
            // thông báo cho model biết để xử lý logic
            moduleLogin = new ModuleLogin(this);
            moduleLogin.login(user,password);


    }



    @Override
    public void LoginSuccess() {
        viewLogin.LoginSuccess();
    }

    @Override
    public void LoginFailded() {
        viewLogin.LoginFailed();
    }
}
