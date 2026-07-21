package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* JADX INFO: loaded from: classes2.dex */
final class pw<FieldDescriptorType> extends ow<FieldDescriptorType, Object> {
    pw(int i2) {
        super(i2, null);
    }

    @Override // com.google.android.gms.internal.ads.ow
    public final void f() {
        if (!a()) {
            for (int i2 = 0; i2 < h(); i2++) {
                Map.Entry<FieldDescriptorType, Object> entryQ = q(i2);
                if (((zzdnu) entryQ.getKey()).t()) {
                    entryQ.setValue(Collections.unmodifiableList((List) entryQ.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : i()) {
                if (((zzdnu) entry.getKey()).t()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.f();
    }
}
