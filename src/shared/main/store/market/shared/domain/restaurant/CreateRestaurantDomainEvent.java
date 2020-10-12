package store.market.shared.domain.restaurant;

import store.market.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class CreateRestaurantDomainEvent extends DomainEvent {

    private String id;
    private String name;
    private String ruc;

    public CreateRestaurantDomainEvent(){
        super(null);
        this.id = id;
        this.name = name;
        this.ruc = ruc;

    }

    public CreateRestaurantDomainEvent(String aggregateID,String name,String ruc){
        super(aggregateID);
        this.name = name;
        this.ruc = ruc;
    }
    public CreateRestaurantDomainEvent(
            String aggregateId,
            String eventId,
            String occurredOn,
            String name,
            String ruc
    ){
        super(aggregateId, eventId, occurredOn);

        this.name     = name;
        this.ruc = ruc;
    }
    @Override
    public String eventName() {
        return "restaurant.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);
            put("ruc", ruc);
        }};
    }
    @Override
    public CreateRestaurantDomainEvent fromPrimitives(
            String aggregateId,
            HashMap<String, Serializable> body,
            String eventId,
            String occurredOn
    ) {
        return new CreateRestaurantDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("name"),
                (String) body.get("ruc")
        );
    }
    public String name() {
        return name;
    }

    public String ruc() {
        return ruc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateRestaurantDomainEvent that = (CreateRestaurantDomainEvent) o;
        return name.equals(that.name) &&
                ruc.equals(that.ruc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ruc);
    }
}
