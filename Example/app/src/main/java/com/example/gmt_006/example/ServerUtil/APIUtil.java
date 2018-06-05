package com.example.gmt_006.example.ServerUtil;

import com.example.gmt_006.example.ServerUtil.GuiYeuCauServer;
import com.example.gmt_006.example.ServerUtil.RetrofitClient;

public class APIUtil {
    public static String url_base = "http://172.16.1.15/examplelogin/";
    public static GuiYeuCauServer getData (){
        return RetrofitClient.getClient(url_base).create(GuiYeuCauServer.class);
    }
}
