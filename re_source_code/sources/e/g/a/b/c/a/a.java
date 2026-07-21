package e.g.a.b.c.a;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: RecyclerViewScrollEvent.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends e.g.a.c.c<RecyclerView> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f21148c;

    private a(RecyclerView recyclerView, int i2, int i3) {
        super(recyclerView);
        this.f21147b = i2;
        this.f21148c = i3;
    }

    public static a b(RecyclerView recyclerView, int i2, int i3) {
        return new a(recyclerView, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return aVar.a() == a() && this.f21147b == aVar.f21147b && this.f21148c == aVar.f21148c;
    }

    public int hashCode() {
        return ((((629 + a().hashCode()) * 37) + this.f21147b) * 37) + this.f21148c;
    }

    public String toString() {
        return "RecyclerViewScrollEvent{view=" + a() + ", dx=" + this.f21147b + ", dy=" + this.f21148c + '}';
    }
}
