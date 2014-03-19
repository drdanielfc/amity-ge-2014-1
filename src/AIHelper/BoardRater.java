/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */

package AIHelper;

import tetris.Board;

/**
 * 
 * @author justinbehymer
 */
public abstract class BoardRater
{

    int callCount = 0;
    int runTime   = 0;

    abstract double rate(Board board);

    public double rateBoard(final Board board)
    {
        this.callCount++;
        board.enableCaching();
        final long start = System.nanoTime();
        final double ret = this.rate(board);
        this.runTime += System.nanoTime() - start;
        board.disableCaching();
        return ret;

    }

}
