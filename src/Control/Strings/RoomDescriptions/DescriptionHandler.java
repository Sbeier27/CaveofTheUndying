package Control.Strings.RoomDescriptions;

import Control.Strings.Endings.EndingHandler;

import java.util.ArrayList;
import java.util.List;

public class DescriptionHandler {
    private List<String> descriptionList = new ArrayList<>();
    private static DescriptionHandler descriptionHandler = new DescriptionHandler();
        public static DescriptionHandler getDescriptionHandler(){return descriptionHandler;}


    public String getDescription(int roomNumber){
        return descriptionList.get(roomNumber);
    }
    public void initializeDescriptionList(){
        descriptionList.add("You enter the cavern\nAs you walk deeper the floor gives way\nYou land on the ground in a much deeper area\nThe light from the entrance reaches only a faint circle on the ground where you landed");
    }
}
