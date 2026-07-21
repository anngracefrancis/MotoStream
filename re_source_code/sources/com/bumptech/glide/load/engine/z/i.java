package com.bumptech.glide.load.engine.z;

/* JADX INFO: compiled from: IntegerArrayAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class i implements a<int[]> {
    @Override // com.bumptech.glide.load.engine.z.a
    public int a() {
        return 4;
    }

    @Override // com.bumptech.glide.load.engine.z.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int b(int[] iArr) {
        return iArr.length;
    }

    @Override // com.bumptech.glide.load.engine.z.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int[] newArray(int i2) {
        return new int[i2];
    }

    @Override // com.bumptech.glide.load.engine.z.a
    public String getTag() {
        return "IntegerArrayPool";
    }
}
