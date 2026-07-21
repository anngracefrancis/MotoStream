package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbeh implements zzjp {
    private InputStream a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f14401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzjp f14402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final WeakReference<zzbei> f14403e;

    public zzbeh(Context context, zzjp zzjpVar, zzbei zzbeiVar) {
        this.f14401c = context;
        this.f14402d = zzjpVar;
        this.f14403e = new WeakReference<>(zzbeiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final long a(zzjq zzjqVar) throws IOException {
        Long l;
        zzjq zzjqVar2 = zzjqVar;
        if (this.f14400b) {
            throw new IOException("Attempt to open an already open CacheDataSource.");
        }
        boolean z = true;
        this.f14400b = z;
        zzvv zzvvVarZ = zzvv.z(zzjqVar2.a);
        if (!((Boolean) zzyt.e().c(zzacu.z3)).booleanValue()) {
            zzvs zzvsVarD = null;
            if (zzvvVarZ != null) {
                zzvvVarZ.m = zzjqVar2.f16359c;
                zzvsVarD = zzk.zzlm().d(zzvvVarZ);
            }
            if (zzvsVarD != null && zzvsVarD.y()) {
                this.a = zzvsVarD.z();
                return -1L;
            }
        } else if (zzvvVarZ != null) {
            zzvvVarZ.m = zzjqVar2.f16359c;
            if (zzvvVarZ.l) {
                l = (Long) zzyt.e().c(zzacu.B3);
            } else {
                l = (Long) zzyt.e().c(zzacu.A3);
            }
            long jLongValue = l.longValue();
            long jB = zzk.zzln().b();
            zzk.zzma();
            Future<InputStream> futureA = zzwi.a(this.f14401c, zzvvVarZ);
            z = false;
            try {
                this.a = futureA.get(jLongValue, TimeUnit.MILLISECONDS);
                return -1L;
            } catch (InterruptedException unused) {
                futureA.cancel(z);
                Thread.currentThread().interrupt();
            } catch (ExecutionException | TimeoutException unused2) {
                futureA.cancel(z);
            } finally {
                long jB2 = zzk.zzln().b() - jB;
                zzbei zzbeiVar = this.f14403e.get();
                if (zzbeiVar != null) {
                    zzbeiVar.a(z, jB2);
                }
                StringBuilder sb = new StringBuilder(44);
                sb.append("Cache connection took ");
                sb.append(jB2);
                sb.append("ms");
                zzawz.m(sb.toString());
            }
        }
        if (zzvvVarZ != null) {
            zzjqVar2 = new zzjq(Uri.parse(zzvvVarZ.f16863f), zzjqVar2.f16358b, zzjqVar2.f16359c, zzjqVar2.f16360d, zzjqVar2.f16361e, zzjqVar2.f16362f);
        }
        return this.f14402d.a(zzjqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final void close() throws IOException {
        if (!this.f14400b) {
            throw new IOException("Attempt to close an already closed CacheDataSource.");
        }
        this.f14400b = false;
        InputStream inputStream = this.a;
        if (inputStream == null) {
            this.f14402d.close();
        } else {
            IOUtils.a(inputStream);
            this.a = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjp
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f14400b) {
            throw new IOException("Attempt to read closed CacheDataSource.");
        }
        InputStream inputStream = this.a;
        return inputStream != null ? inputStream.read(bArr, i2, i3) : this.f14402d.read(bArr, i2, i3);
    }
}
