package com.airbnb.epoxy;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: EpoxyDiffLogger.java */
/* JADX INFO: loaded from: classes.dex */
public class p extends RecyclerView.i {
    private final String a;

    public p(String str) {
        this.a = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemRangeChanged(int i2, int i3) {
        Log.d(this.a, "Item range changed. Start: " + i2 + " Count: " + i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemRangeInserted(int i2, int i3) {
        Log.d(this.a, "Item range inserted. Start: " + i2 + " Count: " + i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemRangeMoved(int i2, int i3, int i4) {
        Log.d(this.a, "Item moved. From: " + i2 + " To: " + i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemRangeRemoved(int i2, int i3) {
        Log.d(this.a, "Item range removed. Start: " + i2 + " Count: " + i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemRangeChanged(int i2, int i3, Object obj) {
        if (obj == null) {
            onItemRangeChanged(i2, i3);
            return;
        }
        Log.d(this.a, "Item range changed with payloads. Start: " + i2 + " Count: " + i3);
    }
}
