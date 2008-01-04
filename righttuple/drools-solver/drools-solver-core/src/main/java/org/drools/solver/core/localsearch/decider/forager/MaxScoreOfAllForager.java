package org.drools.solver.core.localsearch.decider.forager;

import org.drools.solver.core.move.Move;

/**
 * @author Geoffrey De Smet
 */
public class MaxScoreOfAllForager extends AcceptionListBasedForager {

    // ************************************************************************
    // Worker methods
    // ************************************************************************

    public void addMove(Move move, double score, double acceptChance) {
        if (acceptChance > 0.0) {
            addMoveToAcceptionList(move, score, acceptChance);
        }
    }

    public boolean isQuitEarly() {
        return false;
    }

    public Move pickMove() {
        return pickMaxScoreMove();
    }

}
