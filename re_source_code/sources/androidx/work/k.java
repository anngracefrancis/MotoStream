package androidx.work;

import java.util.List;

/* JADX INFO: compiled from: InputMerger.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    private static final String a = n.f("InputMerger");

    public static k a(String str) {
        try {
            return (k) Class.forName(str).newInstance();
        } catch (Exception e2) {
            n.c().b(a, "Trouble instantiating + " + str, e2);
            return null;
        }
    }

    public abstract e b(List<e> list);
}
