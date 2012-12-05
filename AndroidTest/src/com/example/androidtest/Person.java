package com.example.androidtest;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable{
	private String name;
	private String email;
	private String contact;
	private Address address;
	
	public Person() {
		
	}
	
	private Person(Parcel in){
		
		name=in.readString();
		email=in.readString();
		contact=in.readString();
		address=new Address();
		address=in.readParcelable(Address.class.getClassLoader());
	}
	
	public void setName(String strname) {
		this.name = strname;
	}

	public void setEmail(String stremail) {
		this.email = stremail;
	}

	public void setContact(String strcontact) {
		this.contact = strcontact;
	}


	public String getName() {
		return name;
	}

	public void setAddress(Address address) {
		this.address=address;
	}
	
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeString(contact);
		dest.writeString(email);
		dest.writeParcelable(address, flags);
	}
	
	
	public static final Parcelable.Creator<Person> CREATOR=new Parcelable.Creator<Person>() {

		@Override
		public Person createFromParcel(Parcel in) {
			return new Person(in);
		}

		@Override
		public Person[] newArray(int size) {
			return new Person[size];
		}
	};

	public Address getAddress() {
		return address;
	}
}