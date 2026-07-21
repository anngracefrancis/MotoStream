package com.bumptech.glide.load.engine.a0;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: InternalCacheDiskCacheFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class f extends d {

    /* JADX INFO: compiled from: InternalCacheDiskCacheFactory.java */
    class a implements d.a {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f9063b;

        a(Context context, String str) {
            this.a = context;
            this.f9063b = str;
        }

        @Override // com.bumptech.glide.load.engine.a0.d.a
        public File a() {
            File cacheDir = this.a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f9063b != null ? new File(cacheDir, this.f9063b) : cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public f(Context context, String str, long j2) {
        super(new a(context, str), j2);
    }
}
