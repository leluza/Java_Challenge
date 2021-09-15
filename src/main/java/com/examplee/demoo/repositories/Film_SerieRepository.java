
package com.examplee.demoo.repositories;

import com.examplee.demoo.entities.Film_Serie;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Film_SerieRepository extends JpaRepository<Film_Serie, Long> {

  @Query(value = "SELECT fs FROM Film_Serie fs")
  List<Film_Serie> search(); // @Param("name") String f_name, @Param("age") int f_age);

}