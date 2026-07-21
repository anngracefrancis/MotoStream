package com.flurry.sdk;

import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public final class v4 implements f7<x> {
    private String a;

    v4() {
    }

    @Override // com.flurry.sdk.f7
    public final /* synthetic */ void a(x xVar) {
        x xVar2 = xVar;
        String str = xVar2.a;
        boolean z = xVar2.f11134b;
        if (str == null || str.equals(this.a) || !z) {
            return;
        }
        g0.a();
        g0.f("Log Notification Frame", Collections.emptyMap());
        this.a = str;
        m2.a().b(new z5(new a6(str, z)));
    }
}
