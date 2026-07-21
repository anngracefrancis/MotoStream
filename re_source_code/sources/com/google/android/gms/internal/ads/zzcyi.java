package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcyi implements zzaws, zzbro {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet<zzawj> f15771f = new HashSet<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f15772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzawu f15773h;

    public zzcyi(Context context, zzawu zzawuVar) {
        this.f15772g = context;
        this.f15773h = zzawuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaws
    public final synchronized void a(HashSet<zzawj> hashSet) {
        this.f15771f.clear();
        this.f15771f.addAll(hashSet);
    }

    public final Bundle b() {
        return this.f15773h.b(this.f15772g, this);
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final synchronized void onAdFailedToLoad(int i2) {
        if (i2 != 3) {
            this.f15773h.f(this.f15771f);
        }
    }
}
