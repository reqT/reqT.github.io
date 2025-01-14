//> using scala 3.3.4
//> using toolkit 0.6.0
// run with: scala run . -M build
@main def build = 
  // https://pandoc.org/demos.html
  println("TODO: use pandoc to build with os.proc")
  println("Meanwhile use these commands: ")
  println("pandoc footer.md -o footer.html")
  println("pandoc -s --toc -c pandoc.css -A footer.html index.md -o index.html")