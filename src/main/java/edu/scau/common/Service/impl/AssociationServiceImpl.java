package edu.scau.common.Service.impl;

import edu.scau.common.Service.AssociationService;
import edu.scau.common.mapper.AssociationMapper;
import edu.scau.common.mapper.AuthenticationMapper;
import edu.scau.common.pojo.Association;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return associationMapper.getAssociationByName(associationName);
    }

    @Override
    public List<String> getAssociationByType(String type) {
        return associationMapper.getAssociationByType(type);
    }

    @Override
    public Integer updateAssociation(Association association) {
        String associationById = associationMapper.getAssociationById(association.getId());
        authenticationMapper.updateAssociationName(associationById,association.getName());
        Integer result=associationMapper.updateAssociation(association);
        return result>0?1:0;
    }

    @Override
    public Integer insertAssociation(Association association) {
        Integer result=associationMapper.insertAssociation(association);
        return result>0?1:0;
    }
    public List<String> getAssociation(){
        return associationMapper.getAssociation();
    }
}
