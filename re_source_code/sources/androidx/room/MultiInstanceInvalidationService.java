package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f2112f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final HashMap<Integer, String> f2113g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final RemoteCallbackList<d> f2114h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final e.a f2115i = new b();

    class a extends RemoteCallbackList<d> {
        a() {
        }

        @Override // android.os.RemoteCallbackList
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCallbackDied(d dVar, Object obj) {
            MultiInstanceInvalidationService.this.f2113g.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    }

    class b extends e.a {
        b() {
        }

        @Override // androidx.room.e
        public void S6(d dVar, int i2) {
            synchronized (MultiInstanceInvalidationService.this.f2114h) {
                MultiInstanceInvalidationService.this.f2114h.unregister(dVar);
                MultiInstanceInvalidationService.this.f2113g.remove(Integer.valueOf(i2));
            }
        }

        @Override // androidx.room.e
        public int k2(d dVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f2114h) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i2 = multiInstanceInvalidationService.f2112f + 1;
                multiInstanceInvalidationService.f2112f = i2;
                if (multiInstanceInvalidationService.f2114h.register(dVar, Integer.valueOf(i2))) {
                    MultiInstanceInvalidationService.this.f2113g.put(Integer.valueOf(i2), str);
                    return i2;
                }
                MultiInstanceInvalidationService.this.f2112f--;
                return 0;
            }
        }

        @Override // androidx.room.e
        public void z6(int i2, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f2114h) {
                try {
                    String str = MultiInstanceInvalidationService.this.f2113g.get(Integer.valueOf(i2));
                    if (str == null) {
                        Log.w("ROOM", "Remote invalidation client ID not registered");
                        return;
                    }
                    int iBeginBroadcast = MultiInstanceInvalidationService.this.f2114h.beginBroadcast();
                    for (int i3 = 0; i3 < iBeginBroadcast; i3++) {
                        try {
                            int iIntValue = ((Integer) MultiInstanceInvalidationService.this.f2114h.getBroadcastCookie(i3)).intValue();
                            String str2 = MultiInstanceInvalidationService.this.f2113g.get(Integer.valueOf(iIntValue));
                            if (i2 != iIntValue && str.equals(str2)) {
                                try {
                                    ((d) MultiInstanceInvalidationService.this.f2114h.getBroadcastItem(i3)).L1(strArr);
                                } catch (RemoteException e2) {
                                    Log.w("ROOM", "Error invoking a remote callback", e2);
                                }
                            }
                        } catch (Throwable th) {
                            MultiInstanceInvalidationService.this.f2114h.finishBroadcast();
                            throw th;
                        }
                    }
                    MultiInstanceInvalidationService.this.f2114h.finishBroadcast();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f2115i;
    }
}
