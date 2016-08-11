package org.radsaggi.oeuvre

/**
  * Created by abhishek on 8/1/16.
  */


trait State {


//  def apply(): State = new State()
}

object State {
  def create(objs: (Body, Vector3)*): State = {
    State.empty
  }

  def empty = new State {
  }
}