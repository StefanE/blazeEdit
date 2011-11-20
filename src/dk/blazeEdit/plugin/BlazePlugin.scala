package dk.blazeEdit.plugin

import akka.actor.Actor

trait BlazePlugin extends Actor {
  val name: String

  //Register plugin at central


}

class Test extends BlazePlugin {
  def receive = {
    case other => {

    }
  }
}
