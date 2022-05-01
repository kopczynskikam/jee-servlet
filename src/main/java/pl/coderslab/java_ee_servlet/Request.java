package pl.coderslab.java_ee_servlet;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private int id;
    private String userAgent;
    private String queryDateTime;
    private Map<String, String> allRequestParams;
    private long queryTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getQueryDateTime() {
        return queryDateTime;
    }

    public void setQueryDateTime(String queryDateTime) {
        this.queryDateTime = queryDateTime;
    }

    public Map<String, String> getAllRequestParams() {
        return allRequestParams;
    }

    public void setAllRequestParams(Map<String, String> allRequestParams) {
        this.allRequestParams = allRequestParams;
    }

    public long getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(long queryTime) {
        this.queryTime = queryTime;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", userAgent='" + userAgent + '\'' +
                ", queryDateTime='" + queryDateTime + '\'' +
                ", allRequestParams=" + allRequestParams +
                ", queryTime=" + queryTime +
                '}';
    }
}
