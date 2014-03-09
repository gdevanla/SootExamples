package edu.uic.soot.samples;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import soot.G;
import soot.PackManager;
import soot.Transform;
import soot.options.Options;

import java.util.ArrayList;

@RunWith(JUnit4.class)
public class SootSamplesTest {

    @Before
    public void setup() {
        //Default soot settings -move to some central class
        G.reset();
        //Options.v().set_verbose(true);
        Options.v().set_no_bodies_for_excluded(true);
        ArrayList<String> exclude_list = new ArrayList<String>();
        exclude_list.add("java.");
        Options.v().set_exclude(exclude_list);
        Options.v().set_whole_program(true);
        Options.v().set_output_format(Options.output_format_jimple);
        Options.v().set_keep_line_number(true);
        Options.v().setPhaseOption("jb", "use-original-names");

        //Setup output dir where the jimple or class files can be generated.
        //Options.v().set_output_dir(outputDir);

        Options.v().set_allow_phantom_refs(true);

        //Setup the classes that need to be analyzed


    }

    @Test
    public void printDefsOfAllLocals() {

        System.out.println("Printing Example of determining all defs for each Local");
        PackManager.v().getPack("jtp").add(new Transform("jtp.myTransformer", new Analyzer()));

        //move this whole thing to mvn, can that be done?
        String[] sootArguments = new String[]{"-process-dir", Settings.applicationFolder, "-cp", Settings.allClassesForSoot};

        soot.Main.main(sootArguments);

    }


}
