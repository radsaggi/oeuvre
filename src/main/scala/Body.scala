package org.radsaggi.oeuvre

/**
  * Created by abhishek on 8/7/16.
  */

trait Body {
  def at (loc: Vector3): Body = ???
  def ofSize (size: Vector3): Body = ???
  def rotatedBy (rot: Vector3): Body = ???
}

trait BodyCreator[B <: Body] {
  def create: B
}
