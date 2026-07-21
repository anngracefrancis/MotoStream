package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@TargetApi(16)
public final class zzbgp extends zzbft implements zzbfi {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzbfa f14445i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f14446j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14447k;
    private Exception l;
    private boolean m;

    public zzbgp(zzbdf zzbdfVar, zzbde zzbdeVar) {
        super(zzbdfVar);
        zzbfa zzbfaVar = new zzbfa(zzbdfVar.getContext(), zzbdeVar);
        this.f14445i = zzbfaVar;
        zzbfaVar.x(this);
    }

    private static String C(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }

    private final void D(String str) {
        synchronized (this) {
            this.f14447k = true;
            notify();
            c();
        }
        String str2 = this.f14446j;
        if (str2 != null) {
            String strZ = z(str2);
            Exception exc = this.l;
            if (exc != null) {
                q(this.f14446j, strZ, "badUrl", C(str, exc));
            } else {
                q(this.f14446j, strZ, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    public final zzbfa B() {
        synchronized (this) {
            this.m = true;
            notify();
        }
        this.f14445i.x(null);
        zzbfa zzbfaVar = this.f14445i;
        this.f14445i = null;
        return zzbfaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void a(final boolean z, final long j2) {
        final zzbdf zzbdfVar = this.f14432h.get();
        if (zzbdfVar != null) {
            zzbbm.a.execute(new Runnable(zzbdfVar, z, j2) { // from class: com.google.android.gms.internal.ads.la

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzbdf f12918f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private final boolean f12919g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                private final long f12920h;

                {
                    this.f12918f = zzbdfVar;
                    this.f12919g = z;
                    this.f12920h = j2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12918f.R(this.f12919g, this.f12920h);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void b() {
        D(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbft, com.google.android.gms.common.api.Releasable
    public final void c() {
        zzbfa zzbfaVar = this.f14445i;
        if (zzbfaVar != null) {
            zzbfaVar.x(null);
            this.f14445i.t();
        }
        super.c();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void e(int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void f(String str, Exception exc) {
        this.l = exc;
        zzbad.d("Precache error", exc);
        D(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void g(int i2, int i3) {
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void t(int i2) {
        this.f14445i.J().j(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void u(int i2) {
        this.f14445i.J().k(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void v(int i2) {
        this.f14445i.J().h(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void w(int i2) {
        this.f14445i.J().i(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [long] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r33v0, types: [com.google.android.gms.internal.ads.zzbft, com.google.android.gms.internal.ads.zzbgp, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbft
    public final boolean x(String str, String[] strArr) throws Throwable {
        ?? r20;
        ?? r1;
        ?? r2;
        this.f14446j = str;
        String strZ = z(str);
        ?? r14 = "error";
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    uriArr[i2] = Uri.parse(strArr[i2]);
                } catch (Exception e2) {
                    e = e2;
                    String message = e.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length());
                    sb.append("Failed to preload url ");
                    sb.append(str);
                    sb.append(" Exception: ");
                    sb.append(message);
                    zzbad.i(sb.toString());
                    c();
                    q(str, strZ, r14, C(r14, e));
                    return false;
                }
            }
            this.f14445i.y(uriArr, this.f14431g);
            zzbdf zzbdfVar = this.f14432h.get();
            if (zzbdfVar != null) {
                zzbdfVar.g(strZ, this);
            }
            Clock clockZzln = zzk.zzln();
            long jA = clockZzln.a();
            long jLongValue = ((Long) zzyt.e().c(zzacu.F)).longValue();
            long jLongValue2 = ((Long) zzyt.e().c(zzacu.E)).longValue() * 1000;
            long jIntValue = ((Integer) zzyt.e().c(zzacu.D)).intValue();
            ?? r3 = -1;
            r14 = r14;
            while (true) {
                try {
                    synchronized (this) {
                        try {
                            if (clockZzln.a() - jA > jLongValue2) {
                                long j2 = jLongValue2;
                                StringBuilder sb2 = new StringBuilder(47);
                                sb2.append("Timeout reached. Limit: ");
                                sb2.append(j2);
                                sb2.append(" ms");
                                throw new IOException(sb2.toString());
                            }
                            if (this.f14447k) {
                                Exception exc = this.l;
                                if (exc != null) {
                                    throw exc;
                                }
                                throw new IOException("Abort requested before buffering finished. ");
                            }
                            if (!this.m) {
                                zzkv zzkvVarI = this.f14445i.I();
                                if (zzkvVarI == null) {
                                    throw new IOException("ExoPlayer was released during preloading.");
                                }
                                r20 = r14;
                                try {
                                    long jG = zzkvVarI.g();
                                    if (jG > 0) {
                                        long jD = zzkvVarI.d();
                                        if (jD != r3) {
                                            p(str, strZ, jD, jG, jD > 0, zzbfa.G(), zzbfa.H());
                                            r2 = jD;
                                        } else {
                                            r2 = r3;
                                        }
                                        if (jD >= jG) {
                                            s(str, strZ, jG);
                                        } else if (this.f14445i.s() < jIntValue || jD <= 0) {
                                            r1 = r2;
                                        }
                                    } else {
                                        jIntValue = jIntValue;
                                        jLongValue2 = jLongValue2;
                                        r1 = r3;
                                    }
                                    try {
                                        try {
                                            wait(jLongValue);
                                        } catch (InterruptedException unused) {
                                            throw new IOException("Wait interrupted.");
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        r14 = r1;
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    r14 = r20;
                                }
                            }
                            return true;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    return true;
                    jLongValue = jLongValue;
                    r14 = r20;
                    jIntValue = jIntValue;
                    jLongValue2 = jLongValue2;
                    r3 = r1;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final boolean y(String str) {
        return x(str, new String[]{str});
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    protected final String z(String str) {
        String strValueOf = String.valueOf(super.z(str));
        return strValueOf.length() != 0 ? "cache:".concat(strValueOf) : new String("cache:");
    }
}
