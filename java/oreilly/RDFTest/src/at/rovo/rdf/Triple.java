package at.rovo.rdf;

/**
 * <p>A Triple typically represents a subject-, predicate- and object-value.</p>
 * <p>Triples could be something like:</p>
 * <li>"blade_runner" "name" "Blade Runner"</li>
 * <li>"blade_runner" "directed_by" "ridley_scott"</li>
 * <li>"ridley_scott" "name" "Ridley Scott"</li>
 * <br></br>
 * <p>The subject- and object-values name things, while the predicate links those things together.</p>
 * 
 * @author Roman Vottner
 * @version %I%, %G%
 */
public class Triple
{
	/**
	 * Subject-field of the triple
	 */
	protected String subject;
	/**
	 * Predicate-field of the triple
	 */
	protected String predicate;
	/**
	 * Object-field of the triple
	 */
	protected String object;
	
	/**
	 * Creates an instance of a triple, consisting of a subject, a predicate and an object-element.
	 * 
	 * @param subject 
	 * @param predicate
	 * @param object
	 */
	public Triple(String subject, String predicate, String object)
	{
		this.subject = subject;
		this.predicate = predicate;
		this.object = object;
	}
	
	/**
	 * Getter-Methode for the subject
	 * @return Returns the currently stored subject-value of the triple.
	 */
	public String getSubject()
	{
		return this.subject;
	}
	
	/**
	 * Getter-Methode for the predicate
	 * @return Returns the currently stored predicate-value of the triple.
	 */
	public String getPredicate()
	{
		return this.predicate;
	}
	
	/**
	 * Getter-Methode for the object
	 * @return Returns the currently stored object-value of the triple.
	 */
	public String getObject()
	{
		return this.object;
	}
	
	/**
	 * Returns the object as {@link String}
	 */
	public String toString()
	{
		return "("+this.subject+" "+this.predicate+" "+this.object+")";
	}
	
	/**
	 * Returns the field corresponding to the position in the triple
	 * 
	 * @param pos Position of the desired field in the triple
	 * @return Returns the Subject if pos is 0, the Predicate if pos 
	 *         is 1, the Object if pos is 2 or an empty {@link String} 
	 *         otherwise.
	 */
	public String get(int pos)
	{
		switch(pos)
		{
			case 0:
				return this.subject;
			case 1:
				return this.predicate;
			case 2:
				return this.object;
			default:
				return "";
		}
	}
}
