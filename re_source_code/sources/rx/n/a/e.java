package rx.n.a;

import java.util.ArrayList;
import java.util.Queue;
import rx.exceptions.CompositeException;

/* JADX INFO: compiled from: CompletableOnSubscribeMerge.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements rx.b.w {
    public static Throwable a(Queue<Throwable> queue) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            Throwable thPoll = queue.poll();
            if (thPoll == null) {
                break;
            }
            arrayList.add(thPoll);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.size() == 1 ? (Throwable) arrayList.get(0) : new CompositeException(arrayList);
    }
}
