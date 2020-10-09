
var formulario = document.getElementById("register-form");
var Button = document.getElementById("register-button");

var url = 'http://localhost:8090/ProyectoWeb_1/Servlets';

var SendRegister = function(){
    var form = new FormData(formulario);
    
    fecth(url,{method:'POST', body:form} )
    .then(response => response.json()).then((response) =>{
        console.log(response)
    } ).catch(err => err.message)
}
try {
	Button.onclick = SendRegister;
  } catch (e) {
    this._deferred.reject(e);
  }


 
        