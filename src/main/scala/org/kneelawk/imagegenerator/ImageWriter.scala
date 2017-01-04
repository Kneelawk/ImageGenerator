package org.kneelawk.imagegenerator

import java.io.OutputStream
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

class ImageWriter(width: Int, height: Int) extends ImageSink {
  private val image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)

  def apply(x: Float, y: Float, pixel: Color) = image.setRGB(x.floor.toInt, y.floor.toInt, pixel.value)

  def write(stream: OutputStream, format: String) = ImageIO.write(image, format, stream)
}