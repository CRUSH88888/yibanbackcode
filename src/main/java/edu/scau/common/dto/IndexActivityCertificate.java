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
//        无语了这个browsed我改了三次的，下次能不能拉一下代码再写你的，傻逼
        private Boolean browsed;
        private String builtTimeToNow;


}
