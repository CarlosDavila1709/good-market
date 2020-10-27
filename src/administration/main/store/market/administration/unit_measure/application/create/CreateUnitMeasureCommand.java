package store.market.administration.unit_measure.application.create;

import store.market.shared.domain.bus.command.Command;

public final class CreateUnitMeasureCommand implements Command {

    private final String id;
    private final String name;
    private final String prefix;
    
    public CreateUnitMeasureCommand(String id, String name, String prefix) {
        this.id       = id;
        this.name     = name;
        this.prefix   = prefix;
    }
    
    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String prefix() {
        return prefix;
    } 
    
}
