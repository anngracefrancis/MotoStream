package cm.aptoide.analytics.implementation;

import cm.aptoide.analytics.implementation.data.Event;
import java.util.List;
import rx.b;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public interface EventsPersistence {
    e<List<Event>> getAll();

    b remove(List<Event> list);

    b save(Event event);

    b save(List<Event> list);
}
