<#include "../../master.ftl">

<#macro page_title>Categorias</#macro>

<#macro main>
	<form class="w-full max-w-lg" method="post" action="/categories">
	  <div class="flex flex-wrap -mx-3 mb-6">
	  	<div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
	      <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-first-name">
	        Identificador
	      </label>
	      <input class="<#if errors['id']?? >border border-red-500</#if> appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                id="grid-first-name" type="text" name="id" type="text" placeholder="En formado UUID"
                value="${(inputs['id'])!generated_uuid}">
            <#if errors['id']?? >
                <#list errors['id'] as errorMessage>
                    <p class="text-red-500 text-xs italic">${errorMessage}</p>
                </#list>
            </#if>
	    </div>
	    <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
	      <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-first-name">
	        Nombre Categoria
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
	  <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" type="submit">
	  Grabar
	</button>
	</form>

	<!--  <div class="container">
		<table class="w-full flex flex-row flex-no-wrap sm:bg-white rounded-lg overflow-hidden sm:shadow-lg my-5">
			<thead class="text-white">
				<tr class="bg-teal-400 flex flex-col flex-no wrap sm:table-row rounded-l-lg sm:rounded-none mb-2 sm:mb-0">
					<th class="p-3 text-left">Nombre Categoria</th>
					<th class="p-3 text-left" width="110px">Acción</th>
				</tr>
				<tr class="bg-teal-400 flex flex-col flex-no wrap sm:table-row rounded-l-lg sm:rounded-none mb-2 sm:mb-0">
					<th class="p-3 text-left">Nombre Categoria</th>
					<th class="p-3 text-left" width="110px">Acción</th>
				</tr>
                <tr class="bg-teal-400 flex flex-col flex-no wrap sm:table-row rounded-l-lg sm:rounded-none mb-2 sm:mb-0">
					<th class="p-3 text-left">Nombre Categoria</th>
					<th class="p-3 text-left" width="110px">Acción</th>
              </tr>
              <tr class="bg-teal-400 flex flex-col flex-no wrap sm:table-row rounded-l-lg sm:rounded-none mb-2 sm:mb-0">
					<th class="p-3 text-left">Nombre Categoria</th>
					<th class="p-3 text-left" width="110px">Acción</th>
              </tr>
			</thead>
			<tbody class="flex-1 sm:flex-none">
				<tr class="flex flex-col flex-no wrap sm:table-row mb-2 sm:mb-0">
					<td class="border-grey-light border hover:bg-gray-100 p-3">John Covv</td>
					<td class="border-grey-light border hover:bg-gray-100 p-3 text-red-400 hover:text-red-600 hover:font-medium cursor-pointer">Editar</td>
				</tr>
				<tr class="flex flex-col flex-no wrap sm:table-row mb-2 sm:mb-0">
					<td class="border-grey-light border hover:bg-gray-100 p-3">Michael Jackson</td>
					<td class="border-grey-light border hover:bg-gray-100 p-3 text-red-400 hover:text-red-600 hover:font-medium cursor-pointer">Editar</td>
				</tr>
                <tr class="flex flex-col flex-no wrap sm:table-row mb-2 sm:mb-0">
                    <td class="border-grey-light border hover:bg-gray-100 p-3">Julia</td>
                    <td class="border-grey-light border hover:bg-gray-100 p-3 text-red-400 hover:text-red-600 hover:font-medium cursor-pointer">Editar</td>
                </tr>
                <tr class="flex flex-col flex-no wrap sm:table-row mb-2 sm:mb-0">
                  <td class="border-grey-light border hover:bg-gray-100 p-3">Martin Madrazo</td>
                  <td class="border-grey-light border hover:bg-gray-100 p-3 text-red-400 hover:text-red-600 hover:font-medium cursor-pointer">Editar</td>
                </tr>
			</tbody>
		</table>
	</div>-->
	
	<#include "partials/list_categories.ftl">
</#macro>
