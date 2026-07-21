package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: loaded from: classes2.dex */
final class k extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ BaseGmsClient.ConnectionProgressReportCallbacks f11765b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    k(i iVar, zabd zabdVar, BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        super(zabdVar);
        this.f11765b = connectionProgressReportCallbacks;
    }

    @Override // com.google.android.gms.common.api.internal.w
    public final void a() {
        this.f11765b.a(new ConnectionResult(16, null));
    }
}
