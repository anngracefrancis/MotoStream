package kotlin.reflect.y.internal.j0.i.w;

import java.util.Collection;
import java.util.Set;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface h extends k {
    public static final a a = a.a;

    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class a {
        static final /* synthetic */ a a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Function1<f, Boolean> f24420b = C0382a.f24421f;

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.i.w.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MemberScope.kt */
        static final class C0382a extends Lambda implements Function1<f, Boolean> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C0382a f24421f = new C0382a();

            C0382a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(f fVar) {
                m.f(fVar, "it");
                return Boolean.TRUE;
            }
        }

        private a() {
        }

        public final Function1<f, Boolean> a() {
            return f24420b;
        }
    }

    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class b extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f24422b = new b();

        private b() {
        }

        @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
        public Set<f> b() {
            return w0.d();
        }

        @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
        public Set<f> d() {
            return w0.d();
        }

        @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
        public Set<f> e() {
            return w0.d();
        }
    }

    Collection<? extends y0> a(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar);

    Set<f> b();

    Collection<? extends t0> c(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar);

    Set<f> d();

    Set<f> e();
}
