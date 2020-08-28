package it.unibo.deis.lia.ramp.util.componentLocator.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Dmitrij David Padalino Montenero
 */
public class Cache {
    private Map<String, Object> components = new ConcurrentHashMap<>();

    public Object getComponent(String componentName) {
        return null;
    }

    public void addComponent(Object object) {

    }
}
