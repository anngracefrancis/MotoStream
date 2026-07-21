package rx.n.e.o;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SpscArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class t<E> extends f<E> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Integer f26821k = Integer.getInteger("jctools.spsc.max.lookahead.step", RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT);
    protected final int l;

    public t(int i2) {
        super(i2);
        this.l = Math.min(i2 / 4, f26821k.intValue());
    }
}
