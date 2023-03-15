package com.example.poetry.entity;

import java.io.Serializable;

/**
 * (Sentence)实体类
 *
 * @author fauchard
 * @since 2023-03-09 10:59:51
 */
public class Sentence implements Serializable {
    private static final long serialVersionUID = -71820400364321627L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 正文
     */
    private String content;
    /**
     * 译文
     */
    private String tslt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTslt() {
        return tslt;
    }

    public void setTslt(String tslt) {
        this.tslt = tslt;
    }

}

