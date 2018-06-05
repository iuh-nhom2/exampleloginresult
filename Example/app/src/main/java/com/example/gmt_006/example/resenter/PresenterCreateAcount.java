package com.example.gmt_006.example.resenter;

import android.widget.ImageView;

import com.example.gmt_006.example.Module.InterfaceCreateAccount;
import com.example.gmt_006.example.Module.ModuleCreateAccount;
import com.example.gmt_006.example.ViewLogin;
import com.example.gmt_006.example.ViewRigiter;

public class PresenterCreateAcount implements InterfaceCreateAccount {
    private ModuleCreateAccount moduleCreateAccount;
    private ViewRigiter viewRigiter;
    public  PresenterCreateAcount( ViewRigiter viewRigiter){
        this.viewRigiter = viewRigiter;
    }
    public void RequestRigiter(String user, String password,String img){
        moduleCreateAccount = new ModuleCreateAccount(this);
        moduleCreateAccount.Rigister(user,password,img);

    }

    @Override
    public void RigisterSuccess() {
        viewRigiter.RigisterSuccess();
    }

    @Override
    public void RigisterFailed() {
        viewRigiter.RigisterFailed();
    }
}
