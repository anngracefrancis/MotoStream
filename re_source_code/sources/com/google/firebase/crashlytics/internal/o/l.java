package com.google.firebase.crashlytics.internal.o;

import com.google.firebase.crashlytics.internal.n.w;
import com.google.firebase.crashlytics.internal.p.f0;
import com.google.firebase.crashlytics.internal.r.f;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: UserMetadata.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {
    private final g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w f19176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f19177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f19178d = new a(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f19179e = new a(true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k f19180f = new k(128);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicMarkableReference<String> f19181g = new AtomicMarkableReference<>(null, false);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: UserMetadata.java */
    class a {
        final AtomicMarkableReference<e> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicReference<Callable<Void>> f19182b = new AtomicReference<>(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f19183c;

        public a(boolean z) {
            this.f19183c = z;
            this.a = new AtomicMarkableReference<>(new e(64, z ? 8192 : 1024), false);
        }

        private /* synthetic */ Void b() throws Exception {
            this.f19182b.set(null);
            e();
            return null;
        }

        private void d() {
            Callable<Void> callable = new Callable() { // from class: com.google.firebase.crashlytics.h.o.a
                @Override // java.util.concurrent.Callable
                public final Object call() throws Exception {
                    this.f19140f.c();
                    return null;
                }
            };
            if (this.f19182b.compareAndSet(null, callable)) {
                l.this.f19176b.g(callable);
            }
        }

        private void e() throws Throwable {
            Map<String, String> mapA;
            synchronized (this) {
                if (this.a.isMarked()) {
                    mapA = this.a.getReference().a();
                    AtomicMarkableReference<e> atomicMarkableReference = this.a;
                    atomicMarkableReference.set(atomicMarkableReference.getReference(), false);
                } else {
                    mapA = null;
                }
            }
            if (mapA != null) {
                l.this.a.q(l.this.f19177c, mapA, this.f19183c);
            }
        }

        public Map<String, String> a() {
            return this.a.getReference().a();
        }

        public /* synthetic */ Void c() throws Exception {
            b();
            return null;
        }

        public boolean f(String str, String str2) {
            synchronized (this) {
                if (!this.a.getReference().d(str, str2)) {
                    return false;
                }
                AtomicMarkableReference<e> atomicMarkableReference = this.a;
                atomicMarkableReference.set(atomicMarkableReference.getReference(), true);
                d();
                return true;
            }
        }
    }

    public l(String str, f fVar, w wVar) {
        this.f19177c = str;
        this.a = new g(fVar);
        this.f19176b = wVar;
    }

    public static l h(String str, f fVar, w wVar) {
        g gVar = new g(fVar);
        l lVar = new l(str, fVar, wVar);
        lVar.f19178d.a.getReference().e(gVar.i(str, false));
        lVar.f19179e.a.getReference().e(gVar.i(str, true));
        lVar.f19181g.set(gVar.k(str), false);
        lVar.f19180f.c(gVar.j(str));
        return lVar;
    }

    public static String i(String str, f fVar) {
        return new g(fVar).k(str);
    }

    public Map<String, String> d() {
        return this.f19178d.a();
    }

    public Map<String, String> e() {
        return this.f19179e.a();
    }

    public List<f0.e.d.AbstractC0226e> f() {
        return this.f19180f.a();
    }

    public String g() {
        return this.f19181g.getReference();
    }

    public boolean j(String str, String str2) {
        return this.f19179e.f(str, str2);
    }

    public void k(String str) {
        synchronized (this.f19177c) {
            this.f19177c = str;
            Map<String, String> mapA = this.f19178d.a();
            List<j> listB = this.f19180f.b();
            if (g() != null) {
                this.a.s(str, g());
            }
            if (!mapA.isEmpty()) {
                this.a.p(str, mapA);
            }
            if (!listB.isEmpty()) {
                this.a.r(str, listB);
            }
        }
    }
}
