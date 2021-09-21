package com.examplee.demoo.services;

import com.examplee.demoo.DTO.Film_Serie_FullDTO;
import com.examplee.demoo.entities.*;
import com.examplee.demoo.entities.Character;
import com.examplee.demoo.DTO.Film_Serie_LightDTO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.examplee.demoo.repositories.Film_SerieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Film_SerieService {      //implements BaseService<Film_Serie> {

  @Autowired
  private Film_SerieRepository film_serieRepository;

  //public Film_SerieService() {
  //}

  @Transactional  // Mostrar todas las series 3 PROP
  public List<Film_Serie_LightDTO> findAll() throws Exception {
    try {
      List<Film_Serie> entities = film_serieRepository.findAll();
      List<Film_Serie_LightDTO> dtos = new ArrayList<Film_Serie_LightDTO>();

      for (Film_Serie fs : entities) {
        Film_Serie_LightDTO auxDto = new Film_Serie_LightDTO();
        auxDto.setImage(fs.getImage());
        auxDto.setTitle(fs.getTitle());
        auxDto.setBegin_date(fs.getBegin_date());
        dtos.add(auxDto);
      }
      return dtos;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Transactional  // Mostrar UNO
  public Film_Serie_FullDTO findById(Long id) throws Exception {
    try {
      Optional<Film_Serie> entityOptional = film_serieRepository.findById(id);
      Film_Serie fs = entityOptional.get();
      Film_Serie_FullDTO fullDto = new Film_Serie_FullDTO();
      //fullDto.set(fs.getId_film_serie());
      fullDto.setTitle(fs.getTitle());
      fullDto.setBegin_date(fs.getBegin_date());
      fullDto.setImage(fs.getImage());
      fullDto.setCalification(fs.getCalification());
      //fullDto.setAge(ch.getAge());
      // fullDto.setFilm_series_asociated(ch.getFilm_series_asociated());
      List<Character> ch_list = fs.getCharacters_asociated();
      List<String> ch_name_list = new ArrayList<String>();
      ch_list.stream().forEach(e -> ch_name_list.add(e.getName()));
      fullDto.setName_characters_asociated(ch_name_list);
      // no sabe si encontrata una tabla o un registro
      return  fullDto;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Transactional
  public Film_Serie save(Film_Serie entity) throws Exception {
    try {
      entity = film_serieRepository.save(entity);
      return entity;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Transactional
  public Film_Serie update(Long id, Film_Serie entity) throws Exception {
    try {
      Optional<Film_Serie> optionalEntity = film_serieRepository.findById(id);
      Film_Serie entity_bbdd = optionalEntity.get();
      entity_bbdd = film_serieRepository.save(entity);
      return entity_bbdd;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

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

  @Transactional  // QUERY
  public List<Film_Serie> search(String f_title, Long f_gender, Boolean f_asc) throws Exception {

    try {
      List<Film_Serie> query_film_series = film_serieRepository.search(); // f_name, f_age);

      List<Film_Serie> filtered_film_series = new ArrayList<Film_Serie>();

      filtered_film_series = query_film_series;

      if (f_title != null) {
        filtered_film_series = filtered_film_series.stream().filter(
                                                              fs -> fs.getTitle().equals(f_title))
                                                 .collect(Collectors.toCollection(ArrayList::new));
      }

      if (f_gender != null) {
        filtered_film_series = filtered_film_series.stream().filter(
          fs -> fs.getGender().getId_gender() == f_gender)
            .collect(Collectors.toCollection(ArrayList::new));
      }

      if (f_asc  != null)  
      {
        // reversit el orden
        // Collections.sort(objectOfArrayList, Collections.reverseOrder());
          
        //Collections.sort(filtered_film_series ,Collections.reverseOrder());

          Comparator <Film_Serie> c = (a,b) -> f_asc ? ((Integer)a.getBegin_date()).compareTo( (Integer) b.getBegin_date()) :  ((Integer) b.getBegin_date()).compareTo( (Integer)a.getBegin_date()) ;

          filtered_film_series.sort(c);

        }

      return filtered_film_series;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }

  }

  @Transactional // MOSTRAR TODOS completo
  public List<Film_Serie_FullDTO> details() throws Exception {
    try {
      List<Film_Serie> fs_list = film_serieRepository.findAll();
      List<Film_Serie_FullDTO> fs_fullDtos_list = new ArrayList<Film_Serie_FullDTO>();

    for( Film_Serie  fs : fs_list)
    {
      Film_Serie_FullDTO fs_fullDto = new Film_Serie_FullDTO();
     // Film_Serie_FullDTO fullDto = new Film_Serie_FullDTO();
      // fullDto.set(fs.getId_film_serie());
      fs_fullDto.setTitle(fs.getTitle());
      fs_fullDto.setBegin_date(fs.getBegin_date());
      fs_fullDto.setImage(fs.getImage());
      fs_fullDto.setCalification(fs.getCalification());
      // fullDto.setAge(ch.getAge());
      // fullDto.setFilm_series_asociated(ch.getFilm_series_asociated());
      List<Character> ch_list = fs.getCharacters_asociated();
      List<String> ch_name_list = new ArrayList<String>();
      ch_list.stream().forEach(e -> ch_name_list.add(e.getName()));
      fs_fullDto.setName_characters_asociated(ch_name_list);
      fs_fullDtos_list.add(fs_fullDto);
    }
      // no sabe si encontrata una tabla o un registro
      return fs_fullDtos_list;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

}
