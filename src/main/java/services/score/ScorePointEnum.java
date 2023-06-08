package services.score;

public enum ScorePointEnum {
    ZERO("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    ADV("AD"),
    WIN("WIN");

    private final String pointCode;

    private ScorePointEnum(String pointCode){
        this.pointCode = pointCode;
    }

    public String getPointCode() {
        return pointCode;
    }
}
