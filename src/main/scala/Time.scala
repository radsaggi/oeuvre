package org.radsaggi.oeuvre

/**
  * Created by abhishek on 8/7/16.
  */

class IntTime(val value: Int) extends AnyVal {
  def seconds = TimeEvent(value)
}