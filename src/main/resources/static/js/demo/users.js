// Call the dataTables jQuery plugin
$(document).ready(function() {

  alert( ' Buen Dia :) ');

  getUsers();

  //alert( ' alerta de DSP');

  $('#users').DataTable();
});

 async function getUsers() {
  
   const request = await fetch('http://localhost:8080/api/users', { 
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
   });

  const users = await request.json();

  console.log(users);
 
  let usersHtml = ' ';
    for (let us of users){

        let delete_btn = '<a href="#" onclick="deteleUser(' + us.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

        let userHtml = '<tr><td>'+us.name+' '+us.lastname+'</td><td>'+us.email+'</td><td>'+us.user+'</td><td>'+us.id+'</td><td>'+us.image+'</td><td>' + delete_btn + '</td></tr>';

        usersHtml += userHtml;
    }

  document.querySelector('#users tbody').outerHTML =  usersHtml;
}


async function deteleUser(id){
  
  
 // alert(' desde el delete');
  //console.log(id);

  if ( !confirm(' Desea eliminar el usuario ' + id +'? ')){     return;  }

     const request = await fetch('http://localhost:8080/api/users/' +id, { 
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
   });
     
   location.reload();

  //const users = await request.json();
  // console.log(users);
}




 async function saveUser() {
  
  const request = await fetch('http://localhost:8080/api/users/123456789', { // donde id=222 a modo de ejemplo de  peticion
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
   });
  const users = await request.json();

  console.log(users);
}
  
