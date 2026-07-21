package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;

/* JADX INFO: loaded from: classes2.dex */
final class c implements ListenerHolder.Notifier<LocationCallback> {
    private final /* synthetic */ LocationAvailability a;

    c(a aVar, LocationAvailability locationAvailability) {
        this.a = locationAvailability;
    }
}
