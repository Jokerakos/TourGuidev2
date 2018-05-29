package com.example.teo_j.tourguidev2;

import android.os.Parcel;
import android.os.Parcelable;

public class Sight implements Parcelable {

    private int mSightImage;
    private int mSightTitle;
    private int mSightCategory;
    private int mSightShortDesc;
    private int mSightDesc;
    private int mSightLocation;
    private int mSightWeb;


    public Sight(int sightImage, int sightTitle, int sightShortDesc, int sightCategory, int sightDesc, int sightLocation, int sightWeb) {

        mSightImage = sightImage;
        mSightTitle = sightTitle;
        mSightCategory = sightCategory;
        mSightShortDesc = sightShortDesc;
        mSightDesc = sightDesc;
        mSightLocation = sightLocation;
        mSightWeb = sightWeb;


    }


    public int getSightImage() {
        return mSightImage;
    }

    public int getSightTitle() {
        return mSightTitle;
    }

    public int getSightCategory() {
        return mSightCategory;
    }

    public int getSightShortDesc() {
        return mSightShortDesc;
    }

    public int getSightDesc() {
        return mSightDesc;
    }

    public int getSightLocation() {
        return mSightLocation;
    }

    public int getmSightWeb() {
        return mSightWeb;
    }

    protected Sight(Parcel in) {
        mSightImage = in.readInt();
        mSightTitle = in.readInt();
        mSightCategory = in.readInt();
        mSightShortDesc = in.readInt();
        mSightDesc = in.readInt();
        mSightLocation = in.readInt();
        mSightWeb = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mSightImage);
        dest.writeInt(mSightTitle);

        dest.writeInt(mSightCategory);
        dest.writeInt(mSightShortDesc);
        dest.writeInt(mSightDesc);
        dest.writeInt(mSightLocation);
        dest.writeInt(mSightWeb);

    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Sight> CREATOR = new Parcelable.Creator<Sight>() {
        @Override
        public Sight createFromParcel(Parcel in) {
            return new Sight(in);
        }

        @Override
        public Sight[] newArray(int size) {
            return new Sight[size];
        }
    };
}
