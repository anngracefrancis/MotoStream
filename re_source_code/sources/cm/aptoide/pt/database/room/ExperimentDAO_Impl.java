package cm.aptoide.pt.database.room;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.n;
import androidx.room.t.b;
import c.u.a.f;
import h.a.s;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class ExperimentDAO_Impl implements ExperimentDAO {
    private final j __db;
    private final c<RoomExperiment> __insertionAdapterOfRoomExperiment;

    public ExperimentDAO_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRoomExperiment = new c<RoomExperiment>(jVar) { // from class: cm.aptoide.pt.database.room.ExperimentDAO_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `experiment` (`experimentName`,`requestTime`,`assignment`,`payload`,`partOfExperiment`,`experimentOver`) VALUES (?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, RoomExperiment roomExperiment) {
                if (roomExperiment.getExperimentName() == null) {
                    fVar.I0(1);
                } else {
                    fVar.w(1, roomExperiment.getExperimentName());
                }
                fVar.h0(2, roomExperiment.getRequestTime());
                if (roomExperiment.getAssignment() == null) {
                    fVar.I0(3);
                } else {
                    fVar.w(3, roomExperiment.getAssignment());
                }
                if (roomExperiment.getPayload() == null) {
                    fVar.I0(4);
                } else {
                    fVar.w(4, roomExperiment.getPayload());
                }
                fVar.h0(5, roomExperiment.isPartOfExperiment() ? 1L : 0L);
                fVar.h0(6, roomExperiment.isExperimentOver() ? 1L : 0L);
            }
        };
    }

    @Override // cm.aptoide.pt.database.room.ExperimentDAO
    public s<RoomExperiment> get(String str) {
        final m mVarC = m.c("SELECT * FROM experiment WHERE experimentName = ?", 1);
        if (str == null) {
            mVarC.I0(1);
        } else {
            mVarC.w(1, str);
        }
        return n.c(new Callable<RoomExperiment>() { // from class: cm.aptoide.pt.database.room.ExperimentDAO_Impl.2
            protected void finalize() {
                mVarC.f();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RoomExperiment call() throws Exception {
                RoomExperiment roomExperiment = null;
                Cursor cursorB = androidx.room.t.c.b(ExperimentDAO_Impl.this.__db, mVarC, false, null);
                try {
                    int iB = b.b(cursorB, "experimentName");
                    int iB2 = b.b(cursorB, "requestTime");
                    int iB3 = b.b(cursorB, "assignment");
                    int iB4 = b.b(cursorB, "payload");
                    int iB5 = b.b(cursorB, "partOfExperiment");
                    int iB6 = b.b(cursorB, "experimentOver");
                    if (cursorB.moveToFirst()) {
                        roomExperiment = new RoomExperiment(cursorB.getString(iB), cursorB.getLong(iB2), cursorB.getString(iB3), cursorB.getString(iB4), cursorB.getInt(iB5) != 0, cursorB.getInt(iB6) != 0);
                    }
                    if (roomExperiment != null) {
                        cursorB.close();
                        return roomExperiment;
                    }
                    throw new EmptyResultSetException("Query returned empty result set: " + mVarC.a());
                } catch (Throwable th) {
                    cursorB.close();
                    throw th;
                }
            }
        });
    }

    @Override // cm.aptoide.pt.database.room.ExperimentDAO
    public void save(RoomExperiment roomExperiment) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRoomExperiment.insert(roomExperiment);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
