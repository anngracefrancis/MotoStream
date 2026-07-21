package com.bumptech.glide.load.o;

import android.content.Context;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.l;
import java.security.MessageDigest;

/* JADX INFO: compiled from: UnitTransformation.java */
/* JADX INFO: loaded from: classes.dex */
public final class b<T> implements l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final l<?> f9349b = new b();

    private b() {
    }

    public static <T> b<T> a() {
        return (b) f9349b;
    }

    @Override // com.bumptech.glide.load.l
    public u<T> transform(Context context, u<T> uVar, int i2, int i3) {
        return uVar;
    }

    @Override // com.bumptech.glide.load.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
