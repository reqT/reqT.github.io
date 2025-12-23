## What is reqT?

**reqT** is a *flexible* and *scalable* open source **requirements engineering tool** for software developers and learners, available as a desktop application and a Scala library.  

With reqT you can specify requirements using a simple requirements modelling language called **reqT-lang** with essential requirements engineering concepts, giving structure to natural language requirements, while enabling analysis, visualization and automation. 

The reqT-lang syntax is a small subset of [Markdown](https://en.wikipedia.org/wiki/Markdown) using bullet lists with indentation and special keywords, to express textual requirements models by connecting <span class="EntType">*entities*</span> via <span class="RelType">*relations*</span> to <span class="StrAttrType">*attributes*</span>, as in this example:

<pre><code>* <span class="EntType">Feature</span>: helloWorld <span class="RelType">has</span> 
  * <span class="StrAttrType">Spec</span>: Print a nice greeting.
  * <span class="StrAttrType">Why</span>: First step to get started.
</code></pre>

Visit the <a href="https://github.com/reqT/reqT-lang/releases/latest/download/reqT-quickref-GENERATED.pdf">**Quickref**</a> to explore requirements engineering concepts in reqT-lang.

Maintainer of reqT: [Prof. Björn Regnell](https://cs.lth.se/bjorn-regnell). 
Used at Lund University in [this course](https://cs.lth.se/krav). 


## Download

Latest version: <b>
4.6.3
</b> &emsp; All versions: &nbsp; [reqT](https://github.com/reqT/reqT/releases) &nbsp; [reqT-lang](https://github.com/reqT/reqT-lang/releases)


```{=html}
<div id="downloadButtons">

<button type="button" class="button" onclick='window.location.href="https://github.com/reqT/reqT/releases/latest/download/reqT.jar"'>
  <a href="https://github.com/reqT/reqT/releases/latest/download/reqT.jar"> Desktop App </a>
</button>

<button type="button" class="button" onclick='window.location.href="https://github.com/reqT/reqT-lang/releases/latest/download/reqT-quickref-GENERATED.pdf"'>
  <a href="https://github.com/reqT/reqT-lang/releases/latest/download/reqT-quickref-GENERATED.pdf"> Quickref </a>
</button>

<button type="button" class="button" onclick='window.location.href="https://github.com/reqT"'>
  <a href="https://github.com/reqT"> Source Code </a>
</button>

<button type="button" class="button" onclick='window.location.href="https://github.com/reqT/reqT-lang/blob/main/docs/langSpec-GENERATED.md"'>
  <a href="https://github.com/reqT/reqT-lang/blob/main/docs/langSpec-GENERATED.md"> Language Spec </a>
</button>

</div>

```

<p>Latest <b>reqT.jar</b> from: <a href="https://tinyurl.com/yc4zsxy3"> tinyurl.com/get-reqT</a></p>
<pre>curl -L https://tinyurl.com/get-reqT -o reqT.jar</pre>


## Getting started
* Make sure you have [Java 21 - LTS](https://adoptium.net/temurin/releases/?package=jdk&version=21) and [Scala 3](https://www.scala-lang.org/download/) installed for your system. Check this in terminal using: </br>`java -version`</br>`scala -version`</br> (If you use later versions than Java 21 - LTS and Scala 3.6.4 you may get some warnings, but things should work fine anyway.)

* Download the [reqT desktop app](https://github.com/reqT/reqT/releases/latest/download/reqT.jar) and run in terminal using: `java -jar reqT.jar` 

* Visit the reqT [Quickref](https://github.com/reqT/reqT-lang/releases/latest/download/reqT-quickref-GENERATED.pdf) to learn about available concepts in reqT-lang.

* Learn more about [using the reqT app](#using-the-reqt-app)

* Do the reqT labs to learn about using reqT in Requirements Engineering:
  * [Lab 1: Context, Features and Priorities](https://github.com/reqT/reqT/blob/4.x/docs/lab1.md) 
  * [Lab 2: Quality Requirements and Release Planning](https://github.com/reqT/reqT/blob/4.x/docs/lab2.md)
  * Labs are part of this course at Lund University: [ETSN15 Requirements Eng.](https://lunduniversity.github.io/krav/) 

* Start reqT in the [Scala REPL](https://docs.scala-lang.org/scala3/book/taste-repl.html) using: `java -jar reqT.jar repl` </br> You can create a requirements Model in the scala repl like so:

```scala
scala> val m = "* Feature: helloWorld has Spec: print greeting".toModel
val m: reqt.Model = 
  Model(Rel(Ent(Feature,helloWorld),Has,
    Model(StrAttr(Spec,print greeting))))

scala> println(m.show)
Model(
  Feature("helloWorld") has Spec("print greeting"),
)

```
* You can use reqT in Scala programs for automated requirements analysis. 
  * Download example: [`hello-reqt.scala`](https://github.com/reqT/reqT.github.io/blob/master/src/hello-reqt.scala) and run in terminal using: <br> `scala run hello-reqt.scala`  

```scala
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
```

## Why reqT?

With reqT you can...

1. Model, analyse, visualize and prioritize requirements.
1. Combine natural language with formal structure.
1. Flexibly mix abstraction levels and modelling approaches.
1. Integrate requirements and test specification.
1. Export and import models via open formats.
1. Manipulate models with expressive, safe and convenient Scala programs.
1. Allocate requirements to releases with constraint solving.
1. Express prompts for spec-driven development with generative AI .

... using a simple markdown-based language in an open source tool and library.

## Using the reqT desktop app

Download [reqT.jar](https://github.com/reqT/reqT/releases/latest/download/reqT.jar) and start by double-click or open a terminal and navigate to the folder with the downloaded file and type: `java -jar reqT.jar`

![reqT Main Window](img/screen1.png)

## Using reqT with Scala

* TODO: example usage of the [reqT-lang api](https://github.com/reqT/reqT-lang)

* TODO: example usage of the [reqT command-line args](https://github.com/reqT/reqT/blob/4.x/src/main/scala/Main.scala)

## Publications

* TODO: move papers from here: [reqt.org/documentation.html#pub](https://reqt.org/documentation.html#pub)