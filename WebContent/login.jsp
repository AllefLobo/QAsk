<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title></title>
  
    
  <!-- Bootstrap core CSS -->
  
    <link href="bootstrap-3.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="CSS/styleLogin.css" rel="stylesheet">

  <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">

</head>
<body>

    <div class="container">
      <div class="row">

      <div class="col-md-6 col-md-offset-3">
        <div class="panel panel-login">
          <div class="panel-heading">
            <div class="row">
              <div class="col-xs-6">
                <a href="#" class="active" id="login-form-link">Login</a>
              </div>
              <div class="col-xs-6">
                <a href="" name="register" id="register-form-link">Register</a>
              </div>
            </div>
            <hr>
          </div>
          <div class="panel-body">
            <div class="row">
            
              <div class="col-lg-12">
              <!-- Form login -->

                <form id="login-form" action="autentica" method="post" role="form" style="display: block;">
                  <div class="form-group">
                    <input type="text" name="login-username" id="login-username" tabindex="1" class="form-control" placeholder="Username" value=""><br/>
                    
                  </div>
                  <div class="form-group">
                    <input type="password" name="login-password" id="login-password" tabindex="2" class="form-control" placeholder="Password"><br/>
                   <p id="login-erro" class="alert alert-danger" ></p>
                  </div>
                   <div id="erro" class="alert alert-danger" role="alert">
						${erro}
					</div>

                  <div class="form-group">
                    <div class="row">
                      <div class="col-sm-6 col-sm-offset-3">
                        <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
                      </div>
                    </div>
                  </div>
                  
                  
                  <!--<div class="form-group">
                    <div class="row">
                      <div class="col-lg-12">
                        <div class="text-center">
                          <a href="" tabindex="5" class="forgot-password">Forgot Password?</a>
                        </div>
                      </div>
                    </div>
                  </div>-->
                </form>
                <form action="AutenticacaoAnonimo"  method="post">
                	<input type="submit" name="entrar-sem-logar" id="entrar-sem-logar" tabindex="4" class="form-control btn btn-login" value="Entrar sem logar">
                </form>
                <!-- Form registrar -->
             
                <form id="register-form"  action="adicionaPessoa" method="post" role="form" style="display: none;">
                  <div class="form-group">
                    <input type="text" name="register-username" id="register-username" tabindex="1" class="form-control" placeholder="Username" >
                   
                  </div>
                  <div class="form-group">
                    <input type="email" name="register-email" id="register-email" tabindex="1" class="form-control" placeholder="Email Address">
                  
                  </div>
                  <div class="form-group">
                    <input type="password" name="register-password" id="register-password" tabindex="2" class="form-control" placeholder="Password">
                  	
                  </div>
                  <div class="form-group">
                    <input type="password" name="register-confirm-password" id="register-confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password">
                    <p id="register-erro" class="alert alert-danger" ></p>

                    <div class="row">
                    <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
                     
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="bootstrap-3.1.0/dist/js/bootstrap.min.js"></script>
    <script src=" JS/scriptLogin.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="bootstrap-3.1.0/ie10-viewport-bug-workaround.js"></script>
</body>

</html>