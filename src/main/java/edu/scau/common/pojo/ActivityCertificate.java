package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.List;

/**
 * @description:活动证明
 * @auther:cyf
 * @create:2020/8/9 19:45
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityCertificate {
    private Integer id;
    private String activityTitle;
    private String activityContent;
    @Transient
    private List<String> fileUrl;
    @Transient
    private List<String> labels;
    /**
     * 发布者
     */
    private Integer userId;
    /**
     * 发布时间
     */
    private Timestamp buildingTime;
    public ActivityCertificate( String activityTitle, String activityContent, List<String> fileUrl, List<String> labels) {
        this.activityTitle = activityTitle;
        this.activityContent = activityContent;
        this.fileUrl = fileUrl;
        this.labels = labels;
    }

    public ActivityCertificate( String activityTitle, String activityContent, List<String> fileUrl, List<String> labels, Integer userId) {
        this.activityTitle = activityTitle;
        this.activityContent = activityContent;
        this.fileUrl = fileUrl;
        this.labels = labels;
        this.userId = userId;
    }
    public ActivityCertificate( String activityTitle, String activityContent, List<String> fileUrl, List<String> labels, Integer userId,Timestamp buildingTime) {
        this.activityTitle = activityTitle;
        this.activityContent = activityContent;
        this.fileUrl = fileUrl;
        this.labels = labels;
        this.userId = userId;
        this.buildingTime = buildingTime;
    }
}
