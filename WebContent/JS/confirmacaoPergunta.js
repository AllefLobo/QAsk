   

$(document).ready(function(){
	$("#apagar").click(function( e ){
		   if( !(confirm('Deseja apagar?')) ){
			      e.preventDefault();
		   }
	});
	
});