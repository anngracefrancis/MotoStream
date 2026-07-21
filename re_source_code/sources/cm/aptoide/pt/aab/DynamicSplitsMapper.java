package cm.aptoide.pt.aab;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DynamicSplitsMapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¨\u0006\f"}, d2 = {"Lcm/aptoide/pt/aab/DynamicSplitsMapper;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "mapDynamicConfigSplits", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/pt/aab/Split;", "splits", "Lcm/aptoide/pt/dataprovider/model/v7/Split;", "mapDynamicSplits", "Lcm/aptoide/pt/aab/DynamicSplit;", "serverDynamicSplitsList", "Lcm/aptoide/pt/aab/DynamicSplitsResponse$DynamicSplit;", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DynamicSplitsMapper {
    private final List<Split> mapDynamicConfigSplits(List<? extends cm.aptoide.pt.dataprovider.model.v7.Split> splits) {
        ArrayList arrayList = new ArrayList(v.u(splits, 10));
        for (cm.aptoide.pt.dataprovider.model.v7.Split split : splits) {
            String name = split.getName();
            m.e(name, "it.name");
            String type = split.getType();
            m.e(type, "it.type");
            String path = split.getPath();
            m.e(path, "it.path");
            long filesize = split.getFilesize();
            String md5sum = split.getMd5sum();
            m.e(md5sum, "it.md5sum");
            arrayList.add(new Split(name, type, path, filesize, md5sum));
        }
        return arrayList;
    }

    public final List<DynamicSplit> mapDynamicSplits(List<? extends DynamicSplitsResponse.DynamicSplit> serverDynamicSplitsList) {
        m.f(serverDynamicSplitsList, "serverDynamicSplitsList");
        ArrayList arrayList = new ArrayList(v.u(serverDynamicSplitsList, 10));
        for (DynamicSplitsResponse.DynamicSplit dynamicSplit : serverDynamicSplitsList) {
            String name = dynamicSplit.getName();
            m.e(name, "it.name");
            String type = dynamicSplit.getType();
            m.e(type, "it.type");
            String md5sum = dynamicSplit.getMd5sum();
            m.e(md5sum, "it.md5sum");
            String path = dynamicSplit.getPath();
            m.e(path, "it.path");
            Long filesize = dynamicSplit.getFilesize();
            m.e(filesize, "it.filesize");
            long jLongValue = filesize.longValue();
            List<String> list = dynamicSplit.deliveryTypes;
            m.e(list, "it.deliveryTypes");
            List<cm.aptoide.pt.dataprovider.model.v7.Split> splits = dynamicSplit.getSplits();
            m.e(splits, "it.splits");
            arrayList.add(new DynamicSplit(name, type, md5sum, path, jLongValue, list, mapDynamicConfigSplits(splits)));
        }
        return arrayList;
    }
}
