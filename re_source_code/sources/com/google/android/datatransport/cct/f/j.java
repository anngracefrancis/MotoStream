package com.google.android.datatransport.cct.f;

import com.google.auto.value.AutoValue;
import java.util.List;

/* JADX INFO: compiled from: BatchedLogRequest.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class j {
    public static j a(List<m> list) {
        return new d(list);
    }

    public static com.google.firebase.encoders.a b() {
        return new com.google.firebase.encoders.json.d().g(b.a).h(true).f();
    }

    public abstract List<m> c();
}
