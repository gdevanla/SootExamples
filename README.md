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
