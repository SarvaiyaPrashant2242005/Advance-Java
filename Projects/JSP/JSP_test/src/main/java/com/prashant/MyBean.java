package com.prashant;

import java.io.Serializable;

public class MyBean implements Serializable {
    private String msg= "null";

    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg){
        this.msg=msg;
}

}