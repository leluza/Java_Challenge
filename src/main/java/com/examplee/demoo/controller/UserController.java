package com.examplee.demoo.controller;

import com.examplee.demoo.DAO.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.examplee.demoo.entities.*;

@RestController
@CrossOrigin(origins = "*") // acceso desde distintos origenes

// @RequestMapping(path = "/api/users")  // por defecto se ofrece la opcion de acceder,
 // en caso de querer registrarse, se facilita un boton para comenzar el registro

public class UserController {

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user) {
      userDao.register(user);
    
    }

    @RequestMapping( value = "/prueba")
    public String prueba(){
      return "pruebaaaa"; }

    @RequestMapping ( value = "/{id}"  , method = RequestMethod.GET  )
    public User getUser(@PathVariable Long id) {
      User us = new User(id,"ade"+id, "mayol", "@"+id,"lelu","1234","avtrtyhhyh");    
      return us;    }


    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> getUsers() {

       boolean test = false;

        if( test){
                List<User> users = new ArrayList<User>();

                long id = 9999999;
                User u1 = new User(id, "ade" + id, "mayol", "@" + id, "lelu", "1234", "avtrtyhhyh");
                id = 8888888;
                User u2 = new User(id, "ade" + id, "mayol", "@" + id, "lelu", "1234", "avtrtyhhyh");
                  id = 7777777;
                User u3 = new User(id, "ade" + id, "mayol", "@" + id, "lelu", "1234", "avtrtyhhyh");

                users.add(u1);
                users.add(u2);
                users.add(u3);

                return users;   }  
            else          {
                  return  userDao.getUsers();
          }
        
        }
      

    
    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
       userDao.remove(id);
    }


}

/*
 * @RequestMapping(value = "/123") public User getUsuario() { User us = new
 * User("ade", "mayol", "@", "lelu", "1234", "avtrtyhhyh"); return us; }
 */
  
  /*
    0) cambio el archivo "tables.html" a "usuarios.html" 
  
    1) Cambio el metodo prueba, por un metodo getUsuario()
      con valores hardcodeados desde aqui, el controller, 
      solamente para que el html y el .js tengan que mostrar

    @RequestMapping( value = "prueba")
    public String prueba(){
      return "prueba";

      2) del archivo demo.js, le cambio al nombre usuarios.js porque es el archivo que trataba las acciones con la tabla

      3) luego actualizo el nombre "demo"-->"usuario " en el  usuario.html

      4) crea la funcion, cargarUsuario() en usuarios.js
         y hace que la cargue antes de cargar la tabla
        en la funcion principal .ready()

        la crea con la funcion FETCH de Json
        coloca la ruta del metodo del controller asociado get Usuario()
        aclara que es un metodo get
        contiene la palabra async y await para sincronizar las respuestas a las peticiones con las cargas en la pantalla
       
        luego crea en el controller, otro metodo getUsuarios, para que mestre otro metodo hardcodeado del controller, esto lo hace, sobre escribiendo en el json, el metodo llamado getUsuario() por getUsuarios()

        1:45  


          

    }


}

 /*
  * metodos que necesita la clase Usuario
  * 
  * crear, POST, save(), cuando se registra un user
  * 
  * actualizar, PUT, pudate() , para una actualizacion de contraseña
  * 
  * 
  * MECANISMO
  * 
  * 1) se REGISTRA
  * 
  *       html & JS --> carga 5 datos en cajas de texto que son tomados y pasados en
  * formato Json
  * 
  *       Ctrll ---------> POST ( crear, save() ) carga los datos en un registro de la
  * tabla de usuarios
  * 
  * 
  * 2) ACCEDE
  * 
  *       html & JSON --> carga 2 datos en cajas de texto que son tomados y pasados en
  * formato Json y devolver, de ser valido, un token.
  * 
  *        Ctrll  -->   String Generar_Token(  String dato_A )

            Srv  -->           User filtrar_us_con_dato_A ( String dato_A )
  * 
  *        Rep -->                List<User> obtener_lista_usuarios())


      3) DSP de LOGGEARSE, aparecen botones para 

      a) listar todos los personajes
      b) listar el personaje con el id determinado


      LA PLANTILLA DE TABLAS

          sirve para listar los personajes, las pelicuas ---> findAll() 

          tambien srirve para mostrar de a uno. 

          acomodar los nombres de las columnas del html, acorde a los datos que responda del DTO de peliculas o de personajes

  */