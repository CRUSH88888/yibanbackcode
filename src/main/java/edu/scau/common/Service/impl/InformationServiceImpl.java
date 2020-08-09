package edu.scau.common.Service.impl;

import edu.scau.common.Service.InformationService;
import edu.scau.common.mapper.FunctionMapper;
import edu.scau.common.pojo.Information;
import edu.scau.common.utils.DateToStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-08-01 23:15
 **/
@Service
public class InformationServiceImpl implements InformationService {
    @Autowired(required = false)
    private FunctionMapper functionMapper;
    @Override
    public List<Information> getInformation(int userId) {
        List<Information> information = functionMapper.getInformation(userId);
        for (Information information1 : information) {
            information1.setDate(DateToStringUtil.publishTime(information1.getPublishTime()));
        }
        return information;
    }

    @Override
    public Information getInformationById(int id) {
        functionMapper.updateBrowsed(id);
        return functionMapper.getInformationById(id);
    }

}
