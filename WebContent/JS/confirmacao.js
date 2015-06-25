   

$(document).ready(function(){
	$("#apagar").click(function( e ){
		   if( !(confirm('Deseja apagar?')) ){
			   alert('Okay, nada feito!');
			      e.preventDefault();
		   }
	});
	
});