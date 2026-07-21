package kotlin.jvm.internal;

/* JADX INFO: compiled from: PropertyReference2Impl.java */
/* JADX INFO: loaded from: classes2.dex */
public class a0 extends z {
    public a0(Class cls, String str, String str2, int i2) {
        super(cls, str, str2, i2);
    }

    @Override // kotlin.reflect.KProperty2
    public Object t(Object obj, Object obj2) {
        return getGetter().call(obj, obj2);
    }
}
