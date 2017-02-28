public class finishGameTestDriveLow {

    public static void main (String[] args) {

        DotComBust dcbt = new DotComBust();

        int guessNum = 12;

        String result = dcbt.finishGame(guessNum);

        String testResult = "Failed";

        if (result.equals("Game Over." + "Congrats!  You've done better than average!") {

            testResult = "Passed";

        }

        System.out.println(dcbt.finishGame(guessNum);

        System.out.println(testResult);

    }

}
