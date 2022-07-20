package com.newcoder.community.controller;

import com.newcoder.community.entity.DiscussPost;
import com.newcoder.community.entity.User;
import com.newcoder.community.service.DiscussPostService;
import com.newcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    DiscussPostService discussPostService;

    @Autowired
    UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        List<DiscussPost> discussPosts = discussPostService.findDisscussPosts(0, 0, 10);
        List<Map<String, Object>> list = new ArrayList<>();
        for(DiscussPost discussPost : discussPosts) {
            Map<String, Object> map = new HashMap<>();
            map.put("discussPost", discussPost);
            User user = userService.findUserById(discussPost.getUserId());
            map.put("user", user);
            list.add(map);
        }
        model.addAttribute("discussPosts", list);
        return "/index";
    }
}
