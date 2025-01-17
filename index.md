## reqT Resources

* [Download app](https://github.com/reqT/reqT/releases/latest/download/reqT.jar) 
* [Quickref](https://github.com/reqT/reqT-lang/releases/latest/download/reqT-quickref-GENERATED.pdf) 
* [Language specification](https://github.com/reqT/reqT-lang/blob/main/docs/langSpec-GENERATED.md) 
* [Source code](https://github.com/reqT)

## Getting Started with reqT

* Make sure you have [Java 21](https://adoptium.net/temurin/releases/?package=jdk&version=21) and [Scala 3](https://www.scala-lang.org/download/) installed for your system. 

* Download the [reqT desktop app](https://github.com/reqT/reqT/releases/latest/download/reqT.jar) and *double-click* or run in terminal using: `java -jar reqT.jar` 

* Learn more about [using the reqT app](#using-the-reqt-app)

* Start reqT in Scala repl using: `java -jar reqT.jar repl`

```
$ java -jar reqT.jar repl
Welcome to reqT v4.0.0.
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
* You can use reqT as a library in Scala programs. Download example below here: [`hello-reqt.scala`](https://github.com/reqT/reqT/blob/4.x/hello-reqt.scala) and run in terminal using: `scala run hello-reqt.scala`  

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

## Why reqT?

TODO rationale for requirements as code

## Using the reqT App

TODO screendumps etc

## Using reqT with Scala

TODO example usages of the reqT-lang api