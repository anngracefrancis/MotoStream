package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class n1 implements Comparator<zzdu> {
    n1() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzdu zzduVar, zzdu zzduVar2) {
        zzdu zzduVar3 = zzduVar;
        zzdu zzduVar4 = zzduVar2;
        zzed zzedVar = (zzed) zzduVar3.iterator();
        zzed zzedVar2 = (zzed) zzduVar4.iterator();
        while (zzedVar.hasNext() && zzedVar2.hasNext()) {
            int iA = androidx.datastore.preferences.protobuf.i.a(zzdu.u(zzedVar.a()), zzdu.u(zzedVar2.a()));
            if (iA != 0) {
                return iA;
            }
        }
        return androidx.datastore.preferences.protobuf.i.a(zzduVar3.f(), zzduVar4.f());
    }
}
