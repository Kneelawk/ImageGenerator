package org.kneelawk.imagegenerator

import java.io.InputStream
import javax.imageio.ImageIO
import java.awt.image.BufferedImage

class ImageReader extends ImageSource {
  private var image: BufferedImage = null
  
  def load(stream: InputStream) {
    image = ImageIO.read(stream)
  }
  
  def apply(x: Float, y: Float) = new Color(image.getRGB(x.floor.toInt, y.floor.toInt))
}