package org.radsaggi.oeuvre.test

/**
  * Created by abhishek on 8/7/16.
  */

import org.radsaggi.oeuvre._

class MainTest {

  class Cube extends Body

  implicit def CubeCreator = new BodyCreator[Cube] {
    def create = new Cube
  }

  def test1: Unit = {
    val obj = new Marker

    val initialState = State.create(
      AnonMarker.as[Cube],
      obj.as[Cube] -> (1, 1, 2)
    )

    val globalMutator = obj.moveTo(10, 1, 2).withDuration(until = 10.seconds)

    Engine.start(initialState, globalMutator)
  }

  def test2: Unit = {
    val obj = new Marker

    val initialState = State.create(
      obj.as[Cube] at (1, 1, 2) ofSize(1,2,3)
    )

    val globalMutator = Mutator.compose (
      obj.transformTo[Sphere] until 10.seconds from 2.seconds,
      obj.rotateTo(0, 0, Math.PI),
      obj.rotateBy(1, 1, 1) from 0.seconds
    )

    Engine.start(initialState, globalMutator)
  }

  class Mouse extends Body

  implicit def MouseCreator(implicit discCr: BodyCreator[Disc],
                       cylinderCr: BodyCreator[Cylinder]) = new BodyCreator[Mouse] {
    def create: Mouse = {

    }
  }
}
