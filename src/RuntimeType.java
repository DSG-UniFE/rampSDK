import it.unibo.deis.lia.ramp.core.internode.sdn.advancedDataPlane.dataTypesManager.AbstractDataType;

import java.io.Serializable;

public class RuntimeType extends AbstractDataType implements Serializable {
    private static final long serialVersionUID = 1611977844899648823L;

    public RuntimeType() {
        super();
    }

    public RuntimeType(int seqNumber, int payloadSize) {
        this.seqNumber = seqNumber;
        this.payload = new byte[payloadSize];
    }
}
