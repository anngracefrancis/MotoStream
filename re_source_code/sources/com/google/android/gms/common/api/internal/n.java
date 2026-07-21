package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes2.dex */
final class n extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zaak f11772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.signin.internal.zaj f11773c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    n(m mVar, zabd zabdVar, zaak zaakVar, com.google.android.gms.signin.internal.zaj zajVar) {
        super(zabdVar);
        this.f11772b = zaakVar;
        this.f11773c = zajVar;
    }

    @Override // com.google.android.gms.common.api.internal.w
    public final void a() {
        this.f11772b.g(this.f11773c);
    }
}
