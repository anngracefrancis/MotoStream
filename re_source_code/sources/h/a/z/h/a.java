package h.a.z.h;

import h.a.i;
import h.a.z.j.d;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k.a.b;
import k.a.c;

/* JADX INFO: compiled from: StrictSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public class a<T> extends AtomicInteger implements i<T>, c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final b<? super T> f21731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final h.a.z.j.a f21732g = new h.a.z.j.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AtomicLong f21733h = new AtomicLong();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final AtomicReference<c> f21734i = new AtomicReference<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final AtomicBoolean f21735j = new AtomicBoolean();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    volatile boolean f21736k;

    public a(b<? super T> bVar) {
        this.f21731f = bVar;
    }

    @Override // k.a.b
    public void a() {
        this.f21736k = true;
        d.a(this.f21731f, this, this.f21732g);
    }

    @Override // k.a.b
    public void b(c cVar) {
        if (this.f21735j.compareAndSet(false, true)) {
            this.f21731f.b(this);
            h.a.z.i.b.q(this.f21734i, this.f21733h, cVar);
        } else {
            cVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // k.a.c
    public void cancel() {
        if (this.f21736k) {
            return;
        }
        h.a.z.i.b.g(this.f21734i);
    }

    @Override // k.a.b
    public void onError(Throwable th) {
        this.f21736k = true;
        d.b(this.f21731f, th, this, this.f21732g);
    }

    @Override // k.a.b
    public void onNext(T t) {
        d.c(this.f21731f, t, this, this.f21732g);
    }

    @Override // k.a.c
    public void request(long j2) {
        if (j2 > 0) {
            h.a.z.i.b.k(this.f21734i, this.f21733h, j2);
            return;
        }
        cancel();
        onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j2));
    }
}
