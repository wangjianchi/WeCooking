package com.cdcompany.common_lib.rx;

/**
 * Created by wukewei on 16/5/26.
 */
public class ApiResponse<T> {

    public static final int SUCCESS_CODE = 0;

    private int error_code;
    private String reason;
    private T result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean isSuccess() {
        if (this.error_code == SUCCESS_CODE) {
            return true;
        } else {
            return false;
        }
    }
}
