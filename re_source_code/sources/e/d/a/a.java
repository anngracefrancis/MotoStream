package e.d.a;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    protected boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Map<String, String> f20688b;

    public Map<String, String> a() {
        return this.f20688b;
    }

    public boolean b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        Map<String, String> map;
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.a == aVar.b() && ((map = this.f20688b) == null ? aVar.a() == null : map.equals(aVar.a()))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = (this.a ? 1 : 0) * 31;
        Map<String, String> map = this.f20688b;
        return i2 + (map != null ? map.hashCode() : 0);
    }
}
