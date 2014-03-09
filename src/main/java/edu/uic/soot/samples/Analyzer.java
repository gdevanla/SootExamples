package edu.uic.soot.samples;


import soot.*;
import soot.jimple.AssignStmt;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.graph.pdg.EnhancedUnitGraph;
import soot.toolkits.scalar.SimpleLocalDefs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Analyzer extends BodyTransformer {

    // public static final Analyzer v = new Analyzer();
    // private Analyzer() {}

    @Override
    protected void internalTransform(Body body, String s, Map<String, String> stringStringMap) {
        //print all defs for each local in each unit
        printDefsForAllLocals(body);

    }

    private void printDefsForAllLocals(Body body) {

        UnitGraph cfg = new EnhancedUnitGraph(body);
        SimpleLocalDefs simpleLocalDefs = new SimpleLocalDefs(cfg);

        System.out.println(String.format("def-use chains in %s %s", body.getMethod(), body.getMethod().getDeclaringClass()));
        for (Unit u : body.getUnits()) {
            System.out.println("\t\tLocals in unit = " + u);
            for (Local l : getAllLocals(u)) {
                List<Unit> defsForLocal = getDefsOfLocal(simpleLocalDefs, u, l);
                {
                    System.out.println("\t\t\tLocal = " + l);

                    //now print all Defs
                    for (Unit defUnit : defsForLocal) {
                        System.out.println("\t\t\t\t Def = " + defUnit);
                    }

                }
            }
        }

    }


    public static List<Local> getAllLocals(Unit u) {
        List<Immediate> imm = getAllImmediates(u);
        List<Local> locals = new ArrayList<Local>();
        for (Immediate im : imm) {
            if (im instanceof Local) {
                locals.add((Local) im);
            }
        }

        if (u instanceof AssignStmt) {
            //We dont handle assignments to instance fields.
            if (((AssignStmt) u).getLeftOp() instanceof Local) {
                locals.add((Local) ((AssignStmt) u).getLeftOp());
            }
        }

        return locals;

    }


    // Gets only locals on rightOp
    public static List<Immediate> getAllImmediates(Unit u) {
        List<Immediate> imm = new ArrayList<Immediate>();
        for (ValueBox vb : u.getUseBoxes()) {
            getAllImmediates(vb, imm);
        }

        return imm;
    }


    public static void getAllImmediates(ValueBox vb, List<Immediate> imm) {
        if (vb.getValue() instanceof Immediate) {
            imm.add((Immediate) vb.getValue());
            return;
        }

        for (Object o : vb.getValue().getUseBoxes()) {
            ValueBox v = (ValueBox) o;
            getAllImmediates(v, imm);
        }


    }


    public static List<Unit> getDefsOfLocal(SimpleLocalDefs defs, Unit u, Local l) {
        if (defs.hasDefsAt(l, u)) {
            return defs.getDefsOfAt(l, u);
        } else {
            assert (u instanceof AssignStmt);
            List<Unit> defUnits = new ArrayList<Unit>();
            defUnits.add(u);
            return defUnits;
        }
    }


}
