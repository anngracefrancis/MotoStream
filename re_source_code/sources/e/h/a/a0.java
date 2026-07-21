package e.h.a;

import com.liulishuo.filedownloader.message.MessageSnapshot;
import java.util.List;

/* JADX INFO: compiled from: MessageSnapshotGate.java */
/* JADX INFO: loaded from: classes2.dex */
public class a0 implements com.liulishuo.filedownloader.message.b.InterfaceC0246b {
    private boolean a(List<a.b> list, MessageSnapshot messageSnapshot) {
        boolean zI;
        if (list.size() > 1 && messageSnapshot.k() == -3) {
            for (a.b bVar : list) {
                synchronized (bVar.I()) {
                    if (bVar.y().n(messageSnapshot)) {
                        e.h.a.k0.d.a(this, "updateMoreLikelyCompleted", new Object[0]);
                        return true;
                    }
                }
            }
        }
        for (a.b bVar2 : list) {
            synchronized (bVar2.I()) {
                if (bVar2.y().p(messageSnapshot)) {
                    e.h.a.k0.d.a(this, "updateKeepFlow", new Object[0]);
                    return true;
                }
            }
        }
        if (-4 == messageSnapshot.k()) {
            for (a.b bVar3 : list) {
                synchronized (bVar3.I()) {
                    if (bVar3.y().a(messageSnapshot)) {
                        e.h.a.k0.d.a(this, "updateSampleFilePathTaskRunning", new Object[0]);
                        return true;
                    }
                }
            }
        }
        if (list.size() != 1) {
            return false;
        }
        a.b bVar4 = list.get(0);
        synchronized (bVar4.I()) {
            e.h.a.k0.d.a(this, "updateKeepAhead", new Object[0]);
            zI = bVar4.y().i(messageSnapshot);
        }
        return zI;
    }

    @Override // com.liulishuo.filedownloader.message.b.InterfaceC0246b
    public void H(MessageSnapshot messageSnapshot) {
        synchronized (Integer.toString(messageSnapshot.e()).intern()) {
            List<a.b> listJ = h.i().j(messageSnapshot.e());
            if (listJ.size() > 0) {
                a aVarV = listJ.get(0).v();
                if (e.h.a.k0.d.a) {
                    e.h.a.k0.d.a(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.e()), Byte.valueOf(aVarV.getStatus()), Byte.valueOf(messageSnapshot.k()), Integer.valueOf(listJ.size()));
                }
                if (!a(listJ, messageSnapshot)) {
                    StringBuilder sb = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.e() + " status:" + ((int) messageSnapshot.k()) + " task-count:" + listJ.size());
                    for (a.b bVar : listJ) {
                        sb.append(" | ");
                        sb.append((int) bVar.v().getStatus());
                    }
                    e.h.a.k0.d.e(this, sb.toString(), new Object[0]);
                }
            } else {
                e.h.a.k0.d.e(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.k()));
            }
        }
    }
}
