package dk.blazeEdit

import akka.actor.Actor


object GlobalActors {

  val notification =  Actor.actorOf[NotificationActor].start()

}