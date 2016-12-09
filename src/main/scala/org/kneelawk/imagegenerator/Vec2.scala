package org.kneelawk.imagegenerator

case class Vec2f(x: Float, y: Float) {
  val r: Float = Math.sqrt(x * x + y * y).toFloat
  
  /**
   * Theta will often be clockwise in images.
   */
  val theta: Float = Math.atan2(y, x).toFloat

  def dot(m: Float) = new Vec2f(x * m, y * m)

  def dot(v: Vec2f) = x * v.x + y * v.y

  def normalize = new Vec2f(x / r, y / r)
}