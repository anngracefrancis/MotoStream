package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.datatransport.cct.c;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.n;
import com.google.firebase.components.p;
import com.google.firebase.components.r;
import com.google.firebase.components.v;
import com.google.firebase.u.h;
import e.e.b.a.g;
import e.e.b.a.i.u;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    static /* synthetic */ g lambda$getComponents$0(p pVar) {
        u.f((Context) pVar.a(Context.class));
        return u.c().g(c.f11189f);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<n<?>> getComponents() {
        return Arrays.asList(n.c(g.class).h(LIBRARY_NAME).b(v.k(Context.class)).f(new r() { // from class: com.google.firebase.datatransport.a
            @Override // com.google.firebase.components.r
            public final Object a(p pVar) {
                return TransportRegistrar.lambda$getComponents$0(pVar);
            }
        }).d(), h.a(LIBRARY_NAME, "18.1.8"));
    }
}
