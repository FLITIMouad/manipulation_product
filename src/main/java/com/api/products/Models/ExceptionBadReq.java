package com.api.products.Models;

public class ExceptionBadReq extends Exception {

    public ExceptionBadReq() {
    }

    public ExceptionBadReq(String arg0) {
        super(arg0);
    }

    public ExceptionBadReq(Throwable arg0) {
        super(arg0);
    }

    public ExceptionBadReq(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public ExceptionBadReq(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }
    
}
