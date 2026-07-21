package com.bumptech.glide.q;

import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* JADX INFO: compiled from: EmptySignature.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f9537b = new b();

    private b() {
    }

    public static b a() {
        return f9537b;
    }

    public String toString() {
        return "EmptySignature";
    }

    @Override // com.bumptech.glide.load.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
