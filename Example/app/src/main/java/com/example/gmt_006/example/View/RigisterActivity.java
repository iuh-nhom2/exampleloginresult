package com.example.gmt_006.example.View;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gmt_006.example.R;
import com.example.gmt_006.example.ViewRigiter;
import com.example.gmt_006.example.Presenter.PresenterCreateAcount;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class RigisterActivity extends AppCompatActivity implements ViewRigiter{
    Button btnregister;
    EditText username,password;
    public static EditText passwordagain;
    ImageView imgregister;
    int Request_Code_Image = 123;
    String realpath="";
    String userid="",matkhau="";
    PresenterCreateAcount presenterCreateAcount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigister);
        Anhxa();
        presenterCreateAcount = new PresenterCreateAcount(this);
        imgregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,Request_Code_Image);
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userid = username.getText().toString();
                matkhau = password.getText().toString();
//                File file = new File(realpath);
////                    String file_path = file.getAbsolutePath();
////                    String[] mangtenfile = file_path.split("\\.");
////
////                    file_path = mangtenfile[0] + System.currentTimeMillis()+"."+mangtenfile[1];
////                    Log.d("BBB",file_path);
                presenterCreateAcount.RequestRigiter(userid,matkhau,realpath);
//                if(userid.length()>0 && matkhau.length()>0 && matkhau.equals(passwordagain.getText().toString())){
//                    File file = new File(realpath);
//                    String file_path = file.getAbsolutePath();
//                    String[] mangtenfile = file_path.split("\\.");
//
//                    file_path = mangtenfile[0] + System.currentTimeMillis()+"."+mangtenfile[1];
//                    Log.d("BBB",file_path);
//                    RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form"),file);
//
//                    MultipartBody.Part body = MultipartBody.Part.createFormData("upload_file",file_path,requestBody);
//                    GuiYeuCauServer dataClient = APIUtil.getData();
//                    final Call<String> callback = dataClient.UploadPhoto(body);
//                    callback.enqueue(new Callback<String>() {
//                        @Override
//                        public void onResponse(Call<String> call, Response<String> response) {
//                            String message = response.body();
//                            Log.d("Server",message);
//                            if(message.length()>0){
//                                GuiYeuCauServer createuserClient = APIUtil.getData();
//                                Call<String> callbackcreateuser = createuserClient.InsertData(userid,matkhau,APIUtil.url_base+"image/"+message);
//                                callbackcreateuser.enqueue(new Callback<String>() {
//                                    @Override
//                                    public void onResponse(Call<String> call, Response<String> response) {
//                                        String result = response.body();
//                                        if(result.equals("Success")){
//                                            Toast.makeText(RigisterActivity.this,"Create account Success",Toast.LENGTH_LONG).show();
//                                            finish();
//                                        }
//                                    }
//
//                                    @Override
//                                    public void onFailure(Call<String> call, Throwable t) {
//
//                                    }
//                                });
//
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<String> call, Throwable t) {
//                            Log.d("server",t.getMessage());
//                        }
//                    });
//                }else{
//                    Toast.makeText(RigisterActivity.this,"you enter not enought username and password",Toast.LENGTH_LONG).show();
//                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Request_Code_Image && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            realpath = getRealPathFromURI(uri);
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgregister.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public String getRealPathFromURI(Uri contentURI){
        String path = null;
        String[] proj = {MediaStore.MediaColumns.DATA};
        Cursor cursor = getContentResolver().query(contentURI,proj,null,null,null);
        if(cursor.moveToFirst()){
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            path = cursor.getString(column_index);

        }
        cursor.close();
        return  path;
    }

    private void Anhxa() {
        btnregister = findViewById(R.id.btnregister);
        username = findViewById(R.id.edtuserid);
        password = findViewById(R.id.edtpasswordregistion);
        passwordagain = findViewById(R.id.edtpasswordregistionagain);
        imgregister = findViewById(R.id.imgregistion);

    }

    @Override
    public void RigisterSuccess() {
        finish();
        Toast.makeText(RigisterActivity.this,"Create an account success",Toast.LENGTH_LONG).show();
    }

    @Override
    public void RigisterFailed() {

        Toast.makeText(RigisterActivity.this,"Create an account failed",Toast.LENGTH_LONG).show();

    }
}
