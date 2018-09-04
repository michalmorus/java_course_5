package car.engine;

class Engine {

    private static final float CONSUMPTION_CONSTRANT = 0.7f;
    private static final float RPM_MAX = 9000;
    private static final float RPM_ACCELERATION = 10;

    private boolean enabled;

    private float rpm;

    Engine() {
        this.enabled = false;
        this.rpm = 0;
    }

    void start() throws EngineStartException {
        if (this.enabled) {
            throw new EngineStartException();
        }
        this.enabled = true;
    }

    void stop() throws EngineStopException {
        if (!this.enabled) {
            throw new EngineStopException();
        }
        this.enabled = false;
    }

    boolean isEnabled() {
        return this.enabled;
    }

    void increaseRPM(float miliseconds) throws EngineIncreaseRpmException {
        if (!this.isEnabled()) {
            throw new EngineIncreaseRpmException();
        }

        float newRPM = this.rpm + miliseconds * RPM_ACCELERATION;
        if (newRPM > RPM_MAX) {
            throw new EngineIncreaseRpmException();
        }

        this.rpm = newRPM;
    }

    float getRpmLimit() {
        return RPM_MAX;
    }
}
