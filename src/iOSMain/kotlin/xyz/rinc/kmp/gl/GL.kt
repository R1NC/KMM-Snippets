package xyz.rinc.kmp.gl

import kotlinx.cinterop.*
import platform.Foundation.NSLog
import platform.gles2.*
import platform.glescommon.GLenum
import platform.glescommon.GLuint

actual object GL {
    actual fun createShader(type: Int): Int {
        return glCreateShader(type as GLenum) as Int
    }

    actual fun shaderSource(shader: Int, source: String) {
        memScoped {
            glShaderSource(shader as GLuint, 1, cValuesOf(source.cstr.getPointer(this)), cValuesOf(source.length))
        }
    }

    actual fun compileShader(shader: Int) {
        glCompileShader(shader as GLuint)
    }

    actual fun getShaderiv(shader: Int): Boolean {
        var compiledP: CArrayPointer<IntVar> = nativeHeap.allocArray(1)
        glGetShaderiv(shader as GLuint, GL_COMPILE_STATUS, compiledP)
        var compilesB = true
        if (compiledP[0] == 0) {
            NSLog("PGLES", "Compile shader failed")
            compilesB = false
        }
        nativeHeap.free(compiledP)
        return compilesB
    }

    actual fun createProgram(): Int {
        return glCreateProgram() as Int
    }

    actual fun attachShader(program: Int, shader: Int) {
        glAttachShader(program as GLuint, shader as GLuint)
    }

    actual fun linkProgram(program: Int) {
        glLinkProgram(program as GLuint)
    }

    actual fun getProgramiv(program: Int): Boolean {
        var linkedP: CArrayPointer<IntVar> = nativeHeap.allocArray(1)
        glGetProgramiv(program as GLuint, GL_LINK_STATUS, linkedP)
        var linkedB = true
        if (linkedP[0] == 0) {
            NSLog("PGLES", "Link program failed")
            linkedB = false
        }
        nativeHeap.free(linkedP)
        return linkedB
    }

    actual fun deleteShader(shader: Int) {
        glDeleteShader(shader as GLuint)
    }

    actual fun useProgram(program: Int) {
        glUseProgram(program as GLuint)
    }

    actual fun deleteProgram(program: Int) {
        glDeleteProgram(program as GLuint)
    }

    actual fun getAttribLocation(program: Int, name: String): Int {
        return glGetAttribLocation(program as GLuint, name)
    }

    actual fun getUniformLocation(program: Int, name: String): Int {
        return glGetUniformLocation(program as GLuint, name)
    }
}
