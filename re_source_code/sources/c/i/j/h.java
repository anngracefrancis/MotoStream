package c.i.j;

/* JADX INFO: compiled from: Pools.java */
/* JADX INFO: loaded from: classes.dex */
public class h<T> extends g<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f3283c;

    public h(int i2) {
        super(i2);
        this.f3283c = new Object();
    }

    @Override // c.i.j.g, c.i.j.f
    public boolean a(T t) {
        boolean zA;
        synchronized (this.f3283c) {
            zA = super.a(t);
        }
        return zA;
    }

    @Override // c.i.j.g, c.i.j.f
    public T b() {
        T t;
        synchronized (this.f3283c) {
            t = (T) super.b();
        }
        return t;
    }
}
