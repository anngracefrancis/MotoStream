package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(17)
public final class zztd extends Surface {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f16757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f16758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f16759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final r30 f16760i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f16761j;

    private zztd(r30 r30Var, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.f16760i = r30Var;
        this.f16759h = z;
    }

    public static zztd a(Context context, boolean z) {
        if (zzsy.a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
        zzsk.e(!z || b(context));
        return new r30().b(z);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0047  */
    public static synchronized boolean b(Context context) {
        boolean z;
        if (!f16758g) {
            int i2 = zzsy.a;
            if (i2 >= 17) {
                boolean z2 = false;
                String strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                if (strEglQueryString != null && strEglQueryString.contains("EGL_EXT_protected_content")) {
                    if (i2 == 24) {
                        String str = zzsy.f16742d;
                        if ((str.startsWith("SM-G950") || str.startsWith("SM-G955")) && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    if (!z) {
                        z2 = true;
                    }
                }
                f16757f = z2;
            }
            f16758g = true;
        }
        return f16757f;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.f16760i) {
            if (!this.f16761j) {
                this.f16760i.a();
                this.f16761j = true;
            }
        }
    }
}
