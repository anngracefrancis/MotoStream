package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.zzk;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaii implements zzm {
    private volatile zzahz a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f13914b;

    public zzaii(Context context) {
        this.f13914b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        if (this.a == null) {
            return;
        }
        this.a.disconnect();
        Binder.flushPendingCommands();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzm
    public final zzp a(zzr<?> zzrVar) throws zzaf {
        zzaia zzaiaVarY = zzaia.y(zzrVar);
        long jB = zzk.zzln().b();
        try {
            zzbbr zzbbrVar = new zzbbr();
            this.a = new zzahz(this.f13914b, zzk.zzlu().b(), new s0(this, zzbbrVar), new t0(this, zzbbrVar));
            this.a.checkAvailabilityAndConnect();
            p0 p0Var = new p0(this, zzaiaVarY);
            zzbbl zzbblVar = zzaxg.a;
            zzbbh zzbbhVarB = zzbar.b(zzbar.c(zzbbrVar, p0Var, zzbblVar), ((Integer) zzyt.e().c(zzacu.E3)).intValue(), TimeUnit.MILLISECONDS, zzaxg.f14254c);
            zzbbhVarB.k(new r0(this), zzbblVar);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzbbhVarB.get();
            long jB2 = zzk.zzln().b() - jB;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(jB2);
            sb.append("ms");
            zzawz.m(sb.toString());
            zzaic zzaicVar = (zzaic) new zzaru(parcelFileDescriptor).y(zzaic.CREATOR);
            if (zzaicVar == null) {
                return null;
            }
            if (zzaicVar.f13908f) {
                throw new zzaf(zzaicVar.f13909g);
            }
            if (zzaicVar.f13912j.length != zzaicVar.f13913k.length) {
                return null;
            }
            HashMap map = new HashMap();
            int i2 = 0;
            while (true) {
                String[] strArr = zzaicVar.f13912j;
                if (i2 >= strArr.length) {
                    return new zzp(zzaicVar.f13910h, zzaicVar.f13911i, map, zzaicVar.l, zzaicVar.m);
                }
                map.put(strArr[i2], zzaicVar.f13913k[i2]);
                i2++;
            }
        } catch (InterruptedException | ExecutionException unused) {
            long jB3 = zzk.zzln().b() - jB;
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(jB3);
            sb2.append("ms");
            zzawz.m(sb2.toString());
            return null;
        } catch (Throwable th) {
            long jB4 = zzk.zzln().b() - jB;
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(jB4);
            sb3.append("ms");
            zzawz.m(sb3.toString());
            throw th;
        }
    }
}
