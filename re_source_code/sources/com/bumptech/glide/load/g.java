package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.u;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: MultiTransformation.java */
/* JADX INFO: loaded from: classes.dex */
public class g<T> implements l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Collection<? extends l<T>> f9254b;

    @SafeVarargs
    public g(l<T>... lVarArr) {
        if (lVarArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.f9254b = Arrays.asList(lVarArr);
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f9254b.equals(((g) obj).f9254b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return this.f9254b.hashCode();
    }

    @Override // com.bumptech.glide.load.l
    public u<T> transform(Context context, u<T> uVar, int i2, int i3) {
        Iterator<? extends l<T>> it = this.f9254b.iterator();
        u<T> uVar2 = uVar;
        while (it.hasNext()) {
            u<T> uVarTransform = it.next().transform(context, uVar2, i2, i3);
            if (uVar2 != null && !uVar2.equals(uVar) && !uVar2.equals(uVarTransform)) {
                uVar2.c();
            }
            uVar2 = uVarTransform;
        }
        return uVar2;
    }

    @Override // com.bumptech.glide.load.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Iterator<? extends l<T>> it = this.f9254b.iterator();
        while (it.hasNext()) {
            it.next().updateDiskCacheKey(messageDigest);
        }
    }
}
