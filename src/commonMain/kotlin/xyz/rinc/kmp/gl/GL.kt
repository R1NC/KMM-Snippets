package xyz.rinc.kmp.gl

expect object GL() {
    fun createShader(type: Int): Int
    fun shaderSource(shader: Int, source: String)
    fun compileShader(shader: Int)
    fun getShaderiv(shader: Int): Boolean
    fun createProgram(): Int
    fun attachShader(program: Int, shader: Int)
    fun linkProgram(program: Int)
    fun getProgramiv(program: Int): Boolean
    fun deleteShader(shader: Int)
    fun useProgram(program: Int)
    fun deleteProgram(program: Int)
    fun getAttribLocation(program: Int, name: String): Int
    fun getUniformLocation(program: Int, name: String): Int
}
