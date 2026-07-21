package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class zzjm implements zzkf {
    private final AssetManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzke f16351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InputStream f16353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f16354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f16355f;

    public zzjm(Context context, zzke zzkeVar) {
        this.a = context.getAssets();
        this.f16351b = zzkeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final long a(zzjq zzjqVar) throws zzjn {
        try {
            this.f16352c = zzjqVar.a.toString();
            String path = zzjqVar.a.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            InputStream inputStreamOpen = this.a.open(path, 1);
            this.f16353d = inputStreamOpen;
            zzkh.d(inputStreamOpen.skip(zzjqVar.f16359c) == zzjqVar.f16359c);
            long jAvailable = zzjqVar.f16360d;
            if (jAvailable == -1) {
                jAvailable = this.f16353d.available();
            }
            this.f16354e = jAvailable;
            if (jAvailable < 0) {
                throw new EOFException();
            }
            this.f16355f = true;
            zzke zzkeVar = this.f16351b;
            if (zzkeVar != null) {
                zzkeVar.b();
            }
            return this.f16354e;
        } catch (IOException e2) {
            throw new zzjn(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final void close() throws zzjn {
        InputStream inputStream = this.f16353d;
        if (inputStream != null) {
            try {
                try {
                    inputStream.close();
                    this.f16353d = null;
                    if (this.f16355f) {
                        this.f16355f = false;
                        zzke zzkeVar = this.f16351b;
                        if (zzkeVar != null) {
                            zzkeVar.c();
                        }
                    }
                } catch (IOException e2) {
                    throw new zzjn(e2);
                }
            } catch (Throwable th) {
                this.f16353d = null;
                if (this.f16355f) {
                    this.f16355f = false;
                    zzke zzkeVar2 = this.f16351b;
                    if (zzkeVar2 != null) {
                        zzkeVar2.c();
                    }
                }
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final int read(byte[] bArr, int i2, int i3) throws zzjn {
        long j2 = this.f16354e;
        if (j2 == 0) {
            return -1;
        }
        try {
            int i4 = this.f16353d.read(bArr, i2, (int) Math.min(j2, i3));
            if (i4 > 0) {
                this.f16354e -= (long) i4;
                zzke zzkeVar = this.f16351b;
                if (zzkeVar != null) {
                    zzkeVar.a(i4);
                }
            }
            return i4;
        } catch (IOException e2) {
            throw new zzjn(e2);
        }
    }
}
