import sbt._

object AppDependencies {

  import play.core.PlayVersion

  private val bootstrapPlayVersion = "7.15.0"
  private val hmrcMongoVersion = "1.1.0"

  val compile = Seq(
    play.sbt.PlayImport.ws,
    "uk.gov.hmrc" %% "play-frontend-hmrc" % "7.1.0-play-28" excludeAll (ExclusionRule("uk.gov.hmrc", "url-builder_2.12")),
    "uk.gov.hmrc" %% "play-conditional-form-mapping" % "1.12.0-play-28",
    "uk.gov.hmrc" %% "bootstrap-frontend-play-28" % bootstrapPlayVersion,
  )

  val test = Seq(
    "org.scalatest" %% "scalatest" % "3.2.10",
    "org.scalatestplus" %% "scalacheck-1-15" % "3.2.10.0",
    "org.scalatestplus" %% "mockito-3-4" % "3.2.10.0",
    "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0",
    "org.pegdown" % "pegdown" % "1.6.0",
    "org.jsoup" % "jsoup" % "1.14.3",
    "com.typesafe.play" %% "play-test" % PlayVersion.current,
    "org.mockito" %% "mockito-scala" % "1.16.42",
    "org.scalacheck" %% "scalacheck" % "1.15.4",
    "com.vladsch.flexmark" % "flexmark-all" % "0.62.2",
    "uk.gov.hmrc" %% "bootstrap-test-play-28" % bootstrapPlayVersion,

  ).map(_ % "test, it")

  def apply(): Seq[ModuleID] = compile ++ test
}
