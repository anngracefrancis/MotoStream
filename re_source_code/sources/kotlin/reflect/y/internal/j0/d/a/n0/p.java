package kotlin.reflect.y.internal.j0.d.a.n0;

import kotlin.collections.s;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.c;

/* JADX INFO: compiled from: javaLoading.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class p {
    private static final boolean a(r rVar) {
        c cVarD;
        b0 b0Var = (b0) s.u0(rVar.f());
        x type = b0Var != null ? b0Var.getType() : null;
        j jVar = type instanceof j ? (j) type : null;
        if (jVar == null) {
            return false;
        }
        i iVarC = jVar.c();
        return (iVarC instanceof g) && (cVarD = ((g) iVarC).d()) != null && m.a(cVarD.b(), "java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if (r0.equals("hashCode") == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
    
        if (r0.equals("toString") != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        return r3.f().isEmpty();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final boolean b(kotlin.reflect.y.internal.j0.d.a.n0.r r3) {
        /*
            kotlin.f0.y.e.j0.f.f r0 = r3.getName()
            java.lang.String r0 = r0.k()
            int r1 = r0.hashCode()
            r2 = -1776922004(0xffffffff9616526c, float:-1.2142911E-25)
            if (r1 == r2) goto L33
            r2 = -1295482945(0xffffffffb2c87fbf, float:-2.3341157E-8)
            if (r1 == r2) goto L25
            r2 = 147696667(0x8cdac1b, float:1.23784505E-33)
            if (r1 == r2) goto L1c
            goto L44
        L1c:
            java.lang.String r1 = "hashCode"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3b
            goto L44
        L25:
            java.lang.String r1 = "equals"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2e
            goto L44
        L2e:
            boolean r3 = a(r3)
            goto L45
        L33:
            java.lang.String r1 = "toString"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L44
        L3b:
            java.util.List r3 = r3.f()
            boolean r3 = r3.isEmpty()
            goto L45
        L44:
            r3 = 0
        L45:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.y.internal.j0.d.a.n0.p.b(kotlin.f0.y.e.j0.d.a.n0.r):boolean");
    }

    public static final boolean c(q qVar) {
        m.f(qVar, "<this>");
        return qVar.P().H() && (qVar instanceof r) && b((r) qVar);
    }
}
