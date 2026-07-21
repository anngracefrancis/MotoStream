package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbgo extends zzbft implements zzsj<zzrv> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f14442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzbde f14443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14444k;
    private final ka l;
    private final zzbfl m;
    private ByteBuffer n;
    private boolean o;
    private final Object p;
    private boolean q;

    public zzbgo(zzbdf zzbdfVar, zzbde zzbdeVar) {
        super(zzbdfVar);
        this.f14443j = zzbdeVar;
        this.l = new ka();
        this.m = new zzbfl();
        this.p = new Object();
    }

    private final void D() {
        int iB = (int) this.l.b();
        int iA = (int) this.m.a(this.n);
        int iPosition = this.n.position();
        int iRound = Math.round(iA * (iPosition / iB));
        boolean z = iRound > 0;
        int iG = zzbfa.G();
        int iH = zzbfa.H();
        String str = this.f14442i;
        k(str, z(str), iPosition, iB, iRound, iA, z, iG, iH);
    }

    public final ByteBuffer B() {
        synchronized (this.p) {
            ByteBuffer byteBuffer = this.n;
            if (byteBuffer != null && !this.o) {
                byteBuffer.flip();
                this.o = true;
            }
            this.f14444k = true;
        }
        return this.n;
    }

    public final String C() {
        return this.f14442i;
    }

    public final boolean E() {
        return this.q;
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void b() {
        this.f14444k = true;
    }

    @Override // com.google.android.gms.internal.ads.zzsj
    public final /* bridge */ /* synthetic */ void d(zzrv zzrvVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzsj
    public final /* synthetic */ void n(zzrv zzrvVar, zzry zzryVar) {
        zzrv zzrvVar2 = zzrvVar;
        if (zzrvVar2 instanceof zzsa) {
            this.l.a((zzsa) zzrvVar2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsj
    public final /* bridge */ /* synthetic */ void o(zzrv zzrvVar, int i2) {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:? -> B:53:0x0138). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzbft
    public final boolean y(String str) throws Throwable {
        this.f14442i = str;
        String strZ = z(str);
        String str2 = "error";
        int i2 = 0;
        try {
            String str3 = this.f14431g;
            zzbde zzbdeVar = this.f14443j;
            zzrv zzsaVar = new zzsa(str3, null, this, zzbdeVar.f14366d, zzbdeVar.f14368f, true, null);
            if (this.f14443j.f14372j) {
                try {
                    zzsaVar = new zzbex(this.f14430f, zzsaVar, null, null);
                } catch (Exception e2) {
                    e = e2;
                }
            }
            zzsaVar.a(new zzry(Uri.parse(str)));
            zzbdf zzbdfVar = this.f14432h.get();
            if (zzbdfVar != null) {
                zzbdfVar.g(strZ, this);
            }
            Clock clockZzln = zzk.zzln();
            long jA = clockZzln.a();
            long jLongValue = ((Long) zzyt.e().c(zzacu.F)).longValue();
            long jLongValue2 = ((Long) zzyt.e().c(zzacu.E)).longValue();
            this.n = ByteBuffer.allocate(this.f14443j.f14365c);
            int i3 = 8192;
            byte[] bArr = new byte[8192];
            long j2 = jA;
            while (true) {
                int i4 = zzsaVar.read(bArr, i2, Math.min(this.n.remaining(), i3));
                if (i4 == -1) {
                    this.q = true;
                    s(str, strZ, (int) this.m.a(this.n));
                    return true;
                }
                synchronized (this.p) {
                    try {
                        if (!this.f14444k) {
                            try {
                                this.n.put(bArr, 0, i4);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        try {
                            if (this.n.remaining() <= 0) {
                                D();
                                return true;
                            }
                            if (this.f14444k) {
                                int iLimit = this.n.limit();
                                StringBuilder sb = new StringBuilder(35);
                                sb.append("Precache abort at ");
                                sb.append(iLimit);
                                sb.append(" bytes");
                                throw new IOException(sb.toString());
                            }
                            long jA2 = clockZzln.a();
                            if (jA2 - j2 >= jLongValue) {
                                D();
                                j2 = jA2;
                            }
                            if (jA2 - jA > 1000 * jLongValue2) {
                                StringBuilder sb2 = new StringBuilder(49);
                                sb2.append("Timeout exceeded. Limit: ");
                                sb2.append(jLongValue2);
                                sb2.append(" sec");
                                throw new IOException(sb2.toString());
                            }
                            str2 = str2;
                            i3 = 8192;
                            i2 = 0;
                        } catch (Exception e3) {
                            e = e3;
                            str2 = str2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                String canonicalName = e.getClass().getCanonicalName();
                String message = e.getMessage();
                StringBuilder sb3 = new StringBuilder(String.valueOf(canonicalName).length() + 1 + String.valueOf(message).length());
                sb3.append(canonicalName);
                sb3.append(":");
                sb3.append(message);
                String string = sb3.toString();
                StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(string).length());
                sb4.append("Failed to preload url ");
                sb4.append(str);
                sb4.append(" Exception: ");
                sb4.append(string);
                zzbad.i(sb4.toString());
                q(str, strZ, str2, string);
                return false;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    protected final String z(String str) {
        String strValueOf = String.valueOf(super.z(str));
        return strValueOf.length() != 0 ? "cache:".concat(strValueOf) : new String("cache:");
    }
}
