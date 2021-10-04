// Call the dataTables jQuery plugin
$(document).ready(function() {

  alert( ' Bienvenida  :) ');


});

 async function registerUser() {
  
    let data = {};

    data.name = document.getElementById('txtName').value;
    data.lastname = document.getElementById('txtLastname').value;
    data.email = document.getElementById('txtEmail').value;
    data.password = document.getElementById('txtPassword').value;
    //data.repasword = document.getElementById('txtRepassword').value;

    console.log(data);

    if( data.password != document.getElementById('txtRepassword').value)
    {   alert(' Please, verify that the password is the same.'); return;  }

   const request = await fetch('http://localhost:8080/api/users', { 
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
         body: JSON.stringify(data)
   });


  const users = await request.json();

}



