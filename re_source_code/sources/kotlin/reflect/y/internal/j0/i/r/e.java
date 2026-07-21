package kotlin.reflect.y.internal.j0.i.r;

import java.util.Arrays;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends o<Character> {
    public e(char c2) {
        super(Character.valueOf(c2));
    }

    private final String c(char c2) {
        if (c2 == '\b') {
            return "\\b";
        }
        if (c2 == '\t') {
            return "\\t";
        }
        if (c2 == '\n') {
            return "\\n";
        }
        if (c2 == '\f') {
            return "\\f";
        }
        if (c2 == '\r') {
            return "\\r";
        }
        return e(c2) ? String.valueOf(c2) : "?";
    }

    private final boolean e(char c2) {
        byte type = (byte) Character.getType(c2);
        return (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) ? false : true;
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public m0 a(g0 g0Var) {
        m.f(g0Var, "module");
        m0 m0VarU = g0Var.o().u();
        m.e(m0VarU, "module.builtIns.charType");
        return m0VarU;
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    public String toString() {
        String str = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(b().charValue()), c(b().charValue())}, 2));
        m.e(str, "format(this, *args)");
        return str;
    }
}
