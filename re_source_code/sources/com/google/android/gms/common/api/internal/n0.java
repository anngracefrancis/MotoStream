package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
final class n0 {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConnectionResult f11774b;

    n0(ConnectionResult connectionResult, int i2) {
        Preconditions.k(connectionResult);
        this.f11774b = connectionResult;
        this.a = i2;
    }

    final ConnectionResult a() {
        return this.f11774b;
    }

    final int b() {
        return this.a;
    }
}
