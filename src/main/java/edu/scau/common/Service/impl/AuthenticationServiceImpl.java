package edu.scau.common.Service.impl;

import edu.scau.common.Service.AuthenticationService;
import edu.scau.common.mapper.AssociationMapper;
import edu.scau.common.mapper.AuthenticationMapper;
import edu.scau.common.pojo.Association;
import edu.scau.common.pojo.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-08-07 15:49
 **/
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired(required = false)
    private AuthenticationMapper authenticationMapper;
    @Autowired(required = false)
    private AssociationMapper associationMapper;
    @Override
    public Integer insertAuthenticationMapper(Authentication authentication) {
        return null;
    }

    @Override
    public List<Authentication> getAuthentication(int userId) {
        return authenticationMapper.getAuthentication(userId);
    }

    @Override
    public Integer deleteAuthentication(int userId, String associationName) {
        Integer result = authenticationMapper.deleteAuthentication(userId, associationName);
        return result;
    }

    @Override
    public List<String> updateAssociationAuthentication(int userId) {
        ArrayList<String> strings1 = new ArrayList<>();
        List<Integer> level = authenticationMapper.getLevel(userId);
        if(level !=null) {
            for (Integer integer : level) {
                if(integer==3){
                    return associationMapper.getAssociation();
                }
            }
            List<String> strings = authenticationMapper.AssociationAuthentication(userId);
            for (String string : strings) {
                if (authenticationMapper.getAssociationId(string) != null) {
                    strings1.add(string);
                }
            }
        }
        return strings1;
    }

    @Override
    public List<String> insertAssociationAuthentication(int userId) {
        List<String> strings = authenticationMapper.AssociationAuthentication(userId);
        ArrayList<String> strings1 = new ArrayList<>();
        for (String string : strings) {
            if(authenticationMapper.getAssociationId(string)==null){
                strings1.add(string);
            }
        }
        return strings1;
    }

    @Override
    public Integer saveActivityAuthentication(int userId) {
        List<Integer> id = authenticationMapper.getId(userId);
        if(id.isEmpty()){
            return 0;
        }
        return 1;
    }
}
