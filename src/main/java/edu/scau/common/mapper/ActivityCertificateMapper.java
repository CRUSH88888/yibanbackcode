package edu.scau.common.mapper;

import edu.scau.common.dto.ActivityCertificateDetail;
import edu.scau.common.dto.IndexActivityCertificate;
import edu.scau.common.pojo.ActivityCertificate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;

import java.util.List;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/9 20:09
 **/
@Mapper
public interface ActivityCertificateMapper extends MySqlMapper<ActivityCertificate> {

    Integer updateCertificate(ActivityCertificate activityCertificate);
    Integer insertCertificate(ActivityCertificate activityCertificate);
    Integer insertCertificateFile(@Param("files") String fileUrl,@Param("certificateId") Integer certificateId);
    Integer insertCertificateLabel(@Param("label")String label,@Param("certificateId") Integer certificateId);
    Integer collectedCertificate(@Param("userId") Integer userId,@Param("certificateId") Integer certificateId);

    Integer deleteCollectedCertificate(@Param("userId") Integer userId,@Param("certificateId") Integer certificateId);
//    Integer updateCertificateFile(@Param("files") List<String> fileUrl,@Param("certificateId") Integer certificateId);

    List<ActivityCertificate> selectCertificate();
    List<String> selectFileUrl(@Param("certificateId")Integer certificateId);
    List<String> selectLabels(@Param("certificateId")Integer certificateId);
    Integer checkedCertificateBrowsed(@Param("userId") Integer userId,@Param("certificateId") Integer certificateId);
    ActivityCertificate selectCertificateById(@Param("certificateId")Integer certificateId);
}
