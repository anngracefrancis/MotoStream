package cm.aptoide.pt.aab;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SplitsMapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004¨\u0006\b"}, d2 = {"Lcm/aptoide/pt/aab/SplitsMapper;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "mapSplits", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/pt/aab/Split;", "splits", "Lcm/aptoide/pt/dataprovider/model/v7/Split;", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplitsMapper {
    public final List<Split> mapSplits(List<? extends cm.aptoide.pt.dataprovider.model.v7.Split> splits) {
        ArrayList arrayList = new ArrayList();
        if (splits == null) {
            return arrayList;
        }
        for (cm.aptoide.pt.dataprovider.model.v7.Split split : splits) {
            String name = split.getName();
            m.e(name, "split.name");
            String type = split.getType();
            m.e(type, "split.type");
            String path = split.getPath();
            m.e(path, "split.path");
            long filesize = split.getFilesize();
            String md5sum = split.getMd5sum();
            m.e(md5sum, "split.md5sum");
            arrayList.add(new Split(name, type, path, filesize, md5sum));
        }
        return arrayList;
    }
}
