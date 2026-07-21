package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: Lifecycle.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    AtomicReference<Object> a = new AtomicReference<>();

    /* JADX INFO: compiled from: Lifecycle.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f1749b;

        static {
            int[] iArr = new int[b.values().length];
            f1749b = iArr;
            try {
                iArr[b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1749b[b.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1749b[b.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1749b[b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1749b[b.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1749b[b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1749b[b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[c.values().length];
            a = iArr2;
            try {
                iArr2[c.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[c.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[c.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[c.DESTROYED.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[c.INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: compiled from: Lifecycle.java */
    public enum b {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static b g(c cVar) {
            int i2 = a.a[cVar.ordinal()];
            if (i2 == 1) {
                return ON_DESTROY;
            }
            if (i2 == 2) {
                return ON_STOP;
            }
            if (i2 != 3) {
                return null;
            }
            return ON_PAUSE;
        }

        public static b q(c cVar) {
            int i2 = a.a[cVar.ordinal()];
            if (i2 == 1) {
                return ON_START;
            }
            if (i2 == 2) {
                return ON_RESUME;
            }
            if (i2 != 5) {
                return null;
            }
            return ON_CREATE;
        }

        public c k() {
            switch (a.f1749b[ordinal()]) {
                case 1:
                case 2:
                    return c.CREATED;
                case 3:
                case 4:
                    return c.STARTED;
                case 5:
                    return c.RESUMED;
                case 6:
                    return c.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* JADX INFO: compiled from: Lifecycle.java */
    public enum c {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean g(c cVar) {
            return compareTo(cVar) >= 0;
        }
    }

    public abstract void a(j jVar);

    public abstract c b();

    public abstract void c(j jVar);
}
