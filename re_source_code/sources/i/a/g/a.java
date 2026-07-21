package i.a.g;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: DNSCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends ConcurrentHashMap<String, List<b>> {
    public a(a aVar) {
        this(aVar != null ? aVar.size() : 1024);
        if (aVar != null) {
            putAll(aVar);
        }
    }

    private Collection<? extends b> a(String str) {
        return get(str != null ? str.toLowerCase() : null);
    }

    public boolean b(b bVar) {
        if (bVar == null) {
            return false;
        }
        List<b> list = get(bVar.b());
        if (list == null) {
            putIfAbsent(bVar.b(), new ArrayList());
            list = get(bVar.b());
        }
        synchronized (list) {
            list.add(bVar);
        }
        return true;
    }

    public Collection<b> c() {
        ArrayList arrayList = new ArrayList();
        for (List<b> list : values()) {
            if (list != null) {
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    @Override // java.util.AbstractMap
    protected Object clone() throws CloneNotSupportedException {
        return new a(this);
    }

    public b d(String str, i.a.g.s.e eVar, i.a.g.s.d dVar) {
        Collection<? extends b> collectionA = a(str);
        b bVar = null;
        if (collectionA != null) {
            synchronized (collectionA) {
                for (b bVar2 : collectionA) {
                    if (bVar2.t(eVar) && bVar2.s(dVar)) {
                        bVar = bVar2;
                        break;
                    }
                }
            }
        }
        return bVar;
    }

    public b e(b bVar) {
        Collection<? extends b> collectionA;
        b bVar2 = null;
        if (bVar != null && (collectionA = a(bVar.b())) != null) {
            synchronized (collectionA) {
                for (b bVar3 : collectionA) {
                    if (bVar3.l(bVar)) {
                        bVar2 = bVar3;
                        break;
                    }
                }
            }
        }
        return bVar2;
    }

    public Collection<? extends b> f(String str) {
        ArrayList arrayList;
        Collection<? extends b> collectionA = a(str);
        if (collectionA == null) {
            return Collections.emptyList();
        }
        synchronized (collectionA) {
            arrayList = new ArrayList(collectionA);
        }
        return arrayList;
    }

    public Collection<? extends b> h(String str, i.a.g.s.e eVar, i.a.g.s.d dVar) {
        ArrayList arrayList;
        Collection<? extends b> collectionA = a(str);
        if (collectionA == null) {
            return Collections.emptyList();
        }
        synchronized (collectionA) {
            arrayList = new ArrayList(collectionA);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (!bVar.t(eVar) || !bVar.s(dVar)) {
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    public boolean i(b bVar) {
        List<b> list;
        if (bVar == null || (list = get(bVar.b())) == null) {
            return false;
        }
        synchronized (list) {
            list.remove(bVar);
        }
        return false;
    }

    public boolean j(b bVar, b bVar2) {
        if (bVar == null || bVar2 == null || !bVar.b().equals(bVar2.b())) {
            return false;
        }
        List<b> list = get(bVar.b());
        if (list == null) {
            putIfAbsent(bVar.b(), new ArrayList());
            list = get(bVar.b());
        }
        synchronized (list) {
            list.remove(bVar2);
            list.add(bVar);
        }
        return true;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap
    public synchronized String toString() {
        StringBuffer stringBuffer;
        stringBuffer = new StringBuffer(2000);
        stringBuffer.append("\t---- cache ----");
        Enumeration enumerationKeys = keys();
        while (enumerationKeys.hasMoreElements()) {
            String str = (String) enumerationKeys.nextElement();
            stringBuffer.append("\n\t\t");
            stringBuffer.append("\n\t\tname '");
            stringBuffer.append(str);
            stringBuffer.append("' ");
            List<b> list = (List) get(str);
            if (list == null || list.isEmpty()) {
                stringBuffer.append(" no entries");
            } else {
                synchronized (list) {
                    for (b bVar : list) {
                        stringBuffer.append("\n\t\t\t");
                        stringBuffer.append(bVar.toString());
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

    public a(int i2) {
        super(i2);
    }
}
