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
public class AcknowledgesObject {
    private String acknowledgeid;
    private String eventid;
    private String clock;
    private String message;
    private String action;
    private String userid;
    private String old_severity;
    private String new_severity;


    public String getAcknowledgeid() {
        return acknowledgeid;
    }

    public void setAcknowledgeid(String acknowledgeid) {
        this.acknowledgeid = acknowledgeid;
    }

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getOld_severity() {
        return old_severity;
    }

    public void setOld_severity(String old_severity) {
        this.old_severity = old_severity;
    }

    public String getNew_severity() {
        return new_severity;
    }

    public void setNew_severity(String new_severity) {
        this.new_severity = new_severity;
    }
}
