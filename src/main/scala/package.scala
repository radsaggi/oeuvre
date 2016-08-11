package org.radsaggi

/**
  * Created by abhishek on 8/7/16.
  */

package object oeuvre extends Api with Implicits

package oeuvre {

  trait Api

  trait Implicits {
    import scala.language.implicitConversions

    implicit def intToIntTime(value: Int): IntTime = new IntTime(value)
  }
}