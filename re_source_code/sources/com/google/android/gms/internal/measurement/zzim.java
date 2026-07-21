package com.google.android.gms.internal.measurement;

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
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzim {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzim f17435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzim f17436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final zzim f17437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final zzim f17438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final zzim f17439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final zzim f17440k;
    public static final zzim l;
    public static final zzim m;
    public static final zzim n;
    public static final zzim o;
    public static final zzim p;
    public static final zzim q;
    public static final zzim r;
    public static final zzim s;
    public static final zzim t;
    public static final zzim u;
    public static final zzim v;
    public static final zzim w;
    private static final /* synthetic */ zzim[] x;
    private final zzip y;
    private final int z;

    static {
        zzim zzimVar = new zzim("DOUBLE", 0, zzip.DOUBLE, 1);
        f17435f = zzimVar;
        zzim zzimVar2 = new zzim("FLOAT", 1, zzip.FLOAT, 5);
        f17436g = zzimVar2;
        zzip zzipVar = zzip.LONG;
        final int i2 = 2;
        zzim zzimVar3 = new zzim("INT64", 2, zzipVar, 0);
        f17437h = zzimVar3;
        final int i3 = 3;
        zzim zzimVar4 = new zzim("UINT64", 3, zzipVar, 0);
        f17438i = zzimVar4;
        zzip zzipVar2 = zzip.INT;
        zzim zzimVar5 = new zzim("INT32", 4, zzipVar2, 0);
        f17439j = zzimVar5;
        zzim zzimVar6 = new zzim("FIXED64", 5, zzipVar, 1);
        f17440k = zzimVar6;
        zzim zzimVar7 = new zzim("FIXED32", 6, zzipVar2, 5);
        l = zzimVar7;
        zzim zzimVar8 = new zzim("BOOL", 7, zzip.BOOLEAN, 0);
        m = zzimVar8;
        final zzip zzipVar3 = zzip.STRING;
        final String str = "STRING";
        final int i4 = 8;
        zzim zzimVar9 = new zzim(str, i4, zzipVar3, i2) { // from class: com.google.android.gms.internal.measurement.u4
            {
                int i5 = 8;
                int i6 = 2;
            }
        };
        n = zzimVar9;
        final zzip zzipVar4 = zzip.MESSAGE;
        final String str2 = "GROUP";
        final int i5 = 9;
        zzim zzimVar10 = new zzim(str2, i5, zzipVar4, i3) { // from class: com.google.android.gms.internal.measurement.w4
            {
                int i6 = 9;
                int i7 = 3;
            }
        };
        o = zzimVar10;
        final String str3 = "MESSAGE";
        final int i6 = 10;
        final int i7 = 2;
        zzim zzimVar11 = new zzim(str3, i6, zzipVar4, i7) { // from class: com.google.android.gms.internal.measurement.v4
            {
                int i8 = 10;
                int i9 = 2;
            }
        };
        p = zzimVar11;
        final zzip zzipVar5 = zzip.BYTE_STRING;
        final String str4 = "BYTES";
        final int i8 = 11;
        zzim zzimVar12 = new zzim(str4, i8, zzipVar5, i7) { // from class: com.google.android.gms.internal.measurement.x4
            {
                int i9 = 11;
                int i10 = 2;
            }
        };
        q = zzimVar12;
        zzim zzimVar13 = new zzim("UINT32", 12, zzipVar2, 0);
        r = zzimVar13;
        zzim zzimVar14 = new zzim("ENUM", 13, zzip.ENUM, 0);
        s = zzimVar14;
        zzim zzimVar15 = new zzim("SFIXED32", 14, zzipVar2, 5);
        t = zzimVar15;
        zzim zzimVar16 = new zzim("SFIXED64", 15, zzipVar, 1);
        u = zzimVar16;
        zzim zzimVar17 = new zzim("SINT32", 16, zzipVar2, 0);
        v = zzimVar17;
        zzim zzimVar18 = new zzim("SINT64", 17, zzipVar, 0);
        w = zzimVar18;
        x = new zzim[]{zzimVar, zzimVar2, zzimVar3, zzimVar4, zzimVar5, zzimVar6, zzimVar7, zzimVar8, zzimVar9, zzimVar10, zzimVar11, zzimVar12, zzimVar13, zzimVar14, zzimVar15, zzimVar16, zzimVar17, zzimVar18};
    }

    private zzim(String str, int i2, zzip zzipVar, int i3) {
        super(str, i2);
        this.y = zzipVar;
        this.z = i3;
    }

    public static zzim[] values() {
        return (zzim[]) x.clone();
    }

    public final zzip g() {
        return this.y;
    }
}
