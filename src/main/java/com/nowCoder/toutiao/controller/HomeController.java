package com.nowCoder.toutiao.controller;

import com.nowCoder.toutiao.moder.News;
import com.nowCoder.toutiao.moder.ViewObject;
import com.nowCoder.toutiao.service.NewsService;
import com.nowCoder.toutiao.service.UserServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    NewsService newsService;

    @Autowired
    UserServicce userServicce;

    private List<ViewObject> getNews(int userId, int offset, int limit) {
        List<News> newsList = newsService.getLatestNews(userId, offset,limit);

        List<ViewObject> vos = new ArrayList<>();
        for (New new : newList) {
            ViewObject vo = new ViewObject();
            vo.set("news", news);
            vo.set("user", userServicce.getUser(news.getUserId()));
            vos.add(vo);
        }
        return vos;
    }


    @RequestMapping(path = {"/", "index"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model) {
        model.addAttribute("vos", getNews(0, 0, 10));
        return "home";
    }

    @RequestMapping(path = {"/user/{userId}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String userIndex(Model model, @PathVariable("userId") int userId) {
        model.addAttribute("vos", getNews(userId, 0, 10));
        return "home";
    }


}






















