package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: CreationContext.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class h {
    public static h a(Context context, e.e.b.a.i.c0.a aVar, e.e.b.a.i.c0.a aVar2, String str) {
        return new c(context, aVar, aVar2, str);
    }

    public abstract Context b();

    public abstract String c();

    public abstract e.e.b.a.i.c0.a d();

    public abstract e.e.b.a.i.c0.a e();
}
