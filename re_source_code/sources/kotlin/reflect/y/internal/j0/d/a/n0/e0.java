package kotlin.reflect.y.internal.j0.d.a.n0;

import java.util.Iterator;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;

/* JADX INFO: compiled from: javaElements.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface e0 extends d {

    /* JADX INFO: compiled from: javaElements.kt */
    public static final class a {
        public static kotlin.reflect.y.internal.j0.d.a.n0.a a(e0 e0Var, c cVar) {
            Object obj;
            Object next;
            b bVarE;
            m.f(cVar, "fqName");
            Iterator<T> it = e0Var.getAnnotations().iterator();
            do {
                obj = null;
                if (it.hasNext()) {
                    next = it.next();
                    bVarE = ((kotlin.reflect.y.internal.j0.d.a.n0.a) next).e();
                }
                return (kotlin.reflect.y.internal.j0.d.a.n0.a) obj;
            } while (!m.a(bVarE != null ? bVarE.b() : null, cVar));
            obj = next;
            return (kotlin.reflect.y.internal.j0.d.a.n0.a) obj;
        }
    }
}
