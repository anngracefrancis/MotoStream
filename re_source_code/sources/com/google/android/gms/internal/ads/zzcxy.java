package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcxy {
    public static zzyd a(Context context, List<zzcxn> list) {
        ArrayList arrayList = new ArrayList();
        for (zzcxn zzcxnVar : list) {
            if (zzcxnVar.f15735c) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(zzcxnVar.a, zzcxnVar.f15734b));
            }
        }
        return new zzyd(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }
}
