package edu.scau.common.dto;

import edu.scau.common.pojo.ActivityCertificate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/15 9:41
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndexActivityCertificate {

        private ActivityCertificate activityCertificate;
        private Boolean collected;
        private String builtTimeToNow;


}
