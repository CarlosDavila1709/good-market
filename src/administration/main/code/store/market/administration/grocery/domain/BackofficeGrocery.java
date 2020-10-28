package store.market.administration.grocery.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public final class BackofficeGrocery {

	private final String id;
	private final String nameCommercial;
	private final String address;
	private final String active;
	
	public BackofficeGrocery() {
		
		this.id = null;
		this.nameCommercial = null;
		this.address = null;
		this.active = null;
	}
	
	public BackofficeGrocery(String id, String nameCommercial,String address, String active) {
		
		this.id = id;
		this.nameCommercial = nameCommercial;
		this.address = address;
		this.active = active;
	}
	
    public static BackofficeGrocery fromPrimitives(Map<String, Object> plainData) {
        return new BackofficeGrocery(
            (String) plainData.get("id"),
            (String) plainData.get("nameCommercial"),
            (String) plainData.get("address"),
            (String) plainData.get("active")
        );
    }
	public String id() {
		
		return id;
	}
	public String nameCommercial() {
		
		return nameCommercial;
	}
	public String address() {
		
		return address;
	}
	public String active() {
		
		return active;
	}
	
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("id", id);
            put("nameCommercial", nameCommercial);
            put("address", address);
            put("active", active);
        }};
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BackofficeGrocery that = (BackofficeGrocery) o;
        return id.equals(that.id) &&
               nameCommercial.equals(that.nameCommercial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameCommercial);
    }
}
