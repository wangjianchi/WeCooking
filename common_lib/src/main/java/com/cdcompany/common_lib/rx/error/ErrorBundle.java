package com.cdcompany.common_lib.rx.error;

/**
 * Created by wukewei on 16/8/17.
 */
public interface ErrorBundle {
    Exception getException();
    String getErrorMessage();
}
