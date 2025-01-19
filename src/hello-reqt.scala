//> using scala 3.6.2
//> using dep "reqt:reqt:4.4.0,url=https://github.com/reqT/reqT/releases/download/v4.4.0/reqT-4.4.0.jar"

import reqt.*
val m = Model(
    Feature("helloWorld").has(
      Spec("Print a nice greeting."),
      Why("First step to get started."),
    )
  )

@main def hello = 
  println(m.toMarkdown)
