package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
final class b implements PendingResult.StatusListener {
    private final /* synthetic */ BasePendingResult a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zaab f11743b;

    b(zaab zaabVar, BasePendingResult basePendingResult) {
        this.f11743b = zaabVar;
        this.a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void a(Status status) {
        this.f11743b.a.remove(this.a);
    }
}
