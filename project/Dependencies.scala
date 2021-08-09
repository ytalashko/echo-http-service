import sbt._

object Dependencies {

  object Versions {
    val cats       = "2.6.1"
    val catsEffect = "3.2.2"
    val fs2        = "3.1.0"
    val http4s     = "0.23.1"
    val circe      = "0.14.1"

    val logback    = "1.2.5"
  }

  object Libraries {
    def circe(artifact: String): ModuleID  = "io.circe"   %% artifact % Versions.circe
    def http4s(artifact: String): ModuleID = "org.http4s" %% artifact % Versions.http4s

    lazy val cats       = "org.typelevel" %% "cats-core"   % Versions.cats
    lazy val catsEffect = "org.typelevel" %% "cats-effect" % Versions.catsEffect
    lazy val fs2        = "co.fs2"        %% "fs2-core"    % Versions.fs2

    lazy val http4sDsl          = http4s("http4s-dsl")
    lazy val http4sServer       = http4s("http4s-blaze-server")
    lazy val http4sCirce        = http4s("http4s-circe")
    lazy val circeCore          = circe("circe-core")
    lazy val circeGeneric       = circe("circe-generic")
    lazy val circeGenericExtras = circe("circe-generic-extras")

    lazy val logback = "ch.qos.logback" % "logback-classic" % Versions.logback
  }

}
