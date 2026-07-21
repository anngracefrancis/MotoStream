package cm.aptoide.pt.database;

import cm.aptoide.analytics.implementation.EventsPersistence;
import cm.aptoide.analytics.implementation.data.Event;
import cm.aptoide.pt.database.room.EventDAO;
import cm.aptoide.pt.database.room.RoomEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RoomEventPersistence implements EventsPersistence {
    private final EventDAO eventDAO;
    private final RoomEventMapper mapper;

    public RoomEventPersistence(EventDAO eventDAO, RoomEventMapper roomEventMapper) {
        this.eventDAO = eventDAO;
        this.mapper = roomEventMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAll$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ h.a.p a(List list) throws Exception {
        try {
            return h.a.m.t(this.mapper.map((List<RoomEvent>) list));
        } catch (IOException e2) {
            return h.a.m.h(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$remove$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ h.a.p b(Event event) throws Exception {
        try {
            return h.a.m.t(this.mapper.map(event));
        } catch (JsonProcessingException e2) {
            return h.a.m.h(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$remove$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(RoomEvent roomEvent) throws Exception {
        this.eventDAO.delete(roomEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$save$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Event event, h.a.c cVar) throws Exception {
        try {
            this.eventDAO.insert(this.mapper.map(event));
            cVar.a();
        } catch (JsonProcessingException e2) {
            cVar.onError(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$save$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ h.a.f e(Event event) throws Exception {
        return g.a.a.a.d.e(save(event));
    }

    @Override // cm.aptoide.analytics.implementation.EventsPersistence
    public rx.e<List<Event>> getAll() {
        return g.a.a.a.d.b(this.eventDAO.getAll().y(h.a.b0.a.b()).j(new h.a.y.f() { // from class: cm.aptoide.pt.database.s
            @Override // h.a.y.f
            public final Object a(Object obj) {
                return this.f4948f.a((List) obj);
            }
        }), h.a.a.BUFFER);
    }

    @Override // cm.aptoide.analytics.implementation.EventsPersistence
    public rx.b remove(List<Event> list) {
        return g.a.a.a.d.a(h.a.m.s(list).j(new h.a.y.f() { // from class: cm.aptoide.pt.database.v
            @Override // h.a.y.f
            public final Object a(Object obj) {
                return this.f4955f.b((Event) obj);
            }
        }).y(h.a.b0.a.b()).f(new h.a.y.e() { // from class: cm.aptoide.pt.database.t
            @Override // h.a.y.e
            public final void a(Object obj) throws Exception {
                this.a.c((RoomEvent) obj);
            }
        }).A().e());
    }

    @Override // cm.aptoide.analytics.implementation.EventsPersistence
    public rx.b save(final Event event) {
        return g.a.a.a.d.a(h.a.b.c(new h.a.e() { // from class: cm.aptoide.pt.database.u
            @Override // h.a.e
            public final void a(h.a.c cVar) throws Exception {
                this.a.d(event, cVar);
            }
        }).f(h.a.b0.a.b()));
    }

    @Override // cm.aptoide.analytics.implementation.EventsPersistence
    public rx.b save(List<Event> list) {
        return g.a.a.a.d.a(h.a.m.s(list).n(new h.a.y.f() { // from class: cm.aptoide.pt.database.w
            @Override // h.a.y.f
            public final Object a(Object obj) {
                return this.f4958f.e((Event) obj);
            }
        }));
    }
}
