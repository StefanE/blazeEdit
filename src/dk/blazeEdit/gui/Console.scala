package dk.blazeEdit.gui

import javax.swing.border.LineBorder
import swing._
import GridBagPanel._
import java.awt.event.{KeyEvent, KeyListener}
import java.awt.{GridBagConstraints, Dimension}

//class Console extends BoxPanel(Orientation.Vertical) {

class Console extends GridBagPanel {

  val width = 600
  val height = 200

  private val dim = new Dimension(width, height)

  border = LineBorder.createBlackLineBorder()

  val outputArea = new OutputArea()
  val output = new ScrollPane(outputArea)
  val input = new InputArea()

  val c = new Constraints
  c.fill = Fill.Both
  c.gridx = 0
  c.gridy = 0
  c.weightx = 0.00
  c.gridwidth = 1
  layout(new Button("Up")) = c

  c.gridx = 1
  c.gridy = 0
  c.weightx = 0.00
  c.gridwidth = 1
  layout(new Button("Down")) = c


  c.gridx = 0
  c.weightx = 0.5
  c.gridy = 1
  c.gridwidth = 3
  layout(output) = c

  c.gridx = 0
  c.gridy = 2
  c.weightx = 0.5
  c.gridwidth = 1
  layout(input) = c



  preferredSize = dim

  /*
  border = LineBorder.createBlackLineBorder()

  val outputArea = new OutputArea()
  val output = new ScrollPane(outputArea)

  output.border = LineBorder.createBlackLineBorder()
  //output.preferredSize = new Dimension(width, height - 30)
  output

  val input = new InputArea()

  //input.preferredSize = new Dimension(width,50)

  contents += output
  contents += input


  preferredSize = dim

  */
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


