//> using scala 3.6.4
//> using dep "reqt:reqt:4.6.3,url=https://github.com/reqT/reqT/releases/download/v4.6.3/reqT-4.6.3.jar"

import reqt.*

val m = Model(
    Feature("helloWorld").has(
      Spec("Print a nice greeting."),
      Why("First step to get started."),
    )
  )

@main def hello = 
  println(m.toMarkdown)
