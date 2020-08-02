package edu.scau.common.Service.impl;

import edu.scau.common.Service.BrowsedService;
import edu.scau.common.dto.FootPrint;
import edu.scau.common.mapper.BrowsedMapper;
import edu.scau.common.pojo.Browse;
import edu.scau.common.utils.DateToStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Integer insertBrowsed(int activityId, int userId) {
        Browse browse = new Browse(activityId, userId, new Timestamp(System.currentTimeMillis()));
        Integer result = browsedMapper.insertBrowsed(browse);
        return result>0?1:0;
    }

    @Override
    public List<FootPrint> getFootPrint(int userId) {
        List<FootPrint> footPrint = browsedMapper.getFootPrint(userId);
        for (FootPrint print : footPrint) {
            print.setDate(DateToStringUtil.publishTime(print.getBrowsedTime()));
        }
        return footPrint;
    }
}
