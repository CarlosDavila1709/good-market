<div class="container">
<table class="w-full flex flex-row flex-no-wrap sm:bg-white rounded-lg overflow-hidden sm:shadow-lg my-5">
    <thead id ="productscatalog-header" class="text-white">
	    <!--  
	    <tr class="bg-teal-400 flex flex-col flex-no wrap sm:table-row rounded-l-lg sm:rounded-none mb-2 sm:mb-0">
	        <th class="p-3 text-left">Nombre</th>
	        <th class="p-3 text-left">Acción</th>
	    </tr>
	    -->
    </thead>
    <tbody id="productscatalog-list" class="flex-1 sm:flex-none">
				<!-- <tr class="flex flex-col flex-no wrap sm:table-row mb-2 sm:mb-0">
					<td class="border-grey-light border hover:bg-gray-100 p-3">John Covv</td>
					<td class="border-grey-light border hover:bg-gray-100 p-3 text-red-400 hover:text-red-600 hover:font-medium cursor-pointer">Editar</td>
				</tr>-->
    </tbody>
</table>
</div>
<script>

    function addCoursesList(url) {
        console.log(url);

        const tableBody = document.getElementById("productscatalog-list");
        const tableHeader = document.getElementById("productscatalog-header");

        fetch(encodeURI(url))
            .then(function (response) {
                return response.json();
            })
            .then(function (courses) {
                
            	tableBody.innerHTML = "";
                tableHeader.innerHTML = "";
                
                courses.forEach(function (course) {
                    let courseRow = document.createElement("tr");
                    courseRow.setAttribute('class', 'flex flex-col flex-no wrap sm:table-row mb-2 sm:mb-0')
                    courseRow.appendChild(tableCellFor(course.name));
                    courseRow.appendChild(tableCellFor("S/ "+course.price));
                    courseRow.appendChild(tableCellForEditar("Editar"));
                    tableBody.appendChild(courseRow);
                    
                    
                    let productHeaderRow = document.createElement("tr");
                    productHeaderRow.setAttribute('class', 'bg-teal-400 flex flex-col flex-no wrap sm:table-row rounded-l-lg sm:rounded-none mb-2 sm:mb-0')
                    productHeaderRow.appendChild(tableHeaderFor("Nombre"));
                    productHeaderRow.appendChild(tableHeaderFor("Precio"));
                    productHeaderRow.appendChild(tableHeaderFor("Acción"));
                    tableHeader.appendChild(productHeaderRow);
                })
            });
    }

    function tableCellFor(text) {
        const cell = document.createElement("td");
        cell.setAttribute('class', 'border-grey-light border hover:bg-gray-100 p-3') 
        cell.appendChild(document.createTextNode(text));

        return cell;
    }
    function tableCellForEditar(text) {
        const cell = document.createElement("td");
        cell.setAttribute('class', 'border-grey-light border hover:bg-gray-100 p-3 text-red-400 hover:text-red-600 hover:font-medium cursor-pointer') 
        cell.appendChild(document.createTextNode(text));

        return cell;
    }
    function tableHeaderFor(text) {
        const cell = document.createElement("th");
        cell.setAttribute('class', 'p-3 text-left') 
        cell.appendChild(document.createTextNode(text));

        return cell;
    }
</script>

<script>
    addCoursesList("http://localhost:8093/products-catalog");
</script>
