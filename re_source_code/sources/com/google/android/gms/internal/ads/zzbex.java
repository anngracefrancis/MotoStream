package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbex implements zzrv {
    private InputStream a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f14409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzrv f14410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzsj<zzrv> f14411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbey f14412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Uri f14413g;

    public zzbex(Context context, zzrv zzrvVar, zzsj<zzrv> zzsjVar, zzbey zzbeyVar) {
        this.f14409c = context;
        this.f14410d = zzrvVar;
        this.f14411e = zzsjVar;
        this.f14412f = zzbeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final Uri I0() {
        return this.f14413g;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final long a(zzry zzryVar) throws IOException {
        Long l;
        zzry zzryVar2 = zzryVar;
        if (this.f14408b) {
            throw new IOException("Attempt to open an already open CacheDataSource.");
        }
        boolean z = true;
        this.f14408b = z;
        this.f14413g = zzryVar2.a;
        zzsj<zzrv> zzsjVar = this.f14411e;
        if (zzsjVar != null) {
            zzsjVar.n(this, zzryVar2);
        }
        zzvv zzvvVarZ = zzvv.z(zzryVar2.a);
        if (!((Boolean) zzyt.e().c(zzacu.z3)).booleanValue()) {
            zzvs zzvsVarD = null;
            if (zzvvVarZ != null) {
                zzvvVarZ.m = zzryVar2.f16686d;
                zzvsVarD = zzk.zzlm().d(zzvvVarZ);
            }
            if (zzvsVarD != null && zzvsVarD.y()) {
                this.a = zzvsVarD.z();
                return -1L;
            }
        } else if (zzvvVarZ != null) {
            zzvvVarZ.m = zzryVar2.f16686d;
            if (zzvvVarZ.l) {
                l = (Long) zzyt.e().c(zzacu.B3);
            } else {
                l = (Long) zzyt.e().c(zzacu.A3);
            }
            long jLongValue = l.longValue();
            long jB = zzk.zzln().b();
            zzk.zzma();
            Future<InputStream> futureA = zzwi.a(this.f14409c, zzvvVarZ);
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
                this.f14412f.a(z, jB2);
                StringBuilder sb = new StringBuilder(44);
                sb.append("Cache connection took ");
                sb.append(jB2);
                sb.append("ms");
                zzawz.m(sb.toString());
            }
        }
        if (zzvvVarZ != null) {
            zzryVar2 = new zzry(Uri.parse(zzvvVarZ.f16863f), zzryVar2.f16684b, zzryVar2.f16685c, zzryVar2.f16686d, zzryVar2.f16687e, zzryVar2.f16688f, zzryVar2.f16689g);
        }
        return this.f14410d.a(zzryVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final void close() throws IOException {
        if (!this.f14408b) {
            throw new IOException("Attempt to close an already closed CacheDataSource.");
        }
        this.f14408b = false;
        this.f14413g = null;
        InputStream inputStream = this.a;
        if (inputStream != null) {
            IOUtils.a(inputStream);
            this.a = null;
        } else {
            this.f14410d.close();
        }
        zzsj<zzrv> zzsjVar = this.f14411e;
        if (zzsjVar != null) {
            zzsjVar.d(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f14408b) {
            throw new IOException("Attempt to read closed CacheDataSource.");
        }
        InputStream inputStream = this.a;
        int i4 = inputStream != null ? inputStream.read(bArr, i2, i3) : this.f14410d.read(bArr, i2, i3);
        zzsj<zzrv> zzsjVar = this.f14411e;
        if (zzsjVar != null) {
            zzsjVar.o(this, i4);
        }
        return i4;
    }
}
