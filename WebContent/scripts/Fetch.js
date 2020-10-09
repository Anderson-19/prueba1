//--------------------------parte 1----------------------------------------------//

var registerForm = document.getElementById("register-form");
var registerButton = document.getElementById("register-button");

const SendRegister = (e) => {
    var form = new FormData(registerForm);
    console.log("hola");
    let fecth = new FetchLibrary();
    fecth.getResult('http://localhost:8080/ProyectoWeb_1/Servlets', form, 'POST').then((response) =>{
    	alert("Usuario Creado");
        console.log(response)
    } ).catch(err => err.message)
}

registerButton.onclick = SendRegister;

 
        