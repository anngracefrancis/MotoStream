package com.google.android.gms.common.api.internal;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
final class t implements ResultCallback<Status> {
    private final /* synthetic */ StatusPendingResult a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ boolean f11791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ GoogleApiClient f11792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zaaw f11793d;

    t(zaaw zaawVar, StatusPendingResult statusPendingResult, boolean z, GoogleApiClient googleApiClient) {
        this.f11793d = zaawVar;
        this.a = statusPendingResult;
        this.f11791b = z;
        this.f11792c = googleApiClient;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* synthetic */ void a(Result result) {
        Status status = (Status) result;
        Storage.b(this.f11793d.f11820g).l();
        if (status.e0() && this.f11793d.p()) {
            this.f11793d.s();
        }
        this.a.k(status);
        if (this.f11791b) {
            this.f11792c.h();
        }
    }
}
