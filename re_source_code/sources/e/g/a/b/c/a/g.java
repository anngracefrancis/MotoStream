package e.g.a.b.c.a;

import androidx.appcompat.widget.SearchView;

/* JADX INFO: compiled from: SearchViewQueryTextEvent.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends e.g.a.c.c<SearchView> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f21156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f21157c;

    private g(SearchView searchView, CharSequence charSequence, boolean z) {
        super(searchView);
        this.f21156b = charSequence;
        this.f21157c = z;
    }

    public static g b(SearchView searchView, CharSequence charSequence, boolean z) {
        return new g(searchView, charSequence, z);
    }

    public boolean c() {
        return this.f21157c;
    }

    public CharSequence d() {
        return this.f21156b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return gVar.a() == a() && gVar.f21156b.equals(this.f21156b) && gVar.f21157c == this.f21157c;
    }

    public int hashCode() {
        return ((((629 + a().hashCode()) * 37) + this.f21156b.hashCode()) * 37) + (this.f21157c ? 1 : 0);
    }

    public String toString() {
        return "SearchViewQueryTextEvent{view=" + a() + ", queryText=" + ((Object) this.f21156b) + ", submitted=" + this.f21157c + '}';
    }
}
