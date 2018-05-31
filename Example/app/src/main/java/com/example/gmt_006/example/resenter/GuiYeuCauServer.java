package com.example.gmt_006.example.resenter;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface GuiYeuCauServer {
    @Multipart
    @POST("uploadhinh.php")
    Call<String> UploadPhoto(@Part MultipartBody.Part photo);

    //createuser
    @FormUrlEncoded
    @POST("createuser.php")
    Call<String> InsertData (@Field("username") String taikhoan,
                             @Field("password") String matkhau,
                             @Field("image") String hinhanh);

}
