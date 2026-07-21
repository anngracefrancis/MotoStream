package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final class eu implements Comparator<zzdmr> {
    eu() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzdmr zzdmrVar, zzdmr zzdmrVar2) {
        zzdmr zzdmrVar3 = zzdmrVar;
        zzdmr zzdmrVar4 = zzdmrVar2;
        zzdmy zzdmyVar = (zzdmy) zzdmrVar3.iterator();
        zzdmy zzdmyVar2 = (zzdmy) zzdmrVar4.iterator();
        while (zzdmyVar.hasNext() && zzdmyVar2.hasNext()) {
            int iA = androidx.datastore.preferences.protobuf.i.a(zzdmr.s(zzdmyVar.f()), zzdmr.s(zzdmyVar2.f()));
            if (iA != 0) {
                return iA;
            }
        }
        return androidx.datastore.preferences.protobuf.i.a(zzdmrVar3.size(), zzdmrVar4.size());
    }
}
