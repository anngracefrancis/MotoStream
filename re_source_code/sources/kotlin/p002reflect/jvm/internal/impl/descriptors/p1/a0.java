package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.f0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: PackageViewDescriptorFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface a0 {
    public static final a a = a.a;

    /* JADX INFO: compiled from: PackageViewDescriptorFactory.kt */
    public static final class a {
        static final /* synthetic */ a a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final f0<a0> f25210b = new f0<>("PackageViewDescriptorFactory");

        private a() {
        }

        public final f0<a0> a() {
            return f25210b;
        }
    }

    /* JADX INFO: compiled from: PackageViewDescriptorFactory.kt */
    public static final class b implements a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f25211b = new b();

        private b() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.a0
        public p0 a(x xVar, c cVar, n nVar) {
            m.f(xVar, "module");
            m.f(cVar, "fqName");
            m.f(nVar, "storageManager");
            return new r(xVar, cVar, nVar);
        }
    }

    p0 a(x xVar, c cVar, n nVar);
}
