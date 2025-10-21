package app.ctf.ctf_academy.api.dto;

public class SubmitRes {
    private final boolean correct;
    private final Integer pointsAwarded; 

    public SubmitRes(boolean correct, Integer pointsAwarded) {
        this.correct = correct;
        this.pointsAwarded = pointsAwarded;
    }

    public boolean isCorrect() { return correct; }
    public Integer getPointsAwarded() { return pointsAwarded; }
}
