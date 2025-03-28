**reqT** is an open source requirements engineering tool for software developers based on **reqT-lang**, a flexible requirements modelling language with essential requirements engineering concepts, giving structure to natural language requirements, while enabling analysis, visualization and automation. 

The **reqT-lang syntax** is a subset of Markdown using bullet lists with indentation and special keywords to express textual requirements models by connecting *entities*, such as a <span class="EntType">Feature</span>, with *relations*, such as <span class="RelType">has</span>, to *attributes*, such as <span class="StrAttrType">Spec</span>, as in the example below:

<pre><code>* <span class="EntType">Feature</span>: helloWorld <span class="RelType">has</span> 
  * <span class="StrAttrType">Spec</span>: Print a nice greeting.
  * <span class="StrAttrType">Why</span>: First step to get started.
</code></pre>

See the <a href="https://github.com/reqT/reqT-lang/releases/latest/download/reqT-quickref-GENERATED.pdf">**Quickref**</a> to explore reqT keywords covering essential requirements engineering concepts.

Maintainer of reqT: [Prof. Björn Regnell](https://cs.lth.se/bjorn-regnell). 
Used at Lund University in [this course](https://cs.lth.se/krav). 


## Download

Latest version: <b>
%INCLUDE latest-version/index.html
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

%INCLUDE src/tiny-url-download.html


## Getting started
* Make sure you have [Java 21](https://adoptium.net/temurin/releases/?package=jdk&version=21) and [Scala 3](https://www.scala-lang.org/download/) installed for your system. Check this in terminal using: </br>`java -version`</br>`scala -version`

* Download the [reqT desktop app](https://github.com/reqT/reqT/releases/latest/download/reqT.jar) and run in terminal using: `java -jar reqT.jar` 

* Learn more about [using the reqT app](#using-the-reqt-app)

* Start reqT in the [Scala REPL](https://docs.scala-lang.org/scala3/book/taste-repl.html) using: `java -jar reqT.jar repl`

```
$ java -jar reqT.jar repl

Welcome to reqT 4.5.6 https://reqT.github.io
Type 'edit' to open a new reqT window.
Type ':quit' or press Ctrl+D to exit.
Re-run with -h for help on main program args

scala repl -S 3.6.4-RC1 --jar reqT.jar -- --repl-init-script "import reqt.*"
Welcome to Scala 3.6.4-RC1 (17.0.13, Java OpenJDK 64-Bit Server VM).
Type in expressions for evaluation. Or try :help.

scala> val m = "* Feature: helloWorld has Spec: print greeting".toModel
val m: reqt.Model = 
  Model(Rel(Ent(Feature,helloWorld),Has,
    Model(StrAttr(Spec,print greeting))))

scala> println(m.show)
Model(
  Feature("helloWorld") has Spec("print greeting"),
)

```
* You can use reqT as a library in Scala programs for specification analysis and automation. Download example below here: [`hello-reqt.scala`](https://github.com/reqT/reqT.github.io/blob/master/src/hello-reqt.scala) and run in terminal using: <br> `scala run hello-reqt.scala`  

```scala
%INCLUDE src/hello-reqt.scala
```

## Why reqT?

* TODO: add rationale for requirements as code from old site here: [reqt.org](https://reqt.org/index.html)

## Using the reqT App

* TODO: more screendumps and explanations

![reqT Main Window](img/screen1.png)

## Using reqT with Scala

* TODO: example usage of the [reqT-lang api](https://github.com/reqT/reqT-lang)

* TODO: example usage of the [reqT command-line args](https://github.com/reqT/reqT/blob/4.x/src/main/scala/Main.scala)

## Publications

* TODO: move papers from here: [reqt.org/documentation.html#pub](https://reqt.org/documentation.html#pub)