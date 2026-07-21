package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class d implements DynamiteModule.VersionPolicy.IVersions {
    d() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions
    public final int a(Context context, String str, boolean z) throws DynamiteModule.LoadingException {
        return DynamiteModule.f(context, str, z);
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions
    public final int b(Context context, String str) {
        return DynamiteModule.a(context, str);
    }
}
