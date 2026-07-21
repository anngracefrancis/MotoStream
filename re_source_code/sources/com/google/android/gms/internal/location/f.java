package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationListener;

/* JADX INFO: loaded from: classes2.dex */
final class f implements ListenerHolder.Notifier<LocationListener> {
    private final /* synthetic */ Location a;

    f(e eVar, Location location) {
        this.a = location;
    }
}
