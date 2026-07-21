package i.a.g.s;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'f' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: DNSState.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f21884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g f21885g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g f21886h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final g f21887i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final g f21888j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final g f21889k;
    public static final g l;
    public static final g m;
    public static final g n;
    public static final g o;
    public static final g p;
    public static final g q;
    private static final /* synthetic */ g[] r;
    private final String s;
    private final b t;

    /* JADX INFO: compiled from: DNSState.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[g.values().length];
            a = iArr;
            try {
                iArr[g.f21884f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[g.f21885g.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[g.f21886h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[g.f21887i.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[g.f21888j.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[g.f21889k.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[g.l.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[g.m.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[g.n.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[g.o.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[g.p.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[g.q.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: compiled from: DNSState.java */
    private enum b {
        probing,
        announcing,
        announced,
        canceling,
        canceled,
        closing,
        closed
    }

    static {
        b bVar = b.probing;
        g gVar = new g("PROBING_1", 0, "probing 1", bVar);
        f21884f = gVar;
        g gVar2 = new g("PROBING_2", 1, "probing 2", bVar);
        f21885g = gVar2;
        g gVar3 = new g("PROBING_3", 2, "probing 3", bVar);
        f21886h = gVar3;
        b bVar2 = b.announcing;
        g gVar4 = new g("ANNOUNCING_1", 3, "announcing 1", bVar2);
        f21887i = gVar4;
        g gVar5 = new g("ANNOUNCING_2", 4, "announcing 2", bVar2);
        f21888j = gVar5;
        g gVar6 = new g("ANNOUNCED", 5, "announced", b.announced);
        f21889k = gVar6;
        b bVar3 = b.canceling;
        g gVar7 = new g("CANCELING_1", 6, "canceling 1", bVar3);
        l = gVar7;
        g gVar8 = new g("CANCELING_2", 7, "canceling 2", bVar3);
        m = gVar8;
        g gVar9 = new g("CANCELING_3", 8, "canceling 3", bVar3);
        n = gVar9;
        g gVar10 = new g("CANCELED", 9, "canceled", b.canceled);
        o = gVar10;
        g gVar11 = new g("CLOSING", 10, "closing", b.closing);
        p = gVar11;
        g gVar12 = new g("CLOSED", 11, "closed", b.closed);
        q = gVar12;
        r = new g[]{gVar, gVar2, gVar3, gVar4, gVar5, gVar6, gVar7, gVar8, gVar9, gVar10, gVar11, gVar12};
    }

    private g(String str, int i2, String str2, b bVar) {
        super(str, i2);
        this.s = str2;
        this.t = bVar;
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) r.clone();
    }

    public final boolean A() {
        return this.t == b.probing;
    }

    public final g D() {
        switch (a.a[ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return f21884f;
            case 7:
            case 8:
            case 9:
                return l;
            case 10:
                return o;
            case 11:
                return p;
            case 12:
                return q;
            default:
                return this;
        }
    }

    public final g g() {
        switch (a.a[ordinal()]) {
            case 1:
                return f21885g;
            case 2:
                return f21886h;
            case 3:
                return f21887i;
            case 4:
                return f21888j;
            case 5:
                return f21889k;
            case 6:
                return f21889k;
            case 7:
                return m;
            case 8:
                return n;
            case 9:
                return o;
            case 10:
                return o;
            case 11:
                return q;
            case 12:
                return q;
            default:
                return this;
        }
    }

    public final boolean k() {
        return this.t == b.announced;
    }

    public final boolean q() {
        return this.t == b.announcing;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.s;
    }

    public final boolean u() {
        return this.t == b.canceled;
    }

    public final boolean v() {
        return this.t == b.canceling;
    }

    public final boolean x() {
        return this.t == b.closed;
    }

    public final boolean y() {
        return this.t == b.closing;
    }
}
