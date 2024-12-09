package Control.Strings.Endings;

import java.util.ArrayList;
import java.util.List;

public class EndingHandler {
    private List <String> endingList = new ArrayList<>();
    private static EndingHandler endingHandler = new EndingHandler();
            public static EndingHandler getEndingHandler(){return endingHandler;}


    public String getEnding(int endingNumber){
        return endingList.get(endingNumber);
    }
    public void initializeEndingList(){
        endingList.add("You turn around and leave\nThe one fantastical moment in your life and you have chosen to leave\nYou go on to live your life as any other person would\nAs you grow old you always have the regret that you never sought anything extraordinary\n\nRegret Ending");
        endingList.add("You lay down this cavern has seeped its way into your mind\nAs you lay you forget time\nYou forget your home\nYou forget your family\nYour Life\nIt all just fades away as you close your eyes\n\nLost Hope Ending");
            }


}
