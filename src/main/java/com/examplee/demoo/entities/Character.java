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
        @JoinTable( name = "characters__films_series",  joinColumns=@JoinColumn(name="id_character"), inverseJoinColumns=@JoinColumn(name="id_film_serie"))
        private List<Film_Serie> film_series_asociated = new ArrayList<Film_Serie>();


        public Long getId()
        {  return id_character; }

        public void setId( Long id_character )
        {   this.id_character = id_character;}

        public String getNombre() {
          return name;
        }      
        public void setNombre ( String nombre )
        {     this.name = nombre;}

        public String getHistoria(  ) {
              return history;        }

        public void setHistoria( String historia)
        {this.history = historia;  }

          public int getEdad() {             return age;          }

          public void setEdad(int edad) {  this.age = edad;}
          
          public int getPeso() { return this.weight;};

          public void setPeso(int peso) {
            this.weight = peso;}

            public String getImage() {
              return image;
            }

            public void setImage(String image) {
              this.image = image;
            }

            public List<Film_Serie>  getFilmSerie( ) {  return     film_series_asociated ;}

            public void setFilmSerie( List<Film_Serie> film_serie)
             { this.film_series_asociated = film_serie; }

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