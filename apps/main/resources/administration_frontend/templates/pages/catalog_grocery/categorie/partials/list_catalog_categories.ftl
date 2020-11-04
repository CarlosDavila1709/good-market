
<div id="categoires-rows">

</div>

<!--  
<div class="max-w-sm rounded overflow-hidden shadow-lg">
  <img class="w-full" src="/img/card-top.jpg" alt="Sunset in the mountains">
  <div class="px-6 py-4">
    <div class="font-bold text-xl mb-2">BEBIDAS</div>
    <p class="text-gray-700 text-base">
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatibus quia, nulla! Maiores et perferendis eaque, exercitationem praesentium nihil.
    </p>
  </div>
  <div class="px-6 pt-4 pb-2">
    <span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2">#photography</span>
    <span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2">#travel</span>
    <span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2">#winter</span>
  </div>
</div>
-->

<script>
	function addCategorieList(url) {
		
		fetch(encodeURI(url))
		        .then(function (response) {
	                return response.json();
	            })
	            .then(function (categories) {
	               
	                categories.forEach(function (categorie) {
	
	                	printRowCategorie(categorie);
	                	
	                })
	            });

	}
	
	function printRowCategorie(categorie){
			const urlProduct = "http://localhost:8092/catalog-product/"+categorie.id;
			const categoriesRows = document.getElementById('categoires-rows');
			const categoriesRowTemplate = 	"<div class=\"max-w-sm rounded overflow-hidden shadow-lg\">\n" +
										"    <div class=\"px-6 py-4\">\n" +
										"    	<div class=\"font-bold text-xl mb-2\">\n" +
												categorie.name +
										"    	</div>\n" +
										"		<p class=\"text-gray-700 text-base\">\n" +
										//"			Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatibus quia, nulla! Maiores et perferendis eaque, exercitationem praesentium nihil.\n" +
										"		</p>\n" +
										"	</div>\n" +
										"	<div class=\"px-6 pt-4 pb-2\">\n" +
										"		<span class=\"inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2\">\n" +
										"		<a href=\""+ urlProduct +"\">\n" +
										"			#Ver productos\n" +
										"		</a>\n" +
										"		</span>\n" +
										"	</div>\n" +
										"</div>" ;
									
										
			categoriesRows.insertAdjacentHTML('beforeend', categoriesRowTemplate);
	}
</script>
<script>
    addCategorieList("http://localhost:8093/categories");
</script>

