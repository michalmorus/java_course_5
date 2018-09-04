package car.engine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EngineTest {

    private Engine engine;

    @Before
    public void initEngine() {
        this.engine = new Engine();
    }

    @Test
    public void shouldEngineStart() throws EngineStartException {
        engine.start();
        assertTrue(engine.isEnabled());
    }

    @Test(expected = EngineStartException.class)
    public void shouldEngineNotStartWhenWasStarted() throws EngineStartException {
        engine.start();
        engine.start();
    }

    @Test
    public void shouldEngineIncreaseRpm() throws EngineIncreaseRpmException, EngineStartException {
        engine.start();
        engine.increaseRPM(200);
    }

    @Test(expected = EngineIncreaseRpmException.class)
    public void shouldEngineNotIncreaseRpmWhenIsNotStarted() throws EngineIncreaseRpmException {
        engine.increaseRPM(200);
    }

    @Test(expected = EngineIncreaseRpmException.class)
    public void shouldEngineNotIncreaseRpmOverLimit() throws EngineIncreaseRpmException, EngineStartException {
        engine.start();
        engine.increaseRPM( 11000 );
    }
}
