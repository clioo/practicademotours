package org.softtek.utils;

import java.util.Random;

public class AttributesGenerator {
	//arrays for picking one randomly
	private String[] firstNames;
	private String[] lastNames;
	
	public AttributesGenerator() {
		firstNames = new String[] {
				"Paul",
				"Dennis",
				"Gregory",
				"Nathan",
				"Scott",
				"Julian",
				"Miles",
				"Lara",
				"Lorenzo",
				"Connor",
				"Thea",
				"Gabrielle",
				"Charlie",
				"Aimee",
				"Jacqueline",
				"Adele",
				"Marie",
				"Amirah",
				"Amie",
				"Beth"
		};
		firstNames = new String[] {
				"Whittle",
				"Ferguson",
				"Barnes",
				"Yang",
				"Luna",
				"Wilkins",
				"Leonard",
				"Watson",
				"Gordon",
				"Banks"
		};
	}

	public String generateFirstName() {
		return pickRandomlyOne(firstNames);
	}
	
	public String generateLastName() {
		return pickRandomlyOne(lastNames);
	}
	
	private String pickRandomlyOne(String[] stringArray) {
		Random random = new Random();
		Integer number = random.nextInt(stringArray.length);
		return stringArray[number];
	}
	
}
