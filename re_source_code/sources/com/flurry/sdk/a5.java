package com.flurry.sdk;

/* JADX INFO: loaded from: classes2.dex */
public final class a5 implements f7<h0> {
    @Override // com.flurry.sdk.f7
    public final /* synthetic */ void a(h0 h0Var) {
        h0 h0Var2 = h0Var;
        d1.c(3, "SessionPropertyObserver", "Log session property frame");
        if (h0Var2 == null) {
            d1.c(2, "SessionPropertiesFrame", "Session property data is null, do not send the frame.");
        } else {
            m2.a().b(new i4(new j4(i4.h(h0Var2))));
        }
    }
}
