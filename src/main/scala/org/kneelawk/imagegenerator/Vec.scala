package org.kneelawk.imagegenerator

import scala.reflect.ClassTag
import scala.collection.immutable.Vector

class Vec[+T](protected val data: Vector[T])(implicit val num: Numeric[T]) {
  def apply(index: Int) = data(index)
  
  def size = data.size

  def :*(multiplier: T): T = {
    data.collect({ case e => num.times(e, multiplier) }).foldLeft(num.zero)((a, b) => num.plus(a, b))
  }

  def *:(multiplicand: T): Vec[T] = {
    new Vec(data.collect({ case e => num.times(multiplicand, e) }))
  }

  def dot(m: Vec[T]):T = {
    if (m.size != data.size)
      throw new IllegalArgumentException("You cannot take the dot product of vectors of different sizes")
    
    val size = data.size
    var res = num.zero
    
    for (index <- 0 to size) {
      res = num.plus(res, num.times(data(index), m(index)))
    }
    
    res
  }
}

class Vec2[+T](x: T, y: T)(implicit val num: Numeric[T]) extends Vec[T](Vector(x, y))
