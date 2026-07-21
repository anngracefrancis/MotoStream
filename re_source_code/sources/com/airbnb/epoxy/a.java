package com.airbnb.epoxy;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ActivityRecyclerPool.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private final ArrayList<PoolReference> a = new ArrayList<>(5);

    public final void a(PoolReference poolReference) {
        kotlin.jvm.internal.m.g(poolReference, "pool");
        if (b.a(poolReference.c())) {
            poolReference.getViewPool().b();
            this.a.remove(poolReference);
        }
    }

    public final PoolReference b(Context context, Function0<? extends RecyclerView.u> function0) {
        Object obj;
        androidx.lifecycle.g lifecycle;
        kotlin.jvm.internal.m.g(context, "context");
        kotlin.jvm.internal.m.g(function0, "poolFactory");
        Iterator<PoolReference> it = this.a.iterator();
        kotlin.jvm.internal.m.b(it, "pools.iterator()");
        PoolReference poolReference = null;
        while (it.hasNext()) {
            PoolReference next = it.next();
            kotlin.jvm.internal.m.b(next, "iterator.next()");
            PoolReference poolReference2 = next;
            if (poolReference2.c() == context) {
                if (poolReference != null) {
                    throw new IllegalStateException("A pool was already found");
                }
                poolReference = poolReference2;
            } else if (b.a(poolReference2.c())) {
                poolReference2.getViewPool().b();
                it.remove();
            }
        }
        if (poolReference == null) {
            poolReference = new PoolReference(context, function0.invoke(), this);
            if (!(context instanceof androidx.lifecycle.k)) {
                obj = context;
                obj = null;
            }
            obj = context;
            androidx.lifecycle.k kVar = (androidx.lifecycle.k) obj;
            if (kVar != null && (lifecycle = kVar.getLifecycle()) != null) {
                lifecycle.a(poolReference);
            }
            this.a.add(poolReference);
        }
        return poolReference;
    }
}
