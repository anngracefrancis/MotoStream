package io.rakam.api;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Rakam.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    static final Map<String, g> a = new HashMap();

    public static g a() {
        return b(null);
    }

    public static synchronized g b(String str) {
        g gVar;
        String strE = j.e(str);
        Map<String, g> map = a;
        gVar = map.get(strE);
        if (gVar == null) {
            gVar = new g(strE);
            map.put(strE, gVar);
        }
        return gVar;
    }
}
