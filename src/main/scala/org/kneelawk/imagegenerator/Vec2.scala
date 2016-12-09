package org.kneelawk.imagegenerator

case class Vec2f(x: Float, y: Float) {
  def dot(m: Float) = new Vec2f(x * m, y * m)
  
  def dot(v: Vec2f) = x * v.x + y * v.y
}