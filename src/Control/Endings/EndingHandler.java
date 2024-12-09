package Control.Endings;

import Control.Objects.GameObject;

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
        endingList.add("You turn around and leave\nThe one fantastical moment in your life and you have chosen to leave\nYou go on to live your life as any other person would\nAs you grow old you always have the regret that you never sought anything extraordinary");
    }

}
