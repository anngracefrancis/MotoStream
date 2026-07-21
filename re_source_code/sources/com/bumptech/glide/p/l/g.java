package com.bumptech.glide.p.l;

import com.bumptech.glide.r.k;

/* JADX INFO: compiled from: SimpleTarget.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class g<Z> extends a<Z> {
    private final int height;
    private final int width;

    public g() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.p.l.i
    public final void getSize(h hVar) {
        if (k.t(this.width, this.height)) {
            hVar.g(this.width, this.height);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.width + " and height: " + this.height + ", either provide dimensions in the constructor or call override()");
    }

    @Override // com.bumptech.glide.p.l.i
    public void removeCallback(h hVar) {
    }

    public g(int i2, int i3) {
        this.width = i2;
        this.height = i3;
    }
}
