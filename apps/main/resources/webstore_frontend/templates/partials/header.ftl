<header>
    <nav class="flex items-center justify-between flex-wrap bg-teal-900 p-5">
        <div class="flex items-center flex-shrink-0 text-white mr-6">
            <a href="/">
                <img src="images/logo.png" alt="" width="150px">
            </a>
        </div>
        <div class="w-full block flex-grow sm:flex sm:items-center sm:w-auto">
            <div class="text-sm sm:flex-grow">
                <a href="#" 
                	class="block mt-4 sm:inline-block sm:mt-0 text-teal-200 hover:text-white mr-4">
                    Pedidos
                </a>
               <a href="/products-list" 
               		class="block mt-4 sm:inline-block sm:mt-0 text-teal-200 hover:text-white mr-4">
                    Catalogo Bodega
               </a>
            </div>
            <div>
                <!--  <a href="/" class="inline-block text-sm px-4 py-2 leading-none border rounded text-white border-white hover:border-transparent hover:text-teal-500 hover:bg-white mt-4 sm:mt-0">
	                <img src="images/cart.jpeg" alt="" width="50px">
	            </a>-->
				<a href="/shopping-carts"
                   class="inline-block text-sm px-4 py-2 leading-none border rounded text-white border-white hover:border-transparent hover:text-teal-500 hover:bg-white mt-4 lg:mt-0">Entrar</a>
                <label class="inline-block text-sm px-4 py-2 leading-none border rounded text-white border-white hover:border-transparent hover:text-teal-500 hover:bg-white mt-4 sm:mt-0">
	                items: ${cart_items}
	            </label>
	            <label class="inline-block text-sm px-4 py-2 leading-none border rounded text-white border-white hover:border-transparent hover:text-teal-500 hover:bg-white mt-4 sm:mt-0">
	                Total: ${cart_total}
	            </label>
            </div>
        </div>
    </nav>
</header>