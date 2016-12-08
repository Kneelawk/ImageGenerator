package org.kneelawk.imagegenerator

import java.io.InputStream
import javax.imageio.ImageIO
import java.awt.image.BufferedImage

class ImageReader extends ImageSource {
  private var image: BufferedImage = null
  
  def load(stream: InputStream) {
    image = ImageIO.read(stream)
  }
  
  def apply(x: Int, y: Int) = new Pixel(image.getRGB(x, y))
}