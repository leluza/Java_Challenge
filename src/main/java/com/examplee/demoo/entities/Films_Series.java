package com.examplee.demoo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//import lomb
//import lombok.Setter;

@Entity
@Table(name = "Films_Series")
public class Films_Series implements Serializable {

  
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_film_serie;

  @Column
  private String title;

  @Column
  private int begin_date;  

  @Column
  private int calification;

  @Column(length = 1500)
  private String image;

  @ManyToMany //(mappedBy="film_series_asociated")  
  //@JoinTable(name = "characters_films_series", 
 //                         joinColumns = @JoinColumn(name = "id_character"),
   //                       inverseJoinColumns = @JoinColumn(name = "id_film_serie"))
  private List<Character> characters_asociated = new  ArrayList<Character>();


  public Long getId() {     return id_film_serie;}

  public void setId(Long id_film_serie) {    this.id_film_serie = id_film_serie;   }

  public String getTitle() {    return title;    }

  public void setTitle(String title) {    this.title = title;  }

  public String getImage() {  return image;  }

  public void setImage (String image) {     this.image = image;   }

  public int getBeginDate() {     return begin_date;   }

  public void setBeginDate(int begin_date) {      this.begin_date = begin_date; }

  public int getCalification() {    return calification; };

  public void setCalification(int calification) {     this.calification = calification;   }


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

}