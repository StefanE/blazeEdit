package dk.blazeEdit

import swing.Action._
import swing._
import swing.Swing._
import javax.swing.border.{LineBorder, Border}


class MainWindow extends MainFrame {

  title = "BlazeEdit"

  override def closeOperation() {
    dispose()
    System.gc()
    System.exit(0)
  }

  menuBar = new MenuBar {
    contents += new Menu("A Menu") {
      contents += new MenuItem("An item")
      contents += new MenuItem(Action("An action item") {
        println("Action '" + title + "' invoked")
      })
      contents += new Separator
      contents += new CheckMenuItem("Check me")
      contents += new CheckMenuItem("Me too!")
      contents += new Separator
      val a = new RadioMenuItem("a")
      val b = new RadioMenuItem("b")
      val c = new RadioMenuItem("c")
      val mutex = new ButtonGroup(a, b, c)
      contents ++= mutex.buttons
    }
    contents += new Menu("Empty Menu")
  }

  contents = new BorderPanel {
    import BorderPanel.Position._

    val text = new Label("Center")
    text.border = LineBorder.createBlackLineBorder()
    val text2 = new Label("West")
    val text3 = new Label("East")
    val text4 = new Label("North")
    val text5 = new Label("South")

    layout(text) = Center
    layout(text2) = West
    layout(text3) = East
    layout(text4) = North
    layout(text5) = South

    border = LineBorder.createBlackLineBorder()

  }

  size = new Dimension(500,500)
}