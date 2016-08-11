package org.radsaggi.oeuvre

/**
  * Created by abhishek on 8/3/16.
  */

trait Mutator { self =>

  val actions: IndexedSeq[Set[ActionUnit]]

  def ++(that: Mutator) = this.++(that, 0)

  def ++ (m: Mutator, delay: Int): Mutator = {
    val width = actions.map(_.size).max
    val arr = Array.fill(delay)(ActionUnit.empty)

    new Mutator {
      override val actions =
        if(width > delay) {
          self.actions ++ m.actions.map(arr ++ _)
        }
        else{
          self.actions ++ new Array[Array[ActionUnit]](delay - width) ++ m.actions
        }
    }
  }
}

object Mutator {
  def empty: Mutator = empty(0)

  def empty(duration: Int): Mutator = apply(Array.empty)

  def apply(a: Array[Array[ActionUnit]]) = new Mutator {
    override val actions = a
  }

  // TODO: Optimise this function
  def compose(m: Mutator*): Mutator = {
    m.foldLeft(Mutator.empty)(_ ++ _)
  }
}

trait ActionUnit {
  def apply(s: State): State

  def withDuration(from: Event = new TimeEvent(0), until: Event = new TimeEvent(1)): Mutator = {
    Mutator.empty
  }
}

object ActionUnit {
  def empty: ActionUnit = ActionUnit(identity)

  def apply(f: State => State) = new ActionUnit {
    override def apply(s: State) = f(s)
  }
}
