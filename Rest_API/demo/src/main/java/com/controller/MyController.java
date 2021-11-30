package com.controller;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.model.MyUrl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private List<MyUrl> m_Urls;

    MyController()
    {
        m_Urls = new ArrayList<MyUrl>();
    }

    @RequestMapping("/storeurl/{url}")
    public void storeUrl(@PathVariable String url)
    {
        MyUrl myUrl = new MyUrl(url);
        m_Urls.add(myUrl);
    }

    @RequestMapping("/get/{url}")
    public String get(@PathVariable String url)
    {
        MyUrl myUrl = findUrl(url);
        if(myUrl != null)
        {
            myUrl.increaseCount();
            return myUrl.getShortKey();
        }
        
        return "Invalid Url!!!";
    }

    @RequestMapping("/count/{url}")
    public int count(@PathVariable String url)
    {
        MyUrl myUrl = findUrl(url);

        if(myUrl != null)
        {
            return myUrl.getCount();
        }
        
        return 0;
    }

    @RequestMapping("/list")
    public String getAll()
    {
        return new Gson().toJson(m_Urls);
    }

    private MyUrl findUrl(String url)
    {
        for (MyUrl myUrl : m_Urls) {
            if(myUrl.getUrl().equals(url))
            {
                return myUrl;
            }
        }

        return null;
    }
}