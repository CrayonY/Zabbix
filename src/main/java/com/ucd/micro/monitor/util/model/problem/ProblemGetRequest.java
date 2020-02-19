package com.ucd.micro.monitor.util.model.problem;

import com.zabbix4j.GetRequestCommonParams;
import com.zabbix4j.ZabbixApiRequest;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ProblemGetRequest
 * @Description: TODO
 * @Author: gongweimin
 * @CreateDate: 2020/1/12 17:12
 * @Version 1.0
 * @Copyright: Copyright2018-2020 BJCJ Inc. All rights reserved.
 **/
@Data
public class ProblemGetRequest extends ZabbixApiRequest {
    private Params params = new Params();

    public ProblemGetRequest() {
        this.setMethod("problem.get");
    }

    public Params getParams() {
        return this.params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public class Params extends GetRequestCommonParams {
        private List<Integer> eventids;
        private List<Integer> groupids;
        private List<Integer> objectids;
        private List<Integer> hostids;
        private List<Integer> applicationids;
        private List<Integer> severities;
        private List<Object> tags;
        private Integer source;
        private Integer object;
        private Boolean acknowledged;
        private Boolean suppressed;
        private Integer evaltype;
        private Boolean recent;
        private String eventid_from;
        private String eventid_till;
        private String time_from;
        private String time_till;
        private String selectAcknowledges;
        private String selectTags;
        private String selectSuppressionData;

        public Params() {
        }

        public List<Integer> getEventids() {
            return eventids;
        }

        public void setEventids(List<Integer> eventids) {
            this.eventids = eventids;
        }

        public List<Integer> getGroupids() {
            return groupids;
        }

        public void setGroupids(List<Integer> groupids) {
            this.groupids = groupids;
        }

        public List<Integer> getObjectids() {
            return objectids;
        }

        public void setObjectids(List<Integer> objectids) {
            this.objectids = objectids;
        }

        public List<Integer> getHostids() {
            return hostids;
        }

        public void setHostids(List<Integer> hostids) {
            this.hostids = hostids;
        }

        public List<Integer> getApplicationids() {
            return applicationids;
        }

        public void setApplicationids(List<Integer> applicationids) {
            this.applicationids = applicationids;
        }

        public List<Integer> getSeverities() {
            return severities;
        }

        public void setSeverities(List<Integer> severities) {
            this.severities = severities;
        }

        public List<Object> getTags() {
            return tags;
        }

        public void setTags(List<Object> tags) {
            this.tags = tags;
        }

        public Integer getSource() {
            return source;
        }

        public void setSource(Integer source) {
            this.source = source;
        }

        public Integer getObject() {
            return object;
        }

        public void setObject(Integer object) {
            this.object = object;
        }

        public Boolean getAcknowledged() {
            return acknowledged;
        }

        public void setAcknowledged(Boolean acknowledged) {
            this.acknowledged = acknowledged;
        }

        public Boolean getSuppressed() {
            return suppressed;
        }

        public void setSuppressed(Boolean suppressed) {
            this.suppressed = suppressed;
        }

        public Integer getEvaltype() {
            return evaltype;
        }

        public void setEvaltype(Integer evaltype) {
            this.evaltype = evaltype;
        }

        public Boolean getRecent() {
            return recent;
        }

        public void setRecent(Boolean recent) {
            this.recent = recent;
        }

        public String getEventid_from() {
            return eventid_from;
        }

        public void setEventid_from(String eventid_from) {
            this.eventid_from = eventid_from;
        }

        public String getEventid_till() {
            return eventid_till;
        }

        public void setEventid_till(String eventid_till) {
            this.eventid_till = eventid_till;
        }

        public String getTime_from() {
            return time_from;
        }

        public void setTime_from(String time_from) {
            this.time_from = time_from;
        }

        public String getTime_till() {
            return time_till;
        }

        public void setTime_till(String time_till) {
            this.time_till = time_till;
        }

        public String getSelectAcknowledges() {
            return selectAcknowledges;
        }

        public void setSelectAcknowledges(String selectAcknowledges) {
            this.selectAcknowledges = selectAcknowledges;
        }

        public String getSelectTags() {
            return selectTags;
        }

        public void setSelectTags(String selectTags) {
            this.selectTags = selectTags;
        }

        public String getSelectSuppressionData() {
            return selectSuppressionData;
        }

        public void setSelectSuppressionData(String selectSuppressionData) {
            this.selectSuppressionData = selectSuppressionData;
        }

        @Override
        public String toString() {
            return "Params{" +
                    "eventids=" + eventids +
                    ", groupids=" + groupids +
                    ", objectids=" + objectids +
                    ", hostids=" + hostids +
                    ", applicationids=" + applicationids +
                    ", severities=" + severities +
                    ", tags=" + tags +
                    ", source=" + source +
                    ", object=" + object +
                    ", acknowledged=" + acknowledged +
                    ", suppressed=" + suppressed +
                    ", evaltype=" + evaltype +
                    ", recent=" + recent +
                    ", eventid_from='" + eventid_from + '\'' +
                    ", eventid_till='" + eventid_till + '\'' +
                    ", time_from='" + time_from + '\'' +
                    ", time_till='" + time_till + '\'' +
                    ", selectAcknowledges='" + selectAcknowledges + '\'' +
                    ", selectTags='" + selectTags + '\'' +
                    ", selectSuppressionData='" + selectSuppressionData + '\'' +
                    '}';
        }
    }

}
