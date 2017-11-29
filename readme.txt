1.  Copied .pom file and src folder from agInterrogation to ahManipulation
2.  Edited .pom to change the artifact ID to reflect the new project
3.  Started intellij and imported the .pom
4.  Ran the test to build everything and make sure moved correctly.

5. Important - when in Chrome inspect to inspect an element on the screen - then control-f to open search window,
lets you search by name, selector or xpath.
6. Important hot keys in intella-J
a. Cmd-click navigates to source
b. Control-space right next to a period brings up all the code completion options
c. Control-j (on mac & cntrl-q on pc) on a method for example By.id to see the documentation
d. Alt-enter to add import for element

7. There are a variety of drivers for different browsers and environments including:
HTMLUnitDriver
FireFoxDriver
ChromeDriver
OperaDriver // available through maven so we can get it via the POM
IEDriver
RemoteDriver for Saucelabs and Grid
Various Mobile Drivers

