//> using scala 3.3.4
//> using toolkit 0.6.0

//  run with: scala run . -M build

val includeKey = "# INCLUDE "

val sourceDir = "src"

extension (s: String) 
  def toProc = os.proc(s.split(" ").toSeq)

  def insertIncludesTo(f: String): Unit = 
    println(s"\n    insertIncludesTo $includeKey... from $s to file $f")
    val lines = os.read(os.pwd / sourceDir / s).split("\n")
    val result = 
      lines.flatMap: line =>
        if line.startsWith(includeKey) then
          val fileToInclude = line.stripPrefix(includeKey) 
          os.read(os.pwd / sourceDir / fileToInclude).split("\n")
        else Array(line)
      .mkString("\n")

    os.write.over(target = os.pwd / sourceDir / f, data = result)

  end insertIncludesTo

val buildFooter = "pandoc src/footer.md -o footer.html"

val buildTop = "pandoc src/top.md -o top.html"

val buildIndex  = 
  "pandoc -s --toc -c pandoc.css -A footer.html -B top.html -H header.html src/index-GENERATED.md -o index.html"

val commands = Seq(buildTop, buildFooter, buildIndex)

@main def build = // https://pandoc.org/demos.html
  import Console.{RED as redFg, GREEN as greenFg, RED_B as redBg, RESET, BLACK as blackFg}

  println("\n--- BUILDING reqt.github.io using https://pandoc.org with Scala toolkit os.proc ---")
  "index.md".insertIncludesTo("index-GENERATED.md")

  print(redBg + blackFg) 

  import scala.util.{Try, Failure, Success}

  val results = for cmd <- commands yield cmd -> Try:
    val result = cmd.toProc.call()
    val color = if result.exitCode == 0 then greenFg else redFg
    s"$color  $result $RESET"
  
  println(RESET)

  results.foreach: 
    case (cmd, Success(value))     => println(s"$cmd\n  $value")
    case (cmd, Failure(exception)) => 
      println(s"$cmd\n  $redFg $exception $RESET")
  
