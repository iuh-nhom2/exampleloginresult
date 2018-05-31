package com.example.gmt_006.example.resenter;

public class APIUtil {
    public static String url_base = "http://172.16.1.15/examplelogin/";
    public static GuiYeuCauServer getData (){
        return RetrofitClient.getClient(url_base).create(GuiYeuCauServer.class);
    }
}
