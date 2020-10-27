<#include "../../master.ftl">

<#macro page_title>Unidad de Medida</#macro>

<#macro main>
	<form class="w-full max-w-lg" method="post" action="unitmeasures">
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
	        Unidad de Medida
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
	      <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-prefix">
	        Prefijo
	      </label>
	      <input class="<#if errors['name']?? >border border-red-500</#if> appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                   id="grid-prefix" type="text" name="prefix" placeholder="Prefijo"
                   value="${(inputs['prefix'])!""}">
          
            <#if errors['name']?? >
                <#list errors['prefix'] as errorMessage>
                    <p class="text-red-500 text-xs italic">${errorMessage}</p>
                </#list>
            </#if>
	    </div>
	  </div>

	  <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" type="submit">
	  Grabar
	</button>
	</form>
	
</#macro>
