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

    private final String categorieName;
    private final String unitMeasureName;
    
	public Item(ItemId id,OrderId orderId,ProductCatalogId productId,ItemProductName productName,ItemProductPrice productPrice,ItemAmountTotal amountTotal,ItemQuantity quantity,String categorieName,String unitMeasureName) {
		
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.amountTotal = amountTotal;
		this.quantity = quantity;
		this.categorieName = categorieName;
		this.unitMeasureName = unitMeasureName;
	}
	public Item() {
		this.id = null;
		this.orderId = null;
		this.productId = null;
		this.productName = null;
		this.productPrice = null;
		this.amountTotal = null;
		this.quantity = null;
		this.categorieName = null;
		this.unitMeasureName = null;
	}
	public static Item create(ItemId id,OrderId orderId,ProductCatalogId productId,ItemProductName productName,ItemProductPrice productPrice,ItemAmountTotal amountTotal,ItemQuantity quantity,String categorieName,String unitMeasureName) {
		Item item = new Item( id, orderId, productId, productName, productPrice, amountTotal, quantity,categorieName,unitMeasureName);
		
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
	public String categorieName() {
		return categorieName;
	}
	public String unitMeasureName() {
		return unitMeasureName;
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
        		quantity.equals(that.quantity) &&
        		categorieName.equals(that.categorieName) &&
        		unitMeasureName.equals(that.unitMeasureName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, orderId, productId, productName, productPrice, amountTotal, quantity,categorieName,unitMeasureName);
    }
}
