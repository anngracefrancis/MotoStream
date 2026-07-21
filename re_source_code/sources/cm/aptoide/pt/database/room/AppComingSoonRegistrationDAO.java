package cm.aptoide.pt.database.room;

import h.a.m;

/* JADX INFO: loaded from: classes.dex */
public interface AppComingSoonRegistrationDAO {
    m<Integer> isRegisteredForApp(String str);

    void remove(RoomAppComingSoonRegistration roomAppComingSoonRegistration);

    void save(RoomAppComingSoonRegistration roomAppComingSoonRegistration);
}
