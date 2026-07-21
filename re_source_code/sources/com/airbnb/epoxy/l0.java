package com.airbnb.epoxy;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: compiled from: UnboundedViewPool.kt */
/* JADX INFO: loaded from: classes.dex */
public final class l0 extends RecyclerView.u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray<Queue<RecyclerView.c0>> f8440c = new SparseArray<>();

    private final Queue<RecyclerView.c0> m(int i2) {
        Queue<RecyclerView.c0> queue = this.f8440c.get(i2);
        if (queue != null) {
            return queue;
        }
        LinkedList linkedList = new LinkedList();
        this.f8440c.put(i2, linkedList);
        return linkedList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.u
    public void b() {
        this.f8440c.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.u
    public RecyclerView.c0 f(int i2) {
        Queue<RecyclerView.c0> queue = this.f8440c.get(i2);
        if (queue != null) {
            return queue.poll();
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.u
    public void i(RecyclerView.c0 c0Var) {
        kotlin.jvm.internal.m.g(c0Var, "viewHolder");
        m(c0Var.getItemViewType()).add(c0Var);
    }
}
