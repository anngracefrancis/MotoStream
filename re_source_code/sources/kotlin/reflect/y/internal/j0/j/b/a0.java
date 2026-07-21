package kotlin.reflect.y.internal.j0.j.b;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.y.internal.j0.e.c;
import kotlin.reflect.y.internal.j0.e.k;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.s;
import kotlin.reflect.y.internal.j0.e.x;
import kotlin.reflect.y.internal.j0.l.r1;

/* JADX INFO: compiled from: ProtoEnumFlags.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 {
    public static final a0 a = new a0();

    /* JADX INFO: compiled from: ProtoEnumFlags.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f24459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f24460c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f24461d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f24462e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int[] f24463f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int[] f24464g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int[] f24465h;

        static {
            int[] iArr = new int[k.values().length];
            iArr[k.FINAL.ordinal()] = 1;
            iArr[k.OPEN.ordinal()] = 2;
            iArr[k.ABSTRACT.ordinal()] = 3;
            iArr[k.SEALED.ordinal()] = 4;
            a = iArr;
            int[] iArr2 = new int[d0.values().length];
            iArr2[d0.FINAL.ordinal()] = 1;
            iArr2[d0.OPEN.ordinal()] = 2;
            iArr2[d0.ABSTRACT.ordinal()] = 3;
            iArr2[d0.SEALED.ordinal()] = 4;
            f24459b = iArr2;
            int[] iArr3 = new int[x.values().length];
            iArr3[x.INTERNAL.ordinal()] = 1;
            iArr3[x.PRIVATE.ordinal()] = 2;
            iArr3[x.PRIVATE_TO_THIS.ordinal()] = 3;
            iArr3[x.PROTECTED.ordinal()] = 4;
            iArr3[x.PUBLIC.ordinal()] = 5;
            iArr3[x.LOCAL.ordinal()] = 6;
            f24460c = iArr3;
            int[] iArr4 = new int[c.EnumC0365c.values().length];
            iArr4[c.EnumC0365c.CLASS.ordinal()] = 1;
            iArr4[c.EnumC0365c.INTERFACE.ordinal()] = 2;
            iArr4[c.EnumC0365c.ENUM_CLASS.ordinal()] = 3;
            iArr4[c.EnumC0365c.ENUM_ENTRY.ordinal()] = 4;
            iArr4[c.EnumC0365c.ANNOTATION_CLASS.ordinal()] = 5;
            iArr4[c.EnumC0365c.OBJECT.ordinal()] = 6;
            iArr4[c.EnumC0365c.COMPANION_OBJECT.ordinal()] = 7;
            f24461d = iArr4;
            int[] iArr5 = new int[f.values().length];
            iArr5[f.CLASS.ordinal()] = 1;
            iArr5[f.INTERFACE.ordinal()] = 2;
            iArr5[f.ENUM_CLASS.ordinal()] = 3;
            iArr5[f.ENUM_ENTRY.ordinal()] = 4;
            iArr5[f.ANNOTATION_CLASS.ordinal()] = 5;
            iArr5[f.OBJECT.ordinal()] = 6;
            f24462e = iArr5;
            int[] iArr6 = new int[s.c.values().length];
            iArr6[s.c.IN.ordinal()] = 1;
            iArr6[s.c.OUT.ordinal()] = 2;
            iArr6[s.c.INV.ordinal()] = 3;
            f24463f = iArr6;
            int[] iArr7 = new int[q.b.c.values().length];
            iArr7[q.b.c.IN.ordinal()] = 1;
            iArr7[q.b.c.OUT.ordinal()] = 2;
            iArr7[q.b.c.INV.ordinal()] = 3;
            iArr7[q.b.c.STAR.ordinal()] = 4;
            f24464g = iArr7;
            int[] iArr8 = new int[r1.values().length];
            iArr8[r1.IN_VARIANCE.ordinal()] = 1;
            iArr8[r1.OUT_VARIANCE.ordinal()] = 2;
            iArr8[r1.INVARIANT.ordinal()] = 3;
            f24465h = iArr8;
        }
    }

    private a0() {
    }

    public final f a(c.EnumC0365c enumC0365c) {
        switch (enumC0365c == null ? -1 : a.f24461d[enumC0365c.ordinal()]) {
            case 1:
                return f.CLASS;
            case 2:
                return f.INTERFACE;
            case 3:
                return f.ENUM_CLASS;
            case 4:
                return f.ENUM_ENTRY;
            case 5:
                return f.ANNOTATION_CLASS;
            case 6:
            case 7:
                return f.OBJECT;
            default:
                return f.CLASS;
        }
    }

    public final d0 b(k kVar) {
        int i2 = kVar == null ? -1 : a.a[kVar.ordinal()];
        if (i2 == 1) {
            return d0.FINAL;
        }
        if (i2 == 2) {
            return d0.OPEN;
        }
        if (i2 != 3) {
            return i2 != 4 ? d0.FINAL : d0.SEALED;
        }
        return d0.ABSTRACT;
    }

    public final r1 c(q.b.c cVar) {
        m.f(cVar, "projection");
        int i2 = a.f24464g[cVar.ordinal()];
        if (i2 == 1) {
            return r1.IN_VARIANCE;
        }
        if (i2 == 2) {
            return r1.OUT_VARIANCE;
        }
        if (i2 == 3) {
            return r1.INVARIANT;
        }
        if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalArgumentException("Only IN, OUT and INV are supported. Actual argument: " + cVar);
    }

    public final r1 d(s.c cVar) {
        m.f(cVar, "variance");
        int i2 = a.f24463f[cVar.ordinal()];
        if (i2 == 1) {
            return r1.IN_VARIANCE;
        }
        if (i2 == 2) {
            return r1.OUT_VARIANCE;
        }
        if (i2 == 3) {
            return r1.INVARIANT;
        }
        throw new NoWhenBranchMatchedException();
    }
}
