package edu.scau.common.Service.impl;

import edu.scau.common.Service.ActivityCertificateService;
import edu.scau.common.dto.ActivityCertificateCollected;
import edu.scau.common.mapper.ActivityCertificateMapper;
import edu.scau.common.mapper.CertificateFileMapper;
import edu.scau.common.pojo.ActivityCertificate;
import edu.scau.common.pojo.CertificateFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/9 20:10
 **/
@Service
public class ActivityCertificateServiceImpl implements ActivityCertificateService {
    @Autowired
    private ActivityCertificateMapper activityCertificateMapper;
    @Autowired
    private CertificateFileMapper certificateFileMapper;


    @Override
    public Boolean save(ActivityCertificate activityCertificate) {
        Integer certificateId = activityCertificateMapper.insertCertificate(activityCertificate);
        System.out.println(certificateId);
        activityCertificateMapper.insertCertificateFile(activityCertificate.getFileUrl(),certificateId);
        activityCertificateMapper.insertCertificateLabel(activityCertificate.getLabels(),certificateId);
        return null;
    }

    @Override
    public Integer collectedCertificate(Integer userId, Integer certificateId) {
        return activityCertificateMapper.collectedCertificate(userId,certificateId);
    }

    @Override
    public Integer updateCertificate(ActivityCertificate activityCertificate) {
        activityCertificateMapper.updateCertificate(activityCertificate);
        List<String> files = activityCertificate.getFileUrl();
        for (String s:files
             ) {
            certificateFileMapper.updateByPrimaryKey(new CertificateFile());
        }

        return null;
    }
}
