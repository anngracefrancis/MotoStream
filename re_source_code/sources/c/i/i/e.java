package c.i.i;

import java.util.Locale;

/* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final c.i.i.d a = new C0076e(null, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c.i.i.d f3273b = new C0076e(null, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c.i.i.d f3274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c.i.i.d f3275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c.i.i.d f3276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c.i.i.d f3277f;

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static class a implements c {
        static final a a = new a(true);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f3278b;

        private a(boolean z) {
            this.f3278b = z;
        }

        @Override // c.i.i.e.c
        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            boolean z = false;
            while (i2 < i4) {
                int iA = e.a(Character.getDirectionality(charSequence.charAt(i2)));
                if (iA != 0) {
                    if (iA != 1) {
                        continue;
                    } else if (!this.f3278b) {
                        return 1;
                    }
                    i2++;
                } else if (this.f3278b) {
                    return 0;
                }
                z = true;
                i2++;
            }
            if (z) {
                return this.f3278b ? 1 : 0;
            }
            return 2;
        }
    }

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static class b implements c {
        static final b a = new b();

        private b() {
        }

        @Override // c.i.i.e.c
        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            int iB = 2;
            while (i2 < i4 && iB == 2) {
                iB = e.b(Character.getDirectionality(charSequence.charAt(i2)));
                i2++;
            }
            return iB;
        }
    }

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private interface c {
        int a(CharSequence charSequence, int i2, int i3);
    }

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static abstract class d implements c.i.i.d {
        private final c a;

        d(c cVar) {
            this.a = cVar;
        }

        private boolean c(CharSequence charSequence, int i2, int i3) {
            int iA = this.a.a(charSequence, i2, i3);
            if (iA == 0) {
                return true;
            }
            if (iA != 1) {
                return b();
            }
            return false;
        }

        @Override // c.i.i.d
        public boolean a(CharSequence charSequence, int i2, int i3) {
            if (charSequence == null || i2 < 0 || i3 < 0 || charSequence.length() - i3 < i2) {
                throw new IllegalArgumentException();
            }
            return this.a == null ? b() : c(charSequence, i2, i3);
        }

        protected abstract boolean b();
    }

    /* JADX INFO: renamed from: c.i.i.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static class C0076e extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f3279b;

        C0076e(c cVar, boolean z) {
            super(cVar);
            this.f3279b = z;
        }

        @Override // c.i.i.e.d
        protected boolean b() {
            return this.f3279b;
        }
    }

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static class f extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final f f3280b = new f();

        f() {
            super(null);
        }

        @Override // c.i.i.e.d
        protected boolean b() {
            return c.i.i.f.b(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.a;
        f3274c = new C0076e(bVar, false);
        f3275d = new C0076e(bVar, true);
        f3276e = new C0076e(a.a, false);
        f3277f = f.f3280b;
    }

    static int a(int i2) {
        if (i2 != 0) {
            return (i2 == 1 || i2 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i2) {
        if (i2 != 0) {
            if (i2 == 1 || i2 == 2) {
                return 0;
            }
            switch (i2) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
