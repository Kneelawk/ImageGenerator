package org.kneelawk.imagegenerator

case class Rect(x: Float, y: Float, width: Float, height: Float) extends Area {
  val pixelX = x.floor.toInt
  val pixelY = y.floor.toInt
  val pixelWidth = (Math.ceil(x + width) - Math.floor(x)).toInt
  val pixelHeight = (Math.ceil(y + height) - Math.floor(y)).toInt

  class RectIterator extends Iterator[PixelLoc] {
    var ix = pixelX
    var iy = pixelY

    def hasNext = (iy - pixelY) * pixelWidth + (ix - pixelX) < pixelWidth * pixelHeight

    def next = {
      val vec = new PixelLoc(ix, iy,
        if (ix > pixelX && ix < pixelX + pixelWidth && iy > pixelY && iy < pixelY + pixelHeight) 1
        else (
          if (ix == pixelX && ix == (x + width).floor.toInt) width
          else if (ix == pixelX) pixelX + 1 - x
          else x + width - pixelX))
      ix += 1
      if (ix >= pixelX + pixelWidth) {
        ix = pixelX
        iy += 1
      }
      if (iy >= pixelY + pixelHeight) {
        iy = pixelY
      }
      vec
    }
  }

  def iterator = new RectIterator
}