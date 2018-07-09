package io.github.starmineouji.starchemical.register;

import java.util.Map;

import io.github.starmineouji.starchemical.elem.base.Element;
import io.github.starmineouji.starchemical.elem.base.RadioactiveElement;

public class ElementRegister {
	public static RadioactiveElement addRElement(String name, int number, long half_life,
			Map<String, Integer> afterhalf, String ESymbol) {
		RadioactiveElement ra = new RadioactiveElement(name, number, half_life, afterhalf, ESymbol);
		Element.elements.put(ESymbol, ra);
		return ra;
	}

	public static Element addElement(String name, int number, String ESymbol) {
		Element ra = new Element(name, number, ESymbol);
		Element.elements.put(ESymbol, ra);
		return ra;
	}
	public static void addElementRegistClass(RegistClass regist) {
		
	}
}
