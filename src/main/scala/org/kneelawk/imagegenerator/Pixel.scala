package org.kneelawk.imagegenerator

case class Pixel(value: Int) {
  def red: Byte = ((value >> 0x18) & 0xFF).toByte
  def green: Byte = ((value >> 0x10) & 0xFF).toByte
  def blue: Byte = ((value >> 0x08) & 0xFF).toByte
  def alpha: Byte = ((value >> 0x00) & 0xFF).toByte
}

object Pixel {
  
}