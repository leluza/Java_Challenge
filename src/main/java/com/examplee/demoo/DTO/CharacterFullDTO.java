
package com.examplee.demoo.DTO;

import com.examplee.demoo.entities.Films_Series;
import java.util.ArrayList;
import java.util.List;

public class CharacterFullDTO {

  private Long id_character;
  private String name;
  private int age;
  private int weight;
  private String history;
  private String image;
  private List<Films_Series> film_series_asociated = new ArrayList<Films_Series>();

    /**
     * @return Long return the id_character
     */
    public Long getId_character() {
        return id_character;
    }

    /**
     * @param id_character the id_character to set
     */
    public void setId_character(Long id_character) {
        this.id_character = id_character;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return int return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return String return the history
     */
    public String getHistory() {
        return history;
    }

    /**
     * @param history the history to set
     */
    public void setHistory(String history) {
        this.history = history;
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
     * @return List<Films_Series> return the film_series_asociated
     */
    public List<Films_Series> getFilm_series_asociated() {
        return film_series_asociated;
    }

    /**
     * @param film_series_asociated the film_series_asociated to set
     */
    public void setFilm_series_asociated(List<Films_Series> film_series_asociated) {
        this.film_series_asociated = film_series_asociated;
    }

}
