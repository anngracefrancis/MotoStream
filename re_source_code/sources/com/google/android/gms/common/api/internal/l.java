package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
final class l extends p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayList<Api.Client> f11768g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zaak f11769h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(zaak zaakVar, ArrayList<Api.Client> arrayList) {
        super(zaakVar, null);
        this.f11769h = zaakVar;
        this.f11768g = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.p
    public final void a() {
        this.f11769h.a.s.q = this.f11769h.n();
        ArrayList<Api.Client> arrayList = this.f11768g;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Api.Client client = arrayList.get(i2);
            i2++;
            client.getRemoteService(this.f11769h.o, this.f11769h.a.s.q);
        }
    }
}
