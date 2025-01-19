## reqT Resources

* [Download app](https://github.com/reqT/reqT/releases/latest/download/reqT.jar) 
* [Quickref](https://github.com/reqT/reqT-lang/releases/latest/download/reqT-quickref-GENERATED.pdf) 
* [Language specification](https://github.com/reqT/reqT-lang/blob/main/docs/langSpec-GENERATED.md) 
* [Source code](https://github.com/reqT)
* [reqT Tutorial Labs](https://cs.lth.se/krav/labs/)

## Getting Started with reqT

* Make sure you have [Java 21](https://adoptium.net/temurin/releases/?package=jdk&version=21) and [Scala 3](https://www.scala-lang.org/download/) installed for your system. Check this in terminal using: </br>`java -version`</br>`scala -version`

* Download the [reqT desktop app](https://github.com/reqT/reqT/releases/latest/download/reqT.jar) and run in terminal using: `java -jar reqT.jar` 

* Learn more about [using the reqT app](#using-the-reqt-app)

* Start reqT in the [Scala REPL](https://docs.scala-lang.org/scala3/book/taste-repl.html) using: `java -jar reqT.jar repl`

```bash
$ java -jar reqT.jar repl
Welcome to reqT v4.0.0
Type 'import reqt.*' for direct access to full api.
Type 'edit' to open an editor window.
Type 'help' for more information on how to use reqT.

Welcome to Scala 3.6.3 (17.0.13, Java OpenJDK 64-Bit Server VM).
Type in expressions for evaluation. Or try :help.

scala> import reqt.*

scala> m"* Feature: helloWorld has Spec: print greeting"
val res0: reqt.Model = 
  Model(Rel(Ent(Feature,helloWorld),Has,
    Model(StrAttr(Spec,print greeting))))

scala> 
```
* You can use reqT as a library in Scala programs for specification analysis and automation. Download example below here: [`hello-reqt.scala`](https://github.com/reqT/reqT.github.io/blob/master/src/hello-reqt.scala) and run in terminal using: `scala run hello-reqt.scala`  

```scala
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
```

## Why reqT?

* TODO: add rationale for requirements as code from old site here: [reqt.org](https://reqt.org/index.html)

## Using the reqT App

* TODO: screendumps etc

## Using reqT with Scala

* TODO: example usage of the [reqT-lang api](https://github.com/reqT/reqT-lang)

* TODO: example usage of the [reqT command-line args](https://github.com/reqT/reqT/blob/4.x/src/main/scala/Main.scala)

## Publications

* TODO: move papers from here: [reqt.org/documentation.html#pub](https://reqt.org/documentation.html#pub)