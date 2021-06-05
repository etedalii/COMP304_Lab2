package com.example.mohammadetedali_comp304sec1_lab2;
/*
    Author: Mohammad Etedali - 301056465
    Code updated: June 2021
    Course: 304 Sec 001
    Date: 6 June 2021
    https://developer.android.com/reference/android/os/Parcelable
 */

import android.os.Parcel;
import android.os.Parcelable;
//This the pizza entity that keep the name, type, dough, and size of pizza
public class Pizza implements Parcelable {
    public Pizza() {
    }

    // I use parcelable for transfer data between the activity
    // I found in developer.android link https://developer.android.com/reference/android/os/Parcelable
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Pizza createFromParcel(Parcel in) {
            return new Pizza(in);
        }

        public Pizza[] newArray(int size) {
            return new Pizza[size];
        }
    };

    private int price;
    private String name;
    private String type;
    private String dough;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Parcelling part
    public Pizza(Parcel in) {
        this.price = in.readInt();
        this.name = in.readString();
        this.type = in.readString();
        this.dough = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }
//this event is related to the parcelable
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.price);
        dest.writeString(this.name);
        dest.writeString(this.type);
        dest.writeString(this.dough);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    //I use this section when I want to show data in list view
    @Override
    public String toString() {
        return "Price= $ " + price +
                "   Name= " + name + " " +  type  + " " +  dough ;
    }
}
