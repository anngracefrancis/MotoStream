package kotlin.reflect.y.internal.j0.b;

import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'f' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: UnsignedType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m f23211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final m f23212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final m f23213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final m f23214i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ m[] f23215j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final b f23216k;
    private final f l;

    static {
        b bVarE = b.e("kotlin/UByteArray");
        kotlin.jvm.internal.m.e(bVarE, "fromString(\"kotlin/UByteArray\")");
        f23211f = new m("UBYTEARRAY", 0, bVarE);
        b bVarE2 = b.e("kotlin/UShortArray");
        kotlin.jvm.internal.m.e(bVarE2, "fromString(\"kotlin/UShortArray\")");
        f23212g = new m("USHORTARRAY", 1, bVarE2);
        b bVarE3 = b.e("kotlin/UIntArray");
        kotlin.jvm.internal.m.e(bVarE3, "fromString(\"kotlin/UIntArray\")");
        f23213h = new m("UINTARRAY", 2, bVarE3);
        b bVarE4 = b.e("kotlin/ULongArray");
        kotlin.jvm.internal.m.e(bVarE4, "fromString(\"kotlin/ULongArray\")");
        f23214i = new m("ULONGARRAY", 3, bVarE4);
        f23215j = g();
    }

    private m(String str, int i2, b bVar) {
        super(str, i2);
        this.f23216k = bVar;
        f fVarJ = bVar.j();
        kotlin.jvm.internal.m.e(fVarJ, "classId.shortClassName");
        this.l = fVarJ;
    }

    private static final /* synthetic */ m[] g() {
        return new m[]{f23211f, f23212g, f23213h, f23214i};
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) f23215j.clone();
    }

    public final f k() {
        return this.l;
    }
}
