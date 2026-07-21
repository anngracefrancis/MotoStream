package com.google.firebase.crashlytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: AnalyticsDeferredProxy.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    private final com.google.firebase.s.a<com.google.firebase.analytics.a.a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile com.google.firebase.crashlytics.internal.l.a f18987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile com.google.firebase.crashlytics.internal.m.b f18988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<com.google.firebase.crashlytics.internal.m.a> f18989d;

    public e(com.google.firebase.s.a<com.google.firebase.analytics.a.a> aVar) {
        this(aVar, new com.google.firebase.crashlytics.internal.m.c(), new com.google.firebase.crashlytics.internal.l.f());
    }

    private void c() {
        this.a.a(new com.google.firebase.s.a.InterfaceC0234a() { // from class: com.google.firebase.crashlytics.a
            @Override // com.google.firebase.s.a.InterfaceC0234a
            public final void a(com.google.firebase.s.b bVar) {
                this.a.i(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(String str, Bundle bundle) {
        this.f18987b.a(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(com.google.firebase.crashlytics.internal.m.a aVar) {
        synchronized (this) {
            if (this.f18988c instanceof com.google.firebase.crashlytics.internal.m.c) {
                this.f18989d.add(aVar);
            }
            this.f18988c.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(com.google.firebase.s.b bVar) {
        h.f().b("AnalyticsConnector now available.");
        com.google.firebase.analytics.a.a aVar = (com.google.firebase.analytics.a.a) bVar.get();
        com.google.firebase.crashlytics.internal.l.e eVar = new com.google.firebase.crashlytics.internal.l.e(aVar);
        f fVar = new f();
        if (j(aVar, fVar) == null) {
            h.f().k("Could not register Firebase Analytics listener; a listener is already registered.");
            return;
        }
        h.f().b("Registered Firebase Analytics listener.");
        com.google.firebase.crashlytics.internal.l.d dVar = new com.google.firebase.crashlytics.internal.l.d();
        com.google.firebase.crashlytics.internal.l.c cVar = new com.google.firebase.crashlytics.internal.l.c(eVar, 500, TimeUnit.MILLISECONDS);
        synchronized (this) {
            Iterator<com.google.firebase.crashlytics.internal.m.a> it = this.f18989d.iterator();
            while (it.hasNext()) {
                dVar.a(it.next());
            }
            fVar.d(dVar);
            fVar.e(cVar);
            this.f18988c = dVar;
            this.f18987b = cVar;
        }
    }

    private static com.google.firebase.analytics.a.a.InterfaceC0205a j(com.google.firebase.analytics.a.a aVar, f fVar) {
        com.google.firebase.analytics.a.a.InterfaceC0205a interfaceC0205aB = aVar.b("clx", fVar);
        if (interfaceC0205aB == null) {
            h.f().b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            interfaceC0205aB = aVar.b("crash", fVar);
            if (interfaceC0205aB != null) {
                h.f().k("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return interfaceC0205aB;
    }

    public com.google.firebase.crashlytics.internal.l.a a() {
        return new com.google.firebase.crashlytics.internal.l.a() { // from class: com.google.firebase.crashlytics.b
            @Override // com.google.firebase.crashlytics.internal.l.a
            public final void a(String str, Bundle bundle) {
                this.a.e(str, bundle);
            }
        };
    }

    public com.google.firebase.crashlytics.internal.m.b b() {
        return new com.google.firebase.crashlytics.internal.m.b() { // from class: com.google.firebase.crashlytics.c
            @Override // com.google.firebase.crashlytics.internal.m.b
            public final void a(com.google.firebase.crashlytics.internal.m.a aVar) {
                this.a.g(aVar);
            }
        };
    }

    public e(com.google.firebase.s.a<com.google.firebase.analytics.a.a> aVar, com.google.firebase.crashlytics.internal.m.b bVar, com.google.firebase.crashlytics.internal.l.a aVar2) {
        this.a = aVar;
        this.f18988c = bVar;
        this.f18989d = new ArrayList();
        this.f18987b = aVar2;
        c();
    }
}
