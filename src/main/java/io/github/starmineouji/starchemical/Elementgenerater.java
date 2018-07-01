package io.github.starmineouji.starchemical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Elementgenerater {
public static void main(String[] args) throws IOException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	while (true) {
		System.out.print("generate element name:");
		String name = in.readLine();
		if (name.equals("fin"))
			break;
		System.out.println("Creating BlockStates");
		copy("./src/main/resources/assets/sccraft/blockstates/element_block.json",
				"./src/main/resources/assets/sccraft/blockstates/" + name + ".json", name);
		System.out.println("Creating Models");
		copy("./src/main/resources/assets/sccraft/models/block/element_block.json",
				"./src/main/resources/assets/sccraft/models/block/" + name + ".json", name);
		copy("./src/main/resources/assets/sccraft/models/item/element_block.json",
				"./src/main/resources/assets/sccraft/models/item/" + name + ".json", name);
		System.out.println("Complete!");
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
