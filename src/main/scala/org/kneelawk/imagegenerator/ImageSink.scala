package org.kneelawk.imagegenerator

trait ImageSink {
  def apply(x: Int, y: Int, pixel: Pixel)
}