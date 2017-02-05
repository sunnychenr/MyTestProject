package com.lionmobi.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by ChenR on 2017/1/25.
 */

public class UserAccount implements Serializable, Parcelable {

    private static final long SerialVerisionUID = 100000L;

    private Integer userId;
    private String userName;
    private Long userPwd;

    public UserAccount(Integer userId, String userName, Long userPwd) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public Long getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(Long userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (dest != null) {
            synchronized (dest) {
                dest.writeInt(userId);
                dest.writeString(userName);
                dest.writeLong(userPwd);
            }
        }
    }

    public static final Parcelable.Creator<UserAccount> CREATOR = new Creator<UserAccount>() {
        @Override
        public UserAccount createFromParcel(Parcel source) {
            int id = source.readInt();
            String name = source.readString();
            long pwd = source.readLong();
            return new UserAccount(id, name, pwd);
        }

        @Override
        public UserAccount[] newArray(int size) {
            return new UserAccount[size];
        }
    };
}
