name := "untitled3"

version := "0.1"
libraryDependencies += "org.scalafx" %% "scalafx" % "16.0.0-R24"

scalaVersion := "3.1.3"

libraryDependencies += "org.openjfx" % "javafx-base" % "19"
libraryDependencies += "org.openjfx" % "javafx-controls" % "19"
libraryDependencies += "org.openjfx" % "javafx-fxml" % "19"
libraryDependencies += "org.openjfx" % "javafx-graphics" % "19"
fork in run := true

javaOptions += "-Javafx.graphics.use-system-aa-settings=lcd"

javaOptions in run ++= Seq(
  "--module-path",
  s"${System.getProperty("java.home")}/javafx-sdk-11.0.2/lib",
  "--add-modules",
  "javafx.controls,javafx.fxml,javafx.graphics"
)

