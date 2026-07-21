package kotlin.reflect.y.internal.j0.f;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: SpecialNames.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final h a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f24216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f24217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f24218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f24219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f24220f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f24221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f f24222h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f f24223i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final f f24224j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final f f24225k;
    public static final f l;
    public static final f m;
    public static final f n;

    static {
        f fVarD = f.D("<no name provided>");
        m.e(fVarD, "special(\"<no name provided>\")");
        f24216b = fVarD;
        f fVarD2 = f.D("<root package>");
        m.e(fVarD2, "special(\"<root package>\")");
        f24217c = fVarD2;
        f fVarX = f.x("Companion");
        m.e(fVarX, "identifier(\"Companion\")");
        f24218d = fVarX;
        f fVarX2 = f.x("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        m.e(fVarX2, "identifier(\"no_name_in_P…_4cd0_b7f5_b46aa3cd5d40\")");
        f24219e = fVarX2;
        f fVarD3 = f.D("<anonymous>");
        m.e(fVarD3, "special(ANONYMOUS_STRING)");
        f24220f = fVarD3;
        f fVarD4 = f.D("<unary>");
        m.e(fVarD4, "special(\"<unary>\")");
        f24221g = fVarD4;
        f fVarD5 = f.D("<this>");
        m.e(fVarD5, "special(\"<this>\")");
        f24222h = fVarD5;
        f fVarD6 = f.D("<init>");
        m.e(fVarD6, "special(\"<init>\")");
        f24223i = fVarD6;
        f fVarD7 = f.D("<iterator>");
        m.e(fVarD7, "special(\"<iterator>\")");
        f24224j = fVarD7;
        f fVarD8 = f.D("<destruct>");
        m.e(fVarD8, "special(\"<destruct>\")");
        f24225k = fVarD8;
        f fVarD9 = f.D("<local>");
        m.e(fVarD9, "special(\"<local>\")");
        l = fVarD9;
        f fVarD10 = f.D("<unused var>");
        m.e(fVarD10, "special(\"<unused var>\")");
        m = fVarD10;
        f fVarD11 = f.D("<set-?>");
        m.e(fVarD11, "special(\"<set-?>\")");
        n = fVarD11;
    }

    private h() {
    }

    public static final f b(f fVar) {
        return (fVar == null || fVar.y()) ? f24219e : fVar;
    }

    public final boolean a(f fVar) {
        m.f(fVar, "name");
        String strK = fVar.k();
        m.e(strK, "name.asString()");
        return (strK.length() > 0) && !fVar.y();
    }
}
