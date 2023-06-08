package services.score;

public class ScorePoint {

    private ScorePointEnum point;

    public ScorePoint() {
        this.point = ScorePointEnum.ZERO;
    }

    public void nextPoint(){
        switch (point) {
            case ZERO -> point = ScorePointEnum.FIFTEEN;
            case FIFTEEN -> point = ScorePointEnum.THIRTY;
            case THIRTY -> point = ScorePointEnum.FORTY;
            case FORTY -> point = ScorePointEnum.WIN;
        }
    }

    public ScorePointEnum getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return "ScorePoint{" +
                "point=" + point +
                '}';
    }
}

