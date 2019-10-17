name := "Producer"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies += "org.apache.kafka" % "kafka-clients" % "2.3.0"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.2.2"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.2.2"
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.7.4"
libraryDependencies ++= Seq(
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.1.3"
)
libraryDependencies += "org.json4s" %% "json4s-ast" % "3.6.7"

