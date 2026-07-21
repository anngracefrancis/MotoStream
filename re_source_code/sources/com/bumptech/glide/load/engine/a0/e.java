package com.bumptech.glide.load.engine.a0;

import android.util.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: DiskLruCacheWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f9059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f9060c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.k.a f9062e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f9061d = new c();
    private final j a = new j();

    @Deprecated
    protected e(File file, long j2) {
        this.f9059b = file;
        this.f9060c = j2;
    }

    public static a c(File file, long j2) {
        return new e(file, j2);
    }

    private synchronized com.bumptech.glide.k.a d() throws IOException {
        if (this.f9062e == null) {
            this.f9062e = com.bumptech.glide.k.a.D(this.f9059b, 1, 1, this.f9060c);
        }
        return this.f9062e;
    }

    @Override // com.bumptech.glide.load.engine.a0.a
    public void a(com.bumptech.glide.load.f fVar, a.b bVar) {
        String strB = this.a.b(fVar);
        this.f9061d.a(strB);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strB + " for for Key: " + fVar);
            }
            try {
                com.bumptech.glide.k.a aVarD = d();
                if (aVarD.A(strB) != null) {
                    this.f9061d.b(strB);
                    return;
                }
                com.bumptech.glide.k.a.c cVarY = aVarD.y(strB);
                if (cVarY == null) {
                    throw new IllegalStateException("Had two simultaneous puts for: " + strB);
                }
                try {
                    if (bVar.a(cVarY.f(0))) {
                        cVarY.e();
                    }
                    cVarY.b();
                    this.f9061d.b(strB);
                } catch (Throwable th) {
                    cVarY.b();
                    throw th;
                }
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e2);
                }
            }
        } catch (Throwable th2) {
            this.f9061d.b(strB);
            throw th2;
        }
    }

    @Override // com.bumptech.glide.load.engine.a0.a
    public File b(com.bumptech.glide.load.f fVar) {
        String strB = this.a.b(fVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strB + " for for Key: " + fVar);
        }
        try {
            com.bumptech.glide.k.a.e eVarA = d().A(strB);
            if (eVarA != null) {
                return eVarA.a(0);
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e2);
            return null;
        }
    }
}
