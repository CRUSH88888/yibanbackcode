package edu.scau.common.Service;

import edu.scau.common.dto.ActivityCertificateCollected;
import edu.scau.common.pojo.ActivityCertificate;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/9 20:10
 **/

public interface ActivityCertificateService {

    public Boolean save(ActivityCertificate activityCertificate);
    Integer collectedCertificate(Integer userId,
                                 Integer certificateId);
    Integer updateCertificate(ActivityCertificate activityCertificate);
}
