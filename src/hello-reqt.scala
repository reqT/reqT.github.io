//> using scala 3.6.3
//> using dep "reqt:reqt:4.4.1,url=https://github.com/reqT/reqT/releases/download/v4.4.1/reqT-4.4.1.jar"

import reqt.*

val m = Model(
    Feature("helloWorld").has(
      Spec("Print a nice greeting."),
      Why("First step to get started."),
    )
  )

@main def hello = 
  println(m.toMarkdown)
