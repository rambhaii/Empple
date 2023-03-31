package com.empeople.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Dataz {
    @SerializedName("faqCategoryID")
    @Expose
    public String faqCategoryID;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("faqList")
    @Expose
    public List<faqList> faqList = null;

    public Dataz(String faqCategoryID, String title, String description, List<faqList> faqList) {
        this.faqCategoryID = faqCategoryID;
        this.title = title;
        this.description = description;
        this.faqList = faqList;
    }

    public String getFaqCategoryID() {
        return faqCategoryID;
    }

    public void setFaqCategoryID(String faqCategoryID) {
        this.faqCategoryID = faqCategoryID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<faqList> getFaqList() {
        return faqList;
    }

    public void setFaqList(List<faqList> faqList) {
        this.faqList = faqList;
    }
}