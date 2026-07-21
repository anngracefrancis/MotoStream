package g.a.a.a;

import h.a.m;
import h.a.p;
import h.a.s;
import h.a.w;
import rx.Single;

/* JADX INFO: compiled from: RxJavaInterop.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static rx.b a(h.a.f fVar) {
        h.a.z.b.b.c(fVar, "source is null");
        return rx.b.h(new b(fVar));
    }

    public static <T> rx.e<T> b(p<T> pVar, h.a.a aVar) {
        h.a.z.b.b.c(pVar, "source is null");
        h.a.z.b.b.c(aVar, "strategy is null");
        return c(m.D(pVar).z(aVar));
    }

    public static <T> rx.e<T> c(k.a.a<T> aVar) {
        h.a.z.b.b.c(aVar, "source is null");
        return rx.e.b1(new c(aVar));
    }

    public static <T> Single<T> d(w<T> wVar) {
        h.a.z.b.b.c(wVar, "source is null");
        return Single.b(new f(wVar));
    }

    public static h.a.b e(rx.b bVar) {
        h.a.z.b.b.c(bVar, "source is null");
        return new a(bVar);
    }

    public static <T> s<T> f(Single<T> single) {
        h.a.z.b.b.c(single, "source is null");
        return new e(single);
    }
}
