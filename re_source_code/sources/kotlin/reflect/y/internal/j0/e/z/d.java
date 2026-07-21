package kotlin.reflect.y.internal.j0.e.z;

import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.c0;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.e.o;
import kotlin.reflect.y.internal.j0.e.p;

/* JADX INFO: compiled from: NameResolverImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements c {
    private final p a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f24194b;

    /* JADX INFO: compiled from: NameResolverImpl.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[o.c.EnumC0366c.values().length];
            iArr[o.c.EnumC0366c.CLASS.ordinal()] = 1;
            iArr[o.c.EnumC0366c.PACKAGE.ordinal()] = 2;
            iArr[o.c.EnumC0366c.LOCAL.ordinal()] = 3;
            a = iArr;
        }
    }

    public d(p pVar, o oVar) {
        m.f(pVar, "strings");
        m.f(oVar, "qualifiedNames");
        this.a = pVar;
        this.f24194b = oVar;
    }

    private final Triple<List<String>, List<String>, Boolean> c(int i2) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        while (i2 != -1) {
            o.c cVarV = this.f24194b.v(i2);
            String strV = this.a.v(cVarV.z());
            o.c.EnumC0366c enumC0366cX = cVarV.x();
            m.c(enumC0366cX);
            int i3 = a.a[enumC0366cX.ordinal()];
            if (i3 == 1) {
                linkedList2.addFirst(strV);
            } else if (i3 == 2) {
                linkedList.addFirst(strV);
            } else if (i3 == 3) {
                linkedList2.addFirst(strV);
                z = true;
            }
            i2 = cVarV.y();
        }
        return new Triple<>(linkedList, linkedList2, Boolean.valueOf(z));
    }

    @Override // kotlin.reflect.y.internal.j0.e.z.c
    public String a(int i2) {
        Triple<List<String>, List<String>, Boolean> tripleC = c(i2);
        List<String> listA = tripleC.a();
        String strE0 = c0.e0(tripleC.b(), ".", null, null, 0, null, null, 62, null);
        if (listA.isEmpty()) {
            return strE0;
        }
        return c0.e0(listA, "/", null, null, 0, null, null, 62, null) + '/' + strE0;
    }

    @Override // kotlin.reflect.y.internal.j0.e.z.c
    public boolean b(int i2) {
        return c(i2).d().booleanValue();
    }

    @Override // kotlin.reflect.y.internal.j0.e.z.c
    public String getString(int i2) {
        String strV = this.a.v(i2);
        m.e(strV, "strings.getString(index)");
        return strV;
    }
}
