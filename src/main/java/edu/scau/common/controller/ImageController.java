package edu.scau.common.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @auther:cyf
 * @create:2020/7/28 14:47
 **/
@RestController
public class ImageController {

    @Data
    public class first implements Serializable {

        private String name = "发布";
        private String image_src = "http://8.129.172.254:8080/video/%E5%8F%91%E5%B8%83.png";
        private String open_type = "switchTab";
        private String navigator_url = "/pages/category/main";
        private String url = "/pages/publish/publish";
    }
    @Data
    @AllArgsConstructor
    public class Second{
        private String name;
        private String image_src;
        private String url;
    }
    @Data
    public class Response{
        Map<String,Object> message;
        Map<String,Object> meta;

        public Response() {
            Map<String,Object> map = new HashMap<>();
            map.put("0",new first());
            map.put("1",new Second("日程表","http://8.129.172.254:8080/video/%E6%97%A5%E7%A8%8B%E8%A1%A8.png","/pages/calendar/calendar"));
            map.put("2",new Second("收藏","http://8.129.172.254:8080/video/%E6%94%B6%E8%97%8F.png","/pages/collection/collection"));
            map.put("3",new Second("足迹","http://8.129.172.254:8080/video/%E8%B6%B3%E8%BF%B9.png","/pages/footprint/footprint"));
            this.message = map;
            Map<String,Object> metas = new HashMap<>();
            metas.put("msg","获取成功");
            metas.put("status",200);
            this.meta = metas;
        }
    }
    @GetMapping("/returnImages")
    public Response returnImage(){
        Response response = new Response();
        return response;
    }
}
