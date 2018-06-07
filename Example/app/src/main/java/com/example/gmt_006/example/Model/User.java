package com.example.gmt_006.example.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

@SerializedName("Id")
@Expose
private String id;
@SerializedName("Taikhoan")
@Expose
private String taikhoan;
@SerializedName("Matkhau")
@Expose
private String matkhau;
@SerializedName("Hinh")
@Expose
private String hinh;

    protected User(Parcel in) {
        id = in.readString();
        taikhoan = in.readString();
        matkhau = in.readString();
        hinh = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getTaikhoan() {
return taikhoan;
}

public void setTaikhoan(String taikhoan) {
this.taikhoan = taikhoan;
}

public String getMatkhau() {
return matkhau;
}

public void setMatkhau(String matkhau) {
this.matkhau = matkhau;
}

public String getHinh() {
return hinh;
}

public void setHinh(String hinh) {
this.hinh = hinh;
}

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(taikhoan);
        dest.writeString(matkhau);
        dest.writeString(hinh);
    }
}