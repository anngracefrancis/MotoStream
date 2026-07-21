package com.flurry.sdk;

/* JADX INFO: loaded from: classes2.dex */
public final class o4 implements f7<e.d.a.a> {
    @Override // com.flurry.sdk.f7
    public final /* synthetic */ void a(e.d.a.a aVar) {
        e.d.a.a aVar2 = aVar;
        if (aVar2 == null) {
            d1.n("ConsentFrame", "Consent is null, do not send the frame.");
        } else {
            m2.a().b(new l5(new m5(aVar2.b(), aVar2.a())));
        }
    }
}
