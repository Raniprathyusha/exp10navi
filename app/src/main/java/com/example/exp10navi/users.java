package com.example.exp10navi;

public class users {
    private String pid, pname, items, type, vendor;

    public users(String pid, String pname, String items, String type, String vendor) {
        this.pid = pid;
        this.pname = pname;
        this.items = items;
        this.type = type;
        this.vendor = vendor;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
