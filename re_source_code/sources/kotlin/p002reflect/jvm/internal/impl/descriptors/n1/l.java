package kotlin.p002reflect.jvm.internal.impl.descriptors.n1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.c;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g f25189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f25190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Function1<c, Boolean> f25191h;

    /* JADX WARN: Multi-variable type inference failed */
    public l(g gVar, boolean z, Function1<? super c, Boolean> function1) {
        m.f(gVar, "delegate");
        m.f(function1, "fqNameFilter");
        this.f25189f = gVar;
        this.f25190g = z;
        this.f25191h = function1;
    }

    private final boolean c(c cVar) {
        c cVarD = cVar.d();
        return cVarD != null && this.f25191h.invoke(cVarD).booleanValue();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
    public boolean R0(c cVar) {
        m.f(cVar, "fqName");
        if (this.f25191h.invoke(cVar).booleanValue()) {
            return this.f25189f.R0(cVar);
        }
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
    public boolean isEmpty() {
        boolean z;
        g gVar = this.f25189f;
        if (!(gVar instanceof Collection) || !((Collection) gVar).isEmpty()) {
            Iterator<c> it = gVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (c(it.next())) {
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
            break;
        }
        if (this.f25190g) {
            return !z;
        }
        return z;
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        g gVar = this.f25189f;
        ArrayList arrayList = new ArrayList();
        for (c cVar : gVar) {
            if (c(cVar)) {
                arrayList.add(cVar);
            }
        }
        return arrayList.iterator();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
    public c l(c cVar) {
        m.f(cVar, "fqName");
        if (this.f25191h.invoke(cVar).booleanValue()) {
            return this.f25189f.l(cVar);
        }
        return null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(g gVar, Function1<? super c, Boolean> function1) {
        this(gVar, false, function1);
        m.f(gVar, "delegate");
        m.f(function1, "fqNameFilter");
    }
}
