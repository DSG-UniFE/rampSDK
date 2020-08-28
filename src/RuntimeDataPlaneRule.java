import it.unibo.deis.lia.ramp.core.e2e.UnicastHeader;
import it.unibo.deis.lia.ramp.core.e2e.UnicastPacket;
import it.unibo.deis.lia.ramp.core.internode.sdn.advancedDataPlane.rulesManager.AbstractDataPlaneRule;

public class RuntimeDataPlaneRule extends AbstractDataPlaneRule {

    public RuntimeDataPlaneRule() {}

    @Override
    public void applyRuleToUnicastPacket(UnicastPacket up) {
        UnicastHeader uh = up.getHeader();
        System.out.println("RuntimeDataPlaneRule: DataTypeId: " + uh.getDataType());
    }

}
