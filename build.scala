//> using scala 3.3.4
//> using toolkit 0.6.0
/* 
  run with: 
    scala run . -M build
  or click on run above def build
*/ 
extension (s: String) def toProc = os.proc(s.split(" ").toSeq)

val buildFooter = "pandoc footer.md -o footer.html"
val buildIndex  = "pandoc -s --toc -c pandoc.css -A footer.html -B top.html -H header.html index.md -o index.html"

@main def build = // https://pandoc.org/demos.html
  println("Using https://pandoc.org to build with Scala toolkit os.proc")
  println(buildFooter)
  buildFooter.toProc.call()
  println(buildIndex)
  buildIndex.toProc.call()