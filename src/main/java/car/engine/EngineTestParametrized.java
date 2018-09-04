package car.engine;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EngineTestParametrized {

    private Engine engine;
    private float rpm;

    public EngineTestParametrized(float rpm) {
        this.engine = new Engine();
        this.rpm = rpm;
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{100}, {200}, {300}, {400}};
        return Arrays.asList(data);
    }

    @Test
    public void increaseRpmSuccess() throws EngineIncreaseRpmException, EngineStartException {
        engine.start();
        engine.increaseRPM(rpm);
    }
}
