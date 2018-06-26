package com.jsecode.androidmvp.entities;


import com.jsecode.androidmvp.utils.GsonUtils;

public class BaseResponse {
    /**
     * cmd : demo
     * result : 0
     * resultNote : Success
     */

    private String cmd;
    private int result = -1;
    private String note;

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getCmd() {
        return cmd;
    }

    public int getResult() {
        return result;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean success() {
        return getResult() == 1;
    }

    @Override
    public String toString() {
        return GsonUtils.toJson(this);
    }
}
