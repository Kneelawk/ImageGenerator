package org.kneelawk.imagegenerator

class LinearColorInterpolation(start: Color, end: Color) {
  def apply(pos: Float): Color = {
    val r = pos * end.red + (1 - pos) * start.red
    val g = pos * end.green + (1 - pos) * start.green
    val b = pos * end.blue + (1 - pos) * start.blue

    new Color(r.toInt, g.toInt, b.toInt)
  }
}