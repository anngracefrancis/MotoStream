package cm.aptoide.pt.database.room;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.n;
import c.u.a.f;
import h.a.m;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class EventDAO_Impl implements EventDAO {
    private final j __db;
    private final b<RoomEvent> __deletionAdapterOfRoomEvent;
    private final c<RoomEvent> __insertionAdapterOfRoomEvent;

    public EventDAO_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomEvent = new c<RoomEvent>(jVar) { // from class: cm.aptoide.pt.database.room.EventDAO_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `event` (`timestamp`,`eventName`,`action`,`context`,`data`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomEvent roomEvent) {
                fVar.h0(1, roomEvent.getTimestamp());
                if (roomEvent.getEventName() == null) {
                    fVar.I0(2);
                } else {
                    fVar.w(2, roomEvent.getEventName());
                }
                fVar.h0(3, roomEvent.getAction());
                if (roomEvent.getContext() == null) {
                    fVar.I0(4);
                } else {
                    fVar.w(4, roomEvent.getContext());
                }
                if (roomEvent.getData() == null) {
                    fVar.I0(5);
                } else {
                    fVar.w(5, roomEvent.getData());
                }
            }
        };
        this.__deletionAdapterOfRoomEvent = new b<RoomEvent>(jVar) { // from class: cm.aptoide.pt.database.room.EventDAO_Impl.2
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `event` WHERE `timestamp` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, RoomEvent roomEvent) {
                fVar.h0(1, roomEvent.getTimestamp());
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.EventDAO
    public void delete(RoomEvent roomEvent) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRoomEvent.handle(roomEvent);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // cm.aptoide.pt.database.room.EventDAO
    public m<List<RoomEvent>> getAll() {
        final androidx.room.m mVarC = androidx.room.m.c("SELECT * FROM event", 0);
        return n.a(this.__db, false, new String[]{"event"}, new Callable<List<RoomEvent>>() { // from class: cm.aptoide.pt.database.room.EventDAO_Impl.3
            protected void finalize() {
                mVarC.f();
            }

            @Override // java.util.concurrent.Callable
            public List<RoomEvent> call() throws Exception {
                Cursor cursorB = androidx.room.t.c.b(EventDAO_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = androidx.room.t.b.b(cursorB, "timestamp");
                    int iB2 = androidx.room.t.b.b(cursorB, "eventName");
                    int iB3 = androidx.room.t.b.b(cursorB, "action");
                    int iB4 = androidx.room.t.b.b(cursorB, "context");
                    int iB5 = androidx.room.t.b.b(cursorB, "data");
                    ArrayList arrayList = new ArrayList(cursorB.getCount());
                    while (cursorB.moveToNext()) {
                        arrayList.add(new RoomEvent(cursorB.getLong(iB), cursorB.getString(iB2), cursorB.getInt(iB3), cursorB.getString(iB4), cursorB.getString(iB5)));
                    }
                    cursorB.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorB.close();
                    throw th;
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.EventDAO
    public void insert(RoomEvent roomEvent) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomEvent.insert(roomEvent);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
