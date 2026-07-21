package cm.aptoide.pt.database;

import cm.aptoide.pt.database.room.RoomStoredMinimalAd;

/* JADX INFO: loaded from: classes.dex */
public interface StoredMinimalAdPersistence {
    rx.e<RoomStoredMinimalAd> get(String str);

    void insert(RoomStoredMinimalAd roomStoredMinimalAd);

    void remove(RoomStoredMinimalAd roomStoredMinimalAd);
}
