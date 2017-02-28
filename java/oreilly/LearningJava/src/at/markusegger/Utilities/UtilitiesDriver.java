/**
 * 
 */
package at.markusegger.Utilities;

/**
 * @author MarkusME
 *
 * A test/compilation harness for the Utilities class.
 * 
 */
public final class UtilitiesDriver
{
	/**
	 * The main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(String.format("X equals Y? %b"
											, Utilities.nullSafeEquals("X", "Y")));

		System.out.println(String.format("X equals X? %b"
											, Utilities.nullSafeEquals("X", "X")));

	}
}
