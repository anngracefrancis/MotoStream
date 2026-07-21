package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.l0;

/* JADX INFO: compiled from: GetTokenClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s extends l0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(Context context, LoginClient.Request request) {
        super(context, 65536, 65537, 20121101, request.a(), request.m());
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(request, "request");
    }

    @Override // com.facebook.internal.l0
    protected void e(Bundle bundle) {
        kotlin.jvm.internal.m.f(bundle, "data");
    }
}
