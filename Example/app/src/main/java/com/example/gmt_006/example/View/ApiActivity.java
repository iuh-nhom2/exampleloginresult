package com.example.gmt_006.example.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
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
import com.example.gmt_006.example.Model.APILIST;
import com.example.gmt_006.example.Model.User;
import com.example.gmt_006.example.Presenter.PresenterGetApi;
import com.example.gmt_006.example.R;
import com.example.gmt_006.example.ServerUtil.APIUtil;
import com.example.gmt_006.example.ServerUtil.CheckConnection;
import com.example.gmt_006.example.ServerUtil.GuiYeuCauServer;
import com.example.gmt_006.example.ServerUtil.RetrofitClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class ApiActivity extends AppCompatActivity {
    RecyclerView recyclerViewapi;
   public static ApiAdapter apiAdapter;
   public static ArrayList<API> mangapi;
    PresenterGetApi presenterGetApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        Anhxa();
        if(CheckConnection.haveNetWorkConnection(getApplicationContext())){
            GetAPI();
        }else{
            CheckConnection.thongbao(getApplicationContext(),"The internet not connected");
            finish();
        }

    }

    private void GetAPI() {

        presenterGetApi = new PresenterGetApi();
        presenterGetApi.RequestgetAPI(recyclerViewapi,getApplicationContext());





//        GuiYeuCauServer guiYeuCauServer = APIUtil.getData();
//         Call<List<API>> callbackAPI = guiYeuCauServer.getAPIData();
//         Toast.makeText(ApiActivity.this,callbackAPI.toString(),Toast.LENGTH_LONG).show();
//            callbackAPI.enqueue(new Callback<List<API>>() {
//                @Override
//                public void onResponse(Call<List<API>> call, retrofit2.Response<List<API>> response) {
//                    mangapi = (ArrayList<API>) response.body();
//                    apiAdapter = new ApiAdapter(getApplicationContext(),mangapi);
//                    apiAdapter.notifyDataSetChanged();
//                    recyclerViewapi.setAdapter(apiAdapter);
//
//                }
//
//                @Override
//                public void onFailure(Call<List<API>> call, Throwable t) {
//                    Toast.makeText(ApiActivity.this, t.getMessage(),Toast.LENGTH_LONG).show();
//                }
//            });




        //volley
//        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(APIUtil.url_base + "getAPI.php", new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                if(response != null){
//                    int Id=0;
//                    String nameapi ="";
//                    String hinhapi ="";
//                    for(int i=0;i<=response.length();i++){
//                        try {
//                            JSONObject jsonObject = response.getJSONObject(i);
//                            Id = jsonObject.getInt("id");
//                            nameapi = jsonObject.getString("apiname");
//                            hinhapi = jsonObject.getString("hinh");
//
//                            mangapi.add(new API(Id,nameapi,hinhapi));
//                            apiAdapter.notifyDataSetChanged();
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                CheckConnection.thongbao(getApplicationContext(),error.toString());
//            }
//        });
//        requestQueue.add(jsonArrayRequest);


    }

    private void Anhxa() {
        recyclerViewapi =(RecyclerView) findViewById(R.id.recyclerview);

        recyclerViewapi.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewapi.setHasFixedSize(true);
        recyclerViewapi.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

    }
}
