$(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

	document.getElementById("register-submit").onclick = validarRegistro;
	document.getElementById("login-submit").onclick = validarLogin;

});


function validarRegistro(){


	var nome = document.getElementById("register-username").value;
	var email = document.getElementById("register-email").value;
	var confirmSenha = document.getElementById("register-confirm-password").value;
	var senha = document.getElementById("register-password").value;

	
	if (nome == "" || email == "" || senha == "" || confirmSenha == "") {
		document.getElementById("register-erro").innerHTML = "Preencha os campos de nome, senha ou email"; 
		return false;
	}
	
	if( senha != confirmSenha ){
		document.getElementById("register-erro").innerHTML = "Os campos de senha diferentes"; 
		return false;
	}
	

}

function validarLogin(){
	var nome = document.getElementById("login-username").value;
	var senha = document.getElementById("login-password").value;
	
	if (nome == "" || senha == "" ) {
		document.getElementById("login-erro").innerHTML = "Preencha os campos de nome ou senha"; 
		return false;
	}
	

	
}
