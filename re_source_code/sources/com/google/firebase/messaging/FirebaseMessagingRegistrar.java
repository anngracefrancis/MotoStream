package com.google.firebase.messaging;

import androidx.annotation.Keep;
import cm.aptoide.pt.networking.BodyInterceptorV3;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@Keep
@KeepForSdk
public class FirebaseMessagingRegistrar implements ComponentRegistrar {

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    private static class b<T> implements e.e.b.a.f<T> {
        private b() {
        }

        @Override // e.e.b.a.f
        public void a(e.e.b.a.c<T> cVar) {
        }

        @Override // e.e.b.a.f
        public void b(e.e.b.a.c<T> cVar, e.e.b.a.h hVar) {
            hVar.a(null);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    public static class c implements e.e.b.a.g {
        @Override // e.e.b.a.g
        public <T> e.e.b.a.f<T> a(String str, Class<T> cls, e.e.b.a.b bVar, e.e.b.a.e<T, byte[]> eVar) {
            return new b();
        }
    }

    static e.e.b.a.g determineFactory(e.e.b.a.g gVar) {
        if (gVar == null) {
            return new c();
        }
        try {
            gVar.a("test", String.class, e.e.b.a.b.b(BodyInterceptorV3.RESPONSE_MODE_JSON), x.a);
            return gVar;
        } catch (IllegalArgumentException unused) {
            return new c();
        }
    }

    static final /* synthetic */ FirebaseMessaging lambda$getComponents$0$FirebaseMessagingRegistrar(com.google.firebase.components.p pVar) {
        return new FirebaseMessaging((com.google.firebase.j) pVar.a(com.google.firebase.j.class), (com.google.firebase.iid.w.a) pVar.a(com.google.firebase.iid.w.a.class), pVar.c(com.google.firebase.u.i.class), pVar.c(com.google.firebase.r.j.class), (com.google.firebase.installations.i) pVar.a(com.google.firebase.installations.i.class), determineFactory((e.e.b.a.g) pVar.a(e.e.b.a.g.class)), (com.google.firebase.q.d) pVar.a(com.google.firebase.q.d.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<com.google.firebase.components.n<?>> getComponents() {
        return Arrays.asList(com.google.firebase.components.n.c(FirebaseMessaging.class).b(com.google.firebase.components.v.k(com.google.firebase.j.class)).b(com.google.firebase.components.v.h(com.google.firebase.iid.w.a.class)).b(com.google.firebase.components.v.i(com.google.firebase.u.i.class)).b(com.google.firebase.components.v.i(com.google.firebase.r.j.class)).b(com.google.firebase.components.v.h(e.e.b.a.g.class)).b(com.google.firebase.components.v.k(com.google.firebase.installations.i.class)).b(com.google.firebase.components.v.k(com.google.firebase.q.d.class)).f(w.a).c().d(), com.google.firebase.u.h.a("fire-fcm", "20.1.7_1p"));
    }
}
