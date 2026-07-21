package com.google.firebase.crashlytics;

import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.n;
import com.google.firebase.components.p;
import com.google.firebase.components.r;
import com.google.firebase.components.v;
import com.google.firebase.installations.i;
import com.google.firebase.j;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.u.h;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {
    static {
        FirebaseSessionsDependencies.a(SessionSubscriber.a.CRASHLYTICS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g a(p pVar) {
        return g.a((j) pVar.a(j.class), (i) pVar.a(i.class), pVar.i(com.google.firebase.crashlytics.internal.d.class), pVar.i(com.google.firebase.analytics.a.a.class), pVar.i(com.google.firebase.v.a.a.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<n<?>> getComponents() {
        return Arrays.asList(n.c(g.class).h("fire-cls").b(v.k(j.class)).b(v.k(i.class)).b(v.a(com.google.firebase.crashlytics.internal.d.class)).b(v.a(com.google.firebase.analytics.a.a.class)).b(v.a(com.google.firebase.v.a.a.class)).f(new r() { // from class: com.google.firebase.crashlytics.d
            @Override // com.google.firebase.components.r
            public final Object a(p pVar) {
                return this.a.a(pVar);
            }
        }).e().d(), h.a("fire-cls", "18.6.1"));
    }
}
