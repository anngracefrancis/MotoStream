package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
final class r30 extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f13254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f13255g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SurfaceTexture f13256h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Error f13257i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private RuntimeException f13258j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zztd f13259k;

    public r30() {
        super("dummySurface");
        this.f13254f = new int[1];
    }

    public final void a() {
        this.f13255g.sendEmptyMessage(3);
    }

    public final zztd b(boolean z) {
        boolean z2;
        start();
        this.f13255g = new Handler(getLooper(), this);
        synchronized (this) {
            z2 = false;
            this.f13255g.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            while (this.f13259k == null && this.f13258j == null && this.f13257i == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.f13258j;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = this.f13257i;
        if (error == null) {
            return this.f13259k;
        }
        throw error;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        try {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.f13256h.updateTexImage();
                    return true;
                }
                if (i2 != 3) {
                    return true;
                }
                try {
                    try {
                        this.f13256h.release();
                        this.f13259k = null;
                        this.f13256h = null;
                        GLES20.glDeleteTextures(1, this.f13254f, 0);
                        quit();
                    } catch (Throwable th) {
                        this.f13259k = null;
                        this.f13256h = null;
                        GLES20.glDeleteTextures(1, this.f13254f, 0);
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        Log.e("DummySurface", "Failed to release dummy surface", th2);
                    } finally {
                        quit();
                    }
                }
                return true;
            }
            try {
                try {
                    boolean z = message.arg1 != 0;
                    EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
                    zzsk.f(eGLDisplayEglGetDisplay != null, "eglGetDisplay failed");
                    int[] iArr = new int[2];
                    zzsk.f(EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1), "eglInitialize failed");
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    int[] iArr2 = new int[1];
                    zzsk.f(EGL14.eglChooseConfig(eGLDisplayEglGetDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) && iArr2[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplayEglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, z ? new int[]{12440, 2, 12992, 1, 12344} : new int[]{12440, 2, 12344}, 0);
                    zzsk.f(eGLContextEglCreateContext != null, "eglCreateContext failed");
                    EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplayEglGetDisplay, eGLConfig, z ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                    zzsk.f(eGLSurfaceEglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
                    zzsk.f(EGL14.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext), "eglMakeCurrent failed");
                    GLES20.glGenTextures(1, this.f13254f, 0);
                    SurfaceTexture surfaceTexture = new SurfaceTexture(this.f13254f[0]);
                    this.f13256h = surfaceTexture;
                    surfaceTexture.setOnFrameAvailableListener(this);
                    this.f13259k = new zztd(this, this.f13256h, z);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e2) {
                    Log.e("DummySurface", "Failed to initialize dummy surface", e2);
                    this.f13257i = e2;
                    synchronized (this) {
                        notify();
                    }
                }
            } catch (RuntimeException e3) {
                Log.e("DummySurface", "Failed to initialize dummy surface", e3);
                this.f13258j = e3;
                synchronized (this) {
                    notify();
                }
            }
            return true;
        } catch (Throwable th3) {
            synchronized (this) {
                notify();
                throw th3;
            }
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f13255g.sendEmptyMessage(2);
    }
}
