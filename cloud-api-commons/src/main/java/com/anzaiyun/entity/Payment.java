package com.anzaiyun.entity;

import java.io.Serializable;

public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    Integer l_id;
    String vc_serial;

    public Integer getL_id() {
        return l_id;
    }

    public void setL_id(Integer l_id) {
        this.l_id = l_id;
    }

    public String getVc_serial() {
        return vc_serial;
    }

    public void setVc_serial(String vc_serial) {
        this.vc_serial = vc_serial;
    }

    public Payment() {
    }

    public Payment(Integer l_id, String vc_serial) {
        this.l_id = l_id;
        this.vc_serial = vc_serial;
    }
}
