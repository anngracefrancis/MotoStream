package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class c3 implements a3 {
    c3() {
    }

    @Override // com.google.android.gms.internal.measurement.a3
    public final Map<?, ?> b(Object obj) {
        return (zzgi) obj;
    }

    @Override // com.google.android.gms.internal.measurement.a3
    public final Map<?, ?> c(Object obj) {
        return (zzgi) obj;
    }

    @Override // com.google.android.gms.internal.measurement.a3
    public final Object d(Object obj) {
        return zzgi.d().f();
    }

    @Override // com.google.android.gms.internal.measurement.a3
    public final Object e(Object obj) {
        ((zzgi) obj).h();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.a3
    public final boolean f(Object obj) {
        return !((zzgi) obj).i();
    }

    @Override // com.google.android.gms.internal.measurement.a3
    public final Object g(Object obj, Object obj2) {
        zzgi zzgiVarF = (zzgi) obj;
        zzgi zzgiVar = (zzgi) obj2;
        if (!zzgiVar.isEmpty()) {
            if (!zzgiVarF.i()) {
                zzgiVarF = zzgiVarF.f();
            }
            zzgiVarF.e(zzgiVar);
        }
        return zzgiVarF;
    }

    @Override // com.google.android.gms.internal.measurement.a3
    public final int h(int i2, Object obj, Object obj2) {
        zzgi zzgiVar = (zzgi) obj;
        if (zzgiVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzgiVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.a3
    public final z2<?, ?> zzf(Object obj) {
        throw new NoSuchMethodError();
    }
}
