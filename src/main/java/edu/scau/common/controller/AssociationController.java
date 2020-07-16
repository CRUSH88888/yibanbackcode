package edu.scau.common.controller;


import edu.scau.common.Service.impl.AssociationServiceImpl;
import edu.scau.common.pojo.Association;
import edu.scau.common.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-07-15 15:29
 **/
@RestController
public class AssociationController {
    @Autowired
    private AssociationServiceImpl associationService;

    /**
     * 根据名字查询社团组织
     * @param associationName
     * @return
     */
    @GetMapping("/getAssociationByType/getAssociationByName")
    public ApiResponse getAssociationByName(String associationName){
        Association associationByName = associationService.getAssociationByName(associationName);
        return associationByName==null?new ApiResponse(0,"empty"):new ApiResponse(0,"success",associationByName);
    }

    /**
     * 根据类型查询社团组织
     * @param type
     * @return
     */
    @GetMapping("/getAssociationByType")
    public ApiResponse getAssociationByType(String type){
        List<Association> associationByType = associationService.getAssociationByType(type);
        return associationByType.isEmpty()==true?new ApiResponse(0,"empty"):new ApiResponse(0,"success",associationByType);
    }

    /**
     * 更新社团组织资料
     * @param name
     * @param introduce
     * @param href
     * @param type
     * @return
     */
    @PostMapping("/updateAssociation")
    public ApiResponse updateAssociation(@RequestParam("name") String name,
                                         @RequestParam("introduce") String introduce,
                                         @RequestParam("href") String href,
                                         @RequestParam("type") String type){
        Association association = new Association(name, introduce, href, type);
        Integer result=associationService.updateAssociation(association);
        return result>0?new ApiResponse(0,"success"):new ApiResponse(-1,"Update Error");
    }

    /**
     * 新增社团组织资料
     * @param name
     * @param introduce
     * @param href
     * @param type
     * @return
     */
    @PostMapping("/insertAssociation")
    public ApiResponse insertAssociation(@RequestParam("name") String name,
                                         @RequestParam("introduce") String introduce,
                                         @RequestParam("href") String href,
                                         @RequestParam("type") String type){
        Association association = new Association(name, introduce, href, type);
        Integer result=associationService.insertAssociation(association);
        return result>0?new ApiResponse(0,"success"):new ApiResponse(-1,"Server Error");
    }
}
