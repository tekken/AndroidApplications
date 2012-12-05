package com.example.androidapplicationtest;

import android.os.Parcel;
import android.os.Parcelable;

public class Address implements Parcelable{
	String street;
	String city;
	String pincode;
	
	public Address() {
		
	}

	public Address(Parcel source) {
		street=source.readString();
		city=source.readString();
		pincode=source.readString();
		
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public static final Parcelable.Creator<Address> CREATOR=new Parcelable.Creator<Address>() {

		@Override
		public Address createFromParcel(Parcel source) {
			return new Address(source);
		}

		@Override
		public Address[] newArray(int size) {
			return new Address[size];
		}
	
	};
	
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(street);
		dest.writeString(city);
		dest.writeString(pincode);		
	}
}
