package com.example.databox.Controller;

import com.example.databox.Entity.PostInfo;
import com.example.databox.Mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("data")
    public class PostController {
        @Autowired
        private PostMapper postMapper;


    /**用于post-job页面，主要用于显示发布工作页面
     * @return 返回post-job页面，即发布工作页面
     */
    @GetMapping("/post")
    public String pagePostJob() {
        return "post.html";
    }

    /**用于post-job页面，主要用于向数据库插入职位和公司信息
     * @param postInfo postInfo对象，用于存放用户发布工作信息的数据
     * @return 返回post-job页面，即发布工作页面
     */
    @PostMapping("/post")
    public String GetPostJob(PostInfo postInfo) {
        int i= postMapper.savePostJob(postInfo);
        return "postshow.html";
    }






    /**用于postshow页面，主要用于显示发布工作信息页面
     * @return 返回postshow页面，即发布工作信息页面
     */
//    @GetMapping("/postshow")
//    public String pagePostshow() {
//        return "postshow.html";
//    }


    @GetMapping("/postshow/{id}")
    public String getallContent(@PathVariable("id") Integer PositionID, Model model){
        PostInfo postInfo = postMapper.getContent(PositionID);
        model.addAttribute("postInfo", postInfo);
        return "postshow.html";
    }



}
