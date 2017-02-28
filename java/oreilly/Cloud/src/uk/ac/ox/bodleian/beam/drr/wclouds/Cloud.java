/*
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

/* Cloud is a very simple class to create HTML word clouds.
 * It uses Jonathan Feinberg's marvellous Java string tokenizer 
 * as used by him on Wordle. The Word Cloud creation follows
 * Jim Bumgardner's excellent article "Building Tag Clouds in
 * Perl and PHP" (available from pdfs.oreilly.com).
 * 
 * In short, there is absolutely nothing original here, I'm not 
 * claiming any copyright or credit or anything over any of this.
 * I make it available solely to avoid folks typing this all out 
 * again and because I didn't find much when Googling "Word Cloud Java"...
 * 
 * As it says above no "WARRANTIES" about how it'll work and you'll notice
 * the glaring absence of documentation and any kind of error checking!
 * No idea what "scale" does in the em & % outputs - I jus' made that
 * bit up! :-)
 * 
 * If you're looking for a more accomplished Word Cloud software in Java
 * try OpenCloud [http://opencloud.mcavallo.org/] 
 */

/* see the accompanying "Main.java" to see how to use this */

package uk.ac.ox.bodleian.beam.drr.wclouds;

import java.io.File;
import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;

import cue.lang.Counter;
import cue.lang.NGramIterator;
import cue.lang.stop.StopWords;

public class Cloud {
	private Counter<String> mc;

	private double minFontSize;
	private double scale;
	private double maxFontSize;
	private double fontRange;
	
	private double minCount;
	private double maxCount;

	private double minLog;
	private double maxLog;
	private double logRange;

	private int items;

	private boolean USELOGCURVE = true;
	
	HashMap<String, Double> entries;
	
	public Cloud() {
		// set some defaults
		minFontSize = 9;
		maxFontSize = 36;
		scale = (minFontSize+maxFontSize)/2;
		fontRange = maxFontSize - minFontSize;
		minCount = 1000000;
		maxCount = 0;
		items = 30;
	}
	
	public void absorb(File fn, int n) {
		// maybe?
	}

	public void absorb(String str, int n) {
		// Reset counts, etc.
		entries = new HashMap<String, Double>();
		mc = new Counter<String>();
		
		// Count ngrams
		for (String ngram : new NGramIterator(n, str, Locale.ENGLISH, StopWords.English)) {
			mc.note(ngram.toLowerCase(Locale.ENGLISH));			
		}
		
		// smoothing from "Building Tag Clouds in Perl and PHP, Jim Bumgardner" - see pdfs.oreilly.com
		// calculate min & max for smoothing
		for (Entry<String, Integer> e : mc.getAllByFrequency()) {
			double val = e.getValue();
			if (val > maxCount) {
				maxCount = e.getValue();
			}
			if (val < minCount) {
				minCount = e.getValue();
			}
		}
		
		// Logorithmic smoothing
		minLog = Math.log(minCount);
		maxLog = Math.log(maxCount);
		
		if (maxLog == minLog) {
			logRange = 1;
		} else {
			logRange = maxLog - minLog;			
		}
		
		int topx = items;
		
		if (items > mc.getAllByFrequency().size()) {
			topx = mc.getAllByFrequency().size()-1;
		}
		
		// finally calculate font sizes for each tag...
		for (Entry<String, Integer> e : mc.getAllByFrequency().subList(0, topx)) {
			Double fsize = new Double(fontSize(e.getValue().doubleValue()));
			entries.put(e.getKey(), fsize);
		}
	}
	
	public String toHTML() {
		return toHTMLpx();
	}
	
	public String toHTMLpx() {		
		StringBuilder sb = new StringBuilder();
		
		Object[] keys = entries.keySet().toArray();
		Arrays.sort(keys);

		for (int i = 0; i < keys.length; i++) {
			if (i != keys.length-1) {
				sb.append("<span style=\"font-size:"+entries.get(keys[i]).intValue()+"px;\">" + keys[i] + ",</span>\n");				
			} else {
				sb.append("<span style=\"font-size:"+entries.get(keys[i]).intValue()+"px;\">" + keys[i] + "</span>\n");
			}
		}

		return sb.toString();	
	}
	
	public String toHTMLpc() {
		StringBuilder sb = new StringBuilder();
		
		Object[] keys = entries.keySet().toArray();
		Arrays.sort(keys);

		for (int i = 0; i < keys.length; i++) {
			double currentSize = ((Double)entries.get(keys[i])).doubleValue();
			double pc = (currentSize/scale)*100;
			
			String pcStr = new Formatter().format("%.2f", pc).toString();
			// no idea what the number of decimal points matters in browsers - none probably! :)
			
			if (i != keys.length-1) {
				sb.append("<span style=\"font-size:"+pcStr+"%;\">" + keys[i] + ",</span>\n");				
			} else {
				sb.append("<span style=\"font-size:"+pcStr+"%;\">" + keys[i] + "</span>\n");
			}
		}
		return sb.toString();	
	}
	
	public String toHTMLem() {
		StringBuilder sb = new StringBuilder();
		
		Object[] keys = entries.keySet().toArray();
		Arrays.sort(keys);

		for (int i = 0; i < keys.length; i++) {
			double currentSize = ((Double)entries.get(keys[i])).doubleValue();
			double em = (currentSize/scale);
			
			String emStr = new Formatter().format("%.2f", em).toString();
						
			if (i != keys.length-1) {
				sb.append("<span style=\"font-size:"+emStr+"em;\">" + keys[i] + ",</span>\n");				
			} else {
				sb.append("<span style=\"font-size:"+emStr+"em;\">" + keys[i] + "</span>\n");
			}
		}
		return sb.toString();	
	}

	private double fontSize(double count) {
		double cRatio;
		
		if (USELOGCURVE) {
			cRatio = (Math.log(count)-minLog)/logRange;
		} else {
			cRatio = (count - minCount) / (maxCount - minCount);
		}
		
		double fsize = minFontSize + fontRange * (cRatio);
				
		return fsize;
	}

	public double getMinFontSize() {
		return minFontSize;
	}

	public void setMinFontSize(double minFontSize) {
		this.minFontSize = minFontSize;
		this.fontRange = maxFontSize - minFontSize;
	}

	public double getMaxFontSize() {
		return maxFontSize;
	}

	public void setMaxFontSize(double maxFontSize) {
		this.maxFontSize = maxFontSize;
		this.fontRange = maxFontSize - minFontSize;
	}

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

	public boolean isUSELOGCURVE() {
		return USELOGCURVE;
	}

	public void setUSELOGCURVE(boolean uSELOGCURVE) {
		USELOGCURVE = uSELOGCURVE;
	}
	
	public double getScale() {
		return this.scale;
	}
	public void setScale(double scale) {
		this.scale = scale;
	}

}
