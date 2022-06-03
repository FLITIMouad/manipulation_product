package com.api.products.Models;

public class ExceptionDuplicate extends Exception {

    public ExceptionDuplicate() {
    }

    public ExceptionDuplicate(String arg0) {
        super(arg0);
    }

    public ExceptionDuplicate(Throwable arg0) {
        super(arg0);
    }

    public ExceptionDuplicate(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public ExceptionDuplicate(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }
    
}
