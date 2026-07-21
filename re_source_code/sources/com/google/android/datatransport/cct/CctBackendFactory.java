package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import com.google.android.datatransport.runtime.backends.h;
import com.google.android.datatransport.runtime.backends.m;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class CctBackendFactory implements com.google.android.datatransport.runtime.backends.d {
    @Override // com.google.android.datatransport.runtime.backends.d
    public m create(h hVar) {
        return new d(hVar.b(), hVar.e(), hVar.d());
    }
}
