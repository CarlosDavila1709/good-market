<#include "../../master.ftl">

<#macro page_title>Productos</#macro>

<#macro main>

	<div id="products-rows">

	</div>

    <script>
	function addProductList(url) {
		
		fetch(encodeURI(url))
		        .then(function (response) {
	                return response.json();
	            })
	            .then(function (products) {
	               
	            	products.forEach(function (product) {
	
	                	printRowProduct(product);
	                	
	                })
	            });

	}
	
	function printRowProduct(product){
			const urlAddShoppinigCart = "http://localhost:8092/agregar-carrito/";
			const productsRows = document.getElementById('products-rows');
			const productsRowTemplate = "<div class=\"md:flex\">\n" +
			
										"	<form id=\"form1\" class=\"md:flex\" method=\"post\" action=\"/add-cart\">\n" +
										"    <div class=\"md:flex-shrink-0\">\n" +
										"    	<img class=\"rounded-lg md:w-56\"  src=\"https://images.unsplash.com/photo-1556740738-b6a63e27c4df?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=448&q=80\" width=\"448\" height=\"299\" alt=\"Woman paying for a purchase\">\n" +
										"    </div>\n" +
										"    <div class=\"mt-4 md:mt-0 md:ml-6\">\n" +
										"		<div class=\"uppercase tracking-wide text-sm text-indigo-600 font-bold\">\n" +
												product.name +
										"		</div>\n" +
		                                  "        <input class=\"appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500\"\n" +
		                                  "               name=\"productId\" type=\"hidden\" value="+product.id+">\n" +
		                                  "        <input class=\"appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500\"\n" +
		                                  "               name=\"price\" type=\"hidden\" value="+product.price+">\n" +

								        "		<select name =\"quantity\" class=\"block appearance-none w-full bg-gray-200 border border-gray-200 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500\" id=\"grid-state\">\n" +
								        "			<option>1</option>\n" +
								        " 			<option>2</option>\n" +
								        "  			<option>3</option>\n" +
								        "  			<option>4</option>\n" +
								        "  			<option>5</option>\n" +
								        "		</select>\n" +
								        "		<button type=\"submit\" class=\"link-button\">Agregar al carrito</button>\n" +
										"		<p class=\"mt-2 text-gray-600\">S/ "+product.price+"</p>\n" +
										"	 </div>\n" +
										"	</form>\n" +
										
										"</div>" ;
									
										
			productsRows.insertAdjacentHTML('beforeend', productsRowTemplate);
	}
	</script>
	<script>
    addProductList("http://localhost:8093/products-catalog");
	</script>


</#macro>
