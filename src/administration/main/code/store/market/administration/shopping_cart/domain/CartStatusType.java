package store.market.administration.shopping_cart.domain;

public enum CartStatusType {

	ACTIVE("active"), INDICTED("indicted");
	
	private String codigo;
	
	CartStatusType(String codigo) {
		this.codigo = codigo;
	}
	
	public String codigo() {
		return this.codigo;
	}
	public static CartStatusType fromShortCodigo(String shortCodigo) {
        switch (shortCodigo) {
        case "active":
            return CartStatusType.ACTIVE;
        case "indicted":
            return CartStatusType.INDICTED;
        default:
            throw new IllegalArgumentException("ShortCodigo [" + shortCodigo
                    + "] not supported.");
        }
    }
}
