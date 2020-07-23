package edu.scau.common.Service;

import edu.scau.common.pojo.Association;

import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-07-15 15:23
 **/
public interface AssociationService {
    Association getAssociationByName(String associationName);
    List<String> getAssociationByType(String type);
    Integer updateAssociation(Association association);
    Integer insertAssociation(Association association);
}
