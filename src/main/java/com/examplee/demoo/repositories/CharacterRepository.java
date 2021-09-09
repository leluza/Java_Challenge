
package com.examplee.demoo.repositories;

import com.examplee.demoo.entities.Character;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




@Repository
public interface CharacterRepository  extends  JpaRepository< Character, Long >{

  @Query(value = "SELECT c FROM Character c" )
  List<Character> search( ); //@Param("name") String f_name, @Param("age") int f_age);


}

// @Query
// List<Character> findByNombreContaining(String name);

// @Query(value = "SELECT c FROM Character c WHERE c.name LIKE %:name%")
// List<Character> search (@Param("name") String filtro );

// WHERE (c.name LIKE %:name% ) AND ((:age is Null) OR (c.age = :age) )")

// @Query("SELECT c FROM Customer c WHERE (:name is null or c.name = :name) and
// (:email is null" +" or c.email = :email)")

// @Query (value = "SELECT c FROM Character c WHERE ( :name = "" OR ( :name <>
// "" AND c.name LIKE %:name%)) AND (:age = "" OR (:age <> "" AND c.age = :age )
// ")

// @Query (value = "SELECT c FROM Character c WHERE ( :name IS NULL OR c.name
// LIKE %:name%) AND ( :age IS NULL OR c.age = :age ) ")
// @Param("id_movie") int f_id_movie);

// @Param("filtro") String filtro, @Param("id_movie") String filtro) ;
// where (:filtro = "" or (filtro <> "" and c.name like %:filtro%)) and
// siguiente filtro
// where ( filtro no esta O ( filtro esta y X_col == val_filtro))

// @Query(value = "SELECT c FROM Character c WHERE ( %:name% = "" or (%:name% <>
// "" and c.name like %:filtro%)) and (:age = "" or (:age <> "" and c.name like
// %:age%))
// (:filtro = "" or (filtro <> "" and c.name like %:filtro%))

// in nombre edad y pelicula
// cond1 --> si entra nombre y no edad y no pelicula
// cond2 --> si entra nombre y edad y no pelicula
// cond3 --> si entra nombre, edad y pelicula
