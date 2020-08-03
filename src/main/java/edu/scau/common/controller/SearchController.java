package edu.scau.common.controller;

import edu.scau.common.Service.impl.SearchServiceImpl;
import edu.scau.common.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-08-02 23:18
 **/
@RestController
public class SearchController {
    @Autowired
    private SearchServiceImpl searchService;
    @GetMapping("searchAssociation")
    public ApiResponse searchAssociation(@RequestParam("search") String search){
        List<String> strings = searchService.searchAssociation(search);
        return strings.isEmpty()==true?new ApiResponse(0,"empty"):new ApiResponse(0,"success",strings);
    }
}
