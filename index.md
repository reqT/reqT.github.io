# reqT docs

* reqT is an open source requirements engineering tool for software developers.

* Download [latest stable desktop app](https://github.com/reqT/reqT/releases/latest).

## Getting Started

* Make sure you have [Java 21]() and [Scala 3]() installed for your system. 

* Download [desktop app](https://github.com/reqT/reqT/releases/latest/download/reqT.jar) and double-click or run in terminal using: 
  ```
  java -jar reqT.jar
  ```

* You can also use reqT as a library in Scala programs. Example in file [`hello-reqt.scala`](hello-reqt.scala)
  ```scala
  //> using scala 3.6.2
  //> using dep "reqt:reqt:4.0.0-RC2,url=https://github.com/reqT/reqT/releases/download/v4.0.0-RC2/reqT-4.0.0-RC2.jar"

  import reqt.*
  val m = Model(
    Feature("helloWorld") has Spec("print greeting")
  )

  @main def run = 
    println(m.toMarkdown)
  ```
  Replace versions with [lastest Scala release](https://www.scala-lang.org/download/all.html) and [latest reqT release](https://github.com/reqT/reqT/releases).