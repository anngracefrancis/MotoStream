package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@TargetApi(14)
public final class zzbdd extends Thread implements SurfaceTexture.OnFrameAvailableListener, e8 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float[] f14358f = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private final Object A;
    private EGL10 B;
    private EGLDisplay C;
    private EGLContext D;
    private EGLSurface E;
    private volatile boolean F;
    private volatile boolean G;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c8 f14359g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f14360h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f14361i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float[] f14362j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final float[] f14363k;
    private final float[] l;
    private final float[] m;
    private final float[] n;
    private float o;
    private float p;
    private float q;
    private int r;
    private int s;
    private SurfaceTexture t;
    private SurfaceTexture u;
    private int v;
    private int w;
    private int x;
    private FloatBuffer y;
    private final CountDownLatch z;

    public zzbdd(Context context) {
        super("SphericalVideoProcessor");
        float[] fArr = f14358f;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.y = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr).position(0);
        this.f14360h = new float[9];
        this.f14361i = new float[9];
        this.f14362j = new float[9];
        this.f14363k = new float[9];
        this.l = new float[9];
        this.m = new float[9];
        this.n = new float[9];
        this.o = Float.NaN;
        c8 c8Var = new c8(context);
        this.f14359g = c8Var;
        c8Var.c(this);
        this.z = new CountDownLatch(1);
        this.A = new Object();
    }

    private static void c(float[] fArr, float f2) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d2 = f2;
        fArr[4] = (float) Math.cos(d2);
        fArr[5] = (float) (-Math.sin(d2));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d2);
        fArr[8] = (float) Math.cos(d2);
    }

    private static void d(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    private static void f(float[] fArr, float f2) {
        double d2 = f2;
        fArr[0] = (float) Math.cos(d2);
        fArr[1] = (float) (-Math.sin(d2));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d2);
        fArr[4] = (float) Math.cos(d2);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static int g(int i2, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i2);
        h("createShader");
        if (iGlCreateShader == 0) {
            return iGlCreateShader;
        }
        GLES20.glShaderSource(iGlCreateShader, str);
        h("shaderSource");
        GLES20.glCompileShader(iGlCreateShader);
        h("compileShader");
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        h("getShaderiv");
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Could not compile shader ");
        sb.append(i2);
        sb.append(":");
        Log.e("SphericalVideoRenderer", sb.toString());
        Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(iGlCreateShader));
        GLES20.glDeleteShader(iGlCreateShader);
        h("deleteShader");
        return 0;
    }

    private static void h(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21);
            sb.append(str);
            sb.append(": glError ");
            sb.append(iGlGetError);
            Log.e("SphericalVideoRenderer", sb.toString());
        }
    }

    @VisibleForTesting
    private final boolean l() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.E;
        boolean zEglDestroyContext = false;
        if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
            zEglDestroyContext = this.B.eglDestroySurface(this.C, this.E) | this.B.eglMakeCurrent(this.C, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT) | false;
            this.E = null;
        }
        EGLContext eGLContext = this.D;
        if (eGLContext != null) {
            zEglDestroyContext |= this.B.eglDestroyContext(this.C, eGLContext);
            this.D = null;
        }
        EGLDisplay eGLDisplay = this.C;
        if (eGLDisplay == null) {
            return zEglDestroyContext;
        }
        boolean zEglTerminate = zEglDestroyContext | this.B.eglTerminate(eGLDisplay);
        this.C = null;
        return zEglTerminate;
    }

    @Override // com.google.android.gms.internal.ads.e8
    public final void a() {
        synchronized (this.A) {
            this.A.notifyAll();
        }
    }

    public final void b(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.s = i2;
        this.r = i3;
        this.u = surfaceTexture;
    }

    public final void e(float f2, float f3) {
        float f4;
        float f5;
        float f6;
        int i2 = this.s;
        int i3 = this.r;
        if (i2 > i3) {
            f4 = (f2 * 1.7453293f) / i2;
            f5 = f3 * 1.7453293f;
            f6 = i2;
        } else {
            f4 = (f2 * 1.7453293f) / i3;
            f5 = f3 * 1.7453293f;
            f6 = i3;
        }
        this.p -= f4;
        float f7 = this.q - (f5 / f6);
        this.q = f7;
        if (f7 < -1.5707964f) {
            this.q = -1.5707964f;
        }
        if (this.q > 1.5707964f) {
            this.q = 1.5707964f;
        }
    }

    public final void i(int i2, int i3) {
        synchronized (this.A) {
            this.s = i2;
            this.r = i3;
            this.F = true;
            this.A.notifyAll();
        }
    }

    public final void j() {
        synchronized (this.A) {
            this.G = true;
            this.u = null;
            this.A.notifyAll();
        }
    }

    public final SurfaceTexture k() {
        if (this.u == null) {
            return null;
        }
        try {
            this.z.await();
        } catch (InterruptedException unused) {
        }
        return this.t;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.x++;
        synchronized (this.A) {
            this.A.notifyAll();
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00be  */
    /* JADX WARN: Code duplicated, block: B:8:0x0028  */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z;
        int iGlCreateProgram;
        if (this.u == null) {
            zzbad.g("SphericalVideoProcessor started with no output texture.");
            this.z.countDown();
            return;
        }
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.B = egl10;
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.C = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay != EGL10.EGL_NO_DISPLAY && this.B.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
            int[] iArr = new int[1];
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGLConfig eGLConfig = (!this.B.eglChooseConfig(this.C, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344}, eGLConfigArr, 1, iArr) || iArr[0] <= 0) ? null : eGLConfigArr[0];
            if (eGLConfig == null) {
                z = false;
            } else {
                EGLContext eGLContextEglCreateContext = this.B.eglCreateContext(this.C, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                this.D = eGLContextEglCreateContext;
                if (eGLContextEglCreateContext == null || eGLContextEglCreateContext == EGL10.EGL_NO_CONTEXT) {
                    z = false;
                } else {
                    EGLSurface eGLSurfaceEglCreateWindowSurface = this.B.eglCreateWindowSurface(this.C, eGLConfig, this.u, null);
                    this.E = eGLSurfaceEglCreateWindowSurface;
                    if (eGLSurfaceEglCreateWindowSurface == null || eGLSurfaceEglCreateWindowSurface == EGL10.EGL_NO_SURFACE || !this.B.eglMakeCurrent(this.C, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.D)) {
                        z = false;
                    } else {
                        z = true;
                    }
                }
            }
        } else {
            z = false;
        }
        zzacj<String> zzacjVar = zzacu.L1;
        int iG = g(35633, !((String) zzyt.e().c(zzacjVar)).equals(zzacjVar.n()) ? (String) zzyt.e().c(zzacjVar) : "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}");
        if (iG == 0) {
            iGlCreateProgram = 0;
        } else {
            zzacj<String> zzacjVar2 = zzacu.M1;
            int iG2 = g(35632, !((String) zzyt.e().c(zzacjVar2)).equals(zzacjVar2.n()) ? (String) zzyt.e().c(zzacjVar2) : "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}");
            if (iG2 == 0) {
                iGlCreateProgram = 0;
            } else {
                iGlCreateProgram = GLES20.glCreateProgram();
                h("createProgram");
                if (iGlCreateProgram != 0) {
                    GLES20.glAttachShader(iGlCreateProgram, iG);
                    h("attachShader");
                    GLES20.glAttachShader(iGlCreateProgram, iG2);
                    h("attachShader");
                    GLES20.glLinkProgram(iGlCreateProgram);
                    h("linkProgram");
                    int[] iArr2 = new int[1];
                    GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr2, 0);
                    h("getProgramiv");
                    if (iArr2[0] != 1) {
                        Log.e("SphericalVideoRenderer", "Could not link program: ");
                        Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(iGlCreateProgram));
                        GLES20.glDeleteProgram(iGlCreateProgram);
                        h("deleteProgram");
                        iGlCreateProgram = 0;
                    } else {
                        GLES20.glValidateProgram(iGlCreateProgram);
                        h("validateProgram");
                    }
                }
            }
        }
        this.v = iGlCreateProgram;
        GLES20.glUseProgram(iGlCreateProgram);
        h("useProgram");
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.v, "aPosition");
        GLES20.glVertexAttribPointer(iGlGetAttribLocation, 3, 5126, false, 12, (Buffer) this.y);
        h("vertexAttribPointer");
        GLES20.glEnableVertexAttribArray(iGlGetAttribLocation);
        h("enableVertexAttribArray");
        int[] iArr3 = new int[1];
        GLES20.glGenTextures(1, iArr3, 0);
        h("genTextures");
        int i2 = iArr3[0];
        GLES20.glBindTexture(36197, i2);
        h("bindTextures");
        GLES20.glTexParameteri(36197, 10240, 9729);
        h("texParameteri");
        GLES20.glTexParameteri(36197, 10241, 9729);
        h("texParameteri");
        GLES20.glTexParameteri(36197, 10242, 33071);
        h("texParameteri");
        GLES20.glTexParameteri(36197, 10243, 33071);
        h("texParameteri");
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.v, "uVMat");
        this.w = iGlGetUniformLocation;
        GLES20.glUniformMatrix3fv(iGlGetUniformLocation, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
        boolean z2 = this.v != 0;
        if (!z || !z2) {
            String strValueOf = String.valueOf(GLUtils.getEGLErrorString(this.B.eglGetError()));
            String strConcat = strValueOf.length() != 0 ? "EGL initialization failed: ".concat(strValueOf) : new String("EGL initialization failed: ");
            zzbad.g(strConcat);
            zzk.zzlk().e(new Throwable(strConcat), "SphericalVideoProcessor.run.1");
            l();
            this.z.countDown();
            return;
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(i2);
        this.t = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.z.countDown();
        this.f14359g.a();
        try {
            try {
                this.F = true;
                while (!this.G) {
                    while (this.x > 0) {
                        this.t.updateTexImage();
                        this.x--;
                    }
                    if (this.f14359g.d(this.f14360h)) {
                        if (Float.isNaN(this.o)) {
                            float[] fArr = this.f14360h;
                            float[] fArr2 = {0.0f, 1.0f, 0.0f};
                            float[] fArr3 = {(fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]), (fArr[3] * fArr2[0]) + (fArr[4] * fArr2[1]) + (fArr[5] * fArr2[2]), (fArr[6] * fArr2[0]) + (fArr[7] * fArr2[1]) + (fArr[8] * fArr2[2])};
                            this.o = -(((float) Math.atan2(fArr3[1], fArr3[0])) - 1.5707964f);
                        }
                        f(this.m, this.o + this.p);
                    } else {
                        c(this.f14360h, -1.5707964f);
                        f(this.m, this.p);
                    }
                    c(this.f14361i, 1.5707964f);
                    d(this.f14362j, this.m, this.f14361i);
                    d(this.f14363k, this.f14360h, this.f14362j);
                    c(this.l, this.q);
                    d(this.n, this.l, this.f14363k);
                    GLES20.glUniformMatrix3fv(this.w, 1, false, this.n, 0);
                    GLES20.glDrawArrays(5, 0, 4);
                    h("drawArrays");
                    GLES20.glFinish();
                    this.B.eglSwapBuffers(this.C, this.E);
                    if (this.F) {
                        GLES20.glViewport(0, 0, this.s, this.r);
                        h("viewport");
                        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.v, "uFOVx");
                        int iGlGetUniformLocation3 = GLES20.glGetUniformLocation(this.v, "uFOVy");
                        int i3 = this.s;
                        int i4 = this.r;
                        if (i3 > i4) {
                            GLES20.glUniform1f(iGlGetUniformLocation2, 0.87266463f);
                            GLES20.glUniform1f(iGlGetUniformLocation3, (this.r * 0.87266463f) / this.s);
                        } else {
                            GLES20.glUniform1f(iGlGetUniformLocation2, (i3 * 0.87266463f) / i4);
                            GLES20.glUniform1f(iGlGetUniformLocation3, 0.87266463f);
                        }
                        this.F = false;
                    }
                    try {
                        synchronized (this.A) {
                            try {
                                if (!this.G && !this.F && this.x == 0) {
                                    this.A.wait();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } catch (InterruptedException unused) {
                    }
                }
                this.f14359g.b();
                this.t.setOnFrameAvailableListener(null);
                this.t = null;
                l();
            } catch (Throwable th2) {
                this.f14359g.b();
                this.t.setOnFrameAvailableListener(null);
                this.t = null;
                l();
                throw th2;
            }
        } catch (IllegalStateException unused2) {
            zzbad.i("SphericalVideoProcessor halted unexpectedly.");
            this.f14359g.b();
            this.t.setOnFrameAvailableListener(null);
            this.t = null;
            l();
        } catch (Throwable th3) {
            zzbad.c("SphericalVideoProcessor died.", th3);
            zzk.zzlk().e(th3, "SphericalVideoProcessor.run.2");
            this.f14359g.b();
            this.t.setOnFrameAvailableListener(null);
            this.t = null;
            l();
        }
    }
}
