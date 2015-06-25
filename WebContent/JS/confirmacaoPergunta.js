   

$(document).ready(function(){
	$("#excluir").click(function( e ){
		   if( !(confirm('Deseja apagar?')) ){
			      e.preventDefault();
		   }
	});
	
});