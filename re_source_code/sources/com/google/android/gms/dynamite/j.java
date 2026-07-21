package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class j implements DynamiteModule.VersionPolicy {
    j() {
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Code duplicated, block: B:9:0x0022  */
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult a(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        selectionResult.a = iVersions.b(context, str);
        int iA = iVersions.a(context, str, true);
        selectionResult.f12203b = iA;
        int i2 = selectionResult.a;
        if (i2 != 0) {
            if (iA >= i2) {
                selectionResult.f12204c = 1;
            } else {
                selectionResult.f12204c = -1;
            }
        } else if (iA == 0) {
            selectionResult.f12204c = 0;
        } else {
            i2 = 0;
            if (iA >= i2) {
                selectionResult.f12204c = 1;
            } else {
                selectionResult.f12204c = -1;
            }
        }
        return selectionResult;
    }
}
