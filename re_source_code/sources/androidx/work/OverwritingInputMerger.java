package androidx.work;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class OverwritingInputMerger extends k {
    @Override // androidx.work.k
    public e b(List<e> list) {
        e.a aVar = new e.a();
        HashMap map = new HashMap();
        Iterator<e> it = list.iterator();
        while (it.hasNext()) {
            map.putAll(it.next().i());
        }
        aVar.d(map);
        return aVar.a();
    }
}
