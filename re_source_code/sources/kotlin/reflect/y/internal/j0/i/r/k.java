package kotlin.reflect.y.internal.j0.i.r;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.l.u1.h;
import kotlin.reflect.y.internal.j0.l.u1.j;
import kotlin.u;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends g<u> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f24364b = new a(null);

    /* JADX INFO: compiled from: constantValues.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final k a(String str) {
            m.f(str, "message");
            return new b(str);
        }
    }

    /* JADX INFO: compiled from: constantValues.kt */
    public static final class b extends k {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f24365c;

        public b(String str) {
            m.f(str, "message");
            this.f24365c = str;
        }

        @Override // kotlin.reflect.y.internal.j0.i.r.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public h a(g0 g0Var) {
            m.f(g0Var, "module");
            return kotlin.reflect.y.internal.j0.l.u1.k.d(j.m0, this.f24365c);
        }

        @Override // kotlin.reflect.y.internal.j0.i.r.g
        public String toString() {
            return this.f24365c;
        }
    }

    public k() {
        super(u.a);
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public u b() {
        throw new UnsupportedOperationException();
    }
}
