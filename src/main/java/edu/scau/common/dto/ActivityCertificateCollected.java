package edu.scau.common.dto;

import edu.scau.common.pojo.ActivityCertificate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/9 20:03
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityCertificateCollected {
    private ActivityCertificate activityCertificate;
    private Integer userId;
    private Boolean collected;
}
