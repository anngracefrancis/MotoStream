package io.sentry.internal.modules;

import io.sentry.w1;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: CompositeModulesLoader.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
@ApiStatus.Experimental
public final class a extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<b> f22443d;

    public a(List<b> list, w1 w1Var) {
        super(w1Var);
        this.f22443d = list;
    }

    @Override // io.sentry.internal.modules.d
    protected Map<String, String> b() {
        TreeMap treeMap = new TreeMap();
        Iterator<b> it = this.f22443d.iterator();
        while (it.hasNext()) {
            Map<String, String> mapA = it.next().a();
            if (mapA != null) {
                treeMap.putAll(mapA);
            }
        }
        return treeMap;
    }
}
