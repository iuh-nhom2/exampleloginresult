package com.example.gmt_006.example.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.gmt_006.example.Adapter.ApiAdapter;
import com.example.gmt_006.example.Module.ModuleGetAPI;

public class PresenterGetApi {
    ModuleGetAPI moduleGetAPI;

    public void RequestgetAPI(RecyclerView recyclerView, ApiAdapter apiAdapter){
//        moduleGetAPI = new ModuleGetAPI();
//        moduleGetAPI.GETlistapi(recyclerView,context);
        moduleGetAPI = new ModuleGetAPI();
        moduleGetAPI.GETlistapi(recyclerView,apiAdapter);
    }
}
