package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzv;

/* JADX INFO: loaded from: classes2.dex */
final class a extends zzv {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ListenerHolder<LocationCallback> f17080f;

    @Override // com.google.android.gms.location.zzu
    public final void P3(LocationAvailability locationAvailability) {
        this.f17080f.c(new c(this, locationAvailability));
    }

    @Override // com.google.android.gms.location.zzu
    public final void W4(LocationResult locationResult) {
        this.f17080f.c(new b(this, locationResult));
    }
}
