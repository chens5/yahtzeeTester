import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * Created by chens5 on 9/23/17.
 * Note for 9/24/17: HAVE NOT FINISHED YAHTZEE SCORING YET
 * FINISHED CHECKING FOR IF STUFF IS LARGE STRAIGHT, YAHTZEE, ETC.
 */
public class yahtzeeTester {
    protected YahtzeeScorer yahtzee1;
    protected int[] yahtzee, notYahtzee, isLargeStraight, isNotLargeStraight, isFullHouse, isNotFullHouse, is3ofAKind, isNot3ofAKind;

    @Before
    public void setUp()
    {
        yahtzee1 = new YahtzeeScorer();
        isLargeStraight = IntStream.range(1, 6).toArray();
        isNotLargeStraight = IntStream.range(1, 6).toArray();
        isNotLargeStraight[0] = 5;

        yahtzee = new int[5];
        notYahtzee = new int[5];
        notYahtzee[2] = 10;
        isFullHouse = new int[5];
        isFullHouse[0] = 1;
        isFullHouse[4] = 1;

        isNotFullHouse = new int[5];
        isNotFullHouse[0] = 1;
        isNotFullHouse[1] = 2;
        isNotFullHouse[2] = 5;

        is3ofAKind = new int[5];
        is3ofAKind[0] = 1;
        is3ofAKind[4] = 1;

        isNot3ofAKind = new int[5];
        isNot3ofAKind[0] = 1;
        isNot3ofAKind[1] = 2;
        isNot3ofAKind[2] = 5;


    }



    @Test
    public void isYahtzee(){

        assertEquals(true, yahtzee1.isYahtzee(yahtzee));
        assertEquals(false, yahtzee1.isYahtzee(notYahtzee));
    }

    @Test
    public void isLargeStraight()
    {
        isNotLargeStraight[2] = 6;

        assertEquals(true, yahtzee1.isLargeStraight(isLargeStraight));
        assertEquals(false, yahtzee1.isLargeStraight(isNotLargeStraight));
    }

    @Test
    public void isFullHouse()
    {


        assertEquals(true, yahtzee1.isFullHouse(isFullHouse));
        assertEquals(false, yahtzee1.isFullHouse(isNotFullHouse));
    }

    @Test
    public void is3ofAKind()
    {

        assertEquals(true, yahtzee1.is3ofAKind(is3ofAKind));
        assertEquals(false, yahtzee1.is3ofAKind(isNot3ofAKind));
    }

    @Test
    public void LargeStraightScore()
    {
        assertEquals(40, yahtzee1.LargeStraightScore(isLargeStraight));
        assertEquals(0, yahtzee1.LargeStraightScore(isNotLargeStraight));
    }

    @Test
    public void ThreeScore()
    {
        assertEquals(IntStream.of(is3ofAKind).sum(),yahtzee1.ThreeScore(is3ofAKind) );
        assertEquals(0, yahtzee1.ThreeScore(isNot3ofAKind));
    }

    @Test
    public void FullHouseScore()
    {
        assertEquals(25, yahtzee1.FullHouseScore(isFullHouse));
        assertEquals(0, yahtzee1.FullHouseScore(isNotFullHouse));
    }

    @Test
    public void currentScore()
    {
        assertEquals(25, yahtzee1.currentScore());
    }
}
