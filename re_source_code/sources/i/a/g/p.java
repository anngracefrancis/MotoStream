package i.a.g;

/* JADX INFO: compiled from: ServiceEventImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class p extends i.a.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f21844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f21845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final i.a.d f21846h;

    public p(l lVar, String str, String str2, i.a.d dVar) {
        super(lVar);
        this.f21844f = str;
        this.f21845g = str2;
        this.f21846h = dVar;
    }

    @Override // i.a.c
    public i.a.a d() {
        return (i.a.a) getSource();
    }

    @Override // i.a.c
    public i.a.d e() {
        return this.f21846h;
    }

    @Override // i.a.c
    public String f() {
        return this.f21845g;
    }

    @Override // i.a.c
    public String g() {
        return this.f21844f;
    }

    @Override // i.a.c
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public p clone() {
        return new p((l) d(), g(), f(), new q(e()));
    }

    @Override // java.util.EventObject
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[" + p.class.getSimpleName() + "@" + System.identityHashCode(this) + " ");
        sb.append("\n\tname: '");
        sb.append(f());
        sb.append("' type: '");
        sb.append(g());
        sb.append("' info: '");
        sb.append(e());
        sb.append("']");
        return sb.toString();
    }
}
