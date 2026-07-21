package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzhw extends RuntimeException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<String> f17428f;

    public zzhw(zzgo zzgoVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f17428f = null;
    }
}
