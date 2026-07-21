package androidx.work;

/* JADX INFO: compiled from: InputMergerFactory.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: compiled from: InputMergerFactory.java */
    class a extends l {
        a() {
        }

        @Override // androidx.work.l
        public k a(String str) {
            return null;
        }
    }

    public static l c() {
        return new a();
    }

    public abstract k a(String str);

    public final k b(String str) {
        k kVarA = a(str);
        return kVarA == null ? k.a(str) : kVarA;
    }
}
