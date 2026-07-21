package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzazh {
    private Map<Integer, Bitmap> a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicInteger f14297b = new AtomicInteger(0);

    public final Bitmap a(Integer num) {
        return this.a.get(num);
    }
}
