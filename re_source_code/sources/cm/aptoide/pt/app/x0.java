package cm.aptoide.pt.app;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class x0 {
    public static /* synthetic */ int a(double d2) {
        long jDoubleToLongBits = Double.doubleToLongBits(d2);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }
}
