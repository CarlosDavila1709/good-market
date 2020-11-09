<h2 class="font-sans text-gray-800 text-center text-3xl mb-10">Tu Carrito</h2>
<table class="text-left w-full border-collapse">
    <thead>
    <tr>
        <th class="py-4 px-6 bg-grey-lightest font-bold uppercase text-sm text-grey-dark border-b border-grey-light">
            Nombre
        </th>
        <th class="py-4 px-6 bg-grey-lightest font-bold uppercase text-sm text-grey-dark border-b border-grey-light">
            Precio Unit.
        </th>
        <th class="py-4 px-6 bg-grey-lightest font-bold uppercase text-sm text-grey-dark border-b border-grey-light">
            Cantidad
        </th>
        <th class="py-4 px-6 bg-grey-lightest font-bold uppercase text-sm text-grey-dark border-b border-grey-light">
            Total
        </th>
    </tr>
    </thead>
    <tbody id="cart-items-list">

    </tbody>
    <tfoot>
        <tr>
            <th scope="row">Totals</th>
            <th></th>
            <th><label id="lblQuantity"></label></th>
            <th><label id="lblAmountTotal"></label></th>
        </tr>
    </tfoot>

</table>
<script>

function addFootCart(url) {
    fetch(encodeURI(url))
    .then(function (response) {
        return response.json();
    })
    .then(function (data) {
    	document.getElementById('lblQuantity').innerHTML = data.items_total;
		document.getElementById('lblAmountTotal').innerHTML = 'S/ ' +data.amount_total;
    });
}
function addBodyCartItemsList(url) {
    console.log(url);

    const tableBody = document.getElementById("cart-items-list");

    fetch(encodeURI(url))
        .then(function (response) {
            return response.json();
        })
        .then(function (items) {
            tableBody.innerHTML = "";

            items.forEach(function (item) {
                let itemRow = document.createElement("tr");
                itemRow.appendChild(tableCellFor(item.product_name));
                itemRow.appendChild(tableCellFor("S/ "+item.price));
                itemRow.appendChild(tableCellFor(item.quantity));
                itemRow.appendChild(tableCellFor("S/ "+ item.amount_total));

                tableBody.appendChild(itemRow);
            })
        });
}
function tableCellFor(text) {
    const cell = document.createElement("td");

    cell.appendChild(document.createTextNode(text));

    return cell;
}

</script>
<script>
	addFootCart("http://localhost:8093/shopping-carts?sessionid="+"${session_id}");
    addBodyCartItemsList("http://localhost:8093/shopping-cart-items/"+"${session_id}");
</script>
