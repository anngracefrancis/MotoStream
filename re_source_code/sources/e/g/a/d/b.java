package e.g.a.d;

import android.text.Editable;
import android.widget.TextView;

/* JADX INFO: compiled from: TextViewAfterTextChangeEvent.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends e.g.a.c.c<TextView> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Editable f21178b;

    private b(TextView textView, Editable editable) {
        super(textView);
        this.f21178b = editable;
    }

    public static b b(TextView textView, Editable editable) {
        return new b(textView, editable);
    }

    public Editable c() {
        return this.f21178b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return bVar.a() == a() && this.f21178b.equals(bVar.f21178b);
    }

    public int hashCode() {
        return ((629 + a().hashCode()) * 37) + this.f21178b.hashCode();
    }

    public String toString() {
        return "TextViewAfterTextChangeEvent{editable=" + ((Object) this.f21178b) + ", view=" + a() + '}';
    }
}
