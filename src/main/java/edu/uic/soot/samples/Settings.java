package edu.uic.soot.samples;

public class Settings {

    //this folder contains all the classes than needs to be analyzed by soot
    public static String applicationFolder = "SampleApps/target/classes";

    //This classpath has to be set for soot to find the jce classes
    public static String classPathNeedBySoot = "/System/Library/Frameworks/JavaVM.framework/Classes/jce.jar:" +
            "/System/Library/Frameworks/JavaVM.framework/Classes/classes.jar";

    public static String allClassesForSoot = applicationFolder + ":" + classPathNeedBySoot;

}
