package com.examplee.demoo.DTO;
import java.util.ArrayList;
import java.util.List;

public class Film_Serie_FullDTO {
 
  private String title;

  private int begin_date;

  private String image;

  private int calification;

  private List<Character> film_serie_asociated = new ArrayList<Character>();
  

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


    /**
     * @return int return the calification
     */
    public int getCalification() {
        return calification;
    }

    /**
     * @param calification the calification to set
     */
    public void setCalification(int calification) {
        this.calification = calification;
    }

    /**
     * @return List<Character> return the film_serie_asociated
     */
    public List<Character> getCharacters_asociated() {
        return film_serie_asociated;
    }

    /**
     * @param film_serie_asociated the film_serie_asociated to set
     */
    public void setCharacters_asociated(List<Character> film_serie_asociated) {
        this.film_serie_asociated = film_serie_asociated;
    }

}
