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
        @JoinTable( name = "characters_films_series",  joinColumns=@JoinColumn(name="id_character"), inverseJoinColumns=@JoinColumn(name="id_film_serie"))
        private List<Films_Series> film_series_asociated = new ArrayList<Films_Series>();


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

            public List<Films_Series>  getFilmSerie( ) {  return     film_series_asociated ;}

            public void setFilmSerie( List<Films_Series> film_serie)
             { this.film_series_asociated = film_serie; }


}