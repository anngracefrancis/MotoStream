package rx.n.e;

import java.util.List;
import rx.exceptions.OnErrorNotImplementedException;
import rx.n.a.h0;

/* JADX INFO: compiled from: InternalObservableUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public enum f {
    ;


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f26736f = new rx.m.f<Long, Object, Long>() { // from class: rx.n.e.f.e
        @Override // rx.m.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f26737g = new rx.m.f<Object, Object, Boolean>() { // from class: rx.n.e.f.c
        @Override // rx.m.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj, Object obj2) {
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h f26738h = new rx.m.e<List<? extends rx.e<?>>, rx.e<?>[]>() { // from class: rx.n.e.f.h
        @Override // rx.m.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public rx.e<?>[] call(List<? extends rx.e<?>> list) {
            return (rx.e[]) list.toArray(new rx.e[list.size()]);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final g f26739i = new rx.m.e<Object, Void>() { // from class: rx.n.e.f.g
        @Override // rx.m.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call(Object obj) {
            return null;
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d f26740j = new rx.m.f<Integer, Object, Integer>() { // from class: rx.n.e.f.d
        @Override // rx.m.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final b f26741k = new b();
    public static final rx.m.b<Throwable> l = new rx.m.b<Throwable>() { // from class: rx.n.e.f.a
        @Override // rx.m.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final rx.e.b<Boolean, Object> m = new h0(m.a(), true);

    /* JADX INFO: compiled from: InternalObservableUtils.java */
    static final class b implements rx.m.e<rx.d<?>, Throwable> {
        b() {
        }

        @Override // rx.m.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Throwable call(rx.d<?> dVar) {
            return dVar.e();
        }
    }

    /* JADX INFO: renamed from: rx.n.e.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: InternalObservableUtils.java */
    static final class C0463f implements rx.m.e<rx.e<? extends rx.d<?>>, rx.e<?>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final rx.m.e<? super rx.e<? extends Throwable>, ? extends rx.e<?>> f26742f;

        public C0463f(rx.m.e<? super rx.e<? extends Throwable>, ? extends rx.e<?>> eVar) {
            this.f26742f = eVar;
        }

        @Override // rx.m.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public rx.e<?> call(rx.e<? extends rx.d<?>> eVar) {
            return this.f26742f.call(eVar.X(f.f26741k));
        }
    }

    public static rx.m.e<rx.e<? extends rx.d<?>>, rx.e<?>> g(rx.m.e<? super rx.e<? extends Throwable>, ? extends rx.e<?>> eVar) {
        return new C0463f(eVar);
    }
}
