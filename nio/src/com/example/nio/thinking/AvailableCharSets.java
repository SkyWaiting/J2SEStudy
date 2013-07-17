package com.example.nio.thinking;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

import static com.example.io.util.Print.print;
import static com.example.io.util.Print.printnb;

/**
 * Displays Charsets and aliases
 * 
 * @author guorui
 *
 */
public class AvailableCharSets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortedMap<String,Charset> charSets = Charset.availableCharsets();
		Iterator<String> it = charSets.keySet().iterator();
		while(it.hasNext()){
			String csName = it.next();
			printnb(csName);
			Iterator aliases = charSets.get(csName).aliases().iterator();
			if(aliases.hasNext())
				printnb(": ");
			while(aliases.hasNext()){
				printnb(aliases.next());
				if(aliases.hasNext())
					printnb(", ");
			}
			print();
		}
	}

}
