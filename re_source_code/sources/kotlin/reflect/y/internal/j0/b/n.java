package kotlin.reflect.y.internal.j0.b;

import kotlin.jvm.internal.m;
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
public final class n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n f23217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final n f23218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final n f23219h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final n f23220i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ n[] f23221j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final b f23222k;
    private final f l;
    private final b m;

    static {
        b bVarE = b.e("kotlin/UByte");
        m.e(bVarE, "fromString(\"kotlin/UByte\")");
        f23217f = new n("UBYTE", 0, bVarE);
        b bVarE2 = b.e("kotlin/UShort");
        m.e(bVarE2, "fromString(\"kotlin/UShort\")");
        f23218g = new n("USHORT", 1, bVarE2);
        b bVarE3 = b.e("kotlin/UInt");
        m.e(bVarE3, "fromString(\"kotlin/UInt\")");
        f23219h = new n("UINT", 2, bVarE3);
        b bVarE4 = b.e("kotlin/ULong");
        m.e(bVarE4, "fromString(\"kotlin/ULong\")");
        f23220i = new n("ULONG", 3, bVarE4);
        f23221j = g();
    }

    private n(String str, int i2, b bVar) {
        super(str, i2);
        this.f23222k = bVar;
        f fVarJ = bVar.j();
        m.e(fVarJ, "classId.shortClassName");
        this.l = fVarJ;
        this.m = new b(bVar.h(), f.x(fVarJ.k() + "Array"));
    }

    private static final /* synthetic */ n[] g() {
        return new n[]{f23217f, f23218g, f23219h, f23220i};
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) f23221j.clone();
    }

    public final b k() {
        return this.m;
    }

    public final b q() {
        return this.f23222k;
    }

    public final f u() {
        return this.l;
    }
}
