package org.kneelawk.imagegenerator

trait ImageSource {
  def apply(x: Int, y: Int): Int
}