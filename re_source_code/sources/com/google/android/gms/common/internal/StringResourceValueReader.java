package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class StringResourceValueReader {
    private final Resources a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12016b;

    public StringResourceValueReader(Context context) {
        Preconditions.k(context);
        Resources resources = context.getResources();
        this.a = resources;
        this.f12016b = resources.getResourcePackageName(R.string.a);
    }

    @KeepForSdk
    public String a(String str) {
        int identifier = this.a.getIdentifier(str, "string", this.f12016b);
        if (identifier == 0) {
            return null;
        }
        return this.a.getString(identifier);
    }
}
