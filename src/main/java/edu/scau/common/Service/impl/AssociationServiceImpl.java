package edu.scau.common.Service.impl;

import edu.scau.common.Service.AssociationService;
import edu.scau.common.mapper.AssociationMapper;
import edu.scau.common.mapper.AuthenticationMapper;
import edu.scau.common.pojo.Association;
import edu.scau.common.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-07-15 15:24
 **/
@Service
public class AssociationServiceImpl implements AssociationService {
    @Autowired(required = false)
    private AssociationMapper associationMapper;
    @Autowired(required = false)
    private AuthenticationMapper authenticationMapper;

    @Override
    public Association getAssociationByName(String associationName) {
        Association associationByName = associationMapper.getAssociationByName(associationName);
        List<String> picture = associationMapper.getPicture(associationName);
        associationByName.setPicture(picture);
        return associationByName;
    }

    @Override
    public List<String> getAssociationByType(String type) {
        return associationMapper.getAssociationByType(type);
    }

    @Override
    @Transactional
    public Integer updateAssociation(Association association) {
        String associationById = associationMapper.getAssociationById(association.getId());
        Integer result = 0;
        result += authenticationMapper.updateAssociationName(associationById, association.getName());
        List<String> picture1 = associationMapper.getPicture(associationById);
        for (String s : picture1) {
            result += associationMapper.deletePicture(associationById);
            FileUtil.deleteFile(s);
        }
        result += associationMapper.updateAssociation(association);
        List<String> picture = association.getPicture();
        if (picture != null){
            for (String s : picture) {
                result += associationMapper.insertPic(s, association.getName());
            }
        }
        return result>0?1:0;
    }

    @Override
    public Integer insertAssociation(Association association) {
        Integer result=associationMapper.insertAssociation(association);
        List<String> picture = association.getPicture();
        if(picture!=null) {
            for (String s : picture) {
                result+=associationMapper.insertPic(s,association.getName());
            }
        }
        return result>0?1:0;
    }
}
