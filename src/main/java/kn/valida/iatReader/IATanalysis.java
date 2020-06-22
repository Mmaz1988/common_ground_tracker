package kn.valida.iatReader;

import java.util.List;

public class IATanalysis {

    public Integer locutionNodes = 0;
    public Integer propositionNodes = 0;

    public Integer assertingNodes = 0;
    public Integer defaultIllocutionNodes = 0;
    //proposition to proposition
    public Integer inferenceNodes = 0;
    public Integer conflictNodes = 0;
    public Integer rephraseNodes = 0;
    //locution to proposition
    public Integer agreeNodes = 0;
    public Integer disagreeNodes = 0;
    public Integer challengeNodes = 0;
    //Default inference to proposition;
    public Integer restateNodes = 0;


    public IATanalysis()
    {
    }

    public IATanalysis(List<IATmap> multiAnalysis)
    {
        for (IATmap map : multiAnalysis)
        {
            this.locutionNodes = map.analysis.locutionNodes + this.locutionNodes;
            this.propositionNodes = map.analysis.propositionNodes + this.propositionNodes;
            this.assertingNodes = map.analysis.assertingNodes + this.assertingNodes;
            this.defaultIllocutionNodes = map.analysis.defaultIllocutionNodes + this.defaultIllocutionNodes;
            this.inferenceNodes = map.analysis.inferenceNodes + this.inferenceNodes;
            this.conflictNodes = map.analysis.conflictNodes + this.conflictNodes;
            this.rephraseNodes = map.analysis.rephraseNodes + this.rephraseNodes;
            this.agreeNodes = map.analysis.agreeNodes + this.agreeNodes;
            this.disagreeNodes = map.analysis.disagreeNodes + this.disagreeNodes;
            this.challengeNodes = map.analysis.challengeNodes + this.challengeNodes;
            this.restateNodes = map.analysis.restateNodes + this.restateNodes;
        }

    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Number of locution nodes: ").append(locutionNodes);
        sb.append(System.lineSeparator());
        sb.append("Number of proposition nodes: ").append(propositionNodes);
        sb.append(System.lineSeparator());
        sb.append("Number of asserting nodes: ").append(assertingNodes);
        sb.append(System.lineSeparator());
        sb.append("Number of default illocutions: ").append(defaultIllocutionNodes);
        sb.append(System.lineSeparator());
        sb.append("Number of inference nodes: ").append(inferenceNodes);
        sb.append(System.lineSeparator());
        sb.append("Number of conflict nodes: ").append(conflictNodes);
        sb.append(System.lineSeparator());
        sb.append("Number of rephrase nodes: ").append(rephraseNodes);
        sb.append(System.lineSeparator());
        sb.append("Number of agree nodes: ").append(agreeNodes);
        sb.append(System.lineSeparator());
        sb.append("Number of disagree nodes: ").append(disagreeNodes);
        sb.append(System.lineSeparator());
        sb.append("Number of challenge nodes: ").append(challengeNodes);
        sb.append(System.lineSeparator());
        sb.append("Number of restate nodes: ").append(restateNodes);
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());

        return sb.toString();
    }

}
