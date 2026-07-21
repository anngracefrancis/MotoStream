package i.a;

import java.util.EventListener;

/* JADX INFO: compiled from: ServiceListener.java */
/* JADX INFO: loaded from: classes2.dex */
public interface e extends EventListener {
    void serviceAdded(c cVar);

    void serviceRemoved(c cVar);

    void serviceResolved(c cVar);
}
