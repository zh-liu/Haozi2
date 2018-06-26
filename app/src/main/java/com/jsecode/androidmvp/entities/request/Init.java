package com.jsecode.androidmvp.entities.request;


import com.jsecode.androidmvp.entities.BaseRequest;

public class Init extends BaseRequest {
    private String deviceId;
    private String imsi;
    private String model;
    private String phoneNumber;
    private String sdkVersion;
    private int sdkInt;
    private String versionName;
    private int versionCode;
    private String pushToken;

    public Init(String deviceId, String imsi, String model, String phoneNumber, String sdkVersion, int sdkInt, String versionName, int versionCode) {
        this.deviceId = deviceId;
        this.imsi = imsi;
        this.model = model;
        this.phoneNumber = phoneNumber;
        this.sdkVersion = sdkVersion;
        this.sdkInt = sdkInt;
        this.versionName = versionName;
        this.versionCode = versionCode;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public int getSdkInt() {
        return sdkInt;
    }

    public void setSdkInt(int sdkInt) {
        this.sdkInt = sdkInt;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getPushId() {
        return pushToken;
    }

    public Init setPushId(String pushId) {
        this.pushToken = pushId;
        return this;
    }
}
