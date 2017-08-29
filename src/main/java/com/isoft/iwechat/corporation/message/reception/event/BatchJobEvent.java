package com.isoft.iwechat.corporation.message.reception.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isoft.iwechat.corporation.message.reception.BatchJobType;

/**
 * 异步任务完成事件推送
 */
public class BatchJobEvent extends AbstractEventMessage {
    public BatchJobEvent() {
        this.event = EventType.batch_job_result;
    }

    /**
     * 任务
     */
    @JsonProperty("BatchJob")
    private Job batchJob;

    /**
     * 任务类型
     */
    @JsonProperty("JobType")
    private BatchJobType jobType;
    /**
     * 返回码
     */
    @JsonProperty("ErrCode")
    private String errCode;

    /**
     * 对返回码的文本描述内容
     */
    @JsonProperty("ErrMsg")
    private String errMsg;

    class Job{
        /**
         * 异步任务id，最大长度为64字符
         */
        @JsonProperty("JobId")
        private String jobId;

        public String getJobId() {
            return jobId;
        }

        public void setJobId(String jobId) {
            this.jobId = jobId;
        }
    }
}
