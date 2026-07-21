package androidx.work;

import android.annotation.SuppressLint;

/* JADX INFO: compiled from: Operation.java */
/* JADX INFO: loaded from: classes.dex */
public interface q {

    @SuppressLint({"SyntheticAccessor"})
    public static final b.c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"SyntheticAccessor"})
    public static final b.C0056b f2663b;

    /* JADX INFO: compiled from: Operation.java */
    public static abstract class b {

        /* JADX INFO: compiled from: Operation.java */
        public static final class a extends b {
            private final Throwable a;

            public a(Throwable th) {
                this.a = th;
            }

            public Throwable a() {
                return this.a;
            }

            public String toString() {
                return String.format("FAILURE (%s)", this.a.getMessage());
            }
        }

        /* JADX INFO: renamed from: androidx.work.q$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Operation.java */
        public static final class C0056b extends b {
            public String toString() {
                return "IN_PROGRESS";
            }

            private C0056b() {
            }
        }

        /* JADX INFO: compiled from: Operation.java */
        public static final class c extends b {
            public String toString() {
                return "SUCCESS";
            }

            private c() {
            }
        }

        b() {
        }
    }

    static {
        a = new b.c();
        f2663b = new b.C0056b();
    }
}
