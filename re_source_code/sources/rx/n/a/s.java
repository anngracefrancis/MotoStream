package rx.n.a;

import android.R;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: OnSubscribeFromArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s<T> implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final T[] f26466f;

    /* JADX INFO: compiled from: OnSubscribeFromArray.java */
    static final class a<T> extends AtomicLong implements rx.g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final rx.j<? super T> f26467f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final T[] f26468g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f26469h;

        public a(rx.j<? super T> jVar, T[] tArr) {
            this.f26467f = jVar;
            this.f26468g = tArr;
        }

        void a() {
            rx.j<? super T> jVar = this.f26467f;
            for (R.bool boolVar : this.f26468g) {
                if (jVar.isUnsubscribed()) {
                    return;
                }
                jVar.onNext(boolVar);
            }
            if (jVar.isUnsubscribed()) {
                return;
            }
            jVar.onCompleted();
        }

        void b(long j2) {
            rx.j<? super T> jVar = this.f26467f;
            T[] tArr = this.f26468g;
            int length = tArr.length;
            int i2 = this.f26469h;
            do {
                long j3 = 0;
                while (true) {
                    if (j2 == 0 || i2 == length) {
                        j2 = get() + j3;
                        if (j2 == 0) {
                            break;
                        }
                    } else {
                        if (jVar.isUnsubscribed()) {
                            return;
                        }
                        jVar.onNext(tArr[i2]);
                        i2++;
                        if (i2 == length) {
                            if (jVar.isUnsubscribed()) {
                                return;
                            }
                            jVar.onCompleted();
                            return;
                        }
                        j2--;
                        j3--;
                    }
                }
                this.f26469h = i2;
                j2 = addAndGet(j3);
            } while (j2 != 0);
        }

        @Override // rx.g
        public void request(long j2) {
            if (j2 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j2);
            }
            if (j2 == Long.MAX_VALUE) {
                if (rx.n.a.a.b(this, j2) == 0) {
                    a();
                }
            } else {
                if (j2 == 0 || rx.n.a.a.b(this, j2) != 0) {
                    return;
                }
                b(j2);
            }
        }
    }

    public s(T[] tArr) {
        this.f26466f = tArr;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        jVar.setProducer(new a(jVar, this.f26466f));
    }
}
