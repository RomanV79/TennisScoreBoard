package services.newScore;

import lombok.Getter;

@Getter
public enum GameRegularPlayerPoints {
    ZERO("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    ADVANTAGE("AD");

    public GameRegularPlayerPoints next() {
        if (this == ADVANTAGE) {
            throw new IllegalStateException("Can't call next() on ADVANTAGE");
        } else {
            return GameRegularPlayerPoints.values()[this.ordinal() + 1];
        }
    }

    private final String pointCode;

    private GameRegularPlayerPoints(String pointCode) {
        this.pointCode = pointCode;
    }

}
