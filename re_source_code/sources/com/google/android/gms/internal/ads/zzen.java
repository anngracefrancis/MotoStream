package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class zzen extends zzfk {
    private static final zzfl<zzch> n = new zzfl<>();
    private final Context o;
    private zzbk.zza p;

    public zzen(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3, Context context, zzbk.zza zzaVar) {
        super(zzdyVar, str, str2, c0176zza, i2, 27);
        this.p = null;
        this.o = context;
        this.p = zzaVar;
    }

    private static String c(zzbk.zza zzaVar) {
        if (zzaVar == null || !zzaVar.A() || zzef.f(zzaVar.B().x())) {
            return null;
        }
        return zzaVar.B().x();
    }

    private final String d() {
        try {
            if (this.f16221g.A() != null) {
                this.f16221g.A().get();
            }
            zzbp.zza zzaVarZ = this.f16221g.z();
            if (zzaVarZ == null || !zzaVarZ.d0()) {
                return null;
            }
            return zzaVarZ.U();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        zzch zzchVar;
        zzbm zzbmVar;
        AtomicReference<zzch> atomicReferenceA = n.a(this.o.getPackageName());
        synchronized (atomicReferenceA) {
            zzch zzchVar2 = atomicReferenceA.get();
            if (zzchVar2 == null || zzef.f(zzchVar2.f15228b) || zzchVar2.f15228b.equals("E") || zzchVar2.f15228b.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                if (zzef.f(c(this.p))) {
                    zzbk.zza zzaVar = this.p;
                    zzbmVar = (Boolean.valueOf(zzef.f(c(zzaVar)) && zzaVar != null && zzaVar.y() && zzaVar.z().z() == zzbm.ENUM_SIGNAL_SOURCE_GASS).booleanValue() && this.f16221g.x()) ? zzbm.ENUM_SIGNAL_SOURCE_GASS : zzbm.ENUM_SIGNAL_SOURCE_ADSHIELD;
                } else {
                    zzbmVar = zzbm.ENUM_SIGNAL_SOURCE_CALLER_PROVIDED;
                }
                Method method = this.f16225k;
                Object[] objArr = new Object[3];
                objArr[0] = this.o;
                objArr[1] = Boolean.valueOf(zzbmVar == zzbm.ENUM_SIGNAL_SOURCE_ADSHIELD);
                objArr[2] = zzyt.e().c(zzacu.q2);
                zzch zzchVar3 = new zzch((String) method.invoke(null, objArr));
                if (zzef.f(zzchVar3.f15228b) || zzchVar3.f15228b.equals("E")) {
                    int i2 = ty.a[zzbmVar.ordinal()];
                    if (i2 == 1) {
                        zzchVar3.f15228b = this.p.B().x();
                    } else if (i2 == 2) {
                        String strD = d();
                        if (!zzef.f(strD)) {
                            zzchVar3.f15228b = strD;
                        }
                    }
                }
                atomicReferenceA.set(zzchVar3);
            }
            zzchVar = atomicReferenceA.get();
        }
        synchronized (this.f16224j) {
            if (zzchVar != null) {
                this.f16224j.C0(zzchVar.f15228b);
                this.f16224j.Z(zzchVar.f15229c);
                this.f16224j.v(zzchVar.f15230d);
                this.f16224j.w(zzchVar.f15231e);
                this.f16224j.A(zzchVar.f15232f);
            }
        }
    }
}
