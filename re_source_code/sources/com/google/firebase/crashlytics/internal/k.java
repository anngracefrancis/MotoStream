package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.o.l;
import com.google.firebase.s.a;
import com.google.firebase.s.b;

/* JADX INFO: compiled from: RemoteConfigDeferredProxy.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {
    private final a<com.google.firebase.v.a.a> a;

    public k(a<com.google.firebase.v.a.a> aVar) {
        this.a = aVar;
    }

    static /* synthetic */ void a(CrashlyticsRemoteConfigListener crashlyticsRemoteConfigListener, b bVar) {
        ((com.google.firebase.v.a.a) bVar.get()).a("firebase", crashlyticsRemoteConfigListener);
        h.f().b("Registering RemoteConfig Rollouts subscriber");
    }

    public void b(l lVar) {
        if (lVar == null) {
            h.f().k("Didn't successfully register with UserMetadata for rollouts listener");
        } else {
            final CrashlyticsRemoteConfigListener crashlyticsRemoteConfigListener = new CrashlyticsRemoteConfigListener(lVar);
            this.a.a(new a.InterfaceC0234a() { // from class: com.google.firebase.crashlytics.h.c
                @Override // com.google.firebase.s.a.InterfaceC0234a
                public final void a(b bVar) {
                    k.a(crashlyticsRemoteConfigListener, bVar);
                }
            });
        }
    }
}
