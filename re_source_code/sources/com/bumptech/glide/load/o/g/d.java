package com.bumptech.glide.load.o.g;

import android.util.Log;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.k;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: GifDrawableEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements k<c> {
    @Override // com.bumptech.glide.load.k
    public com.bumptech.glide.load.c b(com.bumptech.glide.load.i iVar) {
        return com.bumptech.glide.load.c.SOURCE;
    }

    @Override // com.bumptech.glide.load.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(u<c> uVar, File file, com.bumptech.glide.load.i iVar) throws Throwable {
        try {
            com.bumptech.glide.r.a.d(uVar.get().c(), file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e2);
            }
            return false;
        }
    }
}
