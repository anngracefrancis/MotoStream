package com.flurry.sdk;

/* JADX INFO: loaded from: classes2.dex */
public final class y4 implements f7<c0> {
    @Override // com.flurry.sdk.f7
    public final /* synthetic */ void a(c0 c0Var) {
        c0 c0Var2 = c0Var;
        if (c0Var2 == null) {
            d1.c(2, "ReportingFrame", "Reporting data is null, do not send the frame.");
        } else {
            m2.a().b(new e4(new f4(c0Var2)));
        }
    }
}
