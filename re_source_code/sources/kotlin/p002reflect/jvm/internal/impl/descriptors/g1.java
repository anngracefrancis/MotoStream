package kotlin.p002reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.w1.k;
import kotlin.s;

/* JADX INFO: compiled from: ValueClassRepresentation.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g1<Type extends k> {
    private g1() {
    }

    public /* synthetic */ g1(g gVar) {
        this();
    }

    public abstract List<Pair<f, Type>> a();

    public final <Other extends k> g1<Other> b(Function1<? super Type, ? extends Other> function1) {
        m.f(function1, "transform");
        if (this instanceof z) {
            z zVar = (z) this;
            return new z(zVar.c(), function1.invoke(zVar.d()));
        }
        if (!(this instanceof h0)) {
            throw new NoWhenBranchMatchedException();
        }
        List<Pair<f, Type>> listA = a();
        ArrayList arrayList = new ArrayList(v.u(listA, 10));
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList.add(s.a((f) pair.a(), function1.invoke((k) pair.b())));
        }
        return new h0(arrayList);
    }
}
