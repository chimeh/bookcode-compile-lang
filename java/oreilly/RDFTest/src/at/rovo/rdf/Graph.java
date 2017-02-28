package at.rovo.rdf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;
//import java.util.logging.Level;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * <p>
 * Graph is a simple triplestore, which is responsible for adding, removing and
 * querying {@link Triple}s.
 * </p>
 * <p>
 * The triplestore is based on the Python implementation of Toby Segaran, Colin
 * Evans & Jamie Talor taken from "Programming the Semantic Web" published by
 * O'Reilly in 2009 (ISBN: 978-0-596-15381-6).
 * </p>
 * <p>
 * Graph stores those triples in a {@link Map} which contains the
 * subject-value of the triple as a key and a further {@link Map}-object
 * as its value. The second {@link Map} uses as key the predicate-value of
 * the triple and stores all object-values of the triple in a {@link Set}
 * to avoid duplicates.
 * </p>
 * <p>
 * To facilitate the search, Graph stores all triples three times. The ordering 
 * of those stores are as follows:
 * </p>
 * <pre>subject predicate object (spo)</pre>
 * <pre>predicate object subject (pos)</pre>
 * <pre>object subject predicate (osp)</pre>
 * <p>
 * This is necessary due to the form of how a triplestore is beeing queried. If 
 * you pass no arguments to the {@link #triples(String,String,String)}-Method, Graph returns all triples
 * currently stored in the triplestore, if you pass a predicate-value to the 
 * {@link #triples(String,String,String)}-Method all triples which have this predicate will be returned.
 * </p>
 * 
 * @author Roman Vottner
 * @version %I%, %G%
 */
public class Graph
{
	/**
	 * Triplestore for the subject predicate object-ordering
	 */
	protected Map<String, Map<String, Set<String>>> spo;
	/**
	 * Triplestore for the predicate object subject-ordering
	 */
	protected Map<String, Map<String, Set<String>>> pos;
	/** 
	 * Triplestore for the object subject predicate-ordering
	 */
	protected Map<String, Map<String, Set<String>>> osp;
	/**
	 * Logger, only necessary for debug
	 */
	private Logger logger = Logger.getLogger(this.getClass().getName());

	static 
	{
	    DOMConfigurator.configure("config/log4jconf.xml");
	}
	
	/**
	 * Creates an instance of the Graph-Class and initializes an empty triplestore
	 */
	public Graph()
	{
		logger.setLevel(Level.WARN);
		spo = new HashMap<String, Map<String, Set<String>>>();
		pos = new HashMap<String, Map<String, Set<String>>>();
		osp = new HashMap<String, Map<String, Set<String>>>();
	}

	/**
	 * Adds a triple to the triplestore
	 * 
	 * @param sub Subject of the triple
	 * @param pred Predicate of the triple
	 * @param obj Object of the triple
	 */
	public void add(String sub, String pred, String obj)
	{
		this.addToIndex(spo, sub, pred, obj);
		this.addToIndex(pos, pred, obj, sub);
		this.addToIndex(osp, obj, sub, pred);
	}
	
	/**
	 * Adds a triple to the triplestore
	 * 
	 * @param t Triple which should be added to the triplestore
	 */
	public void add(Triple t)
	{
		this.add(t.getSubject(), t.getPredicate(), t.getObject());
	}

	/**
	 * <p>
	 * Adds a triple to a specified store. Therefore this Method has to determin 
	 * if there already is a triple-entry for a in the specified store.
	 * </p>
	 * <p>
	 * If there already is a triple-entry for t[a][b] c will be addet to the 
	 * list of t[a][b], If there is only a triple-entry for t[a] but not for t[a][b], 
	 * t[a][b] will be added and a list for t[a][b] containing c will be created. 
	 * If there is no triple for t[a] at all, the whole triple t[a][b] will be 
	 * created and a list for c will be added to this triple.
	 * </p>
	 * 
	 * @param index Triplestore which should add the triple
	 * @param a key-value of the outer {@link Map}
	 * @param b key-value of the inner {@link Map}
	 * @param c {@link Set} value to be added
	 */
	private void addToIndex(
			Map<String, Map<String, Set<String>>> index, String a,
			String b, String c)
	{
		// checks if the subject of the triple already exists
		// if not, create the whole triple
		if (!index.containsKey(a))
		{
			Map<String, Set<String>> bc = new HashMap<String, Set<String>>();
			Set<String> list = new LinkedHashSet<String>();
			list.add(c);
			bc.put(b, list);
			index.put(a, bc);
		}
		else
		{
			Map<String, Set<String>> bc = index.get(a);
			// so the subject exists, but is there already a predicate
			// if so add the predicate and an object to its list
			if (!bc.containsKey(b))
			{
				Set<String> list = new LinkedHashSet<String>();
				list.add(c);
				bc.put(b, list);
			}
			// else add only the object to the subject-predicate-pair
			else
			{
				Set<String> list = bc.get(b);
				list.add(c);
			}
		}
	}

	/**
	 * <p>
	 * Removes triples coresponding with the provided arguments from the triplestore.
	 * If there cannot be found any triples representing the provided arguments, nothing
	 * will be removed.
	 * </p>
	 * <p>
	 * <b>Note:</b> If you pass only null-values or empty {@link String}s everything will be
	 * removed!
	 * </p>
	 * @param sub Subject-value of the triple.
	 * @param pred Predicate-value of the triple.
	 * @param obj Object-value of the triple.
	 */
	public void remove(String sub, String pred, String obj)
	{
		Set<Triple> triples = this.triples(sub, pred, obj);
		for (Triple t : triples)
		{
			this.removeFromIndex(spo, t.getSubject(), t.getPredicate(), t.getObject());
			this.removeFromIndex(pos, t.getPredicate(), t.getObject(), t.getSubject());
			this.removeFromIndex(osp, t.getObject(), t.getSubject(), t.getPredicate());
		}
	}

	/**
	 * Removes triples corresponding the provided values from the specified triplestore.
	 * 
	 * @param index Specified triplestore the triple should be removed from.
	 * @param a key-value of the outer {@link Map}.
	 * @param b key-value of the inner {@link Map}.
	 * @param c {@link Set} value to be removed
	 */
	private void removeFromIndex(Map<String, Map<String, Set<String>>> index, String a, String b, String c)
	{
		Map<String, Set<String>> bs = index.get(a);
		Set<String> cList = bs.get(b);
		cList.remove(c);
		if (cList.isEmpty())
			bs.remove(b);
		if (bs.isEmpty())
			index.remove(a);
	}

	/**
	 * Loads triples from a provided file.
	 * 
	 * @param filename Filepath and filename which contains the triples to load 
	 * 		into the triplestore
	 */
	public void load(String filename)
	{
		try
		{
			File file = new File(filename);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while ( (line = bufferedReader.readLine()) != null)
			{
				if (line.contains("Blade Runner"))
					line = line+"";
				StringTokenizer token = new StringTokenizer(line,",");
				if (line.contains("\""))
				{
					// Keep tokens with " together
					// Pattern: SPR,industry,"Aircraft Parts and Auxiliary Equipment, NEC"
					List<String> tokens = new ArrayList<String>();
					while (token.hasMoreElements())
					{
						String temp = token.nextToken();
						if (temp.contains("\""))
						{
							while (token.hasMoreElements() && !temp.endsWith("\""))
								temp += token.nextToken();
						}
						tokens.add(temp);
					}
					if (tokens.size() != 3)
						logger.error("tokensize != 3");
					this.add(tokens.get(0), tokens.get(1), tokens.get(2));
				}
				else
					this.add(token.nextToken(), token.nextToken(), token.nextToken());
			}
			bufferedReader.close();
			fileReader.close();
		}
		catch(FileNotFoundException fnfE)
		{
			logger.fatal(fnfE.getLocalizedMessage());
		}
		catch(IOException ioE)
		{
			logger.fatal(ioE.getLocalizedMessage());
		}
	}

	/**
	 * Saves the triplestore into a specified file.
	 * 
	 * @param filename Filepath and filename where the triplestore should be saved to.
	 */
	public void save(String filename)
	{
		try
		{
			File file = new File(filename);
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			Set<Triple> triples = this.triples("", "", "");
			for (Triple t : triples)
				bufferedWriter.write(t.getSubject()+","+t.getPredicate()+","+t.getObject()+"\n");
			bufferedWriter.close();
			fileWriter.close();
		}
		catch(FileNotFoundException fnfE)
		{
			logger.fatal(fnfE.getLocalizedMessage());
		}
		catch(IOException ioE)
		{
			logger.fatal(ioE.getLocalizedMessage());
		}
	}

	/**
	 * <p>
	 * Queries the triplestore to find triples corresponding the provided triple-elements.
	 * If a triple-part is null or empty, this method will use the the value as a wildcard 
	 * and look for every possible solution for this field. So if you only pass empty 
	 * Strings as a search-pattern, the whole triplestore will be returned.
	 * </p>
	 * @param sub Subject of the triples which should be found
	 * @param pred Predicate of the triples which should be found
	 * @param obj Object of the triples which should be found
	 * @return Returns a {@link Set} of {@link Triple} objects containing the found triples. 
	 * If nothing could be found an empty {@link Set} will be returned.
	 */
	public Set<Triple> triples(String sub, String pred, String obj)
	{
		Set<Triple> results = new LinkedHashSet<Triple>();
		// check which terms are present in order to use the correct index:
		if (sub != null && !sub.equals(""))
		{
			if (pred != null && !pred.equals(""))
			{
				// sub pred obj
				if (obj != null && !obj.equals(""))
				{
					logger.info("'" + sub + "' '" + pred + "' '" + obj + "'");
					if (spo.get(sub).get(pred).contains(obj))
						results.add(new Triple(sub, pred, obj));
				}
				// sub pred None
				else
				{
					logger.info("'" + sub + "' '" + pred + "' None");
					if (spo.get(sub) != null && spo.get(sub).get(pred) != null)
						for (String retObj : spo.get(sub).get(pred))
							results.add(new Triple(sub, pred, retObj));
				}
			}
			else
			{
				// sub None obj
				if (obj != null & !obj.equals(""))
				{
					logger.info("'" + sub + "' None '" + obj + "'");
					if (osp.get(obj) != null && osp.get(obj).get(sub) != null)
						for (String retPred : osp.get(obj).get(sub))
							results.add(new Triple(sub, retPred, obj));
				}
				// sub None None
				else
				{
					logger.info("'" + sub + "' None None");
					Map<String, Set<String>> p = spo.get(sub);
					if (p != null)
					{
						for (Map.Entry<String, Set<String>> pKeys : p.entrySet())
						{
							String retPred = pKeys.getKey();
							for (String retObj : pKeys.getValue())
								results.add(new Triple(sub, retPred, retObj));
						}
					}
				}
			}
		}
		else
		{
			if (pred != null && !pred.equals(""))
			{
				// None pred obj
				if (obj != null && !obj.equals(""))
				{
					logger.info("None '" + pred + "' '" + obj + "'");
					if (pos.get(pred) != null && pos.get(pred).get(obj) != null)
						for (String retSub : pos.get(pred).get(obj))
							results.add(new Triple(retSub, pred, obj));
				}
				// None pred None
				else
				{
					logger.info("None '" + pred + "' None");
					Map<String, Set<String>> o = pos.get(pred);
					if (o != null)
					{
						for (Map.Entry<String, Set<String>> oKeys : o.entrySet())
						{
							String retObj = oKeys.getKey();
							for (String retSub : oKeys.getValue())
								results.add(new Triple(retSub, pred, retObj));
						}
					}
				}
			}
			else
			{
				// None None obj
				if (obj != null && !obj.equals(""))
				{
					logger.info("None None '" + obj + "'");
					if (osp.get(obj) != null)
					{
						Map<String, Set<String>> s = osp.get(obj);
						for (Map.Entry<String, Set<String>> sKeys : s.entrySet())
						{
							String retSub = sKeys.getKey();
							for (String retPred : sKeys.getValue())
								results.add(new Triple(retSub, retPred, obj));
						}
					}
				}
				// None None None
				else
				{
					logger.info("None None None");
					for (Map.Entry<String, Map<String, Set<String>>> sKeys : spo.entrySet())
					{
						String retSub = sKeys.getKey();
						Map<String, Set<String>> p = spo.get(retSub);
						for (Map.Entry<String, Set<String>> pKeys : p.entrySet())
						{
							String retPred = pKeys.getKey();
							for (String retObj : pKeys.getValue())
								results.add(new Triple(retSub, retPred, retObj));
						}
					}
				}
			}
		}
		return results;
	}

	/**
	 * Queries a single value of a triple. If multiple arguments are left empty (or null)
	 * the first found triple which corresponds the parameters will be used for the query.
	 * 
	 * @param sub Subject of the triple.
	 * @param pred Predicate of the triple.
	 * @param obj Object of the triple.
	 * @return Depending on the passed arguments this method returns either the subject, 
	 *         the predicate or the object-field of the first found triple. If multiple 
	 *         fields are left empty (or null), only one value will be returned. The ordering
	 *         therefore is as follows: subject before predicate before object.
	 */
	public String value(String sub, String pred, String obj)
	{
		if (sub == null) sub = "";
		if (pred == null) pred = "";
		if (obj == null) obj = "";
		for (Triple t : this.triples(sub, pred, obj))
		{
			if (sub == null || sub.equals("")) return t.getSubject();
			if (pred == null || pred.equals("")) return t.getPredicate();
			if (obj == null || obj.equals("")) return t.getObject();
		}
		return "";
	}
	
	/**
	 * <p>
	 * Enables the usage of complex triplestore queries with the help of variables.
	 * </p>
	 * <p>
	 * The method takes a {@link Set} of {@link String}-clauses in the following form:
	 * </p>
	 * <code>
	 * Set&lt;String> query = new HashSet&lt;String>();</br>
	 * query.add("?variable, predicate, object");</br>
	 * query.add("?aFurtherVariable, predicate, ?variable);</br>
	 * </br>
	 * Set&lt;Map&lt;String,String>> results = this.query(query);</br>
	 * </code>
	 * <p>"?variable" and "?aFurtherVariable" are examples of how variables should be defined,
	 * whereas predicate and object are corresponding fields of the triple.</p>
	 * @param clauses A {@link Set} of {@link String}-clauses. Variables are defined with
	 *                a leading "?".
	 * @return Returns a {@link Set}-object containing all calculated results as 
	 *         {@link Map}-objects with the defined variables as key and the fitting
	 *         results as {@link String}-value. If one of the the clauses does not equal a valid
	 *         triple, null will be returned.
	 */
	public Set<Map<String, String>> query(Set<String> clauses)
	{
		Set<Map<String, String>> bindings = null;
		for (String clause : clauses)
		{
			// bpos stores the variables and the position in the triple
			Map<String,Integer> bpos = new HashMap<String,Integer>();
			// qc stores the 3 triple values
			List<String>  qc = new ArrayList<String>();
			
			// determin the variables in the clause, save them with their position (bpos)
			// and build the search-pattern (qc)
			StringTokenizer tokens = new StringTokenizer(clause,",");
			int pos = 0;
			while (tokens.hasMoreElements())
			{
				String token = tokens.nextToken().trim();
				// is the token a variable?
				if (token.startsWith("?"))
				{
					qc.add("");
					// saving variable-binding and its position in the triple
					bpos.put(token, pos);
				}
				else
					// no, its a search-value - add only the token
					qc.add(token);
				pos++;
			}
			
			// There should only be 3 triples, if there are more or even fewer 
			// elements something is wrong
			if (qc.size() != 3)
			{
				logger.error("List qc.size != 3 !!!");
				return null;
			}
			
			//  find all triples which correspond to the search-triple
			Set<Triple> rows = this.triples(qc.get(0), qc.get(1), qc.get(2));
			
			// we only want to determin those triples which all clauses correspond to
			// therefore we need to start by adding all triples which match the serch-triple.
			if (bindings == null)
			{
				// This is the first pass, create a new binding
				// The binding will store the token as key and its corresponding binding
				// f.e: triplestore contains '[a] [b] [c]' and [a] [b] [d]'
				// query: '[a] [b] ?var' 
				// then binding will contain:
				// '?var [c]' and '?var [d]'
				bindings = new LinkedHashSet<Map<String, String>>();
				for (Triple row : rows)
				{
					HashMap<String, String> binding = new HashMap<String, String>();
					for (Map.Entry<String, Integer> vars : bpos.entrySet())
						binding.put(vars.getKey(), row.get(vars.getValue().intValue()));
					bindings.add(binding);
				}
			}
			else
			{
				// in subsequent passes, eliminate bindings that don't work
				Set<Map<String,String>> newbindings = new LinkedHashSet<Map<String,String>>();
				for (Map<String, String> binding : bindings)
				{
					// for all valid triple-results based on our search
					for (Triple row : rows)
					{
						// consider the binding to be a valid match
						boolean validmatch = true;
						Map<String,String> tempbinding = new HashMap<String, String>(binding);
						// determine the variables of the search-triple and the position in the triple
						for (Map.Entry<String, Integer> vars : bpos.entrySet())
						{
							String var = vars.getKey();
							pos = vars.getValue().intValue();
							// test if the variable is already in the bindings
							if (tempbinding.containsKey(var))
							{
								// if so, we have to test if the triple-field we have found before
								// matches one of the before stored variable bindings. We only want
								// to keep those fields which match our before determined variable 
								// bindings
								if (!tempbinding.get(var).equals(row.get(pos)))
									validmatch = false;
							}
							else
								// else bind the field of the triple to the variable
								tempbinding.put(var, row.get(pos));
						}
						if (validmatch == true)
							newbindings.add(tempbinding);
					}
				}
				bindings = newbindings;
			}
		}
		return bindings;
	}
	
	public void applyInference(InferenceRule rule)
	{
		Set<Set<String>> queries = rule.getQueries();
		Set<Map<String, String>> bindings = new LinkedHashSet<Map<String, String>>();
		for (Set<String> query : queries)
			bindings.addAll(this.query(query));
		for (Map<String, String> binding : bindings)
		{
			Set<Triple> newTriples = rule.makeTriples(binding);
			for (Triple t : newTriples)
			{
				logger.info("Adding new triple through inference-rule: "+t);
				this.add(t);
			}
		}
	}
}
