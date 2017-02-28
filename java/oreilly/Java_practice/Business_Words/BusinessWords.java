public class BusinessWords {

    public static void main (String [] args) {

        String[] firstWordList = {"24/7", "multi-tier", "30,000 foot", "B-to-B", "win-win", "front-end", "web-based", "pervasive", "smart", "six-sigma", "critical-path", "dynamic"};

        String[] secondWordList = {"empowered", "sticky", "value-added", "oriented", "centric", "distributed", "clustered", "branded", "outside-the-box", "positioned", "networked", "focussed", "leveraged", "aligned", "targeted", "shared", "cooperative", "accelerated"};

        String[] thirdWordList = {"process", "tipping-point", "solution", "architecture", "core competency", "strategy", "mindshare", "portal", "space", "vision", "paradigm", "mission"};

        int oneLength = firstWordList.length;

        int twoLength = secondWordList.length;

        int threeLength = thirdWordList.length;

        int rand1 = (int) (Math.random() * oneLength);

        int rand2 = (int) (Math.random() * twoLength);

        int rand3 = (int) (Math.random() * threeLength);

        String phrase = firstWordList[rand1] + " " + secondWordList[rand2] + " " + thirdWordList[rand3];

        System.out.println("What we need is a " + phrase);

    }

}
