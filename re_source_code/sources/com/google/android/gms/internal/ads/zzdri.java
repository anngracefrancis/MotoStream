package com.google.android.gms.internal.ads;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'h' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public class zzdri {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzdri f16058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzdri f16059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final zzdri f16060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final zzdri f16061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final zzdri f16062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final zzdri f16063k;
    public static final zzdri l;
    public static final zzdri m;
    public static final zzdri n;
    public static final zzdri o;
    public static final zzdri p;
    public static final zzdri q;
    public static final zzdri r;
    public static final zzdri s;
    public static final zzdri t;
    public static final zzdri u;
    public static final zzdri v;
    public static final zzdri w;
    private static final /* synthetic */ zzdri[] x;
    private final zzdrn y;
    private final int z;

    static {
        zzdri zzdriVar = new zzdri("DOUBLE", 0, zzdrn.DOUBLE, 1);
        f16058f = zzdriVar;
        zzdri zzdriVar2 = new zzdri("FLOAT", 1, zzdrn.FLOAT, 5);
        f16059g = zzdriVar2;
        zzdrn zzdrnVar = zzdrn.LONG;
        final int i2 = 2;
        zzdri zzdriVar3 = new zzdri("INT64", 2, zzdrnVar, 0);
        f16060h = zzdriVar3;
        final int i3 = 3;
        zzdri zzdriVar4 = new zzdri("UINT64", 3, zzdrnVar, 0);
        f16061i = zzdriVar4;
        zzdrn zzdrnVar2 = zzdrn.INT;
        zzdri zzdriVar5 = new zzdri("INT32", 4, zzdrnVar2, 0);
        f16062j = zzdriVar5;
        zzdri zzdriVar6 = new zzdri("FIXED64", 5, zzdrnVar, 1);
        f16063k = zzdriVar6;
        zzdri zzdriVar7 = new zzdri("FIXED32", 6, zzdrnVar2, 5);
        l = zzdriVar7;
        zzdri zzdriVar8 = new zzdri("BOOL", 7, zzdrn.BOOLEAN, 0);
        m = zzdriVar8;
        final zzdrn zzdrnVar3 = zzdrn.STRING;
        final String str = "STRING";
        final int i4 = 8;
        zzdri zzdriVar9 = new zzdri(str, i4, zzdrnVar3, i2) { // from class: com.google.android.gms.internal.ads.qx
            {
                int i5 = 8;
                int i6 = 2;
            }
        };
        n = zzdriVar9;
        final zzdrn zzdrnVar4 = zzdrn.MESSAGE;
        final String str2 = "GROUP";
        final int i5 = 9;
        zzdri zzdriVar10 = new zzdri(str2, i5, zzdrnVar4, i3) { // from class: com.google.android.gms.internal.ads.rx
            {
                int i6 = 9;
                int i7 = 3;
            }
        };
        o = zzdriVar10;
        final String str3 = "MESSAGE";
        final int i6 = 10;
        final int i7 = 2;
        zzdri zzdriVar11 = new zzdri(str3, i6, zzdrnVar4, i7) { // from class: com.google.android.gms.internal.ads.sx
            {
                int i8 = 10;
                int i9 = 2;
            }
        };
        p = zzdriVar11;
        final zzdrn zzdrnVar5 = zzdrn.BYTE_STRING;
        final String str4 = "BYTES";
        final int i8 = 11;
        zzdri zzdriVar12 = new zzdri(str4, i8, zzdrnVar5, i7) { // from class: com.google.android.gms.internal.ads.tx
            {
                int i9 = 11;
                int i10 = 2;
            }
        };
        q = zzdriVar12;
        zzdri zzdriVar13 = new zzdri("UINT32", 12, zzdrnVar2, 0);
        r = zzdriVar13;
        zzdri zzdriVar14 = new zzdri("ENUM", 13, zzdrn.ENUM, 0);
        s = zzdriVar14;
        zzdri zzdriVar15 = new zzdri("SFIXED32", 14, zzdrnVar2, 5);
        t = zzdriVar15;
        zzdri zzdriVar16 = new zzdri("SFIXED64", 15, zzdrnVar, 1);
        u = zzdriVar16;
        zzdri zzdriVar17 = new zzdri("SINT32", 16, zzdrnVar2, 0);
        v = zzdriVar17;
        zzdri zzdriVar18 = new zzdri("SINT64", 17, zzdrnVar, 0);
        w = zzdriVar18;
        x = new zzdri[]{zzdriVar, zzdriVar2, zzdriVar3, zzdriVar4, zzdriVar5, zzdriVar6, zzdriVar7, zzdriVar8, zzdriVar9, zzdriVar10, zzdriVar11, zzdriVar12, zzdriVar13, zzdriVar14, zzdriVar15, zzdriVar16, zzdriVar17, zzdriVar18};
    }

    private zzdri(String str, int i2, zzdrn zzdrnVar, int i3) {
        super(str, i2);
        this.y = zzdrnVar;
        this.z = i3;
    }

    public static zzdri[] values() {
        return (zzdri[]) x.clone();
    }

    public final zzdrn g() {
        return this.y;
    }
}
