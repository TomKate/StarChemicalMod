package io.github.starmineouji.starchemical.mol.base;

import java.util.List;
import java.util.Map;

public abstract class Molecule {
	public Map<String, Integer> Elements;
	public String Name, Formula;
public abstract List<Molecule> OnThermalDecomp();
public abstract List<Molecule> OnElectrolysis();
}