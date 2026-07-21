package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbrt extends zzbts<zzbrw> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f14717g;

    public zzbrt(Set<zzbuz<zzbrw>> set) {
        super(set);
        this.f14717g = false;
    }

    public final synchronized void Y() {
        if (!this.f14717g) {
            T(td.a);
            this.f14717g = true;
        }
    }
}
