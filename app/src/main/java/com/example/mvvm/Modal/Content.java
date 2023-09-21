package com.example.mvvm.Modal;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Content implements Parcelable {
    protected Content(Parcel in) {
    }

    public static final Creator<Content> CREATOR = new Creator<Content>() {
        @Override
        public Content createFromParcel(Parcel in) {
            return new Content(in);
        }

        @Override
        public Content[] newArray(int size) {
            return new Content[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
    }
}
