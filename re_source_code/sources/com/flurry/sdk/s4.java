package com.flurry.sdk;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public final class s4 implements f7<r> {
    s4() {
    }

    @Override // com.flurry.sdk.f7
    public final /* synthetic */ void a(r rVar) {
        r rVar2 = rVar;
        String str = rVar2.a;
        String str2 = rVar2.f11028b;
        if ((str == null || str.isEmpty()) && (str2 == null || str2.isEmpty())) {
            d1.c(2, "LocaleFrame", "Locale is empty, do not send the frame.");
        } else {
            m2.a().b(new y3(new z3(str, str2)));
        }
        d1.c(4, "LocaleObserver", "Locale language: " + rVar2.a + ". Locale country: " + rVar2.f11028b);
    }
}
