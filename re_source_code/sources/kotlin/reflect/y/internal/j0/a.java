package kotlin.reflect.y.internal.j0;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.u;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.d.a.a0;
import kotlin.reflect.y.internal.j0.d.a.z;
import kotlin.reflect.y.internal.j0.d.b.q;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;

/* JADX INFO: compiled from: SpecialJvmAnnotations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final a a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<b> f23152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f23153c;

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SpecialJvmAnnotations.kt */
    public static final class C0319a implements q.c {
        final /* synthetic */ c0 a;

        C0319a(c0 c0Var) {
            this.a = c0Var;
        }

        @Override // kotlin.f0.y.e.j0.d.b.q.c
        public void a() {
        }

        @Override // kotlin.f0.y.e.j0.d.b.q.c
        public q.a b(b bVar, z0 z0Var) {
            m.f(bVar, "classId");
            m.f(z0Var, "source");
            if (!m.a(bVar, z.a.a())) {
                return null;
            }
            this.a.f22934f = true;
            return null;
        }
    }

    static {
        List listM = u.m(a0.a, a0.f23333k, a0.l, a0.f23326d, a0.f23328f, a0.f23331i);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listM.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(b.m((c) it.next()));
        }
        f23152b = linkedHashSet;
        b bVarM = b.m(a0.f23332j);
        m.e(bVarM, "topLevel(JvmAnnotationNames.REPEATABLE_ANNOTATION)");
        f23153c = bVarM;
    }

    private a() {
    }

    public final b a() {
        return f23153c;
    }

    public final Set<b> b() {
        return f23152b;
    }

    public final boolean c(q qVar) {
        m.f(qVar, "klass");
        c0 c0Var = new c0();
        qVar.b(new C0319a(c0Var), null);
        return c0Var.f22934f;
    }
}
