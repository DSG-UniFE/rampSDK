package it.unibo.deis.lia.ramp.util.componentLocator;

public enum ComponentType {
    RAMP_UTILS("RampUtils"),
    CONTROLLER_CLIENT("ControllerClient"),
    DATA_TYPES_MANAGER("DataTypesManager");

    private String simpleClassName;

    ComponentType(String simpleClassName) {
        this.simpleClassName = simpleClassName;
    }

    public String getSimpleClassName() {
        return simpleClassName;
    }
}
