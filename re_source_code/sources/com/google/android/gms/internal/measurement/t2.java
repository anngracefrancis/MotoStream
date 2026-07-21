package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class t2 extends s2 {
    private t2() {
        super();
    }

    private static <E> zzfl<E> f(Object obj, long j2) {
        return (zzfl) k4.F(obj, j2);
    }

    @Override // com.google.android.gms.internal.measurement.s2
    final <L> List<L> b(Object obj, long j2) {
        zzfl zzflVarF = f(obj, j2);
        if (zzflVarF.a()) {
            return zzflVarF;
        }
        int size = zzflVarF.size();
        zzfl zzflVarD = zzflVarF.d(size == 0 ? 10 : size << 1);
        k4.j(obj, j2, zzflVarD);
        return zzflVarD;
    }

    @Override // com.google.android.gms.internal.measurement.s2
    final <E> void c(Object obj, Object obj2, long j2) {
        zzfl zzflVarF = f(obj, j2);
        zzfl zzflVarF2 = f(obj2, j2);
        int size = zzflVarF.size();
        int size2 = zzflVarF2.size();
        if (size > 0 && size2 > 0) {
            if (!zzflVarF.a()) {
                zzflVarF = zzflVarF.d(size2 + size);
            }
            zzflVarF.addAll(zzflVarF2);
        }
        if (size > 0) {
            zzflVarF2 = zzflVarF;
        }
        k4.j(obj, j2, zzflVarF2);
    }

    @Override // com.google.android.gms.internal.measurement.s2
    final void e(Object obj, long j2) {
        f(obj, j2).I();
    }
}
