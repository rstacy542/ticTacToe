# Tic Tac Toe
Plays a game of Tic Tac Toe where the computer will never lose.  It was coded using angular, scala, scalatra, and simple http services. jsTestDriver was used to unit test the javascript, and specs2 for unit testing the scala code.

#How To Run
1.  Download and install SBT version 13.7
2.  Download and install Scala 11.5
3.  Run ./sbt from within the project directory
4.  At the > prompt, type package
5.  Then type container:start at the next prompt.
6.  In a browser, hit the URL http://localhost:8080

#Simple Way To Run
1.  Install Tomcat
2.  Rename the ROOT application in Tomcat to ORIGNAL_ROOT
3.  copy the tictactoe.war file to tomcat webapps directory
4.  rename the tictactoe.war file to ROOT.war
5.  start tomcat
6.  In a browser, hit the URL http://localhost:8080

