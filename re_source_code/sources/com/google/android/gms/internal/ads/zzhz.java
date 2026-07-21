package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCrypto;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public interface zzhz {
    boolean a(String str);

    Exception b();

    void c(zzhw zzhwVar);

    void close();

    MediaCrypto d();

    int getState();
}
