import java.util.ArrayList;

public class DotCom {

    private ArrayList<String> locationCells;

    public void setLocationCells(ArrayList<String> loc) {

        locationCells = loc;

    }

    public String checkYourself(String userInput) {

        int index = locationCells.indexOf(userInput);

        String result = "Miss";

        if (index >= 0) {

            locationCells.remove(index);

            if (locationCells.isEmpty()) {

                result = "Kill";

            } else {

                result = "Hit";

            }

        }

        return result;

    }

}
