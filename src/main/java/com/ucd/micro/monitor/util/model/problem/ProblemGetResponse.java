package com.ucd.micro.monitor.util.model.problem;

import com.zabbix4j.ZabbixApiResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ProblemGetResponse
 * @Description: TODO
 * @Author: gongweimin
 * @CreateDate: 2020/1/12 17:12
 * @Version 1.0
 * @Copyright: Copyright2018-2020 BJCJ Inc. All rights reserved.
 **/
@Data
public class ProblemGetResponse extends ZabbixApiResponse {
    private List<Result> result = new ArrayList();

    public ProblemGetResponse() {
    }

    public List<Result> getResult() {
        return this.result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public class Result extends ProblemObject {
        private List<ProblemObject> problemObjectList;
        private List<AcknowledgesObject> acknowledgesObjectList;
        private List<TagsObject> tagsObjectList;
        private List<SuppressionDataObject> suppressionDataObjectList;

        public Result() {
        }

        public List<ProblemObject> getProblemObjectList() {
            return problemObjectList;
        }

        public void setProblemObjectList(List<ProblemObject> problemObjectList) {
            this.problemObjectList = problemObjectList;
        }

        public List<AcknowledgesObject> getAcknowledgesObjectList() {
            return acknowledgesObjectList;
        }

        public void setAcknowledgesObjectList(List<AcknowledgesObject> acknowledgesObjectList) {
            this.acknowledgesObjectList = acknowledgesObjectList;
        }

        public List<TagsObject> getTagsObjectList() {
            return tagsObjectList;
        }

        public void setTagsObjectList(List<TagsObject> tagsObjectList) {
            this.tagsObjectList = tagsObjectList;
        }

        public List<SuppressionDataObject> getSuppressionDataObjectList() {
            return suppressionDataObjectList;
        }

        public void setSuppressionDataObjectList(List<SuppressionDataObject> suppressionDataObjectList) {
            this.suppressionDataObjectList = suppressionDataObjectList;
        }
    }
}
