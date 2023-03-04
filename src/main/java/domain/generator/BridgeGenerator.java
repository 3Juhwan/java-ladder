package domain.generator;

import domain.Bridge;

@FunctionalInterface
public interface BridgeGenerator {

    Bridge generate();
}
