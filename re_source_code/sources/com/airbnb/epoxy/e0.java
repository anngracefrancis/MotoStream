package com.airbnb.epoxy;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: NotifyBlocker.java */
/* JADX INFO: loaded from: classes.dex */
class e0 extends RecyclerView.i {
    private boolean a;

    e0() {
    }

    void a() {
        this.a = true;
    }

    void b() {
        this.a = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onChanged() {
        if (!this.a) {
            throw new IllegalStateException("You cannot notify item changes directly. Call `requestModelBuild` instead.");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemRangeChanged(int i2, int i3) {
        onChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemRangeInserted(int i2, int i3) {
        onChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemRangeMoved(int i2, int i3, int i4) {
        onChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemRangeRemoved(int i2, int i3) {
        onChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemRangeChanged(int i2, int i3, Object obj) {
        onChanged();
    }
}
