package edu.scau.common.Service.impl;

import edu.scau.common.Service.BrowsedService;
import edu.scau.common.dto.ActivityManger;
import edu.scau.common.mapper.ActivityMapper;
import edu.scau.common.mapper.BrowsedMapper;
import edu.scau.common.pojo.Browse;
import edu.scau.common.utils.DateToStringUtil;
import edu.scau.common.utils.ListMerge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-08-02 17:06
 **/
@Service
public class BrowsedServiceImpl implements BrowsedService {
    @Autowired(required = false)
    private BrowsedMapper browsedMapper;
    @Override
    @Transactional
    public Integer insertBrowsed(int activityId, int userId) {
        Integer result;
        Browse browse = new Browse(activityId, userId, new Timestamp(System.currentTimeMillis()));
        if(browsedMapper.getActivityBrowsed(userId,activityId)!=null)
            result = browsedMapper.updateBrowsed(browse);
        else
            result = browsedMapper.insertBrowsed(browse);
        return result>0?1:0;
    }
    public Integer insertCertificateBrowsed(int activityId, int userId) {
        Integer result;
        Browse browse = new Browse(activityId, userId, new Timestamp(System.currentTimeMillis()));
        if(browsedMapper.getCertificateBrowsed(userId,activityId)!=null)
            result = browsedMapper.updateCertificateBrowsed(browse);
        else
            result = browsedMapper.insertCertificateBrowsed(browse);
        return result>0?1:0;
    }

    @Override
    public List<ActivityManger> getFootPrint(int userId) {
        List<ActivityManger> footPrint = browsedMapper.getFootPrint(userId);
        for (ActivityManger activityManger : footPrint) {
            activityManger.setType(1);
        }
        List<ActivityManger> certificateFootPrint = browsedMapper.getCertificateFootPrint(userId);
        for (ActivityManger activityManger : certificateFootPrint) {
            activityManger.setType(2);
        }
        List<ActivityManger> activityMangers = ListMerge.listMerge2(footPrint, certificateFootPrint);
        for (ActivityManger print : activityMangers) {
            print.setDate(DateToStringUtil.publishTime(print.getBuildTime()));
        }
        return activityMangers;
    }
}
