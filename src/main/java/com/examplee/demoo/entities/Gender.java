package com.examplee.demoo.entities;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Genders")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column ( unique =  true, nullable = false)
    private Long id_gender;

    @Column
    private String name;

    @Column
    private String image;

    @OneToMany
    private List<Film_Serie> _film_serie_asociated = new ArrayList<Film_Serie>();


    /**
     * @return Long return the id_gender
     */
    public Long getId_gender() {
        return id_gender;
    }

    /**
     * @param id_gender the id_gender to set
     */
    public void setId_gender(Long id_gender) {
        this.id_gender = id_gender;
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
     * @return Lista<Film_Serie> return the film_serie_asociated
     */
    public List<Film_Serie> getFilm_serie_asociated() {
        return _film_serie_asociated;
    }

    /**
     * @param film_serie_asociated the film_serie_asociated to set
     */
   public void setFilm_serie_asociated(List<Film_Serie> film_serie_asociated) {
        this._film_serie_asociated = film_serie_asociated;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((_film_serie_asociated == null) ? 0 : _film_serie_asociated.hashCode());
      result = prime * result + ((id_gender == null) ? 0 : id_gender.hashCode());
      result = prime * result + ((image == null) ? 0 : image.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
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
      Gender other = (Gender) obj;
      if (_film_serie_asociated == null) {
        if (other._film_serie_asociated != null)
          return false;
      } else if (!_film_serie_asociated.equals(other._film_serie_asociated))
        return false;
      if (id_gender == null) {
        if (other.id_gender != null)
          return false;
      } else if (!id_gender.equals(other.id_gender))
        return false;
      if (image == null) {
        if (other.image != null)
          return false;
      } else if (!image.equals(other.image))
        return false;
      if (name == null) {
        if (other.name != null)
          return false;
      } else if (!name.equals(other.name))
        return false;
      return true;
    }


    
}
