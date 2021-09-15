package com.examplee.demoo.DTO;

public class Film_Serie_LightDTO {
 
  private String title;

  private int begin_date;

  private String image;
  

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return int return the begin_date
     */
    public int getBegin_date() {
        return begin_date;
    }

    /**
     * @param begin_date the begin_date to set
     */
    public void setBegin_date(int begin_date) {
        this.begin_date = begin_date;
    }

    /**
     * @return String return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

}
