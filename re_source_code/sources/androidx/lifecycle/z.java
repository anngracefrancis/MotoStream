package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: ViewModelStore.java */
/* JADX INFO: loaded from: classes.dex */
public class z {
    private final HashMap<String, x> a = new HashMap<>();

    public final void a() {
        Iterator<x> it = this.a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.a.clear();
    }

    final x b(String str) {
        return this.a.get(str);
    }

    Set<String> c() {
        return new HashSet(this.a.keySet());
    }

    final void d(String str, x xVar) {
        x xVarPut = this.a.put(str, xVar);
        if (xVarPut != null) {
            xVarPut.d();
        }
    }
}
