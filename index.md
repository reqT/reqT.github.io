<img src="https://github.com/reqT/reqT/blob/4.x/logo/reqT.jpg?raw=true" width="100"> 

# reqT - requirements tool

**reqT** is an **open source requirements engineering tool** for **software developers** based on **reqT-lang** using **common requirements engineering concepts**

## Resources

* [Download app](https://github.com/reqT/reqT/releases/latest/download/reqT.jar) 
* [Quickref](https://github.com/reqT/reqT-lang/releases/latest/download/reqT-quickref-GENERATED.pdf) 
* [Language specification](https://github.com/reqT/reqT-lang/blob/main/docs/langSpec-GENERATED.md) 
* [Source code](https://github.com/reqT)

## Getting Started

* Make sure you have [Java 21]() and [Scala 3]() installed for your system. 
* Download [desktop app](https://github.com/reqT/reqT/releases/latest/download/reqT.jar) and double-click or run in terminal using: 
  ```
  java -jar reqT.jar
  ```
* You can also use reqT as a library in Scala programs. Example: [`hello-reqt.scala`](https://github.com/reqT/reqT/blob/4.x/hello-reqt.scala)

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