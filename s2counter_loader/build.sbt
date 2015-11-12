import sbtassembly.Plugin.AssemblyKeys._

name := "s2counter-loader"

scalacOptions in Test ++= Seq("-Yrangepos")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % Common.sparkVersion,
  "org.apache.spark" %% "spark-streaming" % Common.sparkVersion,
  "org.apache.spark" %% "spark-streaming-kafka" % Common.sparkVersion,
  "com.typesafe.play" %% "play-ws" % Common.playVersion,
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

// force specific library version
libraryDependencies ++= Seq(
  "com.google.guava" % "guava" % "16.0.1"
)

crossScalaVersions := Seq("2.10.6")

fork := true

transitiveClassifiers ++= Seq()

assemblySettings

mergeStrategy in assembly := {
  case PathList("META-INF", ps @ _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}

test in assembly := {}
