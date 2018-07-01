package io.github.starmineouji.schemicalmod.mol.base;

import java.util.List;

public interface Molecule {
public List<Molecule> OnThermalDecomp();
public List<Molecule> OnElectrolysis();
}