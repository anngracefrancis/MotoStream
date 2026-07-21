package com.google.firebase.r;

import com.google.auto.value.AutoValue;
import java.util.List;

/* JADX INFO: compiled from: HeartBeatResult.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class l {
    public static l a(String str, List<String> list) {
        return new e(str, list);
    }

    public abstract List<String> b();

    public abstract String c();
}
