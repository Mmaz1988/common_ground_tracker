package kn.valida.gui;

import kn.valida.discourseModel.DiscourseProposition;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class PropositionRenderer extends DefaultListCellRenderer {

    private Border padBorder = new EmptyBorder(3,3,3,3);
    private Set<String> highlightCommitments = new HashSet<>();
    private Set<String> highlightJointCommitments = new HashSet<>();
    private Set<String> highlightUnresolved = new HashSet<>();
    private Set<String> highlightControversial = new HashSet<>();
    private String currentPid;

    private Boolean highlightRel = false;
    private Boolean highlightCosine = false;

    private Set<String> highlightRelevance = new HashSet<>();
    private Set<String> highlightCosineSimilarity = new HashSet<>();



    private LinkedHashMap<String,DiscourseProposition> dpReference = new LinkedHashMap<>();

    public PropositionRenderer(LinkedHashMap<String,DiscourseProposition> dpReference)
    {
        this.dpReference = dpReference;
    }

    @Override
    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        /*
        Component c = super.getListCellRendererComponent(
                list,value,index,isSelected,cellHasFocus);



        JLabel l = (JLabel)c;
        */


        JPanel j = new JPanel();
        j.setLayout(new FlowLayout(FlowLayout.LEFT));

        j.setBackground(Color.white);

        JLabel l = new JLabel();

        //Changed to toString() instead of casting so that different objects can be rendered by this
        String f =  ((DiscourseProposition) value).getOriginalSpeaker().getName() + ": " +  ((DiscourseProposition) value).getText();
        //  "{" + ((DiscourseProposition) value).writeExpressiveContent() + "}";
        l.setText(f);
        l.setIcon(null);
        l.setBorder(padBorder);
        l.setOpaque(true);
        l.setBackground(Color.white);

        JLabel m = new JLabel();
        m.setText(((DiscourseProposition)value).writeExpressiveContent());
        m.setIcon(null);
        m.setBorder(padBorder);
        m.setOpaque(true);
        m.setBackground(Color.white);


        j.add(l);
        j.add(m);


        if (isSelected)
        {
            j.setBorder(BorderFactory.createLineBorder(Color.blue));
        }

        if (!((DiscourseProposition)value).getExpressiveContent().isEmpty())
        {
            Boolean highlight = false;
            for (DiscourseProposition p : ((DiscourseProposition) value).getExpressiveContent())
            {
                if (highlightJointCommitments.contains(p.getPid()))
                {
                    m.setBackground(new Color(0,255,0,20));
                }

                if (highlightControversial.contains(p.getPid()))
                {
                    m.setBackground(new Color(255,0,0,20));
                }

                if (!(currentPid == null))
                {
                    if (highlightRel) {

                        if (highlightRelevance.contains(p.getPid())) {
                            Integer opacity = (int) Math.round(dpReference.get(currentPid).getRelevance().
                                    get(p.getPid()) * 100);
                            m.setBackground(new Color(0, 0, 255, opacity));
                        }
                    }
                    if (highlightCosine) {
                        if (highlightCosineSimilarity.contains(p.getPid())) {
                            Integer opacity = (int) Math.round(dpReference.get(currentPid).getSemanticSimilarity().
                                    get(p.getPid()) * 100);
                            m.setBackground(new Color(255, 0, 0, opacity));
                        }
                    }

                }


            }




        }

        if (highlightCommitments.contains(((DiscourseProposition) value).getPid()))
        {
            l.setBackground(new Color(0,0,255,20));
        }

        if (highlightJointCommitments.contains(((DiscourseProposition) value).getPid()))
        {
            l.setBackground(new Color(0,255,0,20));
        }

        if (highlightUnresolved.contains(((DiscourseProposition) value).getPid()))
        {
            l.setBackground(new Color(255,128,0,20));
        }

        if (highlightControversial.contains(((DiscourseProposition) value).getPid()))
        {
            l.setBackground(new Color(255,0,0,20));
        }


        /*
        if (!(currentPid == null)) {
            for (String pid : dpReference.get(currentPid).getRelevance().keySet()) {
                Integer opacity = (int) Math.round(dpReference.get(currentPid).getRelevance().get(pid) * 100);

                l.setBackground(new Color(255, 0, 0, opacity));
            }
        }
*/
        if (!(currentPid == null)) {

            if (highlightRel) {
                if (highlightRelevance.contains(((DiscourseProposition) value).getPid())) {
                    Integer opacity = (int) Math.round(dpReference.get(currentPid).getRelevance().
                            get(((DiscourseProposition) value).getPid()) * 100);
                    l.setBackground(new Color(0, 0, 255, opacity));
                }
            }

            if (highlightCosine) {
                if (highlightCosineSimilarity.contains(((DiscourseProposition) value).getPid())) {
                    Integer opacity = (int) Math.round(dpReference.get(currentPid).getSemanticSimilarity().
                            get(((DiscourseProposition) value).getPid()) * 100);
                    l.setBackground(new Color(255, 0, 0, opacity));
                }
            }
        }

        /*
        if (highlightElements.contains (((Speaker) value).getSid()))
        {
            setBackground(new Color(0,0,255,20));
        }
        */

            /*
            if (searchResult.contains(index))
            {
                setBackground(new Color(0,0,255,20));

            }

            if (possibleEvents.contains(index))
            {
                setBackground(new Color(255,0,0,20));

            }

            if (ruleSource.contains(index))
            {
                setBackground(new Color(0,255,0,20));
            }
            */
        return j;
    }


    public void resetLists(){
        highlightJointCommitments = new HashSet<>();
        highlightCommitments = new HashSet<>();
        highlightUnresolved = new HashSet<>();
        highlightControversial = new HashSet<>();
        highlightRelevance = new HashSet<>();
        highlightCosineSimilarity = new HashSet<>();
        currentPid = null;
        highlightCosine = false;
        highlightRel = false;
    }



    public Set<String> getHighlightCommitments() {
        return highlightCommitments;
    }

    public void setHighlightCommitments(Set<String> highlightCommitments) {
        this.highlightCommitments = highlightCommitments;
    }

    public Set<String> getHighlightJointCommitments() {
        return highlightJointCommitments;
    }

    public void setHighlightJointCommitments(Set<String> highlightJointCommitments) {
        this.highlightJointCommitments = highlightJointCommitments;
    }

    public Set<String> getHighlightUnresolved() {
        return highlightUnresolved;
    }

    public void setHighlightUnresolved(Set<String> highlightUnresolved) {
        this.highlightUnresolved = highlightUnresolved;
    }


    public Set<String> getHighlightControversial() {
        return highlightControversial;
    }

    public void setHighlightControversial(Set<String> highlightControversial) {
        this.highlightControversial = highlightControversial;
    }

    public String getCurrentPid() {
        return currentPid;
    }

    public void setCurrentPid(String currentPid) {
        this.currentPid = currentPid;
    }

    public Set<String> getHighlightRelevance() {
        return highlightRelevance;
    }

    public void setHighlightRelevance(Set<String> highlightRelevance) {
        this.highlightRelevance = highlightRelevance;
    }

    public Set<String> getHighlightCosineSimilarity() {
        return highlightCosineSimilarity;
    }

    public void setHighlightCosineSimilarity(Set<String> highlightCosineSimilarity) {
        this.highlightCosineSimilarity = highlightCosineSimilarity;
    }

    public Boolean getHighlightRel() {
        return highlightRel;
    }

    public void setHighlightRel(Boolean highlightRel) {
        this.highlightRel = highlightRel;
    }

    public Boolean getHighlightCosine() {
        return highlightCosine;
    }

    public void setHighlightCosine(Boolean highlightCosine) {
        this.highlightCosine = highlightCosine;
    }


}



