package com.faishalbadri.qasirid.Model;

import java.util.List;

/**
 * Created by faishal on 9/15/17.
 */

public class Pojo {

    /**
     * status : 1
     * message : success
     * data : [{"product_id":1,"product_name":"Rinso","variants":[{"variant_id":101,"variant_name":"Rinso Sachet 400g","price":4000,"image":"http://www.pasark5.com/image/cache/catalog/product/Detergent/rinso_anti_noda_48g_1-500x500.jpg"},{"variant_id":102,"variant_name":"Rinso 1Kg","price":11000,"image":"https://www.monotaro.id/media/catalog/product/cache/6/thumbnail/9df78eab33525d08d6e5fb8d27136e95/r/i/rinso_anti_noda_1_8kg_front.jpg"},{"variant_id":103,"variant_name":"Rinso 2Kg","price":19000,"image":"http://www.ezyhero.com/wp-content/uploads/2017/04/rinso-sabun-cuci-detergent-top-load-1-kg-4097-63855031-d20713f69bf6ba3b5146a6ef3aa08728-zoom.jpg"},{"variant_id":104,"variant_name":"Rinso Cair","price":19000,"image":"https://www.static-src.com/wcsstore/Indraprastha/images/catalog/medium/rinso_rinso-molto-liquid-detergent-pouch-21135208--800-ml-_full01.jpg"}]},{"product_id":2,"product_name":"Aqua","variants":[{"variant_id":201,"variant_name":"Aqua Gelas","price":500,"image":"http://www.pasificdistributor.com/images/products/thumbnail/6_20090513_12262714.jpg"},{"variant_id":202,"variant_name":"Aqua Botol 1500Ml","price":5000,"image":"https://s3-ap-southeast-1.amazonaws.com/mbiz-images/catalog/aqua-air-mineral-btl-1500-ml.jpg"}]}]
     */

    private int status;
    private String message;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * product_id : 1
         * product_name : Rinso
         * variants : [{"variant_id":101,"variant_name":"Rinso Sachet 400g","price":4000,"image":"http://www.pasark5.com/image/cache/catalog/product/Detergent/rinso_anti_noda_48g_1-500x500.jpg"},{"variant_id":102,"variant_name":"Rinso 1Kg","price":11000,"image":"https://www.monotaro.id/media/catalog/product/cache/6/thumbnail/9df78eab33525d08d6e5fb8d27136e95/r/i/rinso_anti_noda_1_8kg_front.jpg"},{"variant_id":103,"variant_name":"Rinso 2Kg","price":19000,"image":"http://www.ezyhero.com/wp-content/uploads/2017/04/rinso-sabun-cuci-detergent-top-load-1-kg-4097-63855031-d20713f69bf6ba3b5146a6ef3aa08728-zoom.jpg"},{"variant_id":104,"variant_name":"Rinso Cair","price":19000,"image":"https://www.static-src.com/wcsstore/Indraprastha/images/catalog/medium/rinso_rinso-molto-liquid-detergent-pouch-21135208--800-ml-_full01.jpg"}]
         */

        private int product_id;
        private String product_name;
        private List<VariantsBean> variants;

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public List<VariantsBean> getVariants() {
            return variants;
        }

        public void setVariants(List<VariantsBean> variants) {
            this.variants = variants;
        }

        public static class VariantsBean {
            /**
             * variant_id : 101
             * variant_name : Rinso Sachet 400g
             * price : 4000
             * image : http://www.pasark5.com/image/cache/catalog/product/Detergent/rinso_anti_noda_48g_1-500x500.jpg
             */

            private int variant_id;
            private String variant_name;
            private String price;
            private String image;

            public int getVariant_id() {
                return variant_id;
            }

            public void setVariant_id(int variant_id) {
                this.variant_id = variant_id;
            }

            public String getVariant_name() {
                return variant_name;
            }

            public void setVariant_name(String variant_name) {
                this.variant_name = variant_name;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }
    }
}
