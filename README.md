SootExamples
============

A simple example using Soot to list all def-uses of locals.

This project contains an app that prints all def-use statements of every local in all units of a method.

How to use this sample program:

1. Import the project into your favorite editor
2. Change the edu.uic.Settings.java file:
    a. `applicationFolder` = can point to any application that needs to be analyzed
    b. `classPathNeedBySoot` = depends on OS you are running on. Look for classes and jce jar files.

3. Run SootSampleTest.printDefsOfAllLocals as a junit test.

You should see the results in the console.

Note: Currently, the project has a test subject app called SampleApps which will be analyzed when `mvn test` is run.


Dependencies
------------

The latest soot libraries can be obtained from [here](https://github.com/Sable/soot#how-do-i-obtain-the-nightly-builds).

Install `soot.jar` into local repo using the following command:
`mvn install:install-file -Dfile=lib/soot.jar -DartifactId=soot -DgroupId=soot -Dversion=soot-dev-2 -Dpackaging=jar`


`baksmail.jar` : Download this jar file from [here](https://github.com/Sable/soot/blob/develop/libs/baksmali-1.3.2.jar)

Install baksmail.jar using the following command:

`mvn install:install-file -Dfile=baksmail.jar -DartifactId=org.jf -DgroupId=baksmali -Dversion=1.3.2 -Dpackaging=jar`
