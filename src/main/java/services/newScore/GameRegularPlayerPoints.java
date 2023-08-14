package services.newScore;

public enum GameRegularPlayerPoints {
    ZERO, FIFTEEN, THIRTY, FORTY, ADVANTAGE;

    public GameRegularPlayerPoints next() {
        if (this == ADVANTAGE) {
            throw new IllegalStateException("Can't call next() on ADVANTAGE");
        } else {
            return GameRegularPlayerPoints.values()[this.ordinal() + 1];
        }
    }
}
