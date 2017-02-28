public class finishGameTestDrive {

    public static void main (String[] args) {

        DotComBust dcbt = new DotComBust();

        int guessNum = 49;

        String result = dcbt.finishGame(guessNum);

        String testResult = "Failed";

        if (result.equals("All Dot Coms are dead!  Your stocks are now worthless." + "Wow.  Just...  Wow.") {

            testResult = "Passed";

        }

        System.out.println(dcbt.finishGame(guessNum);

        System.out.println(testResult);

    }

}
