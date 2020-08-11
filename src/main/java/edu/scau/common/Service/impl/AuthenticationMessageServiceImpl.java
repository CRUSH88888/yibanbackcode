package edu.scau.common.Service.impl;

import edu.scau.common.Service.AuthenticationMessageService;
import edu.scau.common.Service.AuthenticationService;
import edu.scau.common.mapper.AuthenticationMapper;
import edu.scau.common.mapper.AuthenticationMessageMapper;
import edu.scau.common.mapper.FunctionMapper;
import edu.scau.common.pojo.Authentication;
import edu.scau.common.pojo.AuthenticationMessage;
import edu.scau.common.pojo.Information;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-08-08 13:44
 **/
@Service
public class AuthenticationMessageServiceImpl implements AuthenticationMessageService {
    @Autowired(required = false)
    private AuthenticationMessageMapper authenticationMessageMapper;
    @Autowired(required = false)
    private AuthenticationMapper authenticationMapper;
    @Autowired(required = false)
    private FunctionMapper functionMapper;
    @Override
    public Integer to_authentication(AuthenticationMessage authenticationMessage) {
        if(authenticationMessage.getLevel()==1){
            authenticationMessage.setBrowsed(false);
            Integer result= authenticationMessageMapper.insertAuthenticationMessage(authenticationMessage);
            List<String> pictureUrl = authenticationMessage.getPictureUrl();
            Integer authenticationId = authenticationMessageMapper.getAuthenticationId(authenticationMessage.getUserId(), authenticationMessage.getAssociationName());
            for (String s : pictureUrl) {
                result+= authenticationMessageMapper.insertPicture(s,authenticationId);
            }
            return result==pictureUrl.size()+1?1:0;
        }
        else {
            Integer userId = authenticationMapper.getUserIdByName(authenticationMessage.getAssociationName());
            if(userId==null){
                authenticationMessage.setBrowsed(false);
                Integer result= authenticationMessageMapper.insertAuthenticationMessage(authenticationMessage);
                List<String> pictureUrl = authenticationMessage.getPictureUrl();
                Integer authenticationId = authenticationMessageMapper.getAuthenticationId(authenticationMessage.getUserId(), authenticationMessage.getAssociationName());
                for (String s : pictureUrl) {
                    result+= authenticationMessageMapper.insertPicture(s, authenticationId);
                }
                return result==pictureUrl.size()+1?1:0;
            }
            else{
                String s;
                String name = authenticationMessageMapper.getName(authenticationMessage.getUserId());
                String userName = authenticationMessageMapper.getUserName(authenticationMessage.getUserId());
                if(name==null){
                    s=userName;
                }
                else {
                    s=name;
                }
                int length = s.length();
                String substring = s.substring(0, 1);
                for (int i = 1; i < length; i++) {
                    substring+='*';
                }
                s=substring+authenticationMessage.getAssociationName()+"负责人，请仔细确认，" +
                        "如果需要转让负责人，请到 我的—>身份认证 处进行身份的删除，若无需转让，请忽略本条信息。";
                char[] chars1 = s.toCharArray();

                Information information = new Information(s, userId, new Timestamp(System.currentTimeMillis()));
                Integer result = functionMapper.insertInformation(information);
                return -1;
            }
        }
    }

    @Override
    public List<AuthenticationMessage> getAuthenticationMessage() {
        List<AuthenticationMessage> authenticationMessage = authenticationMessageMapper.getAuthenticationMessage();
        for (AuthenticationMessage message : authenticationMessage) {
            if(message.getLevel()==1){
                message.setAssociationName(message.getAssociationName()+"工作人员");
            }
            else
                message.setAssociationName(message.getAssociationName()+"负责人");
        }
        return authenticationMessage;
    }

    @Override
    public AuthenticationMessage getAuthenticationMessageById(int id) {
        AuthenticationMessage authenticationMessageById = authenticationMessageMapper.getAuthenticationMessageById(id);
        if(authenticationMessageById.getLevel()==1)
            authenticationMessageById.setAssociationName(authenticationMessageById.getAssociationName()+"工作人员");
        else
            authenticationMessageById.setAssociationName(authenticationMessageById.getAssociationName()+"负责人");
        List<String> picture = authenticationMessageMapper.getPicture(id);
        authenticationMessageById.setPictureUrl(picture);
        return authenticationMessageById;
    }

    @Override
    @Transactional
    public Integer success(int id) {
        AuthenticationMessage authenticationMessage = authenticationMessageMapper.getAuthenticationMessageById(id);
        Authentication authentication = new Authentication(authenticationMessage.getUserId(), authenticationMessage.getLevel(), new Timestamp(System.currentTimeMillis()), authenticationMessage.getAssociationName());
        Integer result = authenticationMessageMapper.insertAuthentication(authentication);
        result+= authenticationMessageMapper.updateAuthentication(authenticationMessage.getId());
        String information;
        if(authenticationMessage.getLevel()==1){
            information="你提交申请的"+authenticationMessage.getAssociationName()+"工作人员的审核已通过";
        }
        else
            information="你提交申请的"+authenticationMessage.getAssociationName()+"负责人的审核已通过";
        Information information1 = new Information(information, authenticationMessage.getUserId(), new Timestamp(System.currentTimeMillis()));
        result+= functionMapper.insertInformation(information1);
        return result==3?1:0;
    }

    @Override
    public Integer fail(String information,int id) {
        AuthenticationMessage authenticationMessage = authenticationMessageMapper.getAuthenticationMessageById(id);
        Information information1 = new Information(information, authenticationMessage.getUserId(), new Timestamp(System.currentTimeMillis()));
        Integer result = functionMapper.insertInformation(information1);
        result+= authenticationMessageMapper.updateAuthentication(id);
        return result==2?1:0;
    }
}
