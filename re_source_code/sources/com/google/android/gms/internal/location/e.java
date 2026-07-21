package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.zzy;

/* JADX INFO: loaded from: classes2.dex */
final class e extends zzy {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ListenerHolder<LocationListener> f17081f;

    @Override // com.google.android.gms.location.zzx
    public final synchronized void v6(Location location) {
        this.f17081f.c(new f(this, location));
    }
}
