package kotlin.reflect.y.internal.j0.j.b;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: FlexibleTypeDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface s {

    /* JADX INFO: compiled from: FlexibleTypeDeserializer.kt */
    public static final class a implements s {
        public static final a a = new a();

        private a() {
        }

        @Override // kotlin.reflect.y.internal.j0.j.b.s
        public e0 a(q qVar, String str, m0 m0Var, m0 m0Var2) {
            m.f(qVar, "proto");
            m.f(str, "flexibleId");
            m.f(m0Var, "lowerBound");
            m.f(m0Var2, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    e0 a(q qVar, String str, m0 m0Var, m0 m0Var2);
}
