package com.model;

import java.util.UUID;

public class MyUrl {

    private String m_Url;
    private String m_ShortKey;
    private int m_Count;
    
    public MyUrl(String url)
    {
        m_Url = url;
        m_ShortKey = UUID.randomUUID().toString();
        m_Count = 0;
    }

    public String getUrl()
    {
        return m_Url;
    }

    public String getShortKey()
    {
        return m_ShortKey;
    }

    public int getCount()
    {
        return m_Count;
    }

    public void increaseCount()
    {
        m_Count++;
    }
}