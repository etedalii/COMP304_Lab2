package com.example.mohammadetedali_comp304sec1_lab2;

import android.os.Parcel;
import android.os.Parcelable;

public class Customer implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

    public Customer() {

    }

    // Parcelling part
    public Customer(Parcel in) {
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.cardNumber = in.readString();
        this.expireDate = in.readString();
        this.paymentType = in.readString();

        this.fullName = in.readString();
        this.streetNumber = in.readString();
        this.city = in.readString();
        this.postalCode = in.readString();
        this.phoneNumber = in.readString();
        this.email = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.cardNumber);
        dest.writeString(this.expireDate);
        dest.writeString(this.paymentType);

        dest.writeString(this.fullName);
        dest.writeString(this.streetNumber);
        dest.writeString(this.city);
        dest.writeString(this.postalCode);
        dest.writeString(this.phoneNumber);
        dest.writeString(this.email);
    }

    private String firstName;
    private String lastName;
    private String cardNumber;
    private String expireDate;
    private String paymentType;
    private String fullName;
    private String streetNumber;
    private String city;
    private String postalCode;
    private String phoneNumber;
    private String email;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullAddress() {
        return streetNumber + " " + city +" " + postalCode;
    }
}
