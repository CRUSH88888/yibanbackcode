package edu.scau.common.Service;

import edu.scau.common.dto.ActivityCertificateCollected;
import edu.scau.common.dto.IndexActivityCertificate;
import edu.scau.common.pojo.ActivityCertificate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/9 20:10
 **/

public interface ActivityCertificateService {

    public Boolean save(ActivityCertificate activityCertificate);
    Integer collectedCertificate(Integer userId,
                                 Integer certificateId);
//    没用上
    Integer updateCertificate(ActivityCertificate activityCertificate);
    Integer deleteCollectedCertificate(Integer userId, Integer certificateId);
    List<IndexActivityCertificate> get(Integer userId);
    IndexActivityCertificate selectCertificateById(Integer certificateId,Integer userId);




}
