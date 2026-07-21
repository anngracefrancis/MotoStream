package com.airbnb.epoxy.preload;

import com.airbnb.epoxy.preload.c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;

/* JADX INFO: compiled from: PreloadTargetProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d<P extends c> {
    private final ArrayDeque<P> a;

    public d(int i2, Function0<? extends P> function0) {
        m.g(function0, "requestHolderFactory");
        IntRange intRangeK = l.k(0, i2);
        ArrayList arrayList = new ArrayList(v.u(intRangeK, 10));
        Iterator<Integer> it = intRangeK.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).b();
            arrayList.add(function0.invoke());
        }
        this.a = new ArrayDeque<>(arrayList);
    }

    public final void a() {
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            ((c) it.next()).clear();
        }
    }

    public final P b() {
        P pPoll = this.a.poll();
        this.a.offer(pPoll);
        pPoll.clear();
        m.b(pPoll, "result");
        return pPoll;
    }
}
