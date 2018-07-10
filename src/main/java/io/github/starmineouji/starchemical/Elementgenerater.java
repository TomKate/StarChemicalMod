package io.github.starmineouji.starchemical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.core.util.SystemClock;

public class Elementgenerater {
public static void main(String[] args) throws IOException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	while (true) {
		System.out.print("generate element name:");
		String line = in.readLine().toLowerCase();
		if (line.equals("fin"))
			break;
		String[] strs = line.split(",");
		for (String name : strs) {
		System.out.println("Creating BlockStates");
		copy("./src/main/resources/assets/starchemical/blockstates/element.json",
				"./src/main/resources/assets/starchemical/blockstates/" + name + "_block.json", name);
		System.out.println("Creating Models");
		copy("./src/main/resources/assets/starchemical/models/block/element.json",
				"./src/main/resources/assets/starchemical/models/block/" + name + "_block.json", name);
		copy("./src/main/resources/assets/starchemical/models/item/element.json",
				"./src/main/resources/assets/starchemical/models/item/" + name + ".json", name);
		copy("./src/main/resources/assets/starchemical/models/item/element_block.json",
				"./src/main/resources/assets/starchemical/models/item/" + name + "_block.json", name);
		System.out.println("Complete!");
		}
		for (String name : strs) 
			System.out.println("tile."+name+".name\nitem."+name+".name");
	}
}
public static void copy(String from, String to, String name) throws IOException {
	BufferedReader fin = new BufferedReader(new FileReader(from));
	File f = new File(to);
	System.out.println(to);
	f.createNewFile();
	BufferedWriter br = new BufferedWriter(new FileWriter(f));
	String str = "";
	while ((str = fin.readLine()) != null) {
		br.write(str.replace("{0}", name) + "\n");
	}
	System.out.println("\t\tcomplete.");
	fin.close();
	br.close();
}
}
