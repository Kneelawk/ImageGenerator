package org.kneelawk.imagegenerator

trait ImageSink {
  def apply(x: Float, y: Float, pixel: Color)
}