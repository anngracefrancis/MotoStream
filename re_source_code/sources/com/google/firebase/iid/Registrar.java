package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@Keep
@KeepForSdk
public final class Registrar implements ComponentRegistrar {

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.1.0 */
    static class a implements com.google.firebase.iid.w.a {
        final FirebaseInstanceId a;

        public a(FirebaseInstanceId firebaseInstanceId) {
            this.a = firebaseInstanceId;
        }

        @Override // com.google.firebase.iid.w.a
        public String a() {
            return this.a.o();
        }

        @Override // com.google.firebase.iid.w.a
        public Task<String> b() {
            String strO = this.a.o();
            return strO != null ? Tasks.e(strO) : this.a.k().f(q.a);
        }

        @Override // com.google.firebase.iid.w.a
        public void c(com.google.firebase.iid.w.a.InterfaceC0229a interfaceC0229a) {
            this.a.a(interfaceC0229a);
        }
    }

    static final /* synthetic */ FirebaseInstanceId lambda$getComponents$0$Registrar(com.google.firebase.components.p pVar) {
        return new FirebaseInstanceId((com.google.firebase.j) pVar.a(com.google.firebase.j.class), pVar.c(com.google.firebase.u.i.class), pVar.c(com.google.firebase.r.j.class), (com.google.firebase.installations.i) pVar.a(com.google.firebase.installations.i.class));
    }

    static final /* synthetic */ com.google.firebase.iid.w.a lambda$getComponents$1$Registrar(com.google.firebase.components.p pVar) {
        return new a((FirebaseInstanceId) pVar.a(FirebaseInstanceId.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<com.google.firebase.components.n<?>> getComponents() {
        return Arrays.asList(com.google.firebase.components.n.c(FirebaseInstanceId.class).b(com.google.firebase.components.v.k(com.google.firebase.j.class)).b(com.google.firebase.components.v.i(com.google.firebase.u.i.class)).b(com.google.firebase.components.v.i(com.google.firebase.r.j.class)).b(com.google.firebase.components.v.k(com.google.firebase.installations.i.class)).f(o.a).c().d(), com.google.firebase.components.n.c(com.google.firebase.iid.w.a.class).b(com.google.firebase.components.v.k(FirebaseInstanceId.class)).f(p.a).d(), com.google.firebase.u.h.a("fire-iid", "21.1.0"));
    }
}
