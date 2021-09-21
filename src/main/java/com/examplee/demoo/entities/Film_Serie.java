package com.examplee.demoo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Films_Series")
public class Film_Serie implements Serializable {

  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Long id_film_serie;

  @Column
  private String title;

  @Column
  private int begin_date;  

  @Column(length = 1500)
  private String image;

  @Column
  private int calification;

  
  @ManyToMany  (mappedBy = "film_series_asociated")
  private List<Character> characters_asociated = new  ArrayList<Character>();

  @ManyToOne (cascade = CascadeType.PERSIST) 
  @JoinColumn (name = "fk_gender")
  private  Gender gender;


    /**
     * @return Long return the id_film_serie
     */
    public Long getId_film_serie() {
        return id_film_serie;
    }

    /**
     * @param id_film_serie the id_film_serie to set
     */
    public void setId_film_serie(Long id_film_serie) {
        this.id_film_serie = id_film_serie;
    }

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
     * @return List<Character> return the characters_asociated
     */
    public List<Character> getCharacters_asociated() {
        return characters_asociated;
    }

    /**
     * @param characters_asociated the characters_asociated to set
     */
    public void setCharacters_asociated(List<Character> characters_asociated) {
        this.characters_asociated = characters_asociated;
    }

    /**
     * @return Gender return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + begin_date;
      result = prime * result + calification;
      result = prime * result + ((characters_asociated == null) ? 0 : characters_asociated.hashCode());
      result = prime * result + ((gender == null) ? 0 : gender.hashCode());
      result = prime * result + ((id_film_serie == null) ? 0 : id_film_serie.hashCode());
      result = prime * result + ((image == null) ? 0 : image.hashCode());
      result = prime * result + ((title == null) ? 0 : title.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Film_Serie other = (Film_Serie) obj;
      if (begin_date != other.begin_date)
        return false;
      if (calification != other.calification)
        return false;
      if (characters_asociated == null) {
        if (other.characters_asociated != null)
          return false;
      } else if (!characters_asociated.equals(other.characters_asociated))
        return false;
      if (gender == null) {
        if (other.gender != null)
          return false;
      } else if (!gender.equals(other.gender))
        return false;
      if (id_film_serie == null) {
        if (other.id_film_serie != null)
          return false;
      } else if (!id_film_serie.equals(other.id_film_serie))
        return false;
      if (image == null) {
        if (other.image != null)
          return false;
      } else if (!image.equals(other.image))
        return false;
      if (title == null) {
        if (other.title != null)
          return false;
      } else if (!title.equals(other.title))
        return false;
      return true;
    }

    

}