package com.google.android.gms.common.images;

import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class zad extends zaa {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<ImageManager.OnImageLoadedListener> f11934b;

    public final boolean equals(Object obj) {
        if (!(obj instanceof zad)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zad zadVar = (zad) obj;
        ImageManager.OnImageLoadedListener onImageLoadedListener = this.f11934b.get();
        ImageManager.OnImageLoadedListener onImageLoadedListener2 = zadVar.f11934b.get();
        return onImageLoadedListener2 != null && onImageLoadedListener != null && Objects.a(onImageLoadedListener2, onImageLoadedListener) && Objects.a(zadVar.a, this.a);
    }

    public final int hashCode() {
        return Objects.b(this.a);
    }
}
