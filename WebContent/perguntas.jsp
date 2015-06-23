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
 
 <a href="/Qask/index.jsp"" class="navbar-brand">Qask </a> <button class="navbar-toggle"
      data-toggle="collapse" data-target=".navHeaderCollapse"></button>

      <div class="collapse navbar-collapse navHeaderCollapse">
        <ul class="nav navbar-nav navbar-right">
          <li ><a href="listarRespostas">Home</a></li>

          <li class="active"><a href="listaPergunta">Perguntas</a></li>

          <li class="dropdown">
            <a href="/Qask/perfil.jsp" >Perfil</a>

            <!--<ul class="dropdown-menu">
              <li><a href="#">Perfil</a></li>

              <li><a href="#">Amigos</a></li>

              <li><a href="#">Google+</a></li>

              <li><a href="#">Instagram</a></li>
            </ul>-->
          </li>

          <li><a href="/Qask/amigos.jsp">Amigos</a></li>

          <li><a href="/Qask/configuracao.jsp">ConfiguraÃ§ao</a></li>
          <li><a href="sair">Sair</a></li>
        </ul>
      </div>
    </div>
  </div>
  

  <div class="container">  
 


    <div class="well well-sm">
    <h2>Perguntas</h2>  
   <c:choose>
    	<c:when test="${not empty perguntas}">
	    	<c:forEach var="pergunta" items="${perguntas}">
				<div>
					<p>${pergunta.conteudo}</p>
	        		<a href="perguntaController?id_pergunta=${pergunta.id}" class="btn btn-primary " >Responder</a>
	        		<a href="#" class="btn btn-danger " >Apagar</a>
      			</div>
			</c:forEach>
	    </c:when>
	    <c:otherwise>
	    	não há perguntas
	    </c:otherwise>
    </c:choose>
     </div>
      
    
      


  </div>


  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="bootstrap-3.1.0/dist/js/bootstrap.min.js"></script>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="bootstrap-3.1.0/ie10-viewport-bug-workaround.js"></script>
</body>

</html>
