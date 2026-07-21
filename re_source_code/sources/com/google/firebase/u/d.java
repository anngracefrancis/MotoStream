package com.google.firebase.u;

import com.google.firebase.components.n;
import com.google.firebase.components.p;
import com.google.firebase.components.r;
import com.google.firebase.components.v;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: DefaultUserAgentPublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements i {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f20132b;

    d(Set<g> set, e eVar) {
        this.a = d(set);
        this.f20132b = eVar;
    }

    public static n<i> b() {
        return n.c(i.class).b(v.n(g.class)).f(new r() { // from class: com.google.firebase.u.a
            @Override // com.google.firebase.components.r
            public final Object a(p pVar) {
                return d.c(pVar);
            }
        }).d();
    }

    static /* synthetic */ i c(p pVar) {
        return new d(pVar.g(g.class), e.a());
    }

    private static String d(Set<g> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<g> it = set.iterator();
        while (it.hasNext()) {
            g next = it.next();
            sb.append(next.b());
            sb.append('/');
            sb.append(next.c());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override // com.google.firebase.u.i
    public String a() {
        if (this.f20132b.b().isEmpty()) {
            return this.a;
        }
        return this.a + ' ' + d(this.f20132b.b());
    }
}
