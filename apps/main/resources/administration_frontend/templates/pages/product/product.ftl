<#include "../../master.ftl">

<#macro page_title>Productos</#macro>

<#macro main>
	<form class="w-full max-w-lg" method="post" action="products">
	  <div class="flex flex-wrap -mx-3 mb-6">
	  	<div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
	      <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-id">
	        Identificador
	      </label>
	      <input class="<#if errors['id']?? >border border-red-500</#if> appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                id="grid-id" type="text" name="id" type="text" placeholder="En formado UUID"
                value="${(inputs['id'])!generated_uuid}">
            <#if errors['id']?? >
                <#list errors['id'] as errorMessage>
                    <p class="text-red-500 text-xs italic">${errorMessage}</p>
                </#list>
            </#if>
	    </div>
	    <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
	      <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-first-name">
	        Nombre Producto
	      </label>
	      <input class="<#if errors['name']?? >border border-red-500</#if> appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                   id="grid-first-name" type="text" name="name" placeholder="Nombre"
                   value="${(inputs['name'])!""}">
          
            <#if errors['name']?? >
                <#list errors['name'] as errorMessage>
                    <p class="text-red-500 text-xs italic">${errorMessage}</p>
                </#list>
            </#if>
	    </div>
	  </div>
	  <div class="flex flex-wrap -mx-3 mb-6">
	  	<div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
    	  <input class="<#if errors['categorieID']?? >border border-red-500</#if> appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
            id="categorieID" type="hidden" name="categorieID" 
            value="${(inputs['categorieID'])!""}">
	      <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="categories-list">
	        Categoria
	      </label>
	      <select id="categories-list" class="block appearance-none w-full bg-grey-lighter border border-grey-lighter text-grey-darker py-3 px-4 pr-8 rounded" onchange="updateUidCategorie(this.value)">
          </select>
	    </div>
	    <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
    	  <input class="<#if errors['measureID']?? >border border-red-500</#if> appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
            id="measureID" type="hidden" name="measureID" 
            value="${(inputs['measureID'])!""}">
	      <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="unidades-list">
	        Unidad de Medida
	      </label>
	      <select id="unidades-list" class="block appearance-none w-full bg-grey-lighter border border-grey-lighter text-grey-darker py-3 px-4 pr-8 rounded" onchange="updateUidMeasure(this.value)">
          </select>
	    </div>
	  </div>
	  <div class="flex flex-wrap -mx-3 mb-6">
	  	<div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">

	      <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-price">
	        Precio
	      </label>
	      <input class="<#if errors['price']?? >border border-red-500</#if> appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                   id="grid-price" type="text" name="price" placeholder="Precio"
                   value="${(inputs['price'])!""}">
          
            <#if errors['price']?? >
                <#list errors['price'] as errorMessage>
                    <p class="text-red-500 text-xs italic">${errorMessage}</p>
                </#list>
            </#if>
	    </div>
	  </div>
	  <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" type="submit">
	  Grabar
	</button>
	</form>
	<#include "partials/list_products_catalog.ftl">
	<script>
	function updateUidCategorie(select){
		 console.log("select: "+select);
		  var idCategoria = select;
		  console.log(idCategoria);
		  const gridUidCategorie = document.getElementById("categorieID");
		  gridUidCategorie.value = idCategoria;
	} 
	function updateUidMeasure(select){

		  var idMeasure = select;
		  console.log(idMeasure);
		  const gridUidMeasure = document.getElementById("measureID");
		  gridUidMeasure.value = idMeasure;
	} 
    function addCategoriesList(url) {
        console.log(url);

        const selectBody = document.getElementById("categories-list");

        fetch(encodeURI(url))
            .then(function (response) {
                return response.json();
            })
            .then(function (categories) {
            	selectBody.innerHTML = "";
                categories.forEach(function (categorie) {
                    let categorieOption = document.createElement("option");
                    categorieOption.value = categorie.id;
                    categorieOption.innerHTML = categorie.name;
                    selectBody.appendChild(categorieOption);
                })
                updateUidCategorie(document.getElementById("categories-list").value);
            });
    }
    function addMeasuresList(url) {
        console.log(url);

        const selectBody = document.getElementById("unidades-list");

        fetch(encodeURI(url))
            .then(function (response) {
                return response.json();
            })
            .then(function (categories) {
            	selectBody.innerHTML = "";
                categories.forEach(function (categorie) {
                    let categorieOption = document.createElement("option");
                    categorieOption.value = categorie.id;
                    categorieOption.innerHTML = categorie.name;
                    selectBody.appendChild(categorieOption);
                })
                updateUidMeasure(document.getElementById("unidades-list").value);
            });
    }
    </script>
    <script>
    addCategoriesList("http://localhost:8093/categories");
    addMeasuresList("http://localhost:8093/unitmeasures");
    
	</script>
</#macro>
