package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final class s40 implements Comparator<zzvi> {
    s40(zzvb zzvbVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzvi zzviVar, zzvi zzviVar2) {
        zzvi zzviVar3 = zzviVar;
        zzvi zzviVar4 = zzviVar2;
        int i2 = zzviVar3.f16847c - zzviVar4.f16847c;
        return i2 != 0 ? i2 : (int) (zzviVar3.a - zzviVar4.a);
    }
}
