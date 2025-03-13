//> using scala 3.6.3
//> using toolkit 0.7.0

//  run with: scala run build.scala

val includeKey = "%INCLUDE "

extension (s: String) 

  def insertIncludesTo(f: String): Unit = 
    println(s"\ninsertIncludesTo $includeKey... from $s to file $f\n")
    val lines = os.read(os.pwd / os.SubPath(s)).split("\n")
    val result = 
      lines.flatMap: line =>
        if line.startsWith(includeKey) then
          val fileToInclude = os.SubPath(line.stripPrefix(includeKey))
          println(s"$includeKey${os.pwd}/$fileToInclude")
          val extraLines = os.read(os.pwd / fileToInclude).split("\n")
          println(Console.GREEN 
          + "lines inserted:\n" + Console.BLUE + s"${extraLines.mkString("\n")}" + Console.RESET)
          extraLines
        else Array(line)
      .mkString("\n")

    os.write.over(target = os.pwd / os.SubPath(f), data = result)

  end insertIncludesTo

val buildFooter = Seq("pandoc", "src/footer.md", "-o", "footer.html")

val buildTop = Seq("pandoc", "src/top.md", "-o", "top.html")

val title = "reqT - Requirements Engineering Tool"

val buildIndex  = //--metadata title=reqT 
  Seq("pandoc", "-s", "--toc", "-c", "pandoc.css", "-A", "footer.html", "-B", "top.html", "-H", "header.html", 
      "--metadata", s"""title=$title""", "src/index-GENERATED.md", "-o", "index.html")

val buildQuizJS = Seq("scala", "--power", "package", "quiz/src/quiz.scala", "--js-dom", "-o", "quiz/quiz.js", "-f")

val buildQuizPage =
  Seq("pandoc", "-s", "-c", "../pandoc.css", "-H", "quiz/header.html", "--metadata", "title=reqT Quiz", "quiz/src/index.md", "-o", "quiz/index.html")

val commands = Seq(buildTop, buildFooter, buildIndex, buildQuizJS, buildQuizPage)

@main def build = // https://pandoc.org/demos.html
  import Console.{RED as redFg, GREEN as greenFg, RED_B as redBg, RESET, BLACK as blackFg}

  println("\n--- BUILDING reqt.github.io ---")

  "src/index.md".insertIncludesTo("src/index-GENERATED.md")

  import scala.util.{Try, Failure, Success}

  val results = for cmd <- commands yield cmd -> Try:
    val result = os.proc(cmd).call(stdin = os.Inherit, stdout = os.Inherit, stderr = os.Inherit)
    val color = if result.exitCode == 0 then greenFg else redFg
    s"$color  $result $RESET"
  
  println(RESET)

  results.foreach: 
    case (cmd, Success(value))     => println(s"$cmd\n  $value")
    case (cmd, Failure(exception)) => 
      println(s"$cmd\n  $redFg $exception $RESET")
  
