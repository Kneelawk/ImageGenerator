package org.kneelawk.imagegenerator

trait ImageSource {
  def apply(x: Float, y: Float): Color
}