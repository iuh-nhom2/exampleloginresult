package com.example.gmt_006.example.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class API implements Parcelable{

    @SerializedName("id")
    @Expose
    public int Id;
    @SerializedName("apiname")
    @Expose
    public String Name;
    @SerializedName("hinh")
    @Expose
    public String Image;

    public API(int id, String name, String image) {
        Id = id;
        Name = name;
        Image = image;
    }

    protected API(Parcel in) {
        Id = in.readInt();
        Name = in.readString();
        Image = in.readString();
    }

    public static final Creator<API> CREATOR = new Creator<API>() {
        @Override
        public API createFromParcel(Parcel in) {
            return new API(in);
        }

        @Override
        public API[] newArray(int size) {
            return new API[size];
        }
    };

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(Id);
            dest.writeString(Name);
            dest.writeString(Image);
    }
}
