<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script>
$(document).ready(function(){
	var orderTotal = 0; //Order total
	var products = []; //Cafe products
	$("#itemsize").hide(); //Hide item size drop down
	$('<option/>').val('Select').html('-Select-').appendTo('#cafe'); //Populate cafe drop down with select option
	url1 = '/CafeSite-1.0/rest/cafes'; //RESTful WS URI returning list of cafes
	$.getJSON(url1, function(data) { //Get JSON result after posting to WS
 		$.each(data, function(i,item){ //Set cafe values
 			$('<option/>').val(item).html(item).appendTo('#cafe');
 		});
	});
  	$("#s1").click(function(){ //Select cafe and get the products
  		var index = $("#cafe")[0].selectedIndex; //Index of selected cafe 
  		if(index != 0) { //If value other than select
  			$("#order tr").remove(); //Remove order items
  			$("#orderTotal").text('£'+orderTotal); //Remove order total 
  			orderTotal = 0; //Reset order total
  			$("#cafeName").text($('#cafe').val()); //Set cafe
	  		$("#item> option").remove(); //Remove items
	  		$("#itemsize").hide(); //Hide size drop down
	  		$("#itemsize> option").remove(); //Remove sizes
	  		products = []; //Define products
	  		url2 = '/CafeSite-1.0/rest/cafe/'+$('#cafe').val()+'/products'; //RESTful WS url for cafe products
	  		$('<option/>').val('Select').html('-Select-').appendTo('#item'); //Populate item drop down with select option
	       	$.getJSON(url2, function(data) { //Get JSON result after posting to WS
	       		$.each(data, function(i,item){ //Set cafe products/items/menu items
	       			$('<option/>').val(item.name).html(item.name).appendTo('#item');
	       			products.push(item);
	       		});
			});
  		}	
  	});
  	$("#a1").click(function(){ //Add item 
  		var index = $("#item")[0].selectedIndex; //Index of selected product/item/menu item
  		if(index != 0) { //If value other than select
	  		var row; //Order table row
	  		if(products[index-1].sized) {//If product is sized
	  			row = '<tr><td>'+products[index-1].name+'</td><td>'+$('#itemsize').val()+'</td><td>£'+products[index-1].prices[$("#itemsize")[0].selectedIndex]+'</td></tr>';
	  			orderTotal += products[index-1].prices[$("#itemsize")[0].selectedIndex]; 
	  		}
	  		else { //Product is not sized
	  			row = '<tr><td>'+products[index-1].name+'</td><td>-</td><td>£'+products[index-1].prices[0]+'</td></tr>';
	  			orderTotal += products[index-1].prices[0];
		  	}	
	  		$("#order").append(row); //Add order row 
	  		$("#orderTotal").text('£'+orderTotal); //Update order total
  		}
  			
  	});
  	$("#item").change(function(){ //A different product is selected
  		var index = $("#item")[0].selectedIndex; //Index of selected product
  		if(index != 0) { //If value other than select
  			$("#itemsize> option").remove(); //Remove sizes
	  		var item = products[index-1]; //Get product
	  		if(item.sized) { //Product is sized
	  			$("#itemsize").show(); //Show sizes
	  	  		$.each(item.sizes, function(i,size){ //Set sizes
		  	  		$('<option/>').val(size).html(size).appendTo('#itemsize');
	  	  		});	
	  	  	}
	  		else {
	  			$("#itemsize").hide(); //hide sizes	
	  	  	}
  		}
  		else {
  			$("#itemsize").hide(); //hide sizes	
  	  	}
  	});	
});
</script>
<title>Home</title>
</head>
<body>
<h1>
	Welcome to Cafe Site!  
</h1>

<P>  
	Cafe 
	<select id="cafe">
	</select>
	<button id="s1">Select Cafe</button>
	<b><span id="cafeName"></span></b>
</P>
<P>  
	Menu
	<select id="item">
	</select>
	<select id="itemsize">
	</select>
	<button id="a1">Add Item</button> 
</P>

<P>  
	Order Items:
</P>
<P>
<table id="order" border="1">
</table>
</P>
<P>  
	Order Total: <b><span id="orderTotal"></span></b>
</P>
</body>
</html>
