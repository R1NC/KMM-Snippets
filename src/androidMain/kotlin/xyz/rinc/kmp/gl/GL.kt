package xyz.rinc.kmp.gl

import android.opengl.GLES20
import android.util.Log

actual object GL {
    actual fun createShader(type: Int): Int {
        return GLES20.glCreateShader(type)
    }

    actual fun shaderSource(shader: Int, source: String) {
        GLES20.glShaderSource(shader, source)
    }

    actual fun compileShader(shader: Int) {
        GLES20.glCompileShader(shader)
    }

    actual fun getShaderiv(shader: Int): Boolean {
        var compiled: IntArray = intArrayOf(0)
        GLES20.glGetShaderiv(shader, GLES20.GL_COMPILE_STATUS, compiled, 0)
        if (compiled[0] == 0) {
            Log.d("PGLES", "Compile shader failed")
            return false
        }
        return true
    }

    actual fun createProgram(): Int {
        return GLES20.glCreateProgram()
    }

    actual fun attachShader(program: Int, shader: Int) {
        GLES20.glAttachShader(program, shader)
    }

    actual fun linkProgram(program: Int) {
        GLES20.glLinkProgram(program)
    }

    actual fun getProgramiv(program: Int): Boolean {
        var linked: IntArray = intArrayOf(0)
        GLES20.glGetProgramiv(program, GLES20.GL_LINK_STATUS, linked, 0)
        if (linked[0] == 0) {
            Log.d("PGLES", "Link program failed")
            return false
        }
        return true
    }

    actual fun deleteShader(shader: Int) {
        GLES20.glDeleteShader(shader)
    }

    actual fun useProgram(program: Int) {
        GLES20.glUseProgram(program)
    }

    actual fun deleteProgram(program: Int) {
        GLES20.glDeleteProgram(program)
    }

    actual fun getAttribLocation(program: Int, name: String): Int {
        return GLES20.glGetAttribLocation(program, name)
    }

    actual fun getUniformLocation(program: Int, name: String): Int {
        return GLES20.glGetUniformLocation(program, name)
    }
}
