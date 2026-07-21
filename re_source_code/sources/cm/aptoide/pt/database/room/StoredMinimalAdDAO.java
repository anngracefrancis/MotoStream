package cm.aptoide.pt.database.room;

import h.a.m;

/* JADX INFO: loaded from: classes.dex */
public interface StoredMinimalAdDAO {
    void delete(RoomStoredMinimalAd roomStoredMinimalAd);

    m<RoomStoredMinimalAd> get(String str);

    void insert(RoomStoredMinimalAd roomStoredMinimalAd);
}
