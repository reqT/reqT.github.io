## Download

Latest version: <b>
4.6.3
</b> &emsp; All versions: &nbsp; [reqT](https://github.com/reqT/reqT/releases) &nbsp; [reqT-lang](https://github.com/reqT/reqT-lang/releases)


```{=html}
<div id="downloadButtons">

<button type="button" class="button" onclick='window.location.href="https://github.com/reqT/reqT/releases/latest/download/reqT.jar"'>
  <a href="https://github.com/reqT/reqT/releases/latest/download/reqT.jar"> Desktop App </a>
</button>

<button type="button" class="buttMaintainer of reqT: Prof. Björn Regnell. Used at Lund University in this course.on" onclick='window.location.href="https://github.com/reqT/reqT-lang/releases/latest/download/reqT-quickref-GENERATED.pdf"'>
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


## What is reqT?

**reqT** is a *flexible* and *scalable* open source **requirements engineering tool** for software developers and learners, available as a desktop application and a Scala library.  

With reqT you can specify requirements using a simple requirements modelling language called **reqT-lang** with essential requirements engineering concepts, giving structure to natural language requirements, while enabling analysis, visualization and automation. 

Visit the <a href="https://github.com/reqT/reqT-lang/releases/latest/download/reqT-quickref-GENERATED.pdf">**Quickref**</a> to explore requirements engineering concepts in reqT-lang.

The reqT-lang syntax is a small subset of [Markdown](https://en.wikipedia.org/wiki/Markdown) using bullet lists with indentation and special keywords, to express textual requirements models by connecting <span class="EntType">*entities*</span> via <span class="RelType">*relations*</span> to <span class="StrAttrType">*attributes*</span>, as in this example:

<pre><code>* <span class="EntType">Feature</span>: helloWorld <span class="RelType">has</span> 
  * <span class="StrAttrType">Spec</span>: Print a nice greeting.
  * <span class="StrAttrType">Why</span>: First step to get started.
</code></pre>

*Maintainer of reqT:* [Prof. Björn Regnell](https://cs.lth.se/bjorn-regnell). 
reqT is used at Lund University in [this course](https://lunduniversity.github.io/krav/). 

## Why reqT?

With reqT you can...

1. Model, analyse, visualize and prioritize requirements.
1. Manage requirements in issues and git using simple markdown syntax.
1. Combine natural language with formal structure.
1. Flexibly mix abstraction levels and modelling approaches.
1. Integrate requirements and test specification.
1. Export, import and visualize requirements via open formats.
1. Manipulate models with expressive, safe and convenient Scala programs.
1. Allocate requirements to releases with constraint solving.
1. Express prompts for spec-driven development with generative AI .

... using a simple markdown-based language in an open source tool and library.



## Getting started
* Make sure you have [Java 21 - LTS](https://adoptium.net/temurin/releases/?package=jdk&version=21) and [Scala 3](https://www.scala-lang.org/download/) installed for your specific system. Check this in terminal using: </br>`java -version`</br>`scala -version`</br> (If you use other versions you may get warnings, but things could work anyway.)

* Download [**reqT.jar**](https://github.com/reqT/reqT/releases/latest/download/reqT.jar) and double-click the downloaded file or run in terminal using: `java -jar reqT.jar` 

* Learn more about [using the reqT desktop app](#using-the-reqt-desktop-app) and [using reqT with Scala](#using-reqt-with-scala).

* Visit the reqT [**Quickref**](https://github.com/reqT/reqT-lang/releases/latest/download/reqT-quickref-GENERATED.pdf) to learn about the concepts in reqT-lang.

* Do the [**reqT Quiz**](quiz) to check your knowledge of requirements modelling concepts. 

* Do the **reqT labs** to learn about using reqT in Requirements Engineering:
  * [**Lab 1**: Context, Features and Priorities](https://github.com/reqT/reqT/blob/4.x/docs/lab1.md) 
  * [**Lab 2**: Quality Requirements and Release Planning](https://github.com/reqT/reqT/blob/4.x/docs/lab2.md)
  * These labs are part of the [*ETSN15 Requirements Eng.*](https://lunduniversity.github.io/krav/) course at Lund Univ.  


## Using the reqT desktop app

* Download [reqT.jar](https://github.com/reqT/reqT/releases/latest/download/reqT.jar) and start by double-click or open a terminal and navigate to the folder with the downloaded file and type: `java -jar reqT.jar`

* The main window of the reqT desktop app has menus and three panes as shown in the image below: 
<img src="img/screen1.png" alt="reqT Main Window" width="100%"/>
  
  1. The left pane is called the **Tree** where your reqT model is shown as a hierarchy of (un)foldable and selectable nodes. The model is updated by the *Tree* menu. If you want to edit a selected Tree node then select *Tree -> Edit Selected Node in Editor (Ctrl+E)*. The Tree is not updated until you explicitly issue an update, for example using *Tree -> Replace Selected Node from Editor (Ctrl+R)*.
  
  2. The middle pane is a text **Editor** with reqT-lang syntax highlighting and completion using *Ctrl+Space*. It can be manipulated using the *Editor* menu. Editing of model fragments is *independent* of the Tree pane. You can copy your edits into the Tree *explicitly* by using the *Tree* menu or the shortcuts shown in that menu.   
  
  3. The right pane contains the **Log** where help messages are printed. You can use the *Log* menu to change line wrapping, increase/decrease font size, and clear the log. 

* You can use the *View* menu to toggle pane orientation, fullscreen, window title, and increase/decrease the menu and tree font size.

* You can use the *Tools* menu to apply different pre-defined tools to your model. 

* You can use the *Export* menu to save your model in different formats, such as html and LaTex. If you have [GraphViz](https://graphviz.org/) installed on your path, you can visualize your model as a nested or flat graph. 

* You can use the *Template* menu to enter example models into the editor. 
  
* You can use the *Help* menu to print help messages in the Log and see the current version of reqT using the *About* menu item.


## Using reqT with Scala

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

* Visit the [**reqT-lang api**](https://fileadmin.cs.lth.se/reqt-lang/api) and [**source code**](https://github.com/reqT/reqT-lang/)

* Visit the [**reqT app api**](https://fileadmin.cs.lth.se/reqt/api) and [**source code**](https://github.com/reqT/reqT/)

## reqT command line arguments

* See the command line arguments available using the `help` argument:

```
$ java -jar reqT.jar help

Welcome to reqT 4.6.3 https://reqT.github.io

  Main program args:

    <none>       open a reqT window with empty model
    edit f1 f2   for each file open a window with model from file
    repl         start the scala repl and do 'import reqt.*'
    quiz         start a quiz game in terminal
    version      print version, also -v --version 
    help         print this message, also -h, --help

```

* Visit the reqT main program code: [Main.scala](https://github.com/reqT/reqT/blob/4.x/src/main/scala/Main.scala)

## Publications

* **What is essential? – a pilot survey on views about the requirements metamodel of reqT**, *Björn Regnell*, [download pdf](pub/what-is-essential-REFSQ2016.pdf) published at [REFSQ2016](http://refsq.org/2016).

* **Towards a Semi-Formal, Open and Scalable Requirements Modeling Tool**, *Björn Regnell*, [download pdf](pub/reqT-REFSQ2013.pdf) published at [REFSQ2013](http://refsq.org/2013).

* **A Scala Embedded DSL for Combinatorial Optimization in Software Requirements Engineering**, *Björn Regnell and Krzysztof Kuchcinski*, [download pdf](pub/reqT-COSpeL2013.pdf) published at  First Workshop on Domain Specific Languages in Combinatorial Optimization (COSpeL'2013).

* **A Scala DSL for Constraint-based Requirement Engineering using JaCoP**, *Björn Regnell*, [download pdf](pub/reqT-sweconsnet2013.pdf) presented at [SweConsNet Workshop 2013](https://www.lth.se/index.php?id=70383).