package cm.aptoide.pt.database.room;

import com.google.gson.e;
import com.google.gson.u.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class CampaignUrlTypeConverter {
    CampaignUrlTypeConverter() {
    }

    public static List<RoomCampaignUrl> restoreCampaignUrlList(String str) {
        return (List) new e().i(str, new a<List<RoomCampaignUrl>>() { // from class: cm.aptoide.pt.database.room.CampaignUrlTypeConverter.1
        }.getType());
    }

    public static String saveCampaignUrlList(List<RoomCampaignUrl> list) {
        return new e().q(list);
    }
}
