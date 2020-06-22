package kn.valida.discourseModel;

public class DebugLog {

    //Number of Assertion types;
    public Integer asserting = 0;
    public Integer strongAsserting = 0;
    public Integer weakAsserting = 0;
    public Integer assertiveQuestioning = 0;
    public Integer rhetoricalQuestioning = 0;

    public Integer ciAsserting = 0;

    public Integer challenging = 0;

    //Number of discourse moves;
    public Integer potentialAgreeMoves = 0;
    public Integer agreeMoves = 0;
    public Integer disagreeMoves = 0;
    public Integer argueMoves = 0;
    public Integer restateMoves = 0;

    public Integer ciAgree = 0;
    public Integer ciDisagree = 0;

    public DebugLog()
    {

    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Assertion links (locution to proposition):").append(System.lineSeparator());
        sb.append("Number of assertions: ").append(asserting).append(System.lineSeparator());
        sb.append("Number of strong assertions: ").append(strongAsserting).append(System.lineSeparator());
        sb.append("Number of weak assertions: ").append(weakAsserting).append(System.lineSeparator());
        sb.append("Number of assertive questions: ").append(assertiveQuestioning).append(System.lineSeparator());
        sb.append("Number of rhetorical questions: ").append(rhetoricalQuestioning).append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append("Discourse moves: ").append(System.lineSeparator());
        sb.append("Number of agree moves: ").append(agreeMoves).append(System.lineSeparator());
        sb.append("Number of disagree moves: ").append(disagreeMoves).append(System.lineSeparator());
        sb.append("Number of argue moves: ").append(argueMoves).append(System.lineSeparator());
        sb.append("Number of restate moves: ").append(restateMoves).append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());

        return sb.toString();
    }

}
