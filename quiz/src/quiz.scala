//> using scala 3.6.4
//> using platform scala-js
//> using packaging.output quiz/quiz.js
//> using dep org.scala-js::scalajs-dom::2.8.0

// when developing in vscode, open the quiz folder as project root
// command to package with force overwrite of quiz.js and watch: 
//    scala package quiz/src/quiz.scala -f -w

// see the result page by selecting index.html in parent folder in another vscode window and 
//   in vscode Shift+Ctrl+P "Live Server: Open with Live Server" and
//   in browser add /quiz after local url

import org.scalajs.dom
import org.scalajs.dom.document
import collection.immutable.ArraySeq

@main def quiz = 
  document.addEventListener(
    "DOMContentLoaded",
    (e: dom.Event) => setupUI()
  )

  println("hello quiz")

object Document:
  def appendButton(
      targetNode: dom.Node,
      text: String,
      disabled: Boolean = false
  )(
      action: => Unit
  ): dom.html.Button =
    val button = document.createElement("button").asInstanceOf[dom.html.Button]
    button.classList.add("button")
    button.appendChild(document.createTextNode(text))
    button.onclick = (e: dom.Event) => action
    button.disabled = disabled
    targetNode.appendChild(button)
    button

  def appendInput(
      targetNode: dom.Node,
      placeholder: String,
      id: String,
      disabled: Boolean = false
  )(
      onChange: => Unit
  ): dom.html.Input =
    val input = document.createElement("input").asInstanceOf[dom.html.Input]
    input.classList.add("input")
    input.id = id
    input.placeholder = placeholder
    input.oninput = (e: dom.Event) => if e == e then onChange
    input.onchange = (e: dom.Event) => input.blur()
    input.disabled = disabled
    targetNode.appendChild(input)
    input

  def appendText(
      targetNode: dom.Node,
      tagName: String,
      text: String
  ): dom.Element =
    val textElement = document.createElement(tagName)
    textElement.innerText = text
    targetNode.appendChild(textElement)
    textElement

  /** Deletes the element with the same id from the targetNode if it exists, and
    * then creates a new 'div' element and returns it.
    * 
    * @param id defaults to "container"
    * @param targetNode defaults to the document body
    */
  def appendDynamicContainer(
      id: String = "container",
      targetNode: dom.Node = document.body
  ): dom.Element =
    val oldContainerElement = document.getElementById(id)
    if (oldContainerElement != null) then
      targetNode.removeChild(oldContainerElement)

    val containerElement = document.createElement("div")
    containerElement.id = id
    targetNode.appendChild(containerElement)
    containerElement

  def appendTable(id: String, parent: dom.Node, headings: Seq[String], body: Seq[Seq[String]]): dom.Element =
    val tableElem = document.createElement("table")
    parent.appendChild(tableElem)
    val headRowElem = document.createElement("tr")
    tableElem.appendChild(headRowElem)
    for h <- headings do 
      val th = document.createElement("th")
      headRowElem.appendChild(th)
      th.innerHTML = h
    end for
    for (row, i) <- body.zipWithIndex do 
      val tr = document.createElement("tr")
      tableElem.appendChild(tr)
      for (elem, j) <- row.zipWithIndex do
        val td = document.createElement("td")
        tr.appendChild(td)
        td.innerHTML = elem
        td.id = s"$id-$i-$j"
        if j == 1 then td.setAttribute("style", "font-weight: bold;")
      end for
    end for
    tableElem



end Document

val initLetters = "<p>5 missing letters <b>abcde</b></p>"

def setupUI(): Unit = 

  def showPara = document.getElementById("result").asInstanceOf[dom.html.Paragraph]

  def answer: dom.html.Input = document.getElementById("answer").asInstanceOf[dom.html.Input]

  val quest = Document.appendDynamicContainer(id = "quest")

  val (firstQuestTable, firstCorrect) = quizMaker.generateQuestion()

  var correct = firstCorrect

  val table = Document.appendTable(id = "quest-table", quest, Seq("Entity", "?", "Definition") , firstQuestTable)

  val reply = Document.appendDynamicContainer(id = "reply")

  val inp = Document.appendInput(id = "answer", targetNode = reply, placeholder = "type abcde, but in right order"):
    println(s"inp changed to ${answer.value}")
    answer.value = answer.value.toLowerCase.filter(c => "abcde".contains(c)).distinct
    def lettersLeft: Int = 5 - answer.value.length
    def plural: String = if lettersLeft == 1 then "" else "s"
    showPara.innerHTML = "<p>" + lettersLeft.toString + s" missing letter$plural <b>" + ("abcde".diff(answer.value)) + "</b></p>"
    if lettersLeft == 0 then
      val nbrCorrect = quizMaker.countCorrect(answer.value, correct.mkString)
      showPara.innerHTML = s"<p>Correct: <b>$nbrCorrect</b> out of 5<p>"
    
  inp.`type` = "text"
  inp.size = 25

  val result = Document.appendDynamicContainer(id = "result")

  showPara.innerHTML = initLetters

  inp.focus()

  val but = Document.appendButton(document.body, "New quiz"):
    println("quiz button pressed again")
    answer.value = ""
    showPara.innerHTML = initLetters
    answer.focus()
    val (nextQuestTable, nextCorrect) = quizMaker.generateQuestion() 
    correct = nextCorrect
    for i <- 0 until firstQuestTable.length do
      for j <- 0 until firstQuestTable(i).length do 
        val e = document.getElementById(s"quest-table-$i-$j")
        e.innerHTML = nextQuestTable(i)(j)

end setupUI  

object quizMaker:
  def generateQuestion(nbrConcepts: Int = 5): (Seq[Seq[String]], Seq[Char]) = 
    val n = nbrConcepts
    
    val selected: Seq[((String, String), Int)]  = 
      util.Random.shuffle(entityConcepts).take(n).zipWithIndex.toVector

    val secondShuffle: Seq[(String, Int, String)] = 
      val xs = util.Random.shuffle: 
        selected.map((p, i) => p._1 -> i)
      (0 until xs.length).map(i => (xs(i)._1, xs(i)._2, selected(i)._1._2))

    extension (i: Int) def toChoice: Char = ('a' + i).toChar

    val correct = secondShuffle.map(_._2.toChoice)

    def doNotSpoil(s: String) = 
      val i = s.toLowerCase().indexOf("short for")
      if i > 0 then s.substring(0, i).trim else s

    val questMatrix = secondShuffle.zipWithIndex.map: 
      case ((concept, correctOrder, defInWrongPlace), i) =>
        Seq(concept,  s"${i.toChoice}", s"${doNotSpoil(defInWrongPlace).takeWhile(_ != '.')}.")

    (questMatrix, correct)
  end generateQuestion

  def countCorrect(answer: String, correct: Seq[Char]): Int =
    correct.zipWithIndex.map: (c, i) => 
      if Some(c) == answer.lift(i) then 1 else 0
    .sum

  enum EntGroup:
    case GeneralEnt, ContextEnt, DataEnt, FunctionalEnt, QualityEnt, DesignEnt, VariabilityEnt
  import EntGroup.* 

  lazy val entityConceptGroups: ArraySeq[((EntGroup,String),String)] = ArraySeq(
    ContextEnt -> "Actor" -> "A role played by a user or external system that interacts with the system (product, app, or service) under development.",
    ContextEnt -> "App" -> "A computer program, or group of programs designed for end users, normally with a graphical user interface. Short for application.",
    ContextEnt -> "Domain" -> "The application area of a product with its surrounding entities, e.g. users or other systems.",
    ContextEnt -> "Product" -> "An artifact offered to users or customers, e.g. an app, service or  embedded system.",
    ContextEnt -> "Release" -> "A specific version of a product offered to end users at a specific time.",
    ContextEnt -> "Resource" -> "A capability of, or support for product development, e.g. a development team or some testing equipment.",
    ContextEnt -> "Risk" -> "Something negative that may happen.",
    ContextEnt -> "Scenario" -> "A narrative of foreseeable interactions of user roles (actors) and the system (product, app, or service) under development..",
    ContextEnt -> "Service" -> "System use that provides value to stakeholders. System actions that stakeholders are willing to pay for.",
    ContextEnt -> "Stakeholder" -> "A role, person or legal entity with a stake in the development or operation of a product.",
    ContextEnt -> "System" -> "A set of software or hardware components interacting with users or systems.",
    ContextEnt -> "User" -> "A human interacting with a system.",

    GeneralEnt -> "Epic" -> "A coherent collection of features, stories, use cases or issues. A large part of a release.",
    GeneralEnt -> "Feature" -> "A releasable characteristic of a product. A high-level, coherent bundle of requirements.",
    GeneralEnt -> "Goal" -> "An intention of a stakeholder or desired system property.",
    GeneralEnt -> "Idea" -> "A concept or thought, potentially interesting.",
    GeneralEnt -> "Image" -> "A visual representation, picture or diagram.",
    GeneralEnt -> "Interface" -> "A way to interact with a system.",
    GeneralEnt -> "Issue" -> "Something to be fixed or work to do.",
    GeneralEnt -> "Item" -> "An article in a collection, enumeration, or series.",
    GeneralEnt -> "Label" -> "A descriptive tag used to classify something.",
    GeneralEnt -> "Req" -> "Something needed or wanted. An abstract term denoting any type of information relevant to the (specification of) intentions behind system development. Short for requirement.",
    GeneralEnt -> "Section" -> "A part of a requirements document.",
    GeneralEnt -> "Term" -> "A word or group of words having a particular meaning in a particular domain.",
    GeneralEnt -> "Test" -> "A procedure to check if requirements are met.", 
    GeneralEnt -> "WorkPackage" -> "A coherent collection of (development) activities.", 

    DataEnt -> "Data" -> "A data entity, type, class, or record stored or processed by a system.",
    DataEnt -> "Class" -> "An extensible template for creating objects. A set of objects with certain attributes in common. A category.",
    DataEnt -> "Field" -> "A data attribute that is part of another entity, such as a class.",
    DataEnt -> "Member" -> "A data entity that is part of another entity. More specific alternatives: field, function.",
    DataEnt -> "Relationship" -> "A specific way that data types are connected.",

    DesignEnt -> "Component" -> "A composable part of a system architecture. A reusable, interchangeable system unit or functionality.",
    DesignEnt -> "Design" -> "A specific realization. A description of an implementation.",
    DesignEnt -> "Module" -> "A collection of coherent functions and interfaces.",
    DesignEnt -> "Prototype" -> "A mockup or system with limited functionality to demonstrate a design idea.",
    DesignEnt -> "Screen" -> "A design of (a part of) a user interface.",

    FunctionalEnt -> "Event" -> "Something that can happen in the domain or in the system.",
    FunctionalEnt -> "Function" -> "A description of how input is mapped to output. A capability of a system to do something specific.",
    FunctionalEnt -> "State" -> "A mode or condition of something in the domain or in the system. A configuration of data.",
    FunctionalEnt -> "Task" -> "A piece of work by users, potentially supported by a system. Short for user task",
    FunctionalEnt -> "UseCase" -> "A goal-fulfilling interaction between users and a product in a specific usage context.",
    FunctionalEnt -> "Story" -> "A description of what a user wants in order to achieve a goal. Short for user story.",

    QualityEnt -> "Barrier" -> "Something that makes it difficult to achieve a goal or a higher quality level.",
    QualityEnt -> "Breakpoint" -> "A point of change, representing an important shift in the relation between quality and benefit.",
    QualityEnt -> "Quality" -> "An aspect of system quality, distinguishing characteristic or degree of goodness.",
    QualityEnt -> "Target" -> "A desired quality level or quality goal.",

    VariabilityEnt -> "Configuration" -> "A specific combination of variants.",
    VariabilityEnt -> "Variant" -> "An object or system property that can be chosen from a set of options.",
    VariabilityEnt -> "VariationPoint" -> "An opportunity of choice among variants.",
  )

  lazy val entityConcepts: ArraySeq[(String,String)] = entityConceptGroups.map((gn, d) => gn._2 -> d).sorted
