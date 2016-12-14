package org.kneelawk.imagegenerator

case class Color(value: Int) {
  def this(gray: Int, alpha: Int) = this(
    ((gray & 0xFF) << 0x18) |
      ((gray & 0xFF) << 0x10) |
      ((gray & 0xFF) << 0x08) |
      (alpha & 0xFF));
  
  def this(red: Int, green: Int, blue: Int) = this(
    ((red & 0xFF) << 0x18) |
      ((green & 0xFF) << 0x10) |
      ((blue & 0xFF) << 0x08) |
      0xFF);
  
  def this(red: Int, green: Int, blue: Int, alpha: Int) = this(
    ((red & 0xFF) << 0x18) |
      ((green & 0xFF) << 0x10) |
      ((blue & 0xFF) << 0x08) |
      (alpha & 0xFF));
  
  def red: Byte = ((value >> 0x18) & 0xFF).toByte
  def green: Byte = ((value >> 0x10) & 0xFF).toByte
  def blue: Byte = ((value >> 0x08) & 0xFF).toByte
  def alpha: Byte = ((value >> 0x00) & 0xFF).toByte
}