package kotlin.reflect.y.internal.j0.l;

import java.util.Iterator;
import kotlin.collections.c0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c;
import kotlin.reflect.y.internal.j0.l.w1.k;
import kotlin.reflect.y.internal.j0.l.w1.l;
import kotlin.text.r;

/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m0 extends q1 implements k, l {
    public m0() {
        super(null);
    }

    public abstract m0 V0(boolean z);

    public abstract m0 W0(a1 a1Var);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<c> it = getAnnotations().iterator();
        while (it.hasNext()) {
            r.i(sb, "[", kotlin.reflect.y.internal.j0.h.c.s(kotlin.reflect.y.internal.j0.h.c.f24255j, it.next(), null, 2, null), "] ");
        }
        sb.append(O0());
        if (!M0().isEmpty()) {
            c0.c0(M0(), sb, ", ", "<", ">", 0, null, null, 112, null);
        }
        if (P0()) {
            sb.append("?");
        }
        String string = sb.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
