public class BeerSong {

	public static void main (String[] args) {

		int Beer = 99;

		String word = "bottles";

		while(Beer > 0) {

			System.out.println(Beer + " " + word + " of beer on the wall,");

			System.out.println(Beer + " " + word + " of beer!");

			System.out.println("Take one down, pass it around,");

			Beer = Beer - 1;

			if(Beer > 1) {

				System.out.println(Beer + " " + word + " of beer on the wall.");

			} else if(Beer == 1) {

				word = "bottle";

				System.out.println(Beer + " " + word + " of beer on the wall.");

			} else if(Beer == 0) {

				System.out.println("Now there's no bottles of beer on the wall!");

			}

		}
		
	}

}
