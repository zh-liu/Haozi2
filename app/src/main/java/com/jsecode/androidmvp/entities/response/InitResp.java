package com.jsecode.androidmvp.entities.response;


import com.jsecode.androidmvp.bean.UpdatePatch;
import com.jsecode.androidmvp.entities.BaseResponse;

public class InitResp extends BaseResponse {
    private int hostId;
    private String lpn;
    private String bindTime;
    private String operator;
    private String operatorId;
    private String operatorName;
    private long serverTimeMillis;

    private String serviceUrl;

    public String getServiceUrl() {
        return serviceUrl;
    }

    public InitResp setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
        return this;
    }


    private Update update;


    public int getGrabAwaitSeconds() {
        return grabAwaitSeconds;
    }

    public InitResp setGrabAwaitSeconds(int grabAwaitSeconds) {
        this.grabAwaitSeconds = grabAwaitSeconds;
        return this;
    }

    private int grabAwaitSeconds;


    public long getGetReportTime() {
        return getReportTime;
    }

    public InitResp setGetReportTime(long getReportTime) {
        this.getReportTime = getReportTime;
        return this;
    }

    public  long getReportTime = -1;//位置上传等待时间


    public Update getUpdate() {
        return update;
    }

    public InitResp setUpdate(Update update) {
        this.update = update;
        return this;
    }


    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public String getLpn() {
        return lpn;
    }

    public void setLpn(String lpn) {
        this.lpn = lpn;
    }

    public String getBindTime() {
        return bindTime;
    }

    public void setBindTime(String bindTime) {
        this.bindTime = bindTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }


    public long getServerTimeMillis() {
        return serverTimeMillis;
    }

    public InitResp setServerTimeMillis(long serverTimeMillis) {
        this.serverTimeMillis = serverTimeMillis;
        return this;
    }


    public static class Update {
        private int fileSize;
        private boolean isForce;
        private String apkUrl;
        private String updateNote;
        private int versionCode;
        private String version;
        private String md5;

        private UpdatePatch patch;


        public UpdatePatch getPatch() {
            return patch;
        }

        public Update setPatch(UpdatePatch patch) {
            this.patch = patch;
            return this;
        }

        public int getFileSize() {
            return fileSize;
        }

        public Update setFileSize(int fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        public String getMd5() {
            return md5;
        }

        public Update setMd5(String md5) {
            this.md5 = md5;
            return this;
        }

        public boolean isForce() {
            return isForce;
        }

        public Update setForce(boolean force) {
            isForce = force;
            return this;
        }

        public String getApkUrl() {
            return apkUrl;
        }

        public Update setApkUrl(String apkUrl) {
            this.apkUrl = apkUrl;
            return this;
        }

        public String getUpdateNote() {
            return updateNote;
        }

        public Update setUpdateNote(String updateNote) {
            this.updateNote = updateNote;
            return this;
        }

        public int getVersionCode() {
            return versionCode;
        }

        public Update setVersionCode(int versionCode) {
            this.versionCode = versionCode;
            return this;
        }

        public String getVersion() {
            return version;
        }

        public Update setVersion(String version) {
            this.version = version;
            return this;
        }
    }
}

