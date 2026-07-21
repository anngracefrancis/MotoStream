package rx.p;

import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.k;

/* JADX INFO: compiled from: SafeCompletableSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements rx.c, k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.c f26830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    k f26831g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f26832h;

    public b(rx.c cVar) {
        this.f26830f = cVar;
    }

    @Override // rx.c
    public void a(k kVar) {
        this.f26831g = kVar;
        try {
            this.f26830f.a(this);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            kVar.unsubscribe();
            onError(th);
        }
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.f26832h || this.f26831g.isUnsubscribed();
    }

    @Override // rx.c
    public void onCompleted() {
        if (this.f26832h) {
            return;
        }
        this.f26832h = true;
        try {
            this.f26830f.onCompleted();
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            throw new OnCompletedFailedException(th);
        }
    }

    @Override // rx.c
    public void onError(Throwable th) {
        if (this.f26832h) {
            rx.q.c.j(th);
            return;
        }
        this.f26832h = true;
        try {
            this.f26830f.onError(th);
        } catch (Throwable th2) {
            rx.exceptions.a.e(th2);
            throw new OnErrorFailedException(new CompositeException(th, th2));
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        this.f26831g.unsubscribe();
    }
}
