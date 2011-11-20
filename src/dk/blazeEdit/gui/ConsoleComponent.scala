package dk.blazeEdit.gui

import java.awt.Dimension
import javax.swing.border.LineBorder
import swing.GridBagPanel.Fill
import swing._
import java.awt.event.{KeyEvent, KeyListener}

class ConsoleComponent extends BorderPanel {

  import BorderPanel.Position._

  val width = 600
  val height = 200

  private val dim = new Dimension(width, height)

  border = LineBorder.createBlackLineBorder()

  val outputArea = new OutputArea()
  val output = new ScrollPane(outputArea)
  val input = new InputArea()
  val buttons = new ConsoleButtons()

  layout(output) = Center
  layout(input) = South
  layout(buttons) = North

  preferredSize = dim

  class OutputArea extends TextArea {
    this.rows = 10
    this.editable = false
  }

  class InputArea extends TextField {
    val std = preferredSize
    //preferredSize = new Dimension(width, std.getHeight.toInt)
    this.peer.addKeyListener(new InputListener)
  }

  class InputListener() extends KeyListener {

    def keyTyped(e: KeyEvent) {}

    def keyPressed(e: KeyEvent) {}

    def keyReleased(e: KeyEvent) {
      if (KeyEvent.VK_ENTER == e.getExtendedKeyCode) {
        println("Enter")
        outputArea.append(input.text + "\n")
        input.text = ""
      }

    }
  }

}

class ConsoleButtons extends BoxPanel(Orientation.Horizontal) {

  val increase = new Button("+")
  val decrease = new Button("-")

  contents ++= Seq(increase,decrease)
}