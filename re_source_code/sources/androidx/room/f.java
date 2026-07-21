package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: compiled from: InvalidationLiveDataContainer.java */
/* JADX INFO: loaded from: classes.dex */
class f {
    final Set<LiveData> a = Collections.newSetFromMap(new IdentityHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f2129b;

    f(j jVar) {
        this.f2129b = jVar;
    }
}
