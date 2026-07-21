package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class i extends p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<Api.Client, h> f11761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ zaak f11762h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(zaak zaakVar, Map<Api.Client, h> map) {
        super(zaakVar, null);
        this.f11762h = zaakVar;
        this.f11761g = map;
    }

    @Override // com.google.android.gms.common.api.internal.p
    public final void a() {
        GoogleApiAvailabilityCache googleApiAvailabilityCache = new GoogleApiAvailabilityCache(this.f11762h.f11807d);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client client : this.f11761g.keySet()) {
            if (!client.requiresGooglePlayServices() || this.f11761g.get(client).f11758c) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        int iB = -1;
        int i2 = 0;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                iB = googleApiAvailabilityCache.b(this.f11762h.f11806c, (Api.Client) obj);
                if (iB != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i2 < size2) {
                Object obj2 = arrayList2.get(i2);
                i2++;
                iB = googleApiAvailabilityCache.b(this.f11762h.f11806c, (Api.Client) obj2);
                if (iB == 0) {
                    break;
                }
            }
        }
        if (iB != 0) {
            this.f11762h.a.h(new j(this, this.f11762h, new ConnectionResult(iB, null)));
            return;
        }
        if (this.f11762h.m && this.f11762h.f11814k != null) {
            this.f11762h.f11814k.a();
        }
        for (Api.Client client2 : this.f11761g.keySet()) {
            h hVar = this.f11761g.get(client2);
            if (!client2.requiresGooglePlayServices() || googleApiAvailabilityCache.b(this.f11762h.f11806c, client2) == 0) {
                client2.connect(hVar);
            } else {
                this.f11762h.a.h(new k(this, this.f11762h, hVar));
            }
        }
    }
}
