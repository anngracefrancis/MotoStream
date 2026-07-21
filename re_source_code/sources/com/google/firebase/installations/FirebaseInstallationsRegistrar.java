package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.b0;
import com.google.firebase.components.p;
import com.google.firebase.components.r;
import com.google.firebase.components.v;
import com.google.firebase.concurrent.y;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    static /* synthetic */ i lambda$getComponents$0(p pVar) {
        return new h((com.google.firebase.j) pVar.a(com.google.firebase.j.class), pVar.c(com.google.firebase.r.i.class), (ExecutorService) pVar.f(b0.a(com.google.firebase.o.a.a.class, ExecutorService.class)), y.a((Executor) pVar.f(b0.a(com.google.firebase.o.a.b.class, Executor.class))));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<com.google.firebase.components.n<?>> getComponents() {
        return Arrays.asList(com.google.firebase.components.n.c(i.class).h(LIBRARY_NAME).b(v.k(com.google.firebase.j.class)).b(v.i(com.google.firebase.r.i.class)).b(v.j(b0.a(com.google.firebase.o.a.a.class, ExecutorService.class))).b(v.j(b0.a(com.google.firebase.o.a.b.class, Executor.class))).f(new r() { // from class: com.google.firebase.installations.e
            @Override // com.google.firebase.components.r
            public final Object a(p pVar) {
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(pVar);
            }
        }).d(), com.google.firebase.r.h.a(), com.google.firebase.u.h.a(LIBRARY_NAME, "17.2.0"));
    }
}
