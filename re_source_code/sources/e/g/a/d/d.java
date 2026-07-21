package e.g.a.d;

import android.widget.TextView;

/* JADX INFO: compiled from: TextViewTextChangeEvent.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends e.g.a.c.c<TextView> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f21184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f21185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f21186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f21187e;

    private d(TextView textView, CharSequence charSequence, int i2, int i3, int i4) {
        super(textView);
        this.f21184b = charSequence;
        this.f21185c = i2;
        this.f21186d = i3;
        this.f21187e = i4;
    }

    public static d b(TextView textView, CharSequence charSequence, int i2, int i3, int i4) {
        return new d(textView, charSequence, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.a() == a() && this.f21184b.equals(dVar.f21184b) && this.f21185c == dVar.f21185c && this.f21186d == dVar.f21186d && this.f21187e == dVar.f21187e;
    }

    public int hashCode() {
        return ((((((((629 + a().hashCode()) * 37) + this.f21184b.hashCode()) * 37) + this.f21185c) * 37) + this.f21186d) * 37) + this.f21187e;
    }

    public String toString() {
        return "TextViewTextChangeEvent{text=" + ((Object) this.f21184b) + ", start=" + this.f21185c + ", before=" + this.f21186d + ", count=" + this.f21187e + ", view=" + a() + '}';
    }
}
