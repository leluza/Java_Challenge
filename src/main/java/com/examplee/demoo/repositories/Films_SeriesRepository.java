
package com.examplee.demoo.repositories;

import com.examplee.demoo.entities.Films_Series;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Films_SeriesRepository extends JpaRepository<Films_Series, Long> {

}