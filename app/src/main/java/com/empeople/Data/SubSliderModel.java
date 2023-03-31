package com.empeople.Data;

public class SubSliderModel {
    int img;
    String description;

    public SubSliderModel(int img) {
        this.img = img;

    }
    public SubSliderModel (String description)
    {
        this.description=description;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription()
    {
        this.description=description;
    }
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


}
