package com.internalization.app;

import com.internalization.classes.SystemZoneIdHolder;
import com.internalization.classes.UserZoneIdHolder;
import com.internalization.classes.ZoneIdHolder;
import com.internalization.constants.ZoneIdConstant;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InternalizationWithDates {

    private static class Product {

        private final String name;
        private final Instant purchasedTime;

        private Product(final String name, final Instant purchasedTime) {
            this.name = name;
            this.purchasedTime = purchasedTime;
        }

        public static Product build(final String name, final Instant purchasedTime) {
            return new Product(name, purchasedTime);
        }
    }

    static List<Product> productsDB = new ArrayList<>(10);

    private static void saveAllProductsToDB() {
        SystemZoneIdHolder.setDefaultZoneId();
        ZoneIdHolder zoneIdHolder = SystemZoneIdHolder.getZoneIdHolder();
        for(int i=0; i < 10; i++) {
            Product product = Product
                    .build(String.format("Product %s", i), zoneIdHolder.getInstant().minusSeconds(86400 + (300 * i ))); // one day
            productsDB.add(product);
        }
    }

    private static void listProducts(ZoneIdConstant zoneIdConstant) {
        UserZoneIdHolder.setZoneId(zoneIdConstant);
        ZoneIdHolder zoneIdHolder = UserZoneIdHolder.getZoneIdHolder();

        for(Product product : productsDB) {
            System.out.println(String.format("Product name: %s, purchased time: %s", product.name,
                    zoneIdHolder.toLocalDateTime(product.purchasedTime)));
        }

    }


    public static void main(String[] args) {
        saveAllProductsToDB();

        System.out.println("Product Listing for User in GMT");
        listProducts(ZoneIdConstant.UTC);

        System.out.println("Product Listing for User in Ireland");
        listProducts(ZoneIdConstant.Europe_Dublin);

        System.out.println("Product Listing for User in India");
        listProducts(ZoneIdConstant.ASIA_KOLKATA);
    }
}
