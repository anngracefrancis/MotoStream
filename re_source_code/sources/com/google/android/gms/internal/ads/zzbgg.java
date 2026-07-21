package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbgg extends zzbft {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f14436i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzbde f14437j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14438k;
    private final zzbfl l;
    private ByteBuffer m;
    private boolean n;
    private final Object o;
    private boolean p;

    public zzbgg(zzbdf zzbdfVar, zzbde zzbdeVar) {
        super(zzbdfVar);
        this.f14437j = zzbdeVar;
        this.l = new zzbfl();
        this.o = new Object();
    }

    private final void D() {
        int iPosition = this.m.position();
        boolean z = iPosition > 0;
        int iG = zzbdk.g();
        int iH = zzbdk.h();
        String str = this.f14436i;
        l(str, z(str), iPosition, 0, z, iG, iH);
    }

    public final ByteBuffer B() {
        synchronized (this.o) {
            ByteBuffer byteBuffer = this.m;
            if (byteBuffer != null && !this.n) {
                byteBuffer.flip();
                this.n = true;
            }
            this.f14438k = true;
        }
        return this.m;
    }

    public final String C() {
        return this.f14436i;
    }

    public final boolean E() {
        return this.p;
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void b() {
        this.f14438k = true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:? -> B:53:0x0136). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzbft
    public final boolean y(String str) throws Throwable {
        this.f14436i = str;
        String strZ = z(str);
        String str2 = "error";
        int i2 = 0;
        try {
            String str3 = this.f14431g;
            zzbde zzbdeVar = this.f14437j;
            zzjp zzjsVar = new zzjs(str3, null, null, zzbdeVar.f14366d, zzbdeVar.f14368f, true);
            if (this.f14437j.f14372j) {
                try {
                    zzjsVar = new zzbeh(this.f14430f, zzjsVar, null);
                } catch (Exception e2) {
                    e = e2;
                }
            }
            zzjsVar.a(new zzjq(Uri.parse(str)));
            zzbdf zzbdfVar = this.f14432h.get();
            if (zzbdfVar != null) {
                zzbdfVar.g(strZ, this);
            }
            Clock clockZzln = zzk.zzln();
            long jA = clockZzln.a();
            long jLongValue = ((Long) zzyt.e().c(zzacu.F)).longValue();
            long jLongValue2 = ((Long) zzyt.e().c(zzacu.E)).longValue();
            this.m = ByteBuffer.allocate(this.f14437j.f14365c);
            int i3 = 8192;
            byte[] bArr = new byte[8192];
            long j2 = jA;
            while (true) {
                int i4 = zzjsVar.read(bArr, i2, Math.min(this.m.remaining(), i3));
                if (i4 == -1) {
                    this.p = true;
                    s(str, strZ, (int) this.l.a(this.m));
                    return true;
                }
                synchronized (this.o) {
                    try {
                        if (!this.f14438k) {
                            try {
                                this.m.put(bArr, 0, i4);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        try {
                            if (this.m.remaining() <= 0) {
                                D();
                                return true;
                            }
                            if (this.f14438k) {
                                int iLimit = this.m.limit();
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
                            i2 = 0;
                            i3 = 8192;
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
