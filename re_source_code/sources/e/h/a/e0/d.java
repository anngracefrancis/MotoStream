package e.h.a.e0;

import e.h.a.k0.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: RedirectHandler.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    private static b a(Map<String, List<String>> map, String str) throws IOException {
        b bVarA = e.h.a.g0.c.j().a(str);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    bVarA.f(key, it.next());
                }
            }
        }
        return bVarA;
    }

    private static boolean b(int i2) {
        return i2 == 301 || i2 == 302 || i2 == 303 || i2 == 300 || i2 == 307 || i2 == 308;
    }

    public static b c(Map<String, List<String>> map, b bVar, List<String> list) throws IllegalAccessException, IOException {
        int iD = bVar.d();
        String strE = bVar.e("Location");
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (b(iD)) {
            if (strE == null) {
                throw new IllegalAccessException(f.o("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(iD), bVar.b()));
            }
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(d.class, "redirect to %s with %d, %s", strE, Integer.valueOf(iD), arrayList);
            }
            bVar.g();
            bVar = a(map, strE);
            arrayList.add(strE);
            bVar.execute();
            iD = bVar.d();
            strE = bVar.e("Location");
            i2++;
            if (i2 >= 10) {
                throw new IllegalAccessException(f.o("redirect too many times! %s", arrayList));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return bVar;
    }
}
