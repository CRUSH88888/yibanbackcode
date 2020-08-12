package edu.scau.common.dto;

import edu.scau.common.pojo.ActivityCertificate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/11 20:59
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityCertificateDetail {
    private ActivityCertificate activityCertificate;
    private Boolean isBrowsed;
}
