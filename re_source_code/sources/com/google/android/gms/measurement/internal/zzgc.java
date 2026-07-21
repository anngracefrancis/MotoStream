package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzgc extends zzeo {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzkc f18163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Boolean f18164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f18165h;

    public zzgc(zzkc zzkcVar) {
        this(zzkcVar, null);
    }

    private final void E0(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.f18163f.h().H().a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.f18164g == null) {
                    this.f18164g = Boolean.valueOf("com.google.android.gms".equals(this.f18165h) || UidVerifier.a(this.f18163f.f(), Binder.getCallingUid()) || GoogleSignatureVerifier.a(this.f18163f.f()).c(Binder.getCallingUid()));
                }
                if (this.f18164g.booleanValue()) {
                    return;
                }
            } catch (SecurityException e2) {
                this.f18163f.h().H().b("Measurement Service called with invalid calling package. appId", zzet.x(str));
                throw e2;
            }
        }
        if (this.f18165h == null && GooglePlayServicesUtilLight.uidHasPackageName(this.f18163f.f(), Binder.getCallingUid(), str)) {
            this.f18165h = str;
        }
        if (str.equals(this.f18165h)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    private final void V3(zzm zzmVar, boolean z) {
        Preconditions.k(zzmVar);
        E0(zzmVar.f18234f, false);
        this.f18163f.b0().r0(zzmVar.f18235g, zzmVar.w);
    }

    @VisibleForTesting
    private final void k0(Runnable runnable) {
        Preconditions.k(runnable);
        if (this.f18163f.g().I()) {
            runnable.run();
        } else {
            this.f18163f.g().z(runnable);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzv> A2(String str, String str2, zzm zzmVar) {
        V3(zzmVar, false);
        try {
            return (List) this.f18163f.g().w(new e4(this, zzmVar, str, str2)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.f18163f.h().H().b("Failed to get conditional user properties", e2);
            return Collections.emptyList();
        }
    }

    @VisibleForTesting
    final zzan E3(zzan zzanVar, zzm zzmVar) {
        zzam zzamVar;
        boolean z = false;
        if ("_cmp".equals(zzanVar.f18067f) && (zzamVar = zzanVar.f18068g) != null && zzamVar.y() != 0) {
            String strP0 = zzanVar.f18068g.p0("_cis");
            if (!TextUtils.isEmpty(strP0) && (("referrer broadcast".equals(strP0) || "referrer API".equals(strP0)) && this.f18163f.J().M(zzmVar.f18234f))) {
                z = true;
            }
        }
        if (!z) {
            return zzanVar;
        }
        this.f18163f.h().N().b("Event has been filtered ", zzanVar.toString());
        return new zzan("_cmpx", zzanVar.f18068g, zzanVar.f18069h, zzanVar.f18070i);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzkj> I1(zzm zzmVar, boolean z) {
        V3(zzmVar, false);
        try {
            List<m7> list = (List) this.f18163f.g().w(new n4(this, zzmVar)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (m7 m7Var : list) {
                if (z || !zzkk.u0(m7Var.f17873c)) {
                    arrayList.add(new zzkj(m7Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f18163f.h().H().c("Failed to get user attributes. appId", zzet.x(zzmVar.f18234f), e2);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzkj> K1(String str, String str2, String str3, boolean z) {
        E0(str, true);
        try {
            List<m7> list = (List) this.f18163f.g().w(new f4(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (m7 m7Var : list) {
                if (z || !zzkk.u0(m7Var.f17873c)) {
                    arrayList.add(new zzkj(m7Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f18163f.h().H().c("Failed to get user attributes. appId", zzet.x(str), e2);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final String P4(zzm zzmVar) {
        V3(zzmVar, false);
        return this.f18163f.V(zzmVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void R6(zzv zzvVar) {
        Preconditions.k(zzvVar);
        Preconditions.k(zzvVar.f18242h);
        E0(zzvVar.f18240f, true);
        k0(new d4(this, new zzv(zzvVar)));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final byte[] T1(zzan zzanVar, String str) {
        Preconditions.g(str);
        Preconditions.k(zzanVar);
        E0(str, true);
        this.f18163f.h().O().b("Log and bundle. event", this.f18163f.a0().y(zzanVar.f18067f));
        long jNanoTime = this.f18163f.j().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f18163f.g().B(new l4(this, zzanVar, str)).get();
            if (bArr == null) {
                this.f18163f.h().H().b("Log and bundle returned null. appId", zzet.x(str));
                bArr = new byte[0];
            }
            this.f18163f.h().O().d("Log and bundle processed. event, size, time_ms", this.f18163f.a0().y(zzanVar.f18067f), Integer.valueOf(bArr.length), Long.valueOf((this.f18163f.j().nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e2) {
            this.f18163f.h().H().d("Failed to log and bundle. appId, event, error", zzet.x(str), this.f18163f.a0().y(zzanVar.f18067f), e2);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void U3(zzm zzmVar) {
        V3(zzmVar, false);
        k0(new b4(this, zzmVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void Z5(zzan zzanVar, zzm zzmVar) {
        Preconditions.k(zzanVar);
        V3(zzmVar, false);
        k0(new j4(this, zzanVar, zzmVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void b4(zzkj zzkjVar, zzm zzmVar) {
        Preconditions.k(zzkjVar);
        V3(zzmVar, false);
        k0(new k4(this, zzkjVar, zzmVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzkj> f3(String str, String str2, boolean z, zzm zzmVar) {
        V3(zzmVar, false);
        try {
            List<m7> list = (List) this.f18163f.g().w(new c4(this, zzmVar, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (m7 m7Var : list) {
                if (z || !zzkk.u0(m7Var.f17873c)) {
                    arrayList.add(new zzkj(m7Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f18163f.h().H().c("Failed to get user attributes. appId", zzet.x(zzmVar.f18234f), e2);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void h2(zzv zzvVar, zzm zzmVar) {
        Preconditions.k(zzvVar);
        Preconditions.k(zzvVar.f18242h);
        V3(zzmVar, false);
        zzv zzvVar2 = new zzv(zzvVar);
        zzvVar2.f18240f = zzmVar.f18234f;
        k0(new o4(this, zzvVar2, zzmVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void j3(long j2, String str, String str2, String str3) {
        k0(new p4(this, str2, str3, str, j2));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void j6(zzan zzanVar, String str, String str2) {
        Preconditions.k(zzanVar);
        Preconditions.g(str);
        E0(str, true);
        k0(new i4(this, zzanVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void r2(zzm zzmVar) {
        E0(zzmVar.f18234f, false);
        k0(new g4(this, zzmVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzv> r3(String str, String str2, String str3) {
        E0(str, true);
        try {
            return (List) this.f18163f.g().w(new h4(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.f18163f.h().H().b("Failed to get conditional user properties", e2);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void s6(zzm zzmVar) {
        V3(zzmVar, false);
        k0(new m4(this, zzmVar));
    }

    private zzgc(zzkc zzkcVar, String str) {
        Preconditions.k(zzkcVar);
        this.f18163f = zzkcVar;
        this.f18165h = null;
    }
}
