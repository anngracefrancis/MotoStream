package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class k implements DynamiteModule.VersionPolicy {
    k() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult a(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        int iA;
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int iB = iVersions.b(context, str);
        selectionResult.a = iB;
        int i2 = 0;
        if (iB != 0) {
            iA = iVersions.a(context, str, false);
            selectionResult.f12203b = iA;
        } else {
            iA = iVersions.a(context, str, true);
            selectionResult.f12203b = iA;
        }
        int i3 = selectionResult.a;
        if (i3 == 0) {
            if (iA == 0) {
                selectionResult.f12204c = 0;
            }
            return selectionResult;
        }
        i2 = i3;
        if (iA >= i2) {
            selectionResult.f12204c = 1;
        } else {
            selectionResult.f12204c = -1;
        }
        return selectionResult;
    }
}
