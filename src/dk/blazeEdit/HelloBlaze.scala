package dk.blazeEdit

import swing._
import GlobalActors._
import javax.swing.JFrame
import java.awt.Frame
import dk.blazeEdit.gui.MainWindow

object HelloBlaze extends SwingApplication {

  var started = false

  override def main(args: Array[String]) {
    val start = System.currentTimeMillis()
    if (!started) {
      println("Load first time")
      started = true
    }

    Swing.onEDTWait {
      startup(args)
    }

    val end = System.currentTimeMillis()
    println("Time:" + (end - start))
  }

  override def startup(args: Array[String]) {
    val t = top
    //if (t.size == new Dimension(0, 0)) t.pack()
    //t.peer.setExtendedState(top.peer.getExtendedState() | Frame.MAXIMIZED_BOTH)
    t.size = new Dimension(800,600)
    t.visible = true
    val x : Int = (t.location.getX+20).toInt
    val y : Int = (t.location.getY+60).toInt
    val notifyLocation = new Point(x,y)

    notification ! ("Test",notifyLocation)
    //t.closeOperation()
  }

  val top = new MainWindow
}