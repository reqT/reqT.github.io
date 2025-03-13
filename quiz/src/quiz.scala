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

  def pageNotFound(): Unit =
    val containerElement = appendDynamicContainer()
    appendText(containerElement, "h1", "Oops! Page not found.")


def setupUI(): Unit = 

  val but = Document.appendButton(document.body, "New quiz"):
    println("quiz button pressed again")
    answer.value = ""
    showPara.innerText = "5 letters left abcde"
    answer.focus()

  val quest = Document.appendDynamicContainer(id = "quest")

  val info = Document.appendText(quest, "p", "Press abcde in right order")
  info.id = "quest"

  val reply = Document.appendDynamicContainer(id = "reply")

  val inp = Document.appendInput(id = "answer", targetNode = reply, placeholder = "type abcde in right order"):
    println(s"inp changed to ${answer.value}")
    answer.value = answer.value.toLowerCase.filter(c => "abcde".contains(c)).distinct
    def lettersLeft: Int = 5 - answer.value.length
    showPara.innerText = lettersLeft.toString + " letters left " + ("abcde".diff(answer.value))
    if lettersLeft == 0 then
      showPara.innerText = "Correct answer: ?"
    

  val result = Document.appendDynamicContainer(id = "result")

  showPara.innerText = "5 letters left abcde"

  inp.focus()

end setupUI  

def showPara = document.getElementById("result").asInstanceOf[dom.html.Paragraph]

def answer: dom.html.Input = document.getElementById("answer").asInstanceOf[dom.html.Input]

@main def quiz = 
  document.addEventListener(
    "DOMContentLoaded",
    (e: dom.Event) => setupUI()
  )

  println("hello quiz")
