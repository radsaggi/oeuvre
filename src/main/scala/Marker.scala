package org.radsaggi.oeuvre

/**
  * Created by abhishek on 8/7/16.
  */

sealed trait AbstractMarker {
  def as[T <: Body](implicit constructor: BodyCreator[T]): T = constructor.create
}

case object AnonMarker extends AbstractMarker

final class Marker extends AbstractMarker {
  def translate(position: Vector3) = new ActionUnit {
    override def apply(s: State): State = {

    }
  }
}
