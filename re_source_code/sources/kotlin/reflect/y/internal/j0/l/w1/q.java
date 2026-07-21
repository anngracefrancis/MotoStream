package kotlin.reflect.y.internal.j0.l.w1;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.r1;

/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: compiled from: TypeSystemContext.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r1.values().length];
            iArr[r1.INVARIANT.ordinal()] = 1;
            iArr[r1.IN_VARIANCE.ordinal()] = 2;
            iArr[r1.OUT_VARIANCE.ordinal()] = 3;
            a = iArr;
        }
    }

    public static final u a(r1 r1Var) {
        m.f(r1Var, "<this>");
        int i2 = a.a[r1Var.ordinal()];
        if (i2 == 1) {
            return u.INV;
        }
        if (i2 == 2) {
            return u.IN;
        }
        if (i2 == 3) {
            return u.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }
}
