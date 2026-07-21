package com.bumptech.glide.q;

import com.bumptech.glide.load.f;
import com.bumptech.glide.r.j;
import java.security.MessageDigest;

/* JADX INFO: compiled from: ObjectKey.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f9538b;

    public c(Object obj) {
        this.f9538b = j.d(obj);
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f9538b.equals(((c) obj).f9538b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return this.f9538b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f9538b + '}';
    }

    @Override // com.bumptech.glide.load.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.f9538b.toString().getBytes(f.a));
    }
}
