package k.b.f;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: NamedLoggerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f implements k.b.b, Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f22914f;

    f() {
    }

    public String j() {
        return this.f22914f;
    }

    protected Object readResolve() throws ObjectStreamException {
        return k.b.c.i(j());
    }
}
