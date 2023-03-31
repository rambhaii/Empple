package com.empeople.Data;

public class Dataum {
    //SerializedName("id")
    // @Expose
    private String id;
    //  @SerializedName("userID")
    //  @Expose
    private  String userID;
    // @SerializedName("name")
    //@Expose
  private  String name;
   private String faqcategoryId;
  private String title;
   private String description;

    public String getFaqcategoryId() {
        return faqcategoryId;
    }

    public void setFaqcategoryId(String faqcategoryId) {
        this.faqcategoryId = faqcategoryId;
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

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    private  String joindate;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    private  String profile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}



