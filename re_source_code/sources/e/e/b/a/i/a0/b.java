package e.e.b.a.i.a0;

/* JADX INFO: compiled from: Retries.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static <TInput, TResult, TException extends Throwable> TResult a(int i2, TInput tinput, a<TInput, TResult, TException> aVar, c<TInput, TResult> cVar) throws Throwable {
        TResult tresultA;
        if (i2 < 1) {
            return aVar.a(tinput);
        }
        do {
            tresultA = aVar.a(tinput);
            tinput = cVar.a(tinput, tresultA);
            if (tinput == null) {
                break;
            }
            i2--;
        } while (i2 >= 1);
        return tresultA;
    }
}
