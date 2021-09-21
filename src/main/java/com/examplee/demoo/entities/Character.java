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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//import org.hibernate.annotations.ManyToAny;


//import lomb
//import lombok.Setter;


@Entity
@Table(name= "Characters")
public class Character implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true, nullable = false)
        private Long id_character;

        @Column
        private String name;
        
        @Column
        private int age;
        
        @Column
        private int weight;
        
        @Column
        private String  history;
        
        @Column(length = 1500)
        private String image;

        @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
        @JoinTable( name = "characters__films_series",
                                        joinColumns=@JoinColumn(name="id_character"), inverseJoinColumns=@JoinColumn(name="id_film_serie"))
        private List<Film_Serie> film_series_asociated = new ArrayList<Film_Serie>();

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
         * @return List<Film_Serie> return the film_series_asociated
         */
        public List<Film_Serie> getFilm_series_asociated() {
          return film_series_asociated;
        }

        /**
         * @param film_series_asociated the film_series_asociated to set
         */
        public void setFilm_series_asociated(List<Film_Serie> film_series_asociated) {
          this.film_series_asociated = film_series_asociated;
        }


            @Override
            public int hashCode() {
              final int prime = 31;
              int result = 1;
              result = prime * result + age;
              result = prime * result + ((film_series_asociated == null) ? 0 : film_series_asociated.hashCode());
              result = prime * result + ((history == null) ? 0 : history.hashCode());
              result = prime * result + ((id_character == null) ? 0 : id_character.hashCode());
              result = prime * result + ((image == null) ? 0 : image.hashCode());
              result = prime * result + ((name == null) ? 0 : name.hashCode());
              result = prime * result + weight;
              return result;
            }

            @Override 
            //esta comparando valores de variables no direcciones de mem
            public boolean equals(Object obj) {
              if (this == obj)
                return true;
              if (obj == null)
                return false;
              if (getClass() != obj.getClass())
                return false;
              Character other = (Character) obj;
              if (age != other.age)
                return false;
              if (film_series_asociated == null) {
                if (other.film_series_asociated != null)
                  return false;
              } else if (!film_series_asociated.equals(other.film_series_asociated))
                return false;
              if (history == null) {
                if (other.history != null)
                  return false;
              } else if (!history.equals(other.history))
                return false;
              if (id_character == null) {
                if (other.id_character != null)
                  return false;
              } else if (!id_character.equals(other.id_character))
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
              if (weight != other.weight)
                return false;
              return true;
            }



}