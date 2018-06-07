package com.example.gmt_006.example.Module;

import android.util.Log;

import com.example.gmt_006.example.ServerUtil.APIUtil;
import com.example.gmt_006.example.ServerUtil.GuiYeuCauServer;
import com.example.gmt_006.example.View.RigisterActivity;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModuleCreateAccount {
    InterfaceCreateAccount interfaceCreateAccount;

    public ModuleCreateAccount(InterfaceCreateAccount interfaceCreateAccount){
        this.interfaceCreateAccount = interfaceCreateAccount;
    }
    public void Rigister(final String username, final String password,final String img){
        if(username.length()>0 && password.length()>0 && RigisterActivity.passwordagain.equals(password.toString()) ){
                    File file = new File(img);
//                    String file_path = file.getAbsolutePath();
                    String    duongdan =file.getAbsolutePath();
                    String[] mangtenfile = duongdan.split("\\.");

                    duongdan = mangtenfile[0] + System.currentTimeMillis()+"."+mangtenfile[1];
                    Log.d("BBB",duongdan);
                    RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form"),file);

                    MultipartBody.Part body = MultipartBody.Part.createFormData("upload_file",duongdan,requestBody);
                    GuiYeuCauServer dataClient = APIUtil.getData();
                    final Call<String> callback = dataClient.UploadPhoto(body);
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String message = response.body();
                            Log.d("Server",message);
                            if(message.length()>0){
                                GuiYeuCauServer createuserClient = APIUtil.getData();
                                Call<String> callbackcreateuser = createuserClient.InsertData(username,password,APIUtil.url_base+"image/"+message);
                                callbackcreateuser.enqueue(new Callback<String>() {
                                    @Override
                                    public void onResponse(Call<String> call, Response<String> response) {
                                        String result = response.body();
                                        if(result.equals("Success")){
                                            interfaceCreateAccount.RigisterSuccess();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<String> call, Throwable t) {
                                            interfaceCreateAccount.RigisterFailed();
                                    }
                                });

                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Log.d("server",t.getMessage());
                            interfaceCreateAccount.RigisterFailed();
                        }
                    });
                }else{
                        interfaceCreateAccount.RigisterFailed();
                }

        }





}
