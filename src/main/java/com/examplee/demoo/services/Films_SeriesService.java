package com.examplee.demoo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.examplee.demoo.repositories.Films_SeriesRepository;
import com.examplee.demoo.entities.Films_Series;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Films_SeriesService implements BaseService<Films_Series> {

  @Autowired
  private Films_SeriesRepository film_serieRepository;

  @Override
  @Transactional
  public List<Films_Series> findAll() throws Exception {
    try {
      List<Films_Series> entities = film_serieRepository.findAll();
      return entities;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  @Transactional
  public Films_Series findById(Long id) throws Exception {
    try {
      Optional<Films_Series> entityOptional = film_serieRepository.findById(id);
      // no sabe si encontrata una tabla o un registro
      return entityOptional.get();
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  @Transactional
  public Films_Series save(Films_Series entity) throws Exception {
    try {
      entity = film_serieRepository.save(entity);
      return entity;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  @Transactional
  public Films_Series update(Long id, Films_Series entity) throws Exception {
    try {
      Optional<Films_Series> optionalEntity = film_serieRepository.findById(id);
      Films_Series entity_bbdd = optionalEntity.get();
      entity_bbdd = film_serieRepository.save(entity);
      return entity_bbdd;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  @Transactional
  public boolean delete(Long id) throws Exception {
    try {
      if (film_serieRepository.existsById(id)) {
        film_serieRepository.deleteById(id);
        return true;
      } else {
        throw new Exception();
      }
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

}
