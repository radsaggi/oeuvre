package org.radsaggi.oeuvre

/**
  * Created by abhishek on 8/1/16.
  */

case class Vector2(x: Float, y: Float) {

  def + (v: Vector2): Vector2 = Vector2(x + v.x, y + v.y)
  def - (v: Vector2): Vector2 = Vector2(x - v.x, y - v.y)
  def * (d: Float): Vector2 = Vector2(x * d, y * d)
}

case class Vector3 (x: Float, y: Float, z: Float) {

  def + (v: Vector3): Vector3 = Vector3(x + v.x, y + v.y, z + v.z)
  def - (v: Vector3): Vector3 = Vector3(x - v.x, y - v.y, z - v.z)
  def * (d: Float): Vector3 = Vector3(x * d, y * d, z * d)

  def dot(v: Vector3): Float = (x * v.x) + (y * v.y) + (z * v.z)
  def cross(v: Vector3): Vector3 = Vector3 (y * v.z - v.y * z, x * v.z - z * v.x, x * v.y - y * v.x)
  def mod: Float = Math.sqrt(x * x + y * y + z * z).asInstanceOf[Float]
  def normalize: Vector3 = Vector3(x / mod, y / mod, z / mod)

  def rotateAbout(r: Vector3, angle: Float): Vector3 = {
    val s = r.normalize
    val cos = Math.cos(angle).asInstanceOf[Float]
    val sin = Math.sin(angle).asInstanceOf[Float]
    s * this.dot(s) * (1 - cos) + (this * cos) + (s cross this) * sin
  }
}

case class Vector4 (r: Float, g: Float, b: Float, a: Float) {

  def + (v: Vector4): Vector4 = Vector4(r + v.r, g + v.g, b + v.b, a + v.a)
  def - (v: Vector4): Vector4 = Vector4(r - v.r, g - v.g, b - v.b, a - v.a)
  def * (d: Float): Vector4 = Vector4(r * d, g * d, b * d, a * d)

  def clamp(x: Float, y: Float)(newX: Float, newY: Float): Vector4 = {
    Vector4(0,0,0,0)
  }
}
