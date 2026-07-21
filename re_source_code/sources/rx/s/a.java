package rx.s;

import java.util.ArrayList;
import rx.n.a.h;

/* JADX INFO: compiled from: BehaviorSubject.java */
/* JADX INFO: loaded from: classes.dex */
public final class a<T> extends d<T, T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object[] f26863g = new Object[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final e<T> f26864h;

    /* JADX INFO: renamed from: rx.s.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BehaviorSubject.java */
    /* JADX INFO: loaded from: classes3.dex */
    static class C0468a implements rx.m.b<e.c<T>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f26865f;

        C0468a(e eVar) {
            this.f26865f = eVar;
        }

        @Override // rx.m.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(e.c<T> cVar) {
            cVar.b(this.f26865f.d());
        }
    }

    protected a(rx.e.a<T> aVar, e<T> eVar) {
        super(aVar);
        this.f26864h = eVar;
    }

    public static <T> a<T> g1() {
        return h1(null, false);
    }

    private static <T> a<T> h1(T t, boolean z) {
        e eVar = new e();
        if (z) {
            eVar.g(h.g(t));
        }
        C0468a c0468a = new C0468a(eVar);
        eVar.f26879i = c0468a;
        eVar.f26880j = c0468a;
        return new a<>(eVar, eVar);
    }

    @Override // rx.f
    public void onCompleted() {
        if (this.f26864h.d() == null || this.f26864h.f26877g) {
            Object objB = h.b();
            for (e.c<T> cVar : this.f26864h.h(objB)) {
                cVar.d(objB);
            }
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        if (this.f26864h.d() == null || this.f26864h.f26877g) {
            Object objC = h.c(th);
            ArrayList arrayList = null;
            for (e.c<T> cVar : this.f26864h.h(objC)) {
                try {
                    cVar.d(objC);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.d(arrayList);
        }
    }

    @Override // rx.f
    public void onNext(T t) {
        if (this.f26864h.d() == null || this.f26864h.f26877g) {
            Object objG = h.g(t);
            for (e.c<T> cVar : this.f26864h.e(objG)) {
                cVar.d(objG);
            }
        }
    }
}
