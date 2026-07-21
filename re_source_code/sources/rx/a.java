package rx;

import rx.exceptions.MissingBackpressureException;

/* JADX INFO: compiled from: BackpressureOverflow.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f26001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f26002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f26003d;

    /* JADX INFO: renamed from: rx.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BackpressureOverflow.java */
    static final class C0429a implements d {
        static final C0429a a = new C0429a();

        private C0429a() {
        }

        @Override // rx.a.d
        public boolean a() {
            return false;
        }
    }

    /* JADX INFO: compiled from: BackpressureOverflow.java */
    static final class b implements d {
        static final b a = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean a() {
            return true;
        }
    }

    /* JADX INFO: compiled from: BackpressureOverflow.java */
    static final class c implements d {
        static final c a = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean a() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }

    /* JADX INFO: compiled from: BackpressureOverflow.java */
    public interface d {
        boolean a() throws MissingBackpressureException;
    }

    static {
        c cVar = c.a;
        a = cVar;
        f26001b = cVar;
        f26002c = b.a;
        f26003d = C0429a.a;
    }
}
