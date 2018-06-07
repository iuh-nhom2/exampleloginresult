package com.example.gmt_006.example.Module;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.gmt_006.example.Adapter.ApiAdapter;
import com.example.gmt_006.example.Model.API;
import com.example.gmt_006.example.ServerUtil.APIUtil;
import com.example.gmt_006.example.ServerUtil.CheckConnection;
import com.example.gmt_006.example.ServerUtil.GuiYeuCauServer;
import com.example.gmt_006.example.View.ApiActivity;
import com.example.gmt_006.example.View.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ModuleGetAPI {
        public void GETlistapi(final RecyclerView recyclerView, final Context context){
            GuiYeuCauServer dataclient = APIUtil.getData();
            Call<List<API>> callapi = dataclient.getAPIData();
            callapi.enqueue(new Callback<List<API>>() {
                @Override
                public void onResponse(Call<List<API>> call, retrofit2.Response<List<API>> response) {
                    ApiActivity.mangapi  = (ArrayList<API>) response.body();

                    Toast.makeText(context,response.body().toString(),Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<List<API>> call, Throwable t) {

                }
            });
        }
}
