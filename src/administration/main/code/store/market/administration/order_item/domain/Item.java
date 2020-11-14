package store.market.administration.order_item.domain;

import java.util.Objects;

import store.market.administration.order.domain.OrderId;
import store.market.administration.product_catalog.domain.ProductCatalogId;
import store.market.shared.domain.AggregateRoot;

public final class Item extends AggregateRoot{

	private ItemId id;
	private OrderId orderId;
	private ProductCatalogId productId;
	private ItemProductName productName;
	private ItemProductPrice productPrice;
	private ItemAmountTotal amountTotal;
	private ItemQuantity quantity;
	
	public Item(ItemId id,OrderId orderId,ProductCatalogId productId,ItemProductName productName,ItemProductPrice productPrice,ItemAmountTotal amountTotal,ItemQuantity quantity) {
		
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.amountTotal = amountTotal;
		this.quantity = quantity;
	}
	public Item() {
		this.id = null;
		this.orderId = null;
		this.productId = null;
		this.productName = null;
		this.productPrice = null;
		this.amountTotal = null;
		this.quantity = null;
	}
	public static Item create(ItemId id,OrderId orderId,ProductCatalogId productId,ItemProductName productName,ItemProductPrice productPrice,ItemAmountTotal amountTotal,ItemQuantity quantity) {
		Item item = new Item( id, orderId, productId, productName, productPrice, amountTotal, quantity);
		
		return item;		
	}
	public ItemId id() {
		return id;
	}
	public OrderId orderId() {
		return orderId;
	}
	public ProductCatalogId productId() {
		return productId;
	}
	public ItemProductName productName() {
		return productName;
	}
	public ItemProductPrice productPrice() {
		return productPrice;
	}
	public ItemAmountTotal amountTotal() {
		return amountTotal;
	}
	public ItemQuantity quantity() {
		return quantity;
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item that = (Item) o;
        return id.equals(that.id) &&
        		orderId.equals(that.orderId) &&
        		productId.equals(that.productId) &&
        		productName.equals(that.productName) &&
        		productPrice.equals(that.productPrice) &&
        		amountTotal.equals(that.amountTotal) &&
        		quantity.equals(that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, orderId, productId, productName, productPrice, amountTotal, quantity);
    }
}
