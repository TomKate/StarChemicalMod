package io.github.starmineouji.starchemical.register;

import java.util.List;

import io.github.starmineouji.starchemical.change.Fusion;
import io.github.starmineouji.starchemical.elem.base.Element;

public interface RegistClass {
	public static interface ObjectAdder{
		public void add(List list);
	}
public void onRegistElement(List<Element> list) ;
public void onRegistFusion(List<Fusion> list);
}