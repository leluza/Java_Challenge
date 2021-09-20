package com.examplee.demoo.services;

import com.examplee.demoo.DTO.CharacterDTO;
import com.examplee.demoo.DTO.CharacterFullDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.examplee.demoo.repositories.CharacterRepository;
import com.examplee.demoo.entities.Character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {     //implements BaseService <CharacterDTO>{

  @Autowired
  private CharacterRepository characterRepository;


  
  @Transactional    // MOSTRAR TODOS 2 prop
  public List<CharacterDTO> findAll() throws Exception {
    try  {
        List<Character> entities = characterRepository.findAll();
        List<CharacterDTO> dtos = new ArrayList<CharacterDTO>();
        
        for( Character ch : entities)
        {
          CharacterDTO auxDto = new CharacterDTO();
          auxDto.setImage(ch.getImage());
          auxDto.setName(ch.getName());
          dtos.add(auxDto);
        }
        return dtos;
    } catch (Exception e) {
       throw new Exception(e.getMessage());
    }
  }

  
  @Transactional  // MOSTRAR UNO
  public CharacterFullDTO findById(Long id) throws Exception {
    try {
      Optional<Character> entityOptional = characterRepository.findById(id);
      //no sabe si encontrata una tabla o un registro
      Character ch = entityOptional.get();
      CharacterFullDTO fullDto = new CharacterFullDTO();
        fullDto.setImage(ch.getImage());
        fullDto.setName(ch.getName());
        fullDto.setWeight(ch.getWeight());
        fullDto.setHistory(ch.getHistory());
        fullDto.setId_character(ch.getId_character());
        fullDto.setAge(ch.getAge());
        fullDto.setFilm_series_asociated(ch.getFilm_series_asociated());
      return fullDto;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  
  @Transactional  //  CARGAR
  public Character save(Character entity) throws Exception {
    try {

      //ingresa info de todos los campos, menos id
      entity = characterRepository.save(entity);
      //salen todos los campos, incluidos ID
      return entity;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  
  @Transactional  // ACTUALIZAR
  public Character update(Long id, Character entity) throws Exception {
    try {
      Optional<Character> optionalEntity = characterRepository.findById(id);
      Character entity_bbdd = optionalEntity.get();
      entity_bbdd = characterRepository.save(entity);
      return entity_bbdd;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  
  @Transactional  // ELIMINAR
  public boolean delete(Long id) throws Exception {
    try {
      if( characterRepository.existsById(id))
        {
          characterRepository.deleteById(id);
          return true;
        }
        else{
            throw new Exception();
          }
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }
  

  @Transactional    // QUERY
  public List<Character> search (String f_name, Integer f_age, Long f_id_movie) throws Exception {

    try {
      List<Character> query_characters = characterRepository.search(); //f_name, f_age);

          List<Character> filtered_characters = new ArrayList<Character>();

          filtered_characters = query_characters;

          if ( f_name  != null )
          {
              filtered_characters = filtered_characters.stream().filter(ch -> ch.getName().equals(f_name)).collect(Collectors.toCollection(ArrayList::new));
          }
          
          if (f_age  != null)
          {
              filtered_characters = filtered_characters.stream()
                              .filter(   ch -> ch.getAge() == f_age ).collect(Collectors.toCollection(ArrayList::new));
          }
          
          if(  f_id_movie  != null  ) //|| f_age == 0 )
          {
                filtered_characters = filtered_characters.stream().filter(ch -> ch.getFilm_series_asociated().stream().filter( fs -> fs.getId_film_serie() == f_id_movie).findFirst().isPresent()
                          ).collect(Collectors.toCollection(ArrayList::new)); 
          }

      return filtered_characters;
    } catch ( Exception e)  {
       throw new Exception ( e.getMessage());
    }

  }

  @Transactional // MOSTRAR TODOS completo
  public List<CharacterFullDTO> details() throws Exception {
    try {
      List<Character> entities = characterRepository.findAll();
      List<CharacterFullDTO> fullDtos = new ArrayList<CharacterFullDTO>();
        
        for( Character ch : entities)
        {
          CharacterFullDTO fullDto = new CharacterFullDTO();
          fullDto.setImage(ch.getImage());
          fullDto.setName(ch.getName());
          fullDto.setWeight(ch.getWeight());
          fullDto.setHistory(ch.getHistory());
          fullDto.setId_character(ch.getId_character());
          fullDto.setAge(ch.getAge());
          fullDto.setFilm_series_asociated(ch.getFilm_series_asociated());
          fullDtos.add(fullDto);
        }
          return fullDtos;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }
  

}
