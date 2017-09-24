/**
 * Created by chens5 on 9/23/17.
 */
import java.util.*;
import java.util.stream.IntStream;


public class YahtzeeScorer {

    private HashMap<String, Integer> scoresheet;

    public YahtzeeScorer() {

        scoresheet = new HashMap<String, Integer>();
        scoresheet.put("test", 25);

    }

    public boolean isYahtzee(int[] dice) {
        for (int i = 0; i < dice.length - 1; i++) {
            if (dice[i] != dice[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isLargeStraight(int[] dice)
    {
        //System.out.println(dice);
        Arrays.sort(dice);
        for(int i = 0; i < dice.length - 1; i++)
        {
            if(dice[i] + 1 != dice[i+1])
            {
                return false;
            }
        }
        return true;
    }

    public boolean isFullHouse(int[] dice)
    {
        int[] freq_array = new int[6];


        for(int i = 0; i < dice.length; i++)
        {
            freq_array[dice[i]]++;
        }
        //we don't accept yahtzee as full house

        for(int i = 0; i < freq_array.length; i++)
        {

            if(freq_array[i] != 0 && freq_array[i] != 2 && freq_array[i] != 3)
            {
                return false;
            }
        }
        return true;
    }

    public boolean is3ofAKind(int[] dice)
    {
        int[] freq_array = new int[6];

        for(int i = 0; i < dice.length; i++)
        {
            freq_array[dice[i]]++;
        }
        //we don't accept yahtzee as full house

        for(int i = 0; i < freq_array.length; i++)
        {

            if(freq_array[i] == 3)
            {
                return true;
            }
        }
        return false;
    }

    public int LargeStraightScore(int[] dice)
    {
        if(!isLargeStraight(dice))
        {
            return 0;
        }
        return 40;
    }

    public int ThreeScore(int[] dice)
    {
        if(!is3ofAKind(dice))
        {
            return 0;
        }
        return IntStream.of(dice).sum();
    }

    public int FullHouseScore(int[] dice)
    {
        if(!isFullHouse(dice))
        {
            return 0;
        }
        return 25;
    }

    public int currentScore()
    {
        int currentScore = 0;
        for(int i : scoresheet.values())
        {
            currentScore += i;
        }

        return currentScore;
    }

}
