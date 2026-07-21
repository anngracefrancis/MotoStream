package rx.n.a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: OperatorToObservableList.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e1<T> implements rx.e.b<List<T>, T> {

    /* JADX INFO: compiled from: OperatorToObservableList.java */
    class a extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f26191f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        List<T> f26192g = new LinkedList();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.n.b.b f26193h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ rx.j f26194i;

        a(rx.n.b.b bVar, rx.j jVar) {
            this.f26193h = bVar;
            this.f26194i = jVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f26191f) {
                return;
            }
            this.f26191f = true;
            try {
                ArrayList arrayList = new ArrayList(this.f26192g);
                this.f26192g = null;
                this.f26193h.b(arrayList);
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26194i.onError(th);
        }

        @Override // rx.f
        public void onNext(T t) {
            if (this.f26191f) {
                return;
            }
            this.f26192g.add(t);
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: compiled from: OperatorToObservableList.java */
    static final class b {
        static final e1<Object> a = new e1<>();
    }

    e1() {
    }

    public static <T> e1<T> b() {
        return (e1<T>) b.a;
    }

    @Override // rx.m.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super List<T>> jVar) {
        rx.n.b.b bVar = new rx.n.b.b(jVar);
        a aVar = new a(bVar, jVar);
        jVar.add(aVar);
        jVar.setProducer(bVar);
        return aVar;
    }
}
