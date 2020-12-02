package store.market.administration.order_item.application;

import store.market.administration.order_item.domain.Item;
import store.market.shared.domain.bus.query.Response;

public final class OrderItemResponse implements Response {

	private final String id;
	private final String orderId;
	private final String productId;
	private final String productName;
	private final Double productPrice;
	private final Double amountTotal;
	private final Integer quantity;
	private final String categorieName;
    private final String unitMeasureName;

	public OrderItemResponse(String id, String orderId, String productId, String productName, Double productPrice,
			Double amountTotal, Integer quantity,String categorieName,String unitMeasureName) {
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

	public static OrderItemResponse fromAggregate(Item item) {
		return new OrderItemResponse(item.id().value(), 
				item.orderId().value(), 
				item.productId().value(),
				item.productName().value(), 
				item.productPrice().value(), 
				item.amountTotal().value(),
				item.quantity().value(),
				item.categorieName(),
				item.unitMeasureName());
	}

	public String id() {
		return id;
	}

	public String orderId() {
		return orderId;
	}

	public String productId() {
		return productId;
	}

	public String productName() {
		return productName;
	}

	public Double productPrice() {
		return productPrice;
	}

	public Double amountTotal() {
		return amountTotal;
	}

	public Integer quantity() {
		return quantity;
	}
	public String categorieName() {
		return categorieName;
	}
	public String unitMeasureName() {
		return unitMeasureName;
	}
}
