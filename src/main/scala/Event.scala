package org.radsaggi.oeuvre

/**
  * Created by abhishek on 8/7/16.
  */

trait Event {

}

final case class TimeEvent(when: Int) extends Event
