package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* JADX INFO: loaded from: classes2.dex */
final class h<R, T> implements PendingResultUtil.ResultConverter<R, T> {
    private final /* synthetic */ Response a;

    h(Response response) {
        this.a = response;
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ Object a(Result result) {
        this.a.g(result);
        return this.a;
    }
}
