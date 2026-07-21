package c.l.b.i;

import java.util.Map;
import kotlin.collections.q0;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: Preferences.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: compiled from: Preferences.kt */
    public static final class a<T> {
        private final String a;

        public a(String str) {
            m.f(str, "name");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return m.a(this.a, ((a) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: Preferences.kt */
    public static final class b<T> {
        private final a<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f3332b;

        public final a<T> a() {
            return this.a;
        }

        public final T b() {
            return this.f3332b;
        }
    }

    public abstract Map<a<?>, Object> a();

    public abstract <T> T b(a<T> aVar);

    public final c.l.b.i.a c() {
        return new c.l.b.i.a(q0.u(a()), false);
    }

    public final d d() {
        return new c.l.b.i.a(q0.u(a()), true);
    }
}
