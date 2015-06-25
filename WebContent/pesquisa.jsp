<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title></title>
  
    
  <!-- Bootstrap core CSS -->
    <link href="bootstrap-3.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
  <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">

</head>
<body>
  <!--
Sticky footer example by Mr. M. - Confederation College - IMD Program 

Based on tutorial from: http://www.coders-guide.com/watch.php?v=53
-->

<div class="navbar navbar-inverse navbar-static-top">
 
 <div class="container">
 
 <a href="listarRespostas" class="navbar-brand">Qask </a> <button class="navbar-toggle"
      data-toggle="collapse" data-target=".navHeaderCollapse"></button>

      <div class="collapse navbar-collapse navHeaderCollapse">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="listarRespostas">Home</a></li>

          <li><a href="listaPergunta">Perguntas</a></li>

          <li><a href="perfilController?perfil=${user.nome}" >Perfil</a></li>

          <li><a href="pegarAmigos">Amigos</a></li>

          <li><a href="/Qask/configuracao.jsp">Configura&ccedil&atildeo</a></li>
          <li class="active"><a href="/Qask/pesquisa.jsp">Pesquisar</a></li>
          <li><a href="sair">Sair</a></li>
        </ul>
      </div>
    </div>
  </div>
  

  <div class="container">  



    <div class="well well-sm">


	<div>
		<form method="" action="" class="pesquisa">
			<input type="text" values=""/>
			<input type='submit' class="btn btn-primary" value='Pesquisar' name="pesquisar" id="pesquisa">
		</form>
	</div> 


	<div class="amigo">
		<img src="http://www.gravatar.com/avatar/2ab7b2009d27ec37bffee791819a090c?s=100&d=mm&r=g" alt="Karan Singh Sisodia" title="Karan Singh Sisodia" class="img-circle">
		<h2>adfasdfasd<h2>
		<a href="#" class="btn btn-success " >Ver Perfil</a>
	</div>
	 </div>
   </div>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="bootstrap-3.1.0/dist/js/bootstrap.min.js"></script>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="bootstrap-3.1.0/ie10-viewport-bug-workaround.js"></script>
</body>

</html>
