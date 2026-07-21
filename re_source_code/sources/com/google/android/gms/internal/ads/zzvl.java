package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class zzvl implements Comparator<zzuz> {
    public zzvl(zzvk zzvkVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzuz zzuzVar, zzuz zzuzVar2) {
        zzuz zzuzVar3 = zzuzVar;
        zzuz zzuzVar4 = zzuzVar2;
        if (zzuzVar3.b() < zzuzVar4.b()) {
            return -1;
        }
        if (zzuzVar3.b() > zzuzVar4.b()) {
            return 1;
        }
        if (zzuzVar3.a() < zzuzVar4.a()) {
            return -1;
        }
        if (zzuzVar3.a() > zzuzVar4.a()) {
            return 1;
        }
        float fD = (zzuzVar3.d() - zzuzVar3.b()) * (zzuzVar3.c() - zzuzVar3.a());
        float fD2 = (zzuzVar4.d() - zzuzVar4.b()) * (zzuzVar4.c() - zzuzVar4.a());
        if (fD > fD2) {
            return -1;
        }
        return fD < fD2 ? 1 : 0;
    }
}
