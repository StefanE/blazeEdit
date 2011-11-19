package dk.blazeEdit

import akka.actor.Actor
import com.sun.awt.AWTUtilities
import java.awt.Color
import java.awt.event._
import javax.swing.Timer
import scala.swing._

class NotificationActor extends MouseAdapter with ActionListener with Actor {

  override def receive() = {
    case (msg: String, pos: Point) => createNotification(msg, pos)
    case other => println("Ignored:" + other)
  }

  override def mouseClicked(e: MouseEvent) {
    NotificationRemover()
  }

  override def actionPerformed(e: ActionEvent) {
    NotificationRemover()
  }

  private def NotificationRemover() {
    notification.dispose()
  }

  private def createNotification(msg: String, pos: Point) {
    notification.peer.addMouseListener(this)
    notification.peer.setUndecorated(true)
    AWTUtilities.setWindowOpacity(notification.peer, 0.90f)
    notification.contents = text
    notification.background = backgroundColor
    notification.location = pos
    text.text = String.format("<html><body><font size='20'>%s</font></body></html>", msg)
    notification.pack()
    notification.visible = true
    timer.start()
    timer.setRepeats(false)
  }

  private val notification = new Frame
  private val text = new Label()
  private val backgroundColor = new Color(25, 25, 25)
  val timer = new Timer(4000, this)
}