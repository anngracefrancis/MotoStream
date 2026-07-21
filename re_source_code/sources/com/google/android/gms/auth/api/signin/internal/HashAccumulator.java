package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
public class HashAccumulator {

    @VisibleForTesting
    private static int a = 31;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11526b = 1;

    @KeepForSdk
    public HashAccumulator a(Object obj) {
        this.f11526b = (a * this.f11526b) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    @KeepForSdk
    public int b() {
        return this.f11526b;
    }

    public final HashAccumulator c(boolean z) {
        this.f11526b = (a * this.f11526b) + (z ? 1 : 0);
        return this;
    }
}
