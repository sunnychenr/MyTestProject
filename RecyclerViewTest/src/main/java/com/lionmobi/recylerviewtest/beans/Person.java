package com.lionmobi.recylerviewtest.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by ChenR on 2017/2/6.
 */
public class Person implements Serializable, Parcelable{

    private static final long SerialVerisionUID = 100000L;

    private Integer id;
    private Integer age;
    private Integer tag;
    private String name;
    private String native_place;
    private Boolean six;

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(Integer id, Integer age, PersonTag tag, String name, String native_place, Boolean six) {
        this.id = id;
        this.age = age;
        this.tag = tag.ordinal();
        this.name = name;
        this.native_place = native_place;
        this.six = six;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (dest != null) {
            synchronized (dest) {
                dest.writeInt(id);
                dest.writeInt(tag);
                dest.writeInt(age);
                dest.writeInt((six) ? 0 : 1);
                dest.writeString(name);
                dest.writeString(native_place);
            }
        }
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            Integer id = in.readInt();
            Integer tag = in.readInt();
            Integer age = in.readInt();
            Boolean six = in.readInt() == 0 ? true : false;
            String name = in.readString();
            String native_place = in.readString();
            PersonTag mPersonTag = (tag == 0) ? PersonTag.PUBLIC_PERSON : PersonTag.PRIVATE_PERSON;
            return new Person(id, age, mPersonTag, name, native_place, six);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public Boolean getSix() {
        return six;
    }

    public void setSix(Boolean six) {
        this.six = six;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public static enum PersonTag {
        PUBLIC_PERSON,
        PRIVATE_PERSON
    }
}
