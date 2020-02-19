package com.ucd.micro.monitor.util.model.problem;

import lombok.Data;

/**
 * @ClassName: ProblemObject
 * @Description: TODO
 * @Author: gongweimin
 * @CreateDate: 2020/1/12 17:12
 * @Version 1.0
 * @Copyright: Copyright2018-2020 BJCJ Inc. All rights reserved.
 **/
@Data
public class ProblemObject {
    private String eventid;
    private String source;
    private String object;
    private String objectid;
    private String clock;
    private String ns;
    private String r_eventid;
    private String r_clock;
    private String r_ns;
    private String correlationid;
    private String userid;
    private String name;
    private String acknowledged;
    private String severity;

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getObjectid() {
        return objectid;
    }

    public void setObjectid(String objectid) {
        this.objectid = objectid;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public String getR_eventid() {
        return r_eventid;
    }

    public void setR_eventid(String r_eventid) {
        this.r_eventid = r_eventid;
    }

    public String getR_clock() {
        return r_clock;
    }

    public void setR_clock(String r_clock) {
        this.r_clock = r_clock;
    }

    public String getR_ns() {
        return r_ns;
    }

    public void setR_ns(String r_ns) {
        this.r_ns = r_ns;
    }

    public String getCorrelationid() {
        return correlationid;
    }

    public void setCorrelationid(String correlationid) {
        this.correlationid = correlationid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcknowledged() {
        return acknowledged;
    }

    public void setAcknowledged(String acknowledged) {
        this.acknowledged = acknowledged;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}
