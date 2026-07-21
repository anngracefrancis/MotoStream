package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class s5 extends f7 {
    public s5(zzkc zzkcVar) {
        super(zzkcVar);
    }

    private static String i(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    @Override // com.google.android.gms.measurement.internal.f7
    protected final boolean v() {
        return false;
    }

    public final byte[] w(zzan zzanVar, String str) {
        m7 next;
        zzbr.zzg.zza zzaVar;
        byte[] bArr;
        long j2;
        h hVarA;
        d();
        this.a.s();
        Preconditions.k(zzanVar);
        Preconditions.g(str);
        if (!n().B(str, zzap.p0)) {
            h().O().b("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        }
        if (!"_iap".equals(zzanVar.f18067f) && !"_iapx".equals(zzanVar.f18067f)) {
            h().O().c("Generating a payload for this event is not available. package_name, event_name", str, zzanVar.f18067f);
            return null;
        }
        zzbr.zzf.zza zzaVarF = zzbr.zzf.F();
        q().w0();
        try {
            z3 z3VarJ0 = q().j0(str);
            if (z3VarJ0 == null) {
                h().O().b("Log and bundle not available. package_name", str);
                byte[] bArr2 = new byte[0];
                q().A0();
                return bArr2;
            }
            if (!z3VarJ0.e0()) {
                h().O().b("Log and bundle disabled. package_name", str);
                byte[] bArr3 = new byte[0];
                q().A0();
                return bArr3;
            }
            zzbr.zzg.zza zzaVarI = zzbr.zzg.R0().w(1).I("android");
            if (!TextUtils.isEmpty(z3VarJ0.t())) {
                zzaVarI.m0(z3VarJ0.t());
            }
            if (!TextUtils.isEmpty(z3VarJ0.X())) {
                zzaVarI.h0(z3VarJ0.X());
            }
            if (!TextUtils.isEmpty(z3VarJ0.T())) {
                zzaVarI.r0(z3VarJ0.T());
            }
            if (z3VarJ0.V() != -2147483648L) {
                zzaVarI.t0((int) z3VarJ0.V());
            }
            zzaVarI.l0(z3VarJ0.Z()).E0(z3VarJ0.d0());
            if (!TextUtils.isEmpty(z3VarJ0.A())) {
                zzaVarI.F0(z3VarJ0.A());
            } else if (!TextUtils.isEmpty(z3VarJ0.D())) {
                zzaVarI.P0(z3VarJ0.D());
            }
            zzaVarI.u0(z3VarJ0.b0());
            if (this.a.p() && zzx.X() && n().x(zzaVarI.C0())) {
                zzaVarI.C0();
                if (!TextUtils.isEmpty(null)) {
                    zzaVarI.O0(null);
                }
            }
            Pair<String, Boolean> pairV = m().v(z3VarJ0.t());
            if (z3VarJ0.l() && pairV != null && !TextUtils.isEmpty((CharSequence) pairV.first)) {
                try {
                    zzaVarI.v0(i((String) pairV.first, Long.toString(zzanVar.f18070i)));
                    Object obj = pairV.second;
                    if (obj != null) {
                        zzaVarI.J(((Boolean) obj).booleanValue());
                    }
                } catch (SecurityException e2) {
                    h().O().b("Resettable device id encryption failed", e2.getMessage());
                    byte[] bArr4 = new byte[0];
                    q().A0();
                    return bArr4;
                }
            }
            e().p();
            zzbr.zzg.zza zzaVarV = zzaVarI.V(Build.MODEL);
            e().p();
            zzaVarV.P(Build.VERSION.RELEASE).k0((int) e().v()).a0(e().w());
            try {
                zzaVarI.z0(i(z3VarJ0.x(), Long.toString(zzanVar.f18070i)));
                if (!TextUtils.isEmpty(z3VarJ0.M())) {
                    zzaVarI.H0(z3VarJ0.M());
                }
                String strT = z3VarJ0.t();
                List<m7> listI = q().I(strT);
                Iterator<m7> it = listI.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!"_lte".equals(next.f17873c));
                if (next == null || next.f17875e == null) {
                    m7 m7Var = new m7(strT, "auto", "_lte", j().a(), 0L);
                    listI.add(m7Var);
                    q().T(m7Var);
                }
                if (n().B(strT, zzap.k0)) {
                    zzkg zzkgVarP = p();
                    zzkgVarP.h().P().a("Checking account type status for ad personalization signals");
                    if (zzkgVarP.e().z()) {
                        String strT2 = z3VarJ0.t();
                        if (z3VarJ0.l() && zzkgVarP.r().I(strT2)) {
                            zzkgVarP.h().O().a("Turning off ad personalization due to account type");
                            Iterator<m7> it2 = listI.iterator();
                            while (it2.hasNext()) {
                                if ("_npa".equals(it2.next().f17873c)) {
                                    it2.remove();
                                    break;
                                }
                            }
                            listI.add(new m7(strT2, "auto", "_npa", zzkgVarP.j().a(), 1L));
                        }
                    }
                }
                zzbr.zzk[] zzkVarArr = new zzbr.zzk[listI.size()];
                for (int i2 = 0; i2 < listI.size(); i2++) {
                    zzbr.zzk.zza zzaVarB = zzbr.zzk.X().C(listI.get(i2).f17873c).B(listI.get(i2).f17874d);
                    p().K(zzaVarB, listI.get(i2).f17875e);
                    zzkVarArr[i2] = (zzbr.zzk) ((zzfd) zzaVarB.y());
                }
                zzaVarI.O(Arrays.asList(zzkVarArr));
                Bundle bundleY = zzanVar.f18068g.Y();
                bundleY.putLong("_c", 1L);
                h().O().a("Marking in-app purchase as real-time");
                bundleY.putLong("_r", 1L);
                bundleY.putString("_o", zzanVar.f18069h);
                if (l().v0(zzaVarI.C0())) {
                    l().L(bundleY, "_dbg", 1L);
                    l().L(bundleY, "_r", 1L);
                }
                h hVarD = q().D(str, zzanVar.f18067f);
                if (hVarD == null) {
                    zzaVar = zzaVarI;
                    bArr = null;
                    hVarA = new h(str, zzanVar.f18067f, 0L, 0L, zzanVar.f18070i, 0L, null, null, null, null);
                    j2 = 0;
                } else {
                    zzaVar = zzaVarI;
                    bArr = null;
                    j2 = hVarD.f17788f;
                    hVarA = hVarD.a(zzanVar.f18070i);
                }
                q().N(hVarA);
                zzak zzakVar = new zzak(this.a, zzanVar.f18069h, str, zzanVar.f18067f, zzanVar.f18070i, j2, bundleY);
                zzbr.zzc.zza zzaVarJ = zzbr.zzc.c0().B(zzakVar.f18063d).E(zzakVar.f18061b).J(zzakVar.f18064e);
                for (String str2 : zzakVar.f18065f) {
                    zzbr.zze.zza zzaVarC = zzbr.zze.T().C(str2);
                    p().J(zzaVarC, zzakVar.f18065f.W(str2));
                    zzaVarJ.C(zzaVarC);
                }
                zzbr.zzg.zza zzaVar2 = zzaVar;
                zzaVar2.D(zzaVarJ).E(zzbr.zzh.B().w(zzbr.zzd.B().w(hVarA.f17785c).A(zzanVar.f18067f)));
                zzaVar2.U(o().w(z3VarJ0.t(), Collections.emptyList(), zzaVar2.c0(), Long.valueOf(zzaVarJ.M())));
                if (zzaVarJ.L()) {
                    zzaVar2.N(zzaVarJ.M()).T(zzaVarJ.M());
                }
                long jR = z3VarJ0.R();
                if (jR != 0) {
                    zzaVar2.g0(jR);
                }
                long jP = z3VarJ0.P();
                if (jP != 0) {
                    zzaVar2.X(jP);
                } else if (jR != 0) {
                    zzaVar2.X(jR);
                }
                z3VarJ0.i0();
                zzaVar2.o0((int) z3VarJ0.f0()).q0(n().C()).C(j().a()).Q(true);
                zzaVarF.w(zzaVar2);
                z3VarJ0.a(zzaVar2.j0());
                z3VarJ0.q(zzaVar2.n0());
                q().O(z3VarJ0);
                q().w();
                q().A0();
                try {
                    return p().W(((zzbr.zzf) ((zzfd) zzaVarF.y())).j());
                } catch (IOException e3) {
                    h().H().c("Data loss. Failed to bundle and serialize. appId", zzet.x(str), e3);
                    return bArr;
                }
            } catch (SecurityException e4) {
                h().O().b("app instance id encryption failed", e4.getMessage());
                byte[] bArr5 = new byte[0];
                q().A0();
                return bArr5;
            }
        } catch (Throwable th) {
            q().A0();
            throw th;
        }
    }
}
