package org.example;

import org.example.Common.AppView;
import org.example.Common.PageLoop;
import org.example.Data.Service.ShopService;
import org.example.Data.data_source.Catalog.CatalogDataSource;
import org.example.Data.data_source.Catalog.MockCatalogDataSourceImpl;
import org.example.Data.data_source.cart.CartDataSource;
import org.example.Data.data_source.cart.MockCartDataSourceImpl;
import org.example.Data.data_source.order.MockOrderDataSourceImpl;
import org.example.Data.data_source.order.OrderDataSource;
import org.example.view.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CartDataSource cartDataSource = new MockCartDataSourceImpl();
        CatalogDataSource catalogDataSource = new MockCatalogDataSourceImpl();
        OrderDataSource orderDataSource = new MockOrderDataSourceImpl();
        ShopService shopService = new ShopService(catalogDataSource, cartDataSource, orderDataSource);

        AppView addToCardView = new AddToCartView(shopService);

        ArrayList<AppView> catalogChildren = new ArrayList<>();
        catalogChildren.add(addToCardView);
        AppView catalogView = new CatalogView(shopService, catalogChildren);

        AppView cartView = new CartView(shopService);
AppView orderView = new OrderView(shopService);

        ArrayList<AppView> mainChildren = new ArrayList<>();
        mainChildren.add(catalogView);
          mainChildren.add(cartView);
          mainChildren.add(orderView);
         // mainChildren.add(catalogView);
              AppView mainView = new MainView(mainChildren);



new PageLoop(mainView).run();

//        System.out.println(shopService.getCatalog());
//        System.out.println(shopService.getCart());
//        System.out.println(shopService.addToCart(shopService.getCatalog().get(0).id,5));
//        System.out.println(shopService.addToCart("564654",5));
//        System.out.println(shopService.getCart());
    }
}

/*
models;
Prodact-id, title, discription, prise, available
CartItem - Prodact, count
Order - name, phone, address, paymentType, deliveryTime, List<CartItem> cart
Фичи
- просмотр каталога
-добавление в карзину по id
-сколько штук
- просмотр карзины
-оформить заказ
-ввод данных

 */