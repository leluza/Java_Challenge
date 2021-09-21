package com.examplee.demoo.controller;

import com.examplee.demoo.entities.Film_Serie;
//import com.examplee.demoo.entities.Gender;
import com.examplee.demoo.services.Film_SerieService;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") // acceso desde distintos origenes
@RequestMapping(path = "/api/movies")
public class Film_SerieController {

  @Autowired
  private Film_SerieService film_serieService;

  // @Autowired
  // public Film_SerieController( Film_SerieService film_serieService )
  // { this.film_serieService = film_serieService; }

  //public Film_SerieController(Film_SerieService film_serieService) {
    //this.film_serieService = film_serieService;
  //}

  // RE permite el manejo de Status en formato JSON
  @GetMapping("") // lista los personaje (nada)
  public ResponseEntity<?> getAll() {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(film_serieService.findAll());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente mas tarde. \"}");
    }
  }

  @GetMapping("/{id}") // lista un film/serie  con id especifico
  public ResponseEntity<?> getOne(@PathVariable Long id) {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(film_serieService.findById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente mas tarde. \"}");
    }
  }

  @PostMapping("") // carga un personaje nuevo
  public ResponseEntity<?> save(@RequestBody Film_Serie entity) {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(film_serieService.save(entity));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body("{\"error\":\"Error. Por favor, intente mas tarde. \"}");
    }
  }

  @PutMapping("/{id}") // actualiza la/s caracteristicas de film/serie determinada
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Film_Serie entity) {
    try {

      return ResponseEntity.status(HttpStatus.OK).body(film_serieService.update(id, entity));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body("{\"error\":\"Error. Por favor, intente mas tarde. \"}");
    }
  }

  @DeleteMapping("/{id}") // elimina un personaje con id especifico
  public ResponseEntity<?> delete(@PathVariable Long id) {
    try {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(film_serieService.delete(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente mas tarde. \"}");
    }
  }

  @GetMapping("/search") // QUERY
  public ResponseEntity<?> search(@Nullable @RequestParam("title") String f_title,
      @Nullable @RequestParam("gender") Long f_gender, @Nullable @RequestParam("asc_order") Boolean f_asc) {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(film_serieService.search(f_title, f_gender, f_asc));

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente mas tarde. \"}");
    }
  }

  @GetMapping("/details") // MOSTRAR TODOS completo
  public ResponseEntity<?> details() {
    try {
      ResponseEntity<?> RE = ResponseEntity.status(HttpStatus.OK).body(film_serieService.details());
      return RE;
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente mas tarde. \"}");
    }
  }

}
