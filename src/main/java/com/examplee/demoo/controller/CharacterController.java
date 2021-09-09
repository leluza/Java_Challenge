package com.examplee.demoo.controller;

import com.examplee.demoo.entities.Character;
import com.examplee.demoo.services.CharacterService;

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
@RequestMapping( path = "/api/characters")
public class CharacterController {
  
  @Autowired
  private CharacterService characterService;

   //@Autowired
  // public CharacterController( CharacterService characterService )
   //{  this.characterService = characterService; }

    //RE permite el manejo de Status en formato JSON
    @GetMapping("")  //  MOSTRAR TODOS 2 porp
    public ResponseEntity<?> getAll(){
            try {
              ResponseEntity<?> RE = ResponseEntity.status(HttpStatus.OK).body(characterService.findAll());
              return RE;
            } catch (Exception e) {
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente mas tarde. \"}");
            }
      }


       @GetMapping("/{id}")        // MSTRAR UNO
       public ResponseEntity<?> getOne( @PathVariable Long id) {
        try {
          return ResponseEntity.status(HttpStatus.OK).body(characterService.findById(id));
        } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente mas tarde. \"}");
        }
      }


         @PostMapping("") // CARGAR
        public ResponseEntity<?> save( @RequestBody  Character entity) {
          try {
            return ResponseEntity.status(HttpStatus.OK).body(characterService.save(entity));
          } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor, intente mas tarde. \"}");
          }
        }

        @PutMapping("/{id}") // ACTUALIZAR
        public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Character entity) {
          try {
            
            return ResponseEntity.status(HttpStatus.OK).body(characterService.update(id, entity));
          } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("{\"error\":\"Error. Por favor, intente mas tarde. \"}");
          }
        }

        @DeleteMapping("/{id}") // ELIMINAR
        public ResponseEntity<?> delete(@PathVariable Long id) {
          try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(characterService.delete(id));
          } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente mas tarde. \"}");
          }
        }

        @GetMapping("/search")  // QUERY
        public ResponseEntity<?> search(@Nullable @RequestParam("name") String f_name , @Nullable @RequestParam("age") Integer f_age, @Nullable @RequestParam("id_movie") Long f_id_movie)
        {
          try {
              return ResponseEntity.status(HttpStatus.OK).body ( characterService.search(f_name,f_age,f_id_movie));

          } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("{\"error\":\"Error. Por favor, intente mas tarde. \"}");
          }
        }

        @GetMapping("/details") // MOSTRAR TODOS completo
        public ResponseEntity<?> details() {
          try {
            ResponseEntity<?> RE = ResponseEntity.status(HttpStatus.OK).body(characterService.details());
            return RE;
          } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("{\"error\":\"Error. Por favor, intente mas tarde. \"}");
          }
        }

   }


