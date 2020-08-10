package edu.scau.common.mapper;

import edu.scau.common.dto.ActivityManger;
import edu.scau.common.pojo.Browse;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

/**
 * @description: 浏览、足迹mapper
 * @author: whj
 * @create: 2020-08-02 16:25
 **/
@Mapper
public interface BrowsedMapper {
    Integer insertBrowsed(Browse browse);
    Integer insertCertificateBrowsed(Browse browse);
    List<ActivityManger> getFootPrint(int userId);
    List<ActivityManger> getCertificateFootPrint(int userId);
    Integer updateBrowsed(Browse browse);
    Integer updateCertificateBrowsed(Browse browse);
    Integer deleteBrowsed(int activityId);
    Integer deleteCertificateBrowsed(int activityId);
}
