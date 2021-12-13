package com.udacity.jwdnd.course1.cloudstorage.model;

public class Credential
{
    private String url;
    private String username;
    private String password;
    private Integer credentialid;
    private String userid;

    public Credential(String url, String username, String password, Integer credentialid, String userid) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.credentialid = credentialid;
        this.userid = userid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCredentialid() {
        return credentialid;
    }

    public void setCredentialid(Integer credentialid) {
        this.credentialid = credentialid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
