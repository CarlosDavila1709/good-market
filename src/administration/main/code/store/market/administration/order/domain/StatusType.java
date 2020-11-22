package store.market.administration.order.domain;

public enum StatusType {

	SENT("sent"),ADMITTED("admitted"), TRANSIT("transit"), DELIVERED("delivered");
	
	private String codigo;
	
	StatusType(String codigo) {
		this.codigo = codigo;
	}
	
	public String codigo() {
		return this.codigo;
	}
	public static StatusType fromShortCodigo(String shortCodigo) {
        switch (shortCodigo) {
        case "sent":
        	return StatusType.SENT;
        case "admitted":
            return StatusType.ADMITTED;
        case "transit":
            return StatusType.TRANSIT;
        case "delivered":
            return StatusType.DELIVERED;
        default:
            throw new IllegalArgumentException("ShortCodigo [" + shortCodigo
                    + "] not supported.");
        }
    }
}
