package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzvb {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16842b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzva f16844d = new zzvf();
    private final int a = 6;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16843c = 0;

    public zzvb(int i2) {
        this.f16842b = i2;
    }

    @VisibleForTesting
    private final String b(String str) {
        String[] strArrSplit = str.split("\n");
        if (strArrSplit.length == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        t40 t40Var = new t40();
        PriorityQueue priorityQueue = new PriorityQueue(this.f16842b, new s40(this));
        for (String str2 : strArrSplit) {
            String[] strArrB = zzve.b(str2, false);
            if (strArrB.length != 0) {
                zzvh.d(strArrB, this.f16842b, this.a, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                t40Var.a(this.f16844d.a(((zzvi) it.next()).f16846b));
            } catch (IOException e2) {
                zzbad.c("Error while writing hash to byteStream", e2);
            }
        }
        return t40Var.toString();
    }

    public final String a(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            String str = arrayList.get(i2);
            i2++;
            sb.append(str.toLowerCase(Locale.US));
            sb.append('\n');
        }
        return b(sb.toString());
    }
}
