package cm.aptoide.pt.aab;

import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DynamicSplitsResponse extends BaseV7Response {

    @JsonProperty("list")
    private List<DynamicSplit> dynamicSplitList;

    public static class DynamicSplit {

        @JsonProperty("delivery_types")
        List<String> deliveryTypes;
        private Long filesize;
        private String md5sum;
        private String name;
        private String path;
        private List<cm.aptoide.pt.dataprovider.model.v7.Split> splits;
        private String type;

        public List<String> getDeliveryTypes() {
            return this.deliveryTypes;
        }

        public Long getFilesize() {
            return this.filesize;
        }

        public String getMd5sum() {
            return this.md5sum;
        }

        public String getName() {
            return this.name;
        }

        public String getPath() {
            return this.path;
        }

        public List<cm.aptoide.pt.dataprovider.model.v7.Split> getSplits() {
            return this.splits;
        }

        public String getType() {
            return this.type;
        }

        public void setDeliveryTypes(List<String> list) {
            this.deliveryTypes = list;
        }

        public void setFilesize(Long l) {
            this.filesize = l;
        }

        public void setMd5sum(String str) {
            this.md5sum = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPath(String str) {
            this.path = str;
        }

        public void setSplits(List<cm.aptoide.pt.dataprovider.model.v7.Split> list) {
            this.splits = list;
        }

        public void setType(String str) {
            this.type = str;
        }
    }

    public List<DynamicSplit> getDynamicSplitList() {
        return this.dynamicSplitList;
    }

    public void setDynamicSplitList(List<DynamicSplit> list) {
        this.dynamicSplitList = list;
    }
}
