package com.jsecode.androidmvp.bean;

/**
 * Created by liuzhenghao on 2018/3/18.
 */

public class UpdatePatch {
    private int fileSize;
    private String patchUrl;
    private String fromVersion;
    private int toVersion;

    public int getFileSize() {
        return fileSize;
    }

    public UpdatePatch setFileSize(int fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    public String getPatchUrl() {
        return patchUrl;
    }

    public UpdatePatch setPatchUrl(String patchUrl) {
        this.patchUrl = patchUrl;
        return this;
    }

    public String getFromVersion() {
        return fromVersion;
    }

    public UpdatePatch setFromVersion(String fromVersion) {
        this.fromVersion = fromVersion;
        return this;
    }

    public int getToVersion() {
        return toVersion;
    }

    public UpdatePatch setToVersion(int toVersion) {
        this.toVersion = toVersion;
        return this;
    }
}
