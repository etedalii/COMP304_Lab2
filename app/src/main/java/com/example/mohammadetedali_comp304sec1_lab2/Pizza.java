package com.example.mohammadetedali_comp304sec1_lab2;

import android.os.Parcel;
import android.os.Parcelable;

public class Pizza implements Parcelable {
    public Pizza() {
    }

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

    @Override
    public String toString() {
        return "Price= $ " + price +
                "   Name= " + name + " " +  type  + " " +  dough ;
    }
}
